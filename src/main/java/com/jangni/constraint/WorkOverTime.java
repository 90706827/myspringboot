package com.jangni.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description: 自定义注释
 * @Autor: Jangni
 * @Date: Created in  2018/2/24/024 15:38
 */

@Constraint(validatedBy = {WorkOverTimeValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkOverTime {
    String message() default "加班时间超长，不能超过{max}小时";
    int max() default 5;
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
