package com.finance.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.account.dto.RespBean;
import com.finance.account.mapper.ExCateMapper;
import com.finance.account.service.InCateService;
import com.finance.account.entity.InCate;
import com.finance.account.mapper.InCateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Windows
* @description 针对表【in_cate(收入类别表)】的数据库操作Service实现
* @createDate 2024-04-01 15:37:17
*/
@Service
public class InCateServiceImpl extends ServiceImpl<InCateMapper, InCate>
    implements InCateService {
    @Autowired
    private InCateMapper inCateMapper;
    @Override
    public RespBean inCategory() {
        List<String> result = inCateMapper.incategory();
//        System.out.println(result);
        return RespBean.success(result);
    }
}




