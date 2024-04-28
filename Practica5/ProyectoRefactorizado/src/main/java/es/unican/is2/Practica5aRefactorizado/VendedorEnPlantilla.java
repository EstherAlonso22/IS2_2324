package es.unican.is2.Practica5aRefactorizado;
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
	public void anhadeVentaComision(double importe) {
		double comision = 0;
		comision = calculaComision(importe);
		anhade(importe);
		setC(getC()+comision);
	}
	
	protected abstract double calculaComision(double importe);

}
