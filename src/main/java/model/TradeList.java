package model;

import java.io.Serializable;
import java.util.List;

public class TradeList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8829410937484137654L;
	private int size;
	private List<TradeDetail> list;
	public TradeList(int size, List<TradeDetail> list) {
		super();
		this.size = size;
		this.list = list;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<TradeDetail> getList() {
		return list;
	}
	public void setList(List<TradeDetail> list) {
		this.list = list;
	}
	
	
}
