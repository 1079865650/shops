package com.hs.shop.controller.mainPage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hs.shop.domain.ProCategory;
import com.hs.shop.domain.Product;
import com.hs.shop.service.ProCategoryService;
import com.hs.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索跳转页面  搜索栏动态搜索  图片静态搜索
 * @author :王文松
 * @date : 2022/9/22 15:37
 */
@Controller
@CrossOrigin
public class SearchPage {
    @Autowired
    ProCategoryService proCategoryService;
    @Autowired
    ProductService productService;
    // 图片静态名称搜索
    @RequestMapping
    public String searchPage(Model model,String name, @RequestParam(value = "1") String pageCurrent){
        Page<Product> products = selectAppliancesByName(name, Integer.parseInt(pageCurrent));
        model.addAttribute("products",products);
        return "search-goods";
    }

    /**
     * param name 根据 类型的名称cate_name 返回一个 Page<Product>
     * @author 王文松
     * @date 2022/9/22 15:41
    */
    private Page<Product> selectAppliancesByName(String name,int pageCurrent) {
        QueryWrapper<ProCategory> qw = new QueryWrapper<>();
        qw.like("cate_name",name);
        List<ProCategory> proCategories = proCategoryService.list(qw);
        List<String> ids = new ArrayList<>();
        for(ProCategory p : proCategories){
            ids.add(p.getId()+"");
        }
        QueryWrapper<Product> qw2 = new QueryWrapper<>();
        for(String s : ids){
            qw2.like("cate_ids",s).or();
        }
        Page<Product> page = new Page<>(pageCurrent, 9);
        Page<Product> page1 = productService.page(page, qw2);
        return page1;
    }
}
