package es.unican.is2.Practica5aRefactorizado;
public class VendedorEnPracticas extends Vendedor {
		
	/**
	 * Retorna un nuevo vendedor en practicas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) { //WMC +1
		super(nombre, id, dni);
	}

	@Override
	protected void anhadeVentaComision(double importe) { //WMC +1
		anhade(importe);
	}
	
}
