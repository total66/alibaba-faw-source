package com.ebanma.cloud.usertestall.domain.common;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author 于秦涛
 * @version $ Id: Result, v 0.1 2023/03/15 14:56 98077 Exp $
 */
public class Result<T> {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 906941499553860342L;

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss SSS";

    private Boolean success;

    /**
     * 编码
     */
    private String code;

    /**
     * 描述信息
     */
    private String message;

    /**
     *  数据
     */
    private T data;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 格式为 {@link #DATE_PATTERN} 的时间戳
     */
    private String timestamp;

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> Result<T> success(T payload){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ErrorCode.SUCCESS.getCode());
        result.setMessage(ErrorCode.SUCCESS.getDesc());
        result.setData(payload);
        result.setTimestamp(DateFormatUtils.format(new Date(), DATE_PATTERN));
        return result;
    }

    public static <T> Result<T> success(){
        return success(null);
    }

    public static <T> Result<T> fail(ErrorCode errorCode) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getDesc());
        result.setTimestamp(DateFormatUtils.format(new Date(), DATE_PATTERN));
        return result;
    }

    public static <T> Result<T> fail(Throwable ex, T payload) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(ErrorCode.SYSTEM_ERROR.getCode());
        result.setMessage(ex != null ? ExceptionUtils.getRootCauseMessage(ex) : ErrorCode.SYSTEM_ERROR.getDesc());
        result.setTimestamp(DateFormatUtils.format(new Date(), DATE_PATTERN));
        result.setData(payload);
        return result;
    }

    public static <T> Result<T> fail(Throwable ex) {
        return fail(ex, null);
    }

    public static <T> Result<T> fail() {
        return fail(null, null);
    }

}

