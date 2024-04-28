package com.finance.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.account.dto.RespBean;
import com.finance.account.dto.RespBeanEnum;
import com.finance.account.entity.Result.IndexData;
import com.finance.account.entity.Result.StatisData;
import com.finance.account.service.ShouzhiService;
import com.finance.account.entity.Shouzhi;
import com.finance.account.mapper.ShouzhiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author Windows
* @description 针对表【shouzhi(收支明细表)】的数据库操作Service实现
* @createDate 2024-04-01 15:37:17
*/
@Service
public class ShouzhiServiceImpl extends ServiceImpl<ShouzhiMapper, Shouzhi>
    implements ShouzhiService {
    @Autowired
    private ShouzhiMapper shouzhiMapper;
    @Override
    public RespBean addAccount(Shouzhi shouzhi) {
        if(shouzhi.getCategory().equals("")){
            shouzhiMapper.addacountNoCat(shouzhi);
        }else {
            shouzhiMapper.addacount(shouzhi);
        }
        return RespBean.success();
    }

    @Override
    public RespBean indexLoader(String date) {
        IndexData result = shouzhiMapper.loaderData(date);
        if(result == null){
            IndexData resultReplce = new IndexData();
            resultReplce.setInSum(0);
            resultReplce.setExSum(0);
            resultReplce.setDate(date);
            return RespBean.error(RespBeanEnum.NOT_DATA,resultReplce);
        }else {
            result.setDate(date);
            return RespBean.success(result);
        }
    }

    @Override
    public RespBean queryAll(String name) {
        List<Shouzhi> result = shouzhiMapper.queryAll(name);
        if(result == null){
            return RespBean.error(RespBeanEnum.NOT_DATA);
        }else{
            return RespBean.success(result);
        }
    }

    @Override
    public RespBean queryCond(List<String> data) {
        List<Shouzhi> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals("0")) {
                data.set(i, null);
            }
        }
//        System.out.println("service"+data);
//        System.out.println("service0"+data.get(0));
        if(data.get(0) != null){
            if(data.get(0).equals("支出")){
                result = shouzhiMapper.queryEx(data);
            }else if(data.get(0).equals("收入")){
                result = shouzhiMapper.queryIn(data);
            }
        }else{
            result = shouzhiMapper.queryJstDate(data);
        }

        if(result == null){
            return RespBean.error(RespBeanEnum.NOT_DATA);
        }
        return RespBean.success(result);
    }

    @Override
    public RespBean deleteSZ(String id) {
        shouzhiMapper.deleteSZ(id);
        return RespBean.success();
    }

    @Override
    public RespBean incomeStatis(String name) {
        List<StatisData> result = new ArrayList<>();
        result = shouzhiMapper.incomeStatis(name);
        Double total = 0.0;
        StatisData item = new StatisData();
        for (int i = 0; i < result.size(); i++) {
            // 处理当前元素
//            System.out.println(result.get(i));
            item = result.get(i);
            total = Double.valueOf(item.getValue())+total;
//            Double.parseDouble(str);
        }

        for (int i = 0; i < result.size(); i++) {
            item = result.get(i);
            double d = Double.valueOf(item.getValue()) / total * 100;
            String sd = String.format("%.2f", d);
            // 处理当前元素
            item.setValue(sd);
//            Double.parseDouble(str);
        }
        return RespBean.success(result);
    }

    public RespBean expenseStatis(String name){
        List<StatisData> result = new ArrayList<>();
        result = shouzhiMapper.expenseStatis(name);
        Double total = 0.0;
        StatisData item = new StatisData();
        for (int i = 0; i < result.size(); i++) {
            // 处理当前元素
//            System.out.println(result.get(i));
            item = result.get(i);
            total = Double.valueOf(item.getValue())+total;
//            Double.parseDouble(str);
        }

        for (int i = 0; i < result.size(); i++) {
            item = result.get(i);
            double d = Double.valueOf(item.getValue()) / total * 100;
            String sd = String.format("%.2f", d);
            // 处理当前元素
            item.setValue(sd);
//            Double.parseDouble(str);
        }
        return RespBean.success(result);
    }

    @Override
    public RespBean expenseDetailStatis(String name) {
        List<StatisData> result = shouzhiMapper.exDetailStatis(name);
        List<List> list = new ArrayList<>();
        List<String> date = new ArrayList<>();
        List<String> num = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            date.add(result.get(i).getName());
            num.add(result.get(i).getValue());
        }
        list.add(date);
        list.add(num);
//        System.out.println(date);
//        System.out.println(list);
        return null;
    }
}




