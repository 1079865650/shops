package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.Merchant;
import com.hs.shop.service.MerchantService;
import com.hs.shop.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author carryman
* @description 针对表【merchant】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant>
    implements MerchantService{

}