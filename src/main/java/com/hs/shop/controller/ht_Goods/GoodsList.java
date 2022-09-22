package com.hs.shop.controller.ht_Goods;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hs.shop.domain.Merchant;
import com.hs.shop.domain.Product;
import com.hs.shop.domain.R;
import com.hs.shop.service.MerchantService;
import com.hs.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台商铺信息列表
 * 查询所有
 * 根据名称模糊查询
 * 根据商家查询旗下商品
 * 删除一个商品
 *
 * @author :王文松
 * @date : 2022/9/22 19:35
 */
@RestController
@CrossOrigin
public class GoodsList {
    @Autowired
    MerchantService merchantService;
    @Autowired
    ProductService productService;
    // 查询所有商品
    @RequestMapping("/selectAllGoods")
    public Object selectAllGoods(@RequestParam(defaultValue =  "1") String pageCurrent){
        Page<Product> page1 = new Page<>(Integer.parseInt(pageCurrent), 4);
        Page<Product> page = productService.page(page1);
        return R.ok(page);
    }
    //根据名称模糊查询
    @RequestMapping("/selectGoodsByName")
    public Object selectGoodsByName(String productName,@RequestParam(defaultValue = "1") String pageCurrent){
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.like("product_name",productName);
        Page<Product> page1 = new Page<>(Integer.parseInt(pageCurrent),4);
        Page<Product> page = productService.page(page1, qw);
        return R.ok(page);
    }
}
