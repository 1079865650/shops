package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.ShopCat;
import com.hs.shop.service.ShopCatService;
import com.hs.shop.mapper.ShopCatMapper;
import com.hs.shop.vo.PersonalCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author carryman
* @description 针对表【shop_cat】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class ShopCatServiceImpl extends ServiceImpl<ShopCatMapper, ShopCat>
    implements ShopCatService{
    @Override
    public List<PersonalCartVo> selectShopCartById(Integer id) {
        return baseMapper.selectShopCartById(id);
    }
}




