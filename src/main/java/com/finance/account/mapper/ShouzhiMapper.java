package com.finance.account.mapper;

import com.finance.account.entity.Result.IndexData;
import com.finance.account.entity.Shouzhi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author Windows
* @description 针对表【shouzhi(收支明细表)】的数据库操作Mapper
* @createDate 2024-04-01 15:37:17
* @Entity generator.entity.Shouzhi
*/
@Mapper
public interface ShouzhiMapper extends BaseMapper<Shouzhi> {
    void addacount(@Param("shouzhi") Shouzhi shouzhi);

    IndexData loaderData(@Param("date") String date);
}




