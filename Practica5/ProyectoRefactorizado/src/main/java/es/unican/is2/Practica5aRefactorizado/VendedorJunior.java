package es.unican.is2.Practica5aRefactorizado;

public class VendedorJunior extends VendedorEnPlantilla{
	private static final double COMISION = 0.005;

	public VendedorJunior(String nombre, String id, String dni) { //WMC +1
		super(nombre, id, dni);
	}
	
	@Override
	public double calculaComision(double importe) { //WMC +1
		return importe * COMISION;
	}

}
