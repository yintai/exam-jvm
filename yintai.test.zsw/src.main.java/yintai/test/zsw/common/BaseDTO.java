package yintai.test.zsw.common;


public class BaseDTO{
	
	private static final String SUCCESS_FLAG = "0";
	private static final String FAIL_FLAG = "-1";
	private static final String USER_STATUS_FAIL_FLAG = "-2";
	private static final String USER_VALID_FAIL_FLAG = "-3";
	
	public BaseDTO(){
		this.status = SUCCESS_FLAG;
		this.message = "";
		this.success = true;
	}
	
	public BaseDTO(String status,String message)
	{
		this.status=status;
		this.message=message;
	}
	
	private String status;
	
	private String message;
	private Boolean success;


	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void success(){
		if(!SUCCESS_FLAG.equals(status)){
			setStatus(SUCCESS_FLAG);
			setSuccess(false);
		}
	}
	
	public void fail(){
		if(!FAIL_FLAG.equals(status)){
			setStatus(FAIL_FLAG);
		}
	}
	
	public BaseDTO fail(String message){
		fail();
		setMessage(message);
		return this;
	}
	
	public void userFail(){
		if(!USER_STATUS_FAIL_FLAG.equals(status)){
			setStatus(USER_STATUS_FAIL_FLAG);
		}
	}
	
	public BaseDTO userFail(String message){
		userFail();
		setMessage(message);
		return this;
	}
	
	public BaseDTO userValidFail(String message){
		if(!USER_VALID_FAIL_FLAG.equals(status)){
			setStatus(USER_VALID_FAIL_FLAG);
		}
		setMessage(message);
		return this;
	}
	
}