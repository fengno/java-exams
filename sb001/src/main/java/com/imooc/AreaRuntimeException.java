package com.imooc;

public class AreaRuntimeException extends RuntimeException {
	
	private String msg;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6201866529227235800L;

	public AreaRuntimeException() {
		super();
	}
	
	public AreaRuntimeException(String msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
