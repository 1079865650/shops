package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.Role;
import com.hs.shop.service.RoleService;
import com.hs.shop.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author carryman
* @description 针对表【role】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




