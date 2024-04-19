package com.finance.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.account.dto.RespBean;
import com.finance.account.dto.RespBeanEnum;
import com.finance.account.entity.Result.IndexData;
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
        shouzhiMapper.addacount(shouzhi);
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
    public RespBean queryAll() {
        List<Shouzhi> result = shouzhiMapper.queryAll();
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
}




