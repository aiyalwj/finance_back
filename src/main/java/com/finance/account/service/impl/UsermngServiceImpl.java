package com.finance.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.account.dto.RespBean;
import com.finance.account.dto.RespBeanEnum;
import com.finance.account.entity.Usermng;
import com.finance.account.service.UsermngService;
import com.finance.account.mapper.UsermngMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Windows
* @description 针对表【usermng(用户管理表)】的数据库操作Service实现
* @createDate 2024-04-01 15:37:17
*/
@Service
public class UsermngServiceImpl extends ServiceImpl<UsermngMapper, Usermng>
    implements UsermngService{
    @Autowired
    private UsermngMapper usermngMapper;

    @Override
    public RespBean loginAccount(String name, String password) {
        Usermng user = usermngMapper.checkPwd(name);
        if(user == null){
            return RespBean.error(RespBeanEnum.USER_NOT_FOUND,name);
        }

        if(!password.equals(user.getPassword())){
            System.out.println("不一样");
            return RespBean.error(RespBeanEnum.LOGIN_ERROR,name);
        }
        return RespBean.success();
    }

    @Override
    public RespBean registerAccount(Usermng usermng) {
        usermngMapper.registerAccount(usermng);
        return RespBean.success();
    }
}




