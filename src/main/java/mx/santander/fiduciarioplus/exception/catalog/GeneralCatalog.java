package mx.santander.fiduciarioplus.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria General
 *
 */
public enum GeneralCatalog {
	
	GRAL001("GeneralException","GRAL.001","Internal Server Error.",HttpStatus.INTERNAL_SERVER_ERROR,LevelException.ERROR),
	GRAL002("GeneralException","GRAL.002","Error al enviar Query Parameters.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	GRAL003("GeneralException","GRAL.003","URI Parameter no valido QWEWEW.",HttpStatus.BAD_REQUEST,LevelException.WARN);
	
	private final String type;
	private final String code;
	private final String message;
	private final HttpStatus htttpStatus;
	private final LevelException levelException;
	
	GeneralCatalog(String type, String code, String message, HttpStatus htttpStatus,
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
