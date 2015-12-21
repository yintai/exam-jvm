package dao.trade;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.TradeDetail;

public interface TradeMapper {
	
	
	@Insert("INSERT INTO trade(userid,tradestatus,tradetype,trademoney,trademoneytype)"
			+ " VALUES(#{userid},#{tradestatus},#{tradetype},#{trademoney},#{trademoneytype})")
	public int addTrade(TradeDetail tradeDetail);
	
	@Select("SELECT A.id,A.userid,B.name,A.tradestatus,A.tradetype,A.trademoney,A.trademoneytype,A.createdat FROM TRADE A,CUSTOMER B WHERE A.tradestatus=#{status}")
	public List<TradeDetail> getTrade(Integer status);
}
