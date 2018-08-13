package br.com.modeloconceitual.exception;

public class ObjectNotFundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFundException(String msg, Throwable cause){
		super(msg, cause);
	}

}
