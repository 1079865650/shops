package com.hs.shop.controller.merchant;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hs.shop.domain.Merchant;
import com.hs.shop.domain.Product;
import com.hs.shop.service.MerchantService;
import com.hs.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author: zhangxi
 * @date: 2022/9/21 14:38
 * @Version 1.0
 */
@Controller
//@RestController
public class MerchantController {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ProductService productService;

    /**
     * 进入/刷新商家页面的时候调用此请求
     * @param id 根据传入的这个商家的id来查找对应商家与商品
     * @param currPage 查询的页码
     * @param pageSize    查询的每页展示条数
     * @param model   使用model传回数据
     * @return  返回的是视图，即返回到shangjia.html页面，数据使用model传递
     */
    @RequestMapping("/enterMerchant")
    public Object enterMerchant(Integer id,Integer currPage,Integer pageSize, Model model){
        //根据商家id查询商家店铺信息
        Merchant merchant = merchantService.getById(id);
        model.addAttribute("merchant",merchant);

        //根据商家id查询其所拥有的所有的商品信息 ---- 未分页
//        QueryWrapper<Product> qw = new QueryWrapper<>();
//        qw.eq("merchant_id",id);
//        List<Product> productList = productService.list(qw);
//        model.addAttribute("productList",productList);

        //根据商家id查询其所拥有的所有的商品信息 ---- 分页
        if (currPage == null) currPage = 1;
        if (pageSize == null) pageSize = 8;
        IPage<Product> byPage = productService.findByPage(currPage, pageSize, id);
        model.addAttribute("byPage",byPage);

        //根据商家id查询其所拥有的商品中销量前四的商品信息
        QueryWrapper<Product> qw1 = new QueryWrapper<>();
        qw1.eq("merchant_id",id);
        qw1.orderByDesc("sales");
        qw1.last("limit 0,4");
        List<Product> hotSale = productService.list(qw1);
        model.addAttribute("hotSale",hotSale);

        return "shangjia";
    }

}