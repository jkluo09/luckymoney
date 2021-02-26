package com.jkluo.luckymoney.controller;


import com.jkluo.luckymoney.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    //获取url中的参数
//    @GetMapping("/say/{id}")
////    @PostMapping("/say{id}")
//    public String say(@PathVariable("id") Integer id){
//        return "id:" + id;
//    }

    //获取请求的参数
    @GetMapping("/say")
//    @PostMapping("/say{id}")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id:" + id;
    }


//    @GetMapping("/index")
//    public String showPage(){
//        return "index";
//    }


}
