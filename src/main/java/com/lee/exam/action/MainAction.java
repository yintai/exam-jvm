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
	 * �ӿ������/���ķ�ʽ��ȡ
	 * @param transactionType �ӿڱ���
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/{transactionType}/records/stream", method = { RequestMethod.POST})
	public void doRecordsByStream(@PathVariable String transactionType,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�ռ��������׼�¼����Ϣ
		
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
	 * �ӿ������/ Key-value�ķ�ʽ��ȡ
	 * @param transactionType �ӿڱ���
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/{transactionType}/records/kv", method = { RequestMethod.POST})
	public void doRecordsByKv(@PathVariable String transactionType,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�ռ��������׼�¼����Ϣ
		String str = request.getParameter("msg");
		this.doController(transactionType,str, request,  response);
	}
	
	private void doController(String transactionType,String str,HttpServletRequest request, HttpServletResponse response) throws IOException{
		// ���ñ���
		response.setContentType("text/html;charset=gbk");
		//���ݡ�Լ�����߼������SpringBean����������Ϊ ҵ����루���ĵ���+Service�������Ҫ���������ҵ�����Bean 
		BaseService baseService = (BaseService) SpringContextUtil.getBean(transactionType + "ServiceImpl",
				BaseService.class);
		Map<String, Object> result = JSON.parseObject(str.toString(), Map.class);
		//��result������������Ϣ�������ݵ���֤
		//.....
		Map<String, Object> head = (Map<String, Object>)result.get("head"); 
		Map<String, Object> body = (Map<String, Object>)result.get("body"); 
		//ͨ��head�е�token�ڻ����л�ȥ�û���ID test����Ϊtoken���û�ID
		String userID = (String)head.get("token");
		
		//������ϢУ��
		int resCode = baseService.baseValidateMsgBody(body, userID);
		
		if (resCode == 0) {
			//У��ɹ������ҵ���߼�����
			Map<String, Object> map = baseService.doController(head, body, userID);
			
			response.getWriter().print(JSON.toJSONString(map));
		} else {
			//У��ʧ����Ҫ�����쳣��Ϣ �쳣��Ϣֻ����Ϣͷ
			Map<String, Object> responseMsg = new HashMap<String, Object>();
			Map<String, Object> responseHead = new HashMap<String, Object>();
			
			responseHead.put("resCode", resCode);
			responseHead.put("message", "��resCode������");
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
		//��ѯ
	}
*/
}
