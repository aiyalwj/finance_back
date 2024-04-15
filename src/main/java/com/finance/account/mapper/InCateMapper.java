package com.finance.account.mapper;

import com.finance.account.entity.InCate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Windows
* @description 针对表【in_cate(收入类别表)】的数据库操作Mapper
* @createDate 2024-04-01 15:37:17
* @Entity generator.entity.InCate
*/
@Mapper
public interface InCateMapper extends BaseMapper<InCate> {
    List<String> incategory();
}




