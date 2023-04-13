package com.ebanma.cloud.usertestall.util;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author 于秦涛
 * @version $ Id: CommonMetaObjectHandler, v 0.1 2023/03/22 10:27 98077 Exp $
 */
public class CommonMetaObjectHandler implements MetaObjectHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        if(logger.isInfoEnabled()){
            logger.info("新建时，开始填充系统字段");
        }

        this.strictInsertFill(metaObject, "created",
                LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "modified",
                LocalDateTime.class, LocalDateTime.now());

        this.strictInsertFill(metaObject, "creator",
                String.class, "TODO 从上下文中获取当前人");
        this.strictInsertFill(metaObject, "operator",
                String.class, "TODO 从上下文中获取当前人");

        this.strictInsertFill(metaObject, "delete",
                Integer.class, 0);
        this.strictInsertFill(metaObject, "version",
                Long.class, 1);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(logger.isInfoEnabled()){
            logger.info("更新时，开始填充系统字段");
        }
    }
}

