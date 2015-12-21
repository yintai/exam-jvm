package model;

import java.io.Serializable;

public class BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3320044512814563011L;
	private int code;
	private String message;
	private Object result;
	
	public BaseModel(int code, String message, Object result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	

}
