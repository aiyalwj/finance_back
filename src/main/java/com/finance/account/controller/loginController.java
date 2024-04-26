package com.finance.account.controller;

import com.finance.account.dto.RespBean;
import com.finance.account.entity.Usermng;
import com.finance.account.service.UsermngService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(value= "登录注册" ,tags = "登陆注册")
@RequestMapping("/api")
public class loginController {
    @Autowired
    private UsermngService usermngService;
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public RespBean login(@RequestParam("name")String name,@RequestParam("password") String password){
        return usermngService.loginAccount(name,password);
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public RespBean register(@RequestBody Usermng usermng){
        return usermngService.registerAccount(usermng);
    }

    @ApiOperation(value = "加载个人信息")
    @PostMapping("/user/loaderpm")
    public RespBean loaderPM(@RequestParam("name") String name){
        return usermngService.loadpm(name);
    }

    @ApiOperation(value = "修改个人信息")
    @PostMapping("/user/updatepm")
    public RespBean updatePM(@RequestBody Usermng usermng){
        return usermngService.updatepm(usermng);
    }
}
