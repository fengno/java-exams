package com.imooc;

public class AreaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5389942716262107185L;
	
	private String msg;

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
