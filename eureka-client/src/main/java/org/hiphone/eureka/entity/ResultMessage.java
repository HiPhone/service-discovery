package org.hiphone.eureka.entity;

import java.io.Serializable;

/**
 * @author HiPhone
 */
public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 1452124883024046815L;

    private Integer code;

    private String message;

    private Object data;

    public ResultMessage() {}

    public ResultMessage(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
