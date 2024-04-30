package com.finance.account;

import com.finance.account.entity.Result.StatisData;
import com.finance.account.entity.Shouzhi;
import com.finance.account.mapper.ShouzhiMapper;
import com.finance.account.service.ShouzhiService;
import com.finance.account.utils.MD5Util;
import io.swagger.annotations.Authorization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FinanceBackApplicationTests {

    @Autowired
    private ShouzhiMapper shouzhiMapper;

    @Autowired
    private ShouzhiService shouzhiService;
    @Test
    void contextLoads() {
    }

    @Test
    void queryTest(){
        List<String> date = new ArrayList<>();
        date.add("支出");
        date.add("交通");
        date.add("2024-01-01");
        date.add("2024-04-18");
        List<Shouzhi> result = shouzhiMapper.queryEx(date);
    }

    @Test
    void queryJstDate(){
        List<String> date = new ArrayList<>();
        date.add(null);
        date.add(null);
        date.add("2024-04-11");
        date.add("2024-04-18");
        List<Shouzhi> result = shouzhiMapper.queryJstDate(date);
    }

    @Test
    void incomeStatis(){
        List<StatisData> result = new ArrayList<>();
        result = shouzhiMapper.incomeStatis("test");
        System.out.println(result);
    }

    @Test
    void exbfbStatis(){
        shouzhiService.expenseStatis("test");
//        System.out.println(result);
    }

    @Test
    void exdetailStatis(){
        shouzhiService.expenseDetailStatis("test");
    }

    @Test
    void login(){
        System.out.println(MD5Util.inputPassEQDBPass("12345","zN0TB07eb69150f99107ae52ddfcac623fd7a"));
    }


}
