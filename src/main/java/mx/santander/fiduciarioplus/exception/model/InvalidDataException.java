package mx.santander.fiduciarioplus.exception.model;

import mx.santander.fiduciarioplus.exception.catalog.InvalidDataCatalog;

public class InvalidDataException extends ModelException{

	/**
	 * 
	 * @param catalog Excepcion del catalogo de InvalidDataCatalog
	 * @param description Descripcion detallada de la excepcion
	 */
	public InvalidDataException(InvalidDataCatalog catalog, String description) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString(), description);
	}
	
	
	/**
	 * @param catalog Descripcion detallada de la excepcion
	 */
	public InvalidDataException(InvalidDataCatalog catalog) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString());

	}

	private static final long serialVersionUID = 1L;

}
