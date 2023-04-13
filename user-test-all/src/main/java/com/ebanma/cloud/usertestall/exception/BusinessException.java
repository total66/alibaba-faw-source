package com.ebanma.cloud.usertestall.exception;

import com.ebanma.cloud.usertestall.domain.common.ErrorCode;
import com.ebanma.cloud.usertestall.domain.common.Result;
import com.ebanma.cloud.usertestall.util.CommonMetaObjectHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 于秦涛
 * @version $ Id: BusinessException, v 0.1 2023/03/22 10:51 98077 Exp $
 */

public class BusinessException extends RuntimeException{

    private final String code;

    /**
     * 根据枚举构建业务异常
     *
     * @param errorCode 错误代码
     */
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.code = errorCode.getCode();
    }

    /**
     * 根据自定义消息构建业务异常
     *
     * @param errorCode 错误代码
     * @param message   消息
     */
    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    /**
     * 根据异常构建业务异常
     *
     * @param errorCode 错误代码
     * @param throwable throwable
     */    public BusinessException(ErrorCode errorCode, Throwable throwable) {
        super(throwable);
        this.code = errorCode.getCode();
    }
}

