package service.trade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.trade.TradeMapper;
import model.TradeDetail;

@Service("tradeService")
@Transactional(readOnly=true)
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private TradeMapper tradeMapper;

	@Transactional(readOnly=false)
	public boolean addTrade(TradeDetail trade) {
		int result = tradeMapper.addTrade(trade);
		return result==1;
	}
	
	public List<TradeDetail> getTrade(Integer status) {
		List<TradeDetail> result = tradeMapper.getTrade(status);
		return result;
	}

}
