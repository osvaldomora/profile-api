package mx.santander.fiduciarioplus.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria Business
 *
 */
public enum BusinessCatalog {
	
	BUSI001("BusinessException","BUSI.001","Error el documento no puede exceder el minimo y maximo de tamaño.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	BUSI002("BusinessException","BUSI.002","Formato de archivo no soportado.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	BUSI003("BusinessException","BUSI.003","Se ha excedido el limite de archivos.",HttpStatus.BAD_REQUEST,LevelException.WARN);

	private final String type;
	private final String code;
	private final String message;
	private final HttpStatus htttpStatus;
	private final LevelException levelException;
	
	BusinessCatalog(String type, String code, String message, HttpStatus htttpStatus,
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
