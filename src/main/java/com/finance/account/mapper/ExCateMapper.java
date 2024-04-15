package com.finance.account.mapper;

import com.finance.account.entity.ExCate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Windows
* @description 针对表【ex_cate(支出类别表)】的数据库操作Mapper
* @createDate 2024-04-01 15:37:17
* @Entity generator.entity.ExCate
*/
@Mapper
public interface ExCateMapper extends BaseMapper<ExCate> {
    List<String> excategory();
}




