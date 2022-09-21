package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.OrderProduct;
import com.hs.shop.service.OrderProductService;
import com.hs.shop.mapper.OrderProductMapper;
import org.springframework.stereotype.Service;

/**
* @author carryman
* @description 针对表【order_product】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class OrderProductServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct>
    implements OrderProductService{

}




