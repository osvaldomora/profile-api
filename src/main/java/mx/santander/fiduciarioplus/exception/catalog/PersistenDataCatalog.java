package mx.santander.fiduciarioplus.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria Persistent
 *
 */
public enum PersistenDataCatalog {
	
	PSID001("PersistentDataException","PSID.001","Error al realizar la transaccion.",HttpStatus.CONFLICT,LevelException.ERROR),
	PSID002("PersistentDataException","PSID.002","Error de conexion en origen de datos.",HttpStatus.CONFLICT,LevelException.ERROR);
	
	private final String type;
	private final String code;
	private final String message;
	private final HttpStatus htttpStatus;
	private final LevelException levelException;
	
	PersistenDataCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.type = type;
		this.code = code;
		this.message = message;
		this.htttpStatus = htttpStatus;
		this.levelException = levelException;
	}
	public String getType() {
		return type;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public HttpStatus getHtttpStatus() {
		return htttpStatus;
	}
	public LevelException getLevelException() {
		return levelException;
	}
	
	

}
