package es.unican.is2.Practica5bRefactorizado;
public abstract class VendedorEnPlantilla extends Vendedor {
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni) { //WMC +1
		super(nombre, id, dni);
	}
	
    @Override
	public void anhadeVentaComision(double importe) { //WMC +1
		double comision = 0;
		comision = calculaComision(importe);
		anhade(importe);
		setC(getC()+comision);
	}
	
    /**
     * Calcula la comision de una venta teniendo en cuenta el importe.
     * @param importe Importe de la venta
     * @return Comision calculada
     */
	protected abstract double calculaComision(double importe); //WMC +1

}
