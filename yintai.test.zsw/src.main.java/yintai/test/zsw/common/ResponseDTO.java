package yintai.test.zsw.common;

import java.util.HashMap;
import java.util.Map;



public class ResponseDTO extends BaseDTO{
	
	
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public ResponseDTO() {
		super();
	}

	public ResponseDTO(String status,String message, HashMap<String, Object> data) {
		super(status,message);
		this.data = data;
	}


	public Map<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
	public Object putData(String key,Object value){
		
		return this.data.put(key, value);
	}
	
	
	
	
	
	
}
