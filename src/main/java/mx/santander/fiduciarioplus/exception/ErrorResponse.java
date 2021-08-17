package mx.santander.fiduciarioplus.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private String code;
	private String message;
	private String level;
	private String description;
	private String moreInfo;
	
	/**
	 * Constructor del error de respuesta
	 * @param code Codigo de error interno
	 * @param message Mensaje generico del error
	 * @param level	Nivel del error
	 * @param description Descripcion detallada del error
	 * @param moreInfo Path donde surgio el error
	 */
	public ErrorResponse(String code, String message, String level, String description, String moreInfo) {
		super();
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
		this.moreInfo = moreInfo;
	}
	
	/**
	 * Constructor del error de respuesta sin descripcion detallada
	 * @param code Codigo de error interno
	 * @param message Mensaje generico del error
	 * @param level Nivel del error
	 * @param moreInfo Path donde surgio el error
	 */
	public ErrorResponse(String code, String message, String level, String moreInfo) {
		super();
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = null;
		this.moreInfo = moreInfo;
	}
	
	public ErrorResponse() {}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
}
