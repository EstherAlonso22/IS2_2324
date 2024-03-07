package es.unican.is2.franquiciasUCBusiness;

import es.unican.is2.franquiciasUCCommon.clases.DataAccessException;
import es.unican.is2.franquiciasUCCommon.clases.OperacionNoValidaException;
import es.unican.is2.franquiciasUCCommon.clases.Tienda;
import es.unican.is2.franquiciasUCCommon.interfaces.*;

public class GestionTiendas implements IGestionTiendas {

	public GestionTiendas(ITiendasDAO tiendasDAO) {
		
	}

	@Override
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tienda tienda(String nombre) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
