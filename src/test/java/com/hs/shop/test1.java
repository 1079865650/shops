package com.hs.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hs.shop.domain.Product;
import com.hs.shop.domain.User;
import com.hs.shop.service.ProductService;
import com.hs.shop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author :王文松
 * @date : 2022/9/21 15:27
 */
@SpringBootTest
public class test1 {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Test
    public void toMainPage(){
        User user = userService.getById(1);
        System.out.println(user.toString());
    }
    @Test
    public void t2(){
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.eq("merchant_Id",1);
        List<Product> products = productService.list(qw);
//        Map<String, Object> map = productService.getMap(qw);
//        System.out.println(map);
        for(Product p : products){
            System.out.println("list:"+p.toString());
        }
    }
}
