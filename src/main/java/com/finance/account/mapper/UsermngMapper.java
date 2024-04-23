package com.finance.account.mapper;

import com.finance.account.entity.Usermng;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Windows
* @description 针对表【usermng(用户管理表)】的数据库操作Mapper
* @createDate 2024-04-01 15:37:17
* @Entity generator.entity.Usermng
*/
@Mapper
public interface UsermngMapper extends BaseMapper<Usermng> {
    Usermng checkPwd(@Param("name") String name);
    void registerAccount(@Param("user")Usermng user);

    void updateAccount(@Param("user") Usermng user);
}




