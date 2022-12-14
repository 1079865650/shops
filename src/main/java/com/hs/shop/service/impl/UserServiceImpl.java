package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.User;
import com.hs.shop.service.UserService;
import com.hs.shop.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author carryman
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




