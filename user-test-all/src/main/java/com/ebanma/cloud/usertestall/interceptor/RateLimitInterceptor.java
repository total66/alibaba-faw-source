package com.ebanma.cloud.usertestall.interceptor;

import com.ebanma.cloud.usertestall.domain.common.ErrorCode;
import com.ebanma.cloud.usertestall.exception.BusinessException;
import com.ebanma.cloud.usertestall.util.CommonMetaObjectHandler;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 于秦涛
 * @version $ Id: RateLimitInterceptor, v 0.1 2023/03/22 15:00 98077 Exp $
 */
@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    /**
     * 速度限制器（qps为1）
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(1);

    private static final Logger logger = LoggerFactory.getLogger(CommonMetaObjectHandler.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!rateLimiter.tryAcquire()){
            logger.error("系统已经被限流了！！！");

            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }

        return true;
    }
}

