package com.finance.account.mapper;

import com.finance.account.entity.Shouzhi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Windows
* @description 针对表【shouzhi(收支明细表)】的数据库操作Mapper
* @createDate 2024-04-01 15:37:17
* @Entity generator.entity.Shouzhi
*/
@Mapper
public interface ShouzhiMapper extends BaseMapper<Shouzhi> {
    void addacount(@Param("shouzhi") Shouzhi shouzhi);
}




