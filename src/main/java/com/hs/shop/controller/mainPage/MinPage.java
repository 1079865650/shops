package com.hs.shop.controller.mainPage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hs.shop.domain.*;
import com.hs.shop.service.*;
import com.hs.shop.vo.CityAndCounties;
import com.hs.shop.vo.ProvinceAndCity;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页的controller层
 * @author 王文松
 * @date 2022/9/21 14:47
*/
@Controller
@CrossOrigin
public class MinPage {
    @Autowired
    UserService userService;
    @Autowired
    BannerService bannerService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductPhoService productPhoService;
    @Autowired
    MerchantService merchantService;
    @Autowired
    ProvinceService provinceService;

   /**
    * 返回index.html主页面  并且返回主页面需要的所有数据
    * @author 王文松
    * @date 2022/9/21 19:54
   */
    @RequestMapping(value = {"/toIndex","/","/index.html"})
    public String toIndex(Model model){
        //查询banner图 前三张
        QueryWrapper<Banner> bw = new QueryWrapper<>();
        bw.last("limit 0,3");
        List<Banner> banners = bannerService.list(bw);
        model.addAttribute("banners",banners);
        //商品促销
        List<Product> products = selectProductsBycondition("sales", 0, 4);
        model.addAttribute("products",products);
        //查询限时抢购  根据库存存量查询 返回最多的商品
        List<Product> products1 = selectProductsBycondition("product_stock", 0, 8);
        model.addAttribute("products1",products1);
        //查询品牌盛宴 根据收藏量查询 返回最多的商品
        List<Product> products2 = selectProductsBycondition("col_munber", 0, 8);
        model.addAttribute("products2",products2);
        //热卖排行  根据销售量查询 返回最多的商品
        List<Product> products3 = selectProductsBycondition("sales", 0, 9);
        model.addAttribute("products3",products3);
        //商品超市  根据价格查询   返回最多的商品
        List<Product> products4 = selectProductsBycondition("basis_price", 0, 9);
        model.addAttribute("products4",products4);
        return "index";
    }
/**
 * queryWrapper 根据 order by column desc limit start ， end 条件查询product
 * @author 王文松
 * @date 2022/9/21 23:10
*/

    private List<Product> selectProductsBycondition(String column, int begin, int end) {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        if(column!=null && !"".equals(column)){
            qw.orderByDesc(column);
        }
        String query = "limit "+begin+","+end;
        qw.last(query);
        List<Product> products = productService.list(qw);
        return products;
    }

    @RequestMapping("/goodsDetail")
    public String goodsDetail(Integer id,Model model){
        //返回商品根据id
        Product product = productService.getById(id);
        model.addAttribute("product",product);
        //返回商品关联的相关图片
        List<ProductPho> list = productPhoService.list(new QueryWrapper<ProductPho>().eq("product_id",id));
        model.addAttribute("productPho",list);
        // 返回商品对应的商家id
        Merchant merchant = merchantService.getById(product.getMerchantId());
        model.addAttribute("merchant",merchant);
        return "goods-detail";
    }

    @RequestMapping("/showImg")
    public void showImg(String filename, HttpServletResponse response) throws Exception{
        File file = new File("D:\\桌面\\shopsphoto",filename);
        FileInputStream fin = new FileInputStream(file);
        // 设置响应头信息
        response.setHeader("Content-Disposition", "filename="+filename);//预览
        ServletOutputStream out = response.getOutputStream();
        // 拷贝
        IOUtils.copy(fin,out);
        out.close();
        fin.close();
    }

    /**
     * 省市区联动
     * @param province
     * @return
     */
    @RequestMapping("selectAllProvince")
    @ResponseBody
    public Object selectAllProvince(String province){
        ProvinceAndCity provinceAndCity = new ProvinceAndCity();
        List<CityAndCounties> list = new ArrayList<>();
        Province areaName = provinceService.getOne(new QueryWrapper<Province>().eq("areaName", province));
        List<Province> provinces = provinceService.list(new QueryWrapper<Province>().eq("parent_id", areaName.getId()));
        for (Province p : provinces){
            CityAndCounties cityAndCounties1 = new CityAndCounties();
            List<Province> counties = provinceService.list(new QueryWrapper<Province>().eq("parent_id", p.getId()));
            cityAndCounties1.setCity(p);
            cityAndCounties1.setCounties(counties);
            list.add(cityAndCounties1);
        }
        provinceAndCity.setProvince(areaName);
        provinceAndCity.setCities(list);
        return R.ok(provinceAndCity);
    }

}
