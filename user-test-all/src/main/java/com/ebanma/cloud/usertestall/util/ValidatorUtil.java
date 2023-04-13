package com.ebanma.cloud.usertestall.util;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author 于秦涛
 * @version $ Id: ValidatorUtil, v 0.1 2023/03/22 14:15 98077 Exp $
 */
public class ValidatorUtil {

    //定制校验器

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T object,Class... groups){
        Set<ConstraintViolation<T>> validate = validator.validate(object, groups);

        //如果校验结果不为空
        if(CollectionUtils.isEmpty(validate)){
            StringBuilder stringBuilder = new StringBuilder();
            validate.forEach(result->stringBuilder.append(result.toString()));

            throw new RuntimeException(stringBuilder.toString());
        }
    }

}

