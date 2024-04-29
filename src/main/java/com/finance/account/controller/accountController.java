package com.finance.account.controller;

import com.finance.account.dto.RespBean;
import com.finance.account.entity.Shouzhi;
import com.finance.account.service.ExCateService;
import com.finance.account.service.InCateService;
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

    @Autowired
    private ExCateService exCateService;

    @Autowired
    private InCateService inCateService;

    @ApiOperation(value = "添加明细")
    @PostMapping("/add")
    public RespBean addAccount(@RequestBody Shouzhi shouzhi){
        return shouzhiService.addAccount(shouzhi);
    }

//    public Result<EdinggonglvALL> statRatedPowerALL(@RequestBody(required=false) Map<String, List<String>> data) {
//        return iDeviceInfoStatService.edinggonglvALL(data);
//    }

    @ApiOperation(value = "返回收入类别")
    @GetMapping("/inCategory")
    public RespBean returnInCategory(){
        return inCateService.inCategory();
    }
    @ApiOperation(value= "返回支出类别")
    @GetMapping("/exCategory")
    public RespBean returnExCategory(){
        return exCateService.exCategory();
    }

    @ApiOperation(value = "查询所有筛选结果")
    @GetMapping("/queryAll")
    public RespBean queryAll(@RequestParam("name") String name){
        return shouzhiService.queryAll(name);
    }

    @ApiOperation(value = "根据筛选条件查询")
    @PostMapping("/queryWithCond")
    public RespBean queryWithCond(@RequestBody List<String> data){
//        System.out.println(data);
        return shouzhiService.queryCond(data);
    }

    @ApiOperation(value = "删除收支")
    @PostMapping("/delete")
    public RespBean deleteShouzhi(@RequestParam String id){
        return shouzhiService.deleteSZ(id);
    }


    @ApiOperation(value = "支出分布统计")
    @GetMapping("/exStatis")
    public RespBean expenseStatis(@RequestParam String name){
        return shouzhiService.expenseStatis(name);
    }
    @ApiOperation(value = "收入分布统计")
    @GetMapping("/inStatis")
    public RespBean incomeStatis(@RequestParam String name){
        return shouzhiService.incomeStatis(name);
    }

    @ApiOperation(value= "支出明细统计")
    @GetMapping("/exdtalStatis")
    public RespBean expenseDetailStatis(@RequestParam String name){
        return shouzhiService.expenseDetailStatis(name);
    }

    @ApiOperation(value= "收入明细统计")
    @GetMapping("/indtalStatis")
    public RespBean incomeDetailStatis(@RequestParam String name){
        return shouzhiService.incomeDetailStatis(name);
    }


}
