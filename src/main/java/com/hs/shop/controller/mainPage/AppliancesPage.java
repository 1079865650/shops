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

import java.util.ArrayList;
import java.util.List;

/**
 * 家用电器的首页
 * @author :王文松
 * @date : 2022/9/22 14:22
 */
@Controller
@CrossOrigin
public class AppliancesPage {
    @Autowired
    ProductService productService;
    @Autowired
    ProCategoryService proCategoryService;
    // 跳转到首页 并返回所需要的数据
    @RequestMapping("/toAppliancesPage")
    public String toAppliancesPage(Model model){
        // 轮播图
        // 根据品牌分类 戴尔
        List<Product> products = selectBrandAndProducts("戴尔");
        // 根据品牌分类  华硕
        List<Product> products1 = selectBrandAndProducts("华硕");
        model.addAttribute("products",products);
        model.addAttribute("products1",products1);
        return "index-dq";
    }
    /**
     * 根据品牌名称查询旗下所有商品
     * @author 王文松
     * @date 2022/9/22 16:03
    */
    private List<Product> selectBrandAndProducts(String brandName) {
        QueryWrapper<ProCategory> qw = new QueryWrapper<>();
        qw.and(i -> i.like("cate_name",brandName).eq("level",1));
        List<ProCategory> proCategories = proCategoryService.list(qw);
        List<String> ids = new ArrayList<>();
        for(ProCategory p : proCategories){
            ids.add(p.getId()+"");
        }
        QueryWrapper<Product> qw1 = new QueryWrapper<>();
        for(String s : ids){
            qw1.likeRight("cate_ids",s).or();
        }
        List<Product> products = productService.list(qw1);
        return products;
    }

}
