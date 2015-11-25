DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL IDENTITY  PRIMARY KEY,
  `username` varchar(10) default NULL COMMENT '用户名',
  `createdate` datetime default NULL COMMENT '创建时间',
);
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL IDENTITY  PRIMARY KEY,
  `orderNo` varchar(25) NOT NULL COMMENT '交易 ID' ,
  `customerNo` int(11) default NULL COMMENT '所属用户id',
  `createdate` datetime default NULL COMMENT '创建时间',
  `status` int(255) default NULL COMMENT '交易状态（例如是否交易成功)',
  `type` int(255) default NULL COMMENT '交易类型（例如支付还是退款',
  `money` decimal(18,2) default NULL COMMENT '交易金额',
  `currency` int(255) default NULL COMMENT '交易币种（例如美元还是人民币）',
);