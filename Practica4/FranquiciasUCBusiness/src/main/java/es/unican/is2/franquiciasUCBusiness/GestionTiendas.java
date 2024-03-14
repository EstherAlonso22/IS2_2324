package es.unican.is2.franquiciasUCBusiness;

import es.unican.is2.franquiciasUCCommon.clases.DataAccessException;
import es.unican.is2.franquiciasUCCommon.clases.OperacionNoValidaException;
import es.unican.is2.franquiciasUCCommon.clases.Tienda;
import es.unican.is2.franquiciasUCCommon.interfaces.*;

public class GestionTiendas implements IGestionTiendas {
	private ITiendasDAO tiendas; 
	public GestionTiendas(ITiendasDAO tiendasDAO) {
		tiendas = tiendasDAO;
	}

	@Override
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		// Busco si hay alguna tienda registrada con el mismo nombre en la interfaz
		Tienda tiendaBuscada = tienda(t.getNombre());
		
		if (tiendaBuscada != null) {
			return null;
		}
		
		// Anhado tienda
		tiendas.crearTienda(t);
		return t;
	}

	@Override
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		// Busco si hay alguna tienda registrada con el mismo nombre en la interfaz
		Tienda tiendaBuscada = tienda(nombre);
		
		// Si no hay tienda con ese nombre, devuelvo null
		if (tiendaBuscada == null) {
			return null;
		}
		
		// Si hay tienda con ese nombre pero tiene empleados, lanzo excepción
		if (!tiendaBuscada.getEmpleados().isEmpty()) {
			throw new OperacionNoValidaException("La tienda tiene empleados");
		}
		
		// Elimino la tienda
		tiendas.eliminarTienda(tiendaBuscada.getId());
		return tiendaBuscada;
	}

	@Override
	public Tienda tienda(String nombre) throws DataAccessException {
		// Obtener tienda por el nombre
		Tienda tienda = tiendas.tiendaPorNombre(nombre);
		
		// Si no hay tienda con ese nombre, devuelvo null
		if (tienda == null) {
			return null;
		}
		return tienda;
	}
	

}
