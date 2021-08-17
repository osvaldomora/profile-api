package mx.santander.fiduciarioplus.exception.model;

import org.springframework.http.HttpStatus;


public class ModelException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
	private final String level;
	private final String description;
	
	/**
	 * Constructor del error de respuesta
	 * @param httpStatus Estatus HTTP de respuesta del error
	 * @param code Codigo interno del error
	 * @param message Mensaje generico del error
	 * @param level Nivel del error
	 * @param description Descripcion detallada del error
	 */
	public ModelException(HttpStatus httpStatus, String code, String message, String level, String description) {
		super();
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
	}
	
	/**
	 * Constructor del error de respuesta sin descripcion detallada
	 * @param httpStatus Estatus HTTP de respuesta del error
	 * @param code Codigo interno del error
	 * @param message Mensaje generico del error
	 * @param level Nivel del error
	 */
	public ModelException(HttpStatus httpStatus, String code, String message, String level) {
		super();
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = null;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getLevel() {
		return level;
	}
	public String getDescription() {
		return description;
	}

}
