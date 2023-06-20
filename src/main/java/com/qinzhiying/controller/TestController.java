package com.qinzhiying.controller;


import com.qinzhiying.base.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public R hello() {
        return R.ok().message("hello");
    }

}