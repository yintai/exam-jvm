package com.sample.service;

import com.sample.entity.Business;
import com.sample.util.DataMap;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: liuwang
 * Date: 15-6-25
 * Time: 上午1:18
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BusinessService {

    /**
     * 新增
     * @param busi
     * @return
     */
    public int addBusiness(Business busi)  {
        DataMap.businessMap.put(busi.getId(),busi) ;
        return DataMap.businessMap.size();
    }

    /**
     * 根据状态查询
     * @param busi
     * @return
     */
    public List getBusiness(Business busi){

        List list=new ArrayList();

        Iterator it =  DataMap.businessMap.entrySet().iterator();
        while(it.hasNext()){
             Map.Entry entry = (Map.Entry)it.next();
            Business b= (Business) entry.getValue();
            if(busi.getStatus()==b.getStatus()&&busi.getStatus()!=null){
                list.add(b);
              //  System.out.println(b.toStr());
            }
        }
        return list;
    }


}
