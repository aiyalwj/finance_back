package com.finance.account.controller;

import com.finance.account.dto.RespBean;
import com.finance.account.entity.Shouzhi;
import com.finance.account.service.ShouzhiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
@Api(value= "主页" ,tags = "主页")
@RequestMapping("/api/index")
public class indexController {
    @Autowired
    private ShouzhiService shouzhiService;
    @ApiOperation(value = "主页信息初始化")
    @GetMapping("/loader")
    public RespBean indexLoader(@RequestParam("date")String date){
        return shouzhiService.indexLoader(date);
    }
}
