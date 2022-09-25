package com.hs.shop.service;

import com.hs.shop.domain.ShopCat;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hs.shop.vo.PersonalCartVo;

import java.util.List;

/**
* @author carryman
* @description 针对表【shop_cat】的数据库操作Service
* @createDate 2022-09-20 15:17:11
*/
public interface ShopCatService extends IService<ShopCat> {
    //个人购物车联查
    List<PersonalCartVo> selectShopCartById(Integer id);
}
