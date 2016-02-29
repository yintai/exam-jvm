package com.linzhijia.boot.service;

import org.springframework.data.repository.CrudRepository;

import com.linzhijia.boot.domain.TradeInfo;

public interface TradeRepository extends CrudRepository<TradeInfo, Long> {
	Iterable<TradeInfo> findByTradeStateAllIgnoringCase(Integer tradeState);
}
