package util;

import java.util.List;

/**
 * Excecoes de Negocio
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}
	
	public BusinessException(Class clazz, String message) {
		super(clazz.getName() + " : " + message);
	}
	
	public BusinessException(List<String> messages) {
		super(geMensagens(messages));
	}
	
	public static String geMensagens(List<String> messages) {
		String msg = "";
		for (String message : messages){
			msg += message + "\n";
		}
		
		msg = msg += "\n";
		return msg;
	}
	
	public String getNameException(){
		return "BusinessException";
	}
}