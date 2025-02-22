package com.finance.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.account.dto.RespBean;
import com.finance.account.dto.RespBeanEnum;
import com.finance.account.entity.Usermng;
import com.finance.account.service.UsermngService;
import com.finance.account.mapper.UsermngMapper;
import com.finance.account.utils.MD5Util;
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
//        if(!password.equals(user.getPassword())){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR,name);
//        }
        Boolean flag = MD5Util.inputPassEQDBPass(password,user.getPassword());
        if(!flag){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR,name);
        }
        return RespBean.success();
    }

    @Override
    public RespBean registerAccount(Usermng usermng) {
        //判断数据库是否存在该昵称
        Usermng user = usermngMapper.checkPwd(usermng.getName());
        if(user != null){
            return RespBean.error(RespBeanEnum.USER_NAME_REPEAT,usermng.getName());
        }else {
            MD5Util md = new MD5Util();
            usermng.setPassword(md.inputPassSaveToDBPass(usermng.getPassword()));
            usermngMapper.registerAccount(usermng);
            return RespBean.success();
        }
    }

    @Override
    public RespBean loadpm(String name) {
        Usermng user = usermngMapper.checkPwd(name);
        return RespBean.success(user);
    }

    @Override
    public RespBean updatepm(Usermng user) {
        if(user.getPassword() == "" || user.getEmail() == "" || user.getPhone() == ""){
            return RespBean.error(RespBeanEnum.DATA_EMPTY_EXIST);
        }else{
            MD5Util md = new MD5Util();
            user.setPassword(md.inputPassSaveToDBPass(user.getPassword()));
            usermngMapper.updateAccount(user);
            return RespBean.success();
        }
    }
}




