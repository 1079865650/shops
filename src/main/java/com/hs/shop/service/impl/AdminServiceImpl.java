package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.Admin;
import com.hs.shop.service.AdminService;
import com.hs.shop.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author carryman
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




