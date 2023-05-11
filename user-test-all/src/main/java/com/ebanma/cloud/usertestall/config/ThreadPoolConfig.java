package com.ebanma.cloud.usertestall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 于秦涛
 * @version $ Id: ThreadPoolConfig, v 0.1 2023/03/29 11:17 98077 Exp $
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("exportServiceExecutor")
    public Executor exportServiceExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int processors = Runtime.getRuntime().availableProcessors();
        executor.setCorePoolSize(processors);
        executor.setMaxPoolSize(2*processors);
        executor.setQueueCapacity(Integer.MAX_VALUE);
        executor.setThreadNamePrefix("export-service-");
        return executor;
    }

}

