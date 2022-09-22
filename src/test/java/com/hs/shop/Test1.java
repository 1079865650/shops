package com.hs.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hs.shop.domain.Product;
import com.hs.shop.service.MerchantService;
import com.hs.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test1 {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ProductService productService;

    @Test
    public void t1(){
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.eq("merchant_id",1);
        List<Product> list = productService.list(qw);
        list.forEach(System.out::println);

    }

}
