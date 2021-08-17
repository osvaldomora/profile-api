package mx.santander.fiduciarioplus.exception.model;

import mx.santander.fiduciarioplus.exception.catalog.PersistenDataCatalog;

public class PersistenDataException extends ModelException{

	/**
	 * 
	 * @param catalog Excepcion del catalogo de PersistendDataCatalog
	 * @param description Descripcion detallada de la excepcion
	 */
	public PersistenDataException(PersistenDataCatalog catalog, String description) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString(), description);
	}
	
	/**
	 * @param catalog Descripcion detallada de la excepcion
	 */
	public PersistenDataException(PersistenDataCatalog catalog) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString());
	}

	private static final long serialVersionUID = 1L;

}
