package es.unican.is2.franquiciasUCBusiness;

import es.unican.is2.franquiciasUCCommon.clases.DataAccessException;
import es.unican.is2.franquiciasUCCommon.clases.Empleado;
import es.unican.is2.franquiciasUCCommon.clases.OperacionNoValidaException;
import es.unican.is2.franquiciasUCCommon.clases.Tienda;
import es.unican.is2.franquiciasUCCommon.interfaces.*;

public class GestionEmpleados implements IGestionEmpleados {
	private ITiendasDAO tiendasDAO;
	private IEmpleadosDAO empleadosDAO;
	
	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		this.tiendasDAO = tiendasDAO;
		this.empleadosDAO = empleadosDAO;
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		Empleado empleado = empleadosDAO.crearEmpleado(e);
		if (empleado != null) {
			throw new OperacionNoValidaException("El empleado ya está");
		}
		Tienda tienda = tiendasDAO.tiendaPorNombre(nombre);
		if (tienda == null) {
			return null;
		}
		
		tienda.getEmpleados().add(empleado);
		return empleado;
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		Tienda tienda = tiendasDAO.tiendaPorNombre(nombre);
		if (tienda == null) {
			return null;
		}
		Empleado empleado = empleadosDAO.eliminarEmpleado(dni);
		if (empleado == null ) {
			return null;
		}
		if (!tienda.getEmpleados().remove(empleado)) {
			throw new OperacionNoValidaException("El empleado no pertenece a la tienda");
		}
		return empleado;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		Tienda tiendaActual = tiendasDAO.tiendaPorNombre(actual);
		Tienda tiendaDest = tiendasDAO.tiendaPorNombre(destino);
		Empleado empleado = empleadosDAO.empleado(dni);
		if (tiendaActual == null || empleado == null || tiendaDest == null) {
			return false;
		}
		if (!tiendaActual.getEmpleados().remove(empleado)) {
			throw new OperacionNoValidaException("El empleado no pertenece a la tienda");
		}
		return tiendaDest.getEmpleados().add(empleado);	
	}

	@Override
	public Empleado empleado(String dni) throws DataAccessException {
		return empleadosDAO.empleado(dni);
	}

}
