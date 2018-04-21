package com.imooc.dto;

/** 
 * HTTP请求返回的最外层对象
 * @param <T>
 */
public class Result<T> {

	/** 响应码 */
	private Integer code; // 响应码、响应信息最好在枚举中统一维护
	/** 响应信息 */
	private String msg;
	/** 具体内容 */
	private T data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
