package com.hs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hs.shop.domain.Product;
import com.hs.shop.service.ProductService;
import com.hs.shop.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author carryman
* @description 针对表【product】的数据库操作Service实现
* @createDate 2022-09-20 15:17:11
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




