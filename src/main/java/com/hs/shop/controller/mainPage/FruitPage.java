package com.hs.shop.controller.mainPage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hs.shop.domain.ProCategory;
import com.hs.shop.domain.Product;
import com.hs.shop.domain.ProductClassification;
import com.hs.shop.service.ProCategoryService;
import com.hs.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * 水果生鲜页面
 * @author :王文松
 * @date : 2022/9/22 9:19
 */
@Controller
@CrossOrigin
public class FruitPage {
    @Autowired
    ProductService productService;
    @Autowired
    ProCategoryService proCategoryService;
    /**
     * 跳转到 水果生鲜页面 并查询所有需要的数据 放入model返回
     * @author 王文松
     * @date 2022/9/22 9:20
    */
    @RequestMapping("/toFruitPage")
    public String toFruitPage(Model model){
        // 查询全部分类 新鲜水果为一级  下面字段为二级
        ProductClassification productClassification = selectAllProductClassification(7);
        model.addAttribute("p_Classification",productClassification);
        //查询今日特惠的商品  根据product cate_ids属性查询生鲜下面的商品 按照时间排序(也可以按照别的排序) 取五个
        List<Product> products1 = selectFruitByCategory("1", "sales", 0, 5);
        //查询新鲜水果
        List<Product> products2 = selectFruitByCategory("1", "col_munber", 0, 6);
        //查询新鲜海鲜
        List<Product> products3 = selectFruitByCategory("1", "product_stock", 0, 6);
        //查询新鲜鲜肉
        List<Product> products4 = selectFruitByCategory("2", "", 0, 6);
        //查询蔬菜蛋白
        List<Product> products5 = selectFruitByCategory("4", null, 0, 6);
        return "index-sxtc";
    }
    /**
     * cateId 种类id  group 按照条件查询倒序 如 销售量  limit  start，end
     * @author 王文松
     * @date 2022/9/22 11:51
    */
    private  List<Product> selectFruitByCategory(String cateId, String group, int start, int end) {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        if(cateId!=null && !"".equals(cateId)){
            qw.like("cate_ids",cateId);
        }
        if(group!=null && !"".equals(group)){
            qw.orderByDesc(group);
        }
        if(start!=0 && end!=0 ){
            String limit = "limit "+start+","+end;
            qw.last(limit);
        }
        List<Product> products = productService.list(qw);
        return products;

    }

    /**
     * 参数:父级商品id 返回一个productClassification对象 封装了 父类商品 子类商品
     * @author 王文松
     * @date 2022/9/22 9:27
    */
    private ProductClassification selectAllProductClassification(int id) {
        ProCategory byId = proCategoryService.getById(7);
        QueryWrapper<ProCategory> qw = new QueryWrapper<>();
        qw.eq("parent_id", 7);
        List<ProCategory> list = proCategoryService.list(qw);
        ProductClassification allProduct = new ProductClassification();
        allProduct.setProCategory(byId);
        allProduct.setProCategories(list);
       return allProduct;
    }
}
