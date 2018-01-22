/**
 * 
 */
package com.lvbaoer.api.common;

import java.util.List;

public class Result {

    private String code;
    private String msg;
    private List<Object> data;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the data
     */
    public List<Object> getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(List<Object> data) {
        this.data = data;
    }

}
