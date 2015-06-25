package com.sample.controller;

import com.sample.entity.Business;
import com.sample.service.BusinessService;
import com.sample.util.RetData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liuwang
 * Date: 15-6-25
 * Time: 上午1:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="/business")
public class BusinessController {
    @Autowired
    private BusinessService businessServic;
    static Logger logger = Logger.getLogger(BusinessController.class) ;

    /**
     * 新增 交易信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = { "/add" }, method = { RequestMethod.GET })
    public RetData addBusiness( Business bus ,  HttpServletRequest request) {
        RetData data=new RetData();

              try{
                  if(bus.getId()==null){
                      data.setCode("error");
                      data.setMessage("id not is null");
                  }
                  if(bus.getType()==null){
                      data.setCode("error");
                      data.setMessage("type not is null");
                  }
                  if(bus.getCustomerId()==null){
                      data.setCode("error");
                      data.setMessage("customer not is null");
                  }
                  if(bus.getCurrency()==null){
                      data.setCode("error");
                      data.setMessage("currency not is null");
                  }
                  if(bus.getStatus()==null){
                      data.setCode("error");
                      data.setMessage("status not is null");
                  }
             businessServic.addBusiness(bus);
              }catch (Exception e){
                  data.setCode("error");
                  data.setMessage("system error");
              }
             return data;
    }

    /**
     * 根据 查询条件 查询交易信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = { "/query" }, method = {RequestMethod.GET })
    public RetData queryBusiness(   HttpServletRequest request) {
        RetData data=new RetData();
        Business bus =new  Business();
         try{
             String status=request.getParameter("status");
             if(status==null){
                 data.setCode("error");
                 data.setMessage("status is not null");
             }
             bus.setStatus( status);
             data.setResult( businessServic.getBusiness(bus)) ;
         }catch (Exception e){
             data.setCode("error");
             data.setMessage("system error");
         }
        return data;
    }
}
