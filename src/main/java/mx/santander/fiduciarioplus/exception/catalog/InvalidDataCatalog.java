package mx.santander.fiduciarioplus.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria InvalidData
 *
 */
public enum InvalidDataCatalog {
	
	INVD001("InvalidDataException","INVD.001","Error al mapear datos.",HttpStatus.CONFLICT,LevelException.ERROR),
	INVD002("InvalidDataException","INVD.002","Error al codificar archivo.",HttpStatus.CONFLICT,LevelException.ERROR);
	
	private final String type;
	private final String code;
	private final String message;
	private final HttpStatus htttpStatus;
	private final LevelException levelException;
	
	InvalidDataCatalog(String type, String code, String message, HttpStatus htttpStatus,
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
