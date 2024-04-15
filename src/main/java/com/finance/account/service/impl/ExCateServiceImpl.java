package com.finance.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.account.dto.RespBean;
import com.finance.account.service.ExCateService;
import com.finance.account.entity.ExCate;
import com.finance.account.mapper.ExCateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Windows
* @description 针对表【ex_cate(支出类别表)】的数据库操作Service实现
* @createDate 2024-04-01 15:37:17
*/
@Service
public class ExCateServiceImpl extends ServiceImpl<ExCateMapper, ExCate>
    implements ExCateService {
    @Autowired
    private ExCateMapper exCateMapper;
    @Override
    public RespBean exCategory() {
        List<String> result = exCateMapper.excategory();
//        System.out.println(result);
        return RespBean.success(result);
    }
}




