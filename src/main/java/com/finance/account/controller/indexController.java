package com.finance.account.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value= "主页" ,tags = "主页")
@RequestMapping("/index")
public class indexController {

}
