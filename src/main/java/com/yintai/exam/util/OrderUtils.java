package com.yintai.exam.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderUtils {
	private static final Logger logger = LoggerFactory.getLogger(OrderUtils.class);
	private static String machineId = null;
	private static String milliseconds = null;
	private static int values = 0;

	// 读取配置文件
	static {
		String machineIdStr = System.getenv("machineId");
		if (machineIdStr == null || "".equals(machineIdStr)) {
			logger.error("machineId未配置！默认为1");
			machineId = "1";
		} else {
			machineId = machineIdStr;
		}
	}

	public static String getOrderNum() {
		return null;
	}

	public static synchronized String getOrderNum(String ms) {
		if (ms.equals(milliseconds)) {
			++values;
		} else {
			milliseconds = ms;
			values = 1;
		}
		return milliseconds + machineId + String.format("%02d", values);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		System.out.println(getOrderNum(sdf.format(new Date())));
	}
}
