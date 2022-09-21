package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.GoodsOrder;
import com.hs.shop.service.GoodsOrderService;
import com.hs.shop.mapper.GoodsOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author carryman
* @description 针对表【goods_order】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderMapper, GoodsOrder>
    implements GoodsOrderService{

}




