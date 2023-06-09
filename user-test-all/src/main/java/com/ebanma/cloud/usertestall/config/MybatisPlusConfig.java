package com.ebanma.cloud.usertestall.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 于秦涛
 * @version $ Id: MybatisPlusConfig, v 0.1 2023/03/22 10:46 98077 Exp $
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页拦截器
     *
     * @return {@link PaginationInterceptor}
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        // 数据库类型配置
        paginationInterceptor.setDbType(DbType.MYSQL);

        return paginationInterceptor;
    }

    /**
     * 乐观锁拦截器
     *
     * @return {@link OptimisticLockerInterceptor}
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}

