package com.ebanma.cloud.usertestall.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author 于秦涛
 * @version $ Id: CaffeineCacheConfig, v 0.1 2023/03/22 14:37 98077 Exp $
 * 缓存相关配置
 */

@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    private static final Logger logger = LoggerFactory.getLogger(CaffeineCacheConfig.class);

//    @Bean("cacheManager1")
//    public CacheManager cacheManager1(){
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        ArrayList<CaffeineCache> caches = new ArrayList<>();
//        caches.add(new CaffeineCache("user-cache", Caffeine.newBuilder()
//                .maximumSize(1024)
//                .expireAfterAccess(120, TimeUnit.SECONDS)
//                .build()));
//
//        cacheManager.setCaches(caches);
//        return cacheManager;
//    }



    @Bean("cacheManager")
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        // 缓存集合
        ArrayList<CaffeineCache> caches = new ArrayList<>();

        // 对缓存key属性做设置
        caches.add(new CaffeineCache("user-cache",
                Caffeine.newBuilder()

                        // 指定Key下的最大缓存数据量
                        .maximumSize(1000)

                        // 最后一次访问之后 120秒 过期
                        .expireAfterAccess(120, TimeUnit.SECONDS)

                        .build()));

        cacheManager.setCaches(caches);

        return cacheManager;
    }

    }

