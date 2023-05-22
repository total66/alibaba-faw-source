package com.ebanma.cloud.demo.domain.service;

import org.springframework.stereotype.Service;

/**
 * @author 于秦涛
 * @version $ Id: DefaultIdGenerator, v 0.1 2023/05/19 10:32 98077 Exp $
 */
@Service
public class DefaultIdGenerator implements IdGenerator {
    @Override
    public Long next() {
        return null;
    }
}

