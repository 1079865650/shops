package com.hs.shop.mapper;

import com.hs.shop.domain.ShopCat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hs.shop.vo.PersonalCartVo;

import java.util.List;

/**
* @author carryman
* @description 针对表【shop_cat】的数据库操作Mapper
* @createDate 2022-09-20 15:17:11
* @Entity com.hs.shop.domain.ShopCat
*/
public interface ShopCatMapper extends BaseMapper<ShopCat> {
    //个人购物车联查
    List<PersonalCartVo> selectShopCartById(Integer id);

}




