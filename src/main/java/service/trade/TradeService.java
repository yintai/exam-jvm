package service.trade;

import java.util.List;

import model.TradeDetail;

public interface TradeService {
	/**
	 * 添加交易
	 * @param trade
	 * @return
	 */
	public boolean addTrade(TradeDetail trade);
	
	/**
	 * 按交易状态查询
	 * @param status
	 * @return
	 */
	public List<TradeDetail> getTrade(Integer status);
}
