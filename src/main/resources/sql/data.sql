-- 初始化用户张三，id自增那么张三的id应该为1
INSERT INTO `customer` (`username`, `createdate`) VALUES ('张三', '2015-12-01 17:46:05');
-- 给id为1的张三新增5条记录
INSERT INTO `order` (`customerNo`, `orderNo`, `createdate`, `status`, `type`, `money`, `currency`) VALUES ('1', '151125193112658101', '2015-11-25 19:31:18', '1', '1', '10.00', '1');
INSERT INTO `order` (`customerNo`, `orderNo`, `createdate`, `status`, `type`, `money`, `currency`) VALUES ('1', '151125193216799101', '2015-11-25 19:32:21', '1', '1', '20.00', '1');
INSERT INTO `order` (`customerNo`, `orderNo`, `createdate`, `status`, `type`, `money`, `currency`) VALUES ('1', '151125193307995101', '2015-11-25 19:33:13', '1', '1', '30.00', '1');
INSERT INTO `order` (`customerNo`, `orderNo`, `createdate`, `status`, `type`, `money`, `currency`) VALUES ('1', '151125193333873101', '2015-11-25 19:33:51', '0', '1', '40.00', '1');
INSERT INTO `order` (`customerNo`, `orderNo`, `createdate`, `status`, `type`, `money`, `currency`) VALUES ('1', '151125193427784101', '2015-11-25 19:34:31', '0', '1', '50.00', '1');
