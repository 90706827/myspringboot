package com.jangni.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: 自定义注释
 * @Autor: Jangni
 * @Date: Created in  2018/2/24/024 15:39
 */

public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime,Integer> {

    WorkOverTime workOverTime;
    int max;

    public void initialize(WorkOverTime workOverTime) {
        //获取注解的定义
        this.workOverTime = workOverTime;
        max = workOverTime.max();
    }

    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        //逻辑校验
        if(value == null){
            return true;
        }
        return value < max;
    }
}
