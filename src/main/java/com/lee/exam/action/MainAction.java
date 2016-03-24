package com.lee.exam.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.lee.exam.service.BaseService;
import com.lee.exam.util.SpringContextUtil;

@Controller
@RequestMapping("/api")
public class MainAction {

	/**
	 * 接口总入口/流的方式获取
	 * @param transactionType 接口编码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/{transactionType}/records/stream", method = { RequestMethod.POST})
	public void doRecordsByStream(@PathVariable String transactionType,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//收集创建交易记录的信息
		
		InputStream in = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String text = "";
		StringBuffer strB = new StringBuffer();
		while((text = reader.readLine()) != null){
			strB.append(text);
		}
		String str = strB.toString().startsWith("msg=")?strB.toString().replace("msg=", ""):strB.toString();
		this.doController(transactionType,str, request,  response);
	}
	
	/**
	 * 接口总入口/ Key-value的方式获取
	 * @param transactionType 接口编码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/{transactionType}/records/kv", method = { RequestMethod.POST})
	public void doRecordsByKv(@PathVariable String transactionType,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//收集创建交易记录的信息
		String str = request.getParameter("msg");
		this.doController(transactionType,str, request,  response);
	}
	
	private void doController(String transactionType,String str,HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 设置编码
		response.setContentType("text/html;charset=gbk");
		//根据【约定：逻辑处理的SpringBean的命名规则为 业务代码（见文档）+Service】获得需要进行请求的业务处理的Bean 
		BaseService baseService = (BaseService) SpringContextUtil.getBean(transactionType + "ServiceImpl",
				BaseService.class);
		Map<String, Object> result = JSON.parseObject(str.toString(), Map.class);
		//对result（传输的相关消息）的内容的验证
		//.....
		Map<String, Object> head = (Map<String, Object>)result.get("head"); 
		Map<String, Object> body = (Map<String, Object>)result.get("body"); 
		//通过head中的token在缓存中回去用户的ID test中认为token既用户ID
		String userID = (String)head.get("token");
		
		//基本信息校验
		int resCode = baseService.baseValidateMsgBody(body, userID);
		
		if (resCode == 0) {
			//校验成功后进行业务逻辑处理
			Map<String, Object> map = baseService.doController(head, body, userID);
			
			response.getWriter().print(JSON.toJSONString(map));
		} else {
			//校验失败需要返回异常信息 异常信息只有消息头
			Map<String, Object> responseMsg = new HashMap<String, Object>();
			Map<String, Object> responseHead = new HashMap<String, Object>();
			
			responseHead.put("resCode", resCode);
			responseHead.put("message", "对resCode的描述");
			responseHead.put("transactionType", transactionType);
			responseHead.put("timeStamp", new Date().getTime());
			responseHead.put("messageID", head.get("messageID"));
			responseMsg.put("head", responseHead);
			
			response.getWriter().print(JSON.toJSONString(responseMsg));
		}
		
	}

/*	
	@RequestMapping(value = "/records", method = { RequestMethod.GET})
	public void findRecords(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String recordStatus = request.getParameter("status");
		//查询
	}
*/
}
