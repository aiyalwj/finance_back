package com.finance.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.account.dto.RespBean;
import com.finance.account.service.ShouzhiService;
import com.finance.account.entity.Shouzhi;
import com.finance.account.mapper.ShouzhiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;

/**
* @author Windows
* @description 针对表【shouzhi(收支明细表)】的数据库操作Service实现
* @createDate 2024-04-01 15:37:17
*/
@Service
public class ShouzhiServiceImpl extends ServiceImpl<ShouzhiMapper, Shouzhi>
    implements ShouzhiService {
    @Autowired
    private ShouzhiMapper shouzhiMapper;
    @Override
    public RespBean addAccount(Shouzhi shouzhi) {
        shouzhiMapper.addacount(shouzhi);
        return RespBean.success();
    }
}




