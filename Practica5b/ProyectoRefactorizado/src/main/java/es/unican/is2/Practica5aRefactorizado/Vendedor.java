package es.unican.is2.Practica5aRefactorizado;
/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	private double c;
	private double totalVentas;
	private String dni;
	
	
	public Vendedor(String nombre, String id, String dni) { //WMC +1
		this.nombre = nombre;
		this.id = id;
		this.dni=dni;
	}
	
	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() { //WMC +1
		return nombre;
	}
	
	/**
	 * Retorna el id del vendedor
	 * @return id
	 */
	public String getId() { //WMC +1
		return id;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getDni() { //WMC +1
		return dni;
	}

	/**
	 * Retorna la comision mensual acumulada
	 * @return Comision total acumulada
	 */
	public double getC() { //WMC +1
		return c;
	}
	
	/**
	 * Asigna valor a la comision mensual acumulada
	 * @param value comision a asignar
	 */
	public void setC(double value) {  //WMC +1
		this.c = value;
	}
	
	/**
	 * Retorna el importe total mensual de ventas
	 * @return importe total de ventas acumuladas
	 */
	public double getTotalVentas( ) { //WMC +1
		return totalVentas;
	}
	
	/**
	 * Asigna valor al total de ventas mensual
	 * @param value total de ventas a asignar
	 */
	public void setTotalVentas(double value) { //WMC +1
		totalVentas = value;
	}
	
	/**
	 * Anhade una nueva venta al vendedor
	 * @param importe de la venta
	 */
	public void anhade(double importe)  { //WMC +1
		totalVentas += importe;
	}

	/**
	 * Anhade una venta calculando y actualizando la comision del vendedor.
	 * @param importe De la venta
	 */
	protected abstract void anhadeVentaComision(double importe); //WMC +1
	
	@Override
	public boolean equals(Object obj) { //WMC +1 
		if (!(obj instanceof Vendedor)) //WMC +1 //CCog +1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //CCog +1
	}

	
}
