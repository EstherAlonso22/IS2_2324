package es.unican.is2.Practica5aRefactorizado;

public class VendedorSenior extends VendedorEnPlantilla{
	private static final double COMISION = 0.01;

	public VendedorSenior(String nombre, String id, String dni) { //WMC +1
		super(nombre, id, dni);
	}

	@Override
	public double calculaComision(double importe) { //WMC +1
		return importe * COMISION;
	}
}
