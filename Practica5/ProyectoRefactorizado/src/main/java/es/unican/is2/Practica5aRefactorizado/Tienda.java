package es.unican.is2.Practica5aRefactorizado;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores. Gestiona las
 * ventas realizadas y las comisiones asignadas a cada vendedor. Los datos de la
 * tienda se almacenan en un fichero de texto que se pasa como parametro al
 * crear la tienda
 */
public class Tienda {

	private List<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) { //WMC + 1
		this.datos = datos;
	}

	/**
	 * Retorna la direccion de la tienda
	 * @return Direccion de la tienda
	 */
	public String direccion() {  //WMC + 1
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() { //WMC + 1
		return nombre;
	}

	/**
	 * Anhade un nuevo vendedor a la tienda
	 * @param nuevo El vendedor a anhadir
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya existe el vendedor
	 */
	public boolean anhadeVendedor(Vendedor nuevo) throws DataAccessException { //WMC + 1
		Vendedor v = buscaVendedor(nuevo.getId());
		if (v != null) { //WMC + 1 //CCog +1
			return false;
		}
		lista.add(nuevo); 
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo id se pasa como argumento
	 * @param id
	 * @return true si se elimina el vendedor false si no existe el vendedor
	 */
	public boolean eliminaVendedor(String id) throws DataAccessException { //WMC + 1
		Vendedor v = buscaVendedor(id);
		if (v == null) { //WMC + 1 //CCog +1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * Anhade una venta a un vendedor
	 * @param id      Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se anhade la venta false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws DataAccessException {  //WMC + 1
		Vendedor v = buscaVendedor(id);
		if (v == null) { //WMC +1 //CCog +1
			return false;
		}	
		v.anhadeVentaComision(importe);
		vuelcaDatos();
		return true;
	}


	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese dni o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) throws DataAccessException { //WMC +1
		leeVendedores();
		for (Vendedor v : lista) { //WMC +1 //CCog +1
			if (v.getId().equals(id)) { //WMC +1 //CCog +2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() throws DataAccessException { //WMC +1
		leeVendedores();
		return lista;

	}

	/**
	 * Lee el fichero con los datos de los vendedores y los añade a la lista de la tienda
	 * @throws DataAccessException
	 */
	private void leeVendedores() throws DataAccessException {
		lista.clear();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de numeros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) { //WMC +2 //CCog +3
				creaVendedorDatos(in, "Senior");
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Practicas")) { //WMC +2 //CCog +3
				creaVendedorDatos(in, "Junior");
			}
			while (in.hasNext()) { //WMC +1 //CCog +2
				creaVendedorDatos(in, "Practicas");
			}
		} catch (FileNotFoundException e) { //WMC +1 //CCog +1
			throw new DataAccessException();
		} finally {
			if (in != null) { //WMC +1 //CCog +2
				in.close();
			}
		} // try
	}

	/**
	 * Lee un vendedor del fichero y lo crea
	 * @param in Fichero a leer
	 * @param tipo Tipo de vendedor que crea
	 */
	private void creaVendedorDatos(Scanner in, String tipo) {
		Vendedor ven;
		String nombre = in.next();
		in.next();
		String idIn = in.next();
		in.next();
		String dni = in.next();
		in.next();
		double totalVentas = in.nextDouble();
		in.next();
		double totalComision = in.nextDouble();
		switch (tipo) {
		case "Senior":
			ven = new VendedorSenior(nombre, idIn, dni);
			break;
		case "Junior":
			ven = new VendedorJunior(nombre, idIn, dni);
			break;
		default:
			ven = new VendedorEnPracticas(nombre, idIn, dni);
		}
		ven.setTotalVentas(totalVentas);
		ven.setC(totalComision);
		lista.add(ven);
	}

	/**
	 * Actualiza el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 */
	private void vuelcaDatos() throws DataAccessException { //WMC +1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) { //WMC +1 //CCog +1
			if (v instanceof VendedorEnPracticas) { //WMC +1 //CCog +2
				practicas.add(v);
			} else if (v instanceof VendedorSenior) { //WMC +1 //CCog +1
				senior.add(v);
			}	else //CCog +1
				junior.add(v);
		}

		try {
			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			escribeVendedor(out, senior, "Plantilla");
			escribeVendedor(out, junior, "Plantilla");
			escribeVendedor(out, practicas, "Practicas");
		} catch (IOException e) { //WMC +1 //CCog +1
			throw new DataAccessException();

		} finally {
			if (out != null) //WMC +1 //CCog +2
				out.close();
		}
	}

	private void escribeVendedor(PrintWriter out, List<Vendedor> list, String tipo) {
		out.println();
		out.println(tipo);
		for (Vendedor v : list) { 
			if (tipo.equals("Plantilla")) {
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println(calculaString(v1) + " TotalComision: "+ v1.getC());
			} else {
				VendedorEnPracticas v1 = (VendedorEnPracticas) v;
				out.println(calculaString(v1));
			}
		}
	}

	private String calculaString(Vendedor v1) {
		return "  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: " + v1.getDni()
		+ " TotalVentasMes: " + v1.getTotalVentas();
	}
}
