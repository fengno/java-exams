package com.imooc;

public class AreaException extends RuntimeException {
	
	private String msg;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6201866529227235800L;

	public AreaException() {
		super();
	}
	
	public AreaException(String msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
