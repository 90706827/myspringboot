package com.jangni.form;

import com.jangni.constraint.WorkOverTime;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/24/024 13:45
 */
public class WorkInfoForm {

    public interface Update{}
    public interface Add{}

    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    Long Id;

    @Max(value = 100, message = "年龄不能大于120岁")
    @Min(value= 18 ,message= "必须年满18岁！" )
    Long age;

    @Length(min = 5, max = 20, message = "用户名长度必须位于5到20之间")
    String name;

    @Email(message = "请输入正确的邮箱")
    String email;

    @Pattern(regexp="1[0-9]{10}", message="手机号错误")
    String mobile;

    @WorkOverTime(max = 2, message = "加班时间超长")
    Integer workTime;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
