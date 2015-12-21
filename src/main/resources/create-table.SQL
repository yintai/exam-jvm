CREATE TABLE customer(
	id IDENTITY(1,1) PRIMARY KEY,
	name VARCHAR(10)
);
COMMENT ON TABLE customer IS '客户表';
COMMENT ON COLUMN customer.id IS '主键';
COMMENT ON COLUMN customer.name IS '客户姓名';
--交易信息包含「交易 ID」、「创建时间」、「交易状态（例如是否交易成功）」、「交易类型（例如支付还是退款）」、「交易金额」、
--「交易币种（例如美元还是人民币）」、「客户信息」

CREATE TABLE trade(
	id IDENTITY(1,1) PRIMARY KEY,
	userid BIGINT REFERENCES customer(id),
	tradestatus INT ,
	tradetype INT ,
	trademoney DECIMAL ,
	trademoneytype INT ,
	createdat TIMESTAMP NOT NULL Default NOW()
);
COMMENT ON TABLE trade IS '交易记录';
COMMENT ON COLUMN trade.id IS '主键';
COMMENT ON COLUMN trade.userid IS '用户主键';
COMMENT ON COLUMN trade.tradestatus IS '交易状态0未成功，1成功';
COMMENT ON COLUMN trade.tradetype IS '交易类型0支付，1退款';
COMMENT ON COLUMN trade.trademoneytype IS '交易币种0人民币，1美元';
COMMENT ON COLUMN trade.createdat IS '交易时间';



