package com.sample.util;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liuwang
 * Date: 15-6-25
 * Time: 上午7:53
 * To change this template use File | Settings | File Templates.
 */

@XStreamAlias("data")
public class RetData implements Serializable {
    private String code="ok";

    private Long longTime = System.currentTimeMillis();

    private String stringTime = new Timestamp(System.currentTimeMillis()).toString();

    private String message= "";

    private List result = new ArrayList();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getLongTime() {
        return longTime;
    }

    public void setLongTime(Long longTime) {
        this.longTime = longTime;
    }

    public String getStringTime() {
        return stringTime;
    }

    public void setStringTime(String stringTime) {
        this.stringTime = stringTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
