package com.jangni.controller;

import com.jangni.form.WorkInfoForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/24/024 13:43
 */
@Controller
@RequestMapping("/valid")
public class ValidatorController {

    @RequestMapping(value = "/demo.html")
    public String  demos(){
        System.out.println("1");
        return "/valid.btl";
    }

    @RequestMapping("/add")
    @ResponseBody
    public void addInfo(@Validated({WorkInfoForm.Add.class})WorkInfoForm form,BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError)list.get(0);
            System.out.println(error.getField());
            System.out.println(error.getObjectName());
            System.out.println(error.getDefaultMessage());
            return;
        }
        return;
    }

    @RequestMapping("/update")
    @ResponseBody
    public void updateInfo(@Validated({WorkInfoForm.Update.class})WorkInfoForm form,BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError)list.get(0);
            System.out.println(error.getField());
            System.out.println(error.getObjectName());
            System.out.println(error.getDefaultMessage());
            return;
        }
        return;
    }
}
