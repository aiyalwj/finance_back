package com.finance.account.service;

import com.finance.account.dto.RespBean;
import com.finance.account.entity.Shouzhi;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.xml.transform.Result;
import java.util.Date;
import java.util.List;

/**
* @author Windows
* @description 针对表【shouzhi(收支明细表)】的数据库操作Service
* @createDate 2024-04-01 15:37:17
*/
public interface ShouzhiService extends IService<Shouzhi> {
    RespBean addAccount(Shouzhi shouzhi);

    RespBean indexLoader(String date);

    RespBean queryAll();

    RespBean queryCond(List<String> data);

    RespBean deleteSZ(String id);
}
