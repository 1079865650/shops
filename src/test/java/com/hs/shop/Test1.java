package com.hs.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hs.shop.domain.ProCategory;
import com.hs.shop.domain.Product;
import com.hs.shop.mapper.ShopCatMapper;
import com.hs.shop.service.MerchantService;
import com.hs.shop.service.ProCategoryService;
import com.hs.shop.service.ProductService;
import com.hs.shop.service.ShopCatService;
import com.hs.shop.vo.PersonalCartVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class Test1 {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProCategoryService proCategoryService;
    @Autowired
    private ShopCatService shopCatService;
    @Autowired
    private ShopCatMapper shopCatMapper;

    @Test
    public void t1() {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.eq("merchant_id", 1);
        List<Product> list = productService.list(qw);
        list.forEach(System.out::println);
    }

    @Test
    public void selectAllProductClassification() {
        ProCategory byId = proCategoryService.getById(7);
        QueryWrapper<ProCategory> qw = new QueryWrapper<>();
        qw.eq("parent_id", 7);
        List<ProCategory> list = proCategoryService.list(qw);
        Map<ProCategory, List<ProCategory>> allProduct = new HashMap<>();
        allProduct.put(byId, list);
    }
    @Test
    public void t3(){
        Page<Product> page = new Page<>(1, 2);
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.like("cate_ids",1);
        Page<Product> page1 = productService.page(page, qw);
        System.out.println(page1.getTotal());
        System.out.println(page1.getCurrent());
        System.out.println(page1.getPages());
        System.out.println(page1.hasNext());
        System.out.println(page1.hasPrevious());
        for(Product p :page1.getRecords()){
            System.out.println(p.toString());
        }
    }
    @Test
    public void t4(){
        int i = 10;
        String a = i+"";
        Integer b = 10;
        String c = b.toString();
        System.out.println(a.getClass());
        System.out.println(c.getClass());
    }
    @Test
    public void t5(){
        QueryWrapper<ProCategory> qw = new QueryWrapper<>();
        qw.and(i -> i.like("cate_name","戴尔").eq("level",1));
        List<ProCategory> list = proCategoryService.list(qw);
        for(ProCategory p : list){
            System.out.println(p.toString());
        }
    }
    @Test
    public void t6(){
        List<PersonalCartVo> personalCartVos = shopCatMapper.selectShopCartById(1);
        for(PersonalCartVo p : personalCartVos){
            System.out.println(p.toString());
        }
    }

}
