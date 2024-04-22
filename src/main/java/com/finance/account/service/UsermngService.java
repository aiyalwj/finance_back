package com.finance.account.service;

import com.finance.account.dto.RespBean;
import com.finance.account.entity.Usermng;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Windows
* @description 针对表【usermng(用户管理表)】的数据库操作Service
* @createDate 2024-04-01 15:37:17
*/
public interface UsermngService extends IService<Usermng> {
    RespBean loginAccount(String name,String password);
    RespBean registerAccount(Usermng usermng);

    RespBean loadpm(String name);
}
