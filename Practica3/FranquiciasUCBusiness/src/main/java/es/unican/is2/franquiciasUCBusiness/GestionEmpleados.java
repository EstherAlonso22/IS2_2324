package es.unican.is2.franquiciasUCBusiness;

import es.unican.is2.franquiciasUCCommon.clases.DataAccessException;
import es.unican.is2.franquiciasUCCommon.clases.Empleado;
import es.unican.is2.franquiciasUCCommon.clases.OperacionNoValidaException;
import es.unican.is2.franquiciasUCCommon.interfaces.*;

public class GestionEmpleados implements IGestionEmpleados {

	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado empleado(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
