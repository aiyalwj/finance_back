package com.finance.account.controller;

import com.finance.account.dto.RespBean;
import com.finance.account.entity.Shouzhi;
import com.finance.account.service.ShouzhiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@Api(value= "收支明细" ,tags = "收支明细")
@RequestMapping("/api/account")
public class accountController {
    @Autowired
    private ShouzhiService shouzhiService;

    @ApiOperation(value = "添加明细")
    @PostMapping("/add")
    public RespBean addAccount(@RequestBody Shouzhi shouzhi){
        return shouzhiService.addAccount(shouzhi);
    }

//    public Result<EdinggonglvALL> statRatedPowerALL(@RequestBody(required=false) Map<String, List<String>> data) {
//        return iDeviceInfoStatService.edinggonglvALL(data);
//    }
}
