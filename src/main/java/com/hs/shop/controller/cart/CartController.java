package com.hs.shop.controller.cart;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hs.shop.domain.Merchant;
import com.hs.shop.domain.Product;
import com.hs.shop.domain.ShopCat;
import com.hs.shop.domain.User;
import com.hs.shop.service.MerchantService;
import com.hs.shop.service.ProductService;
import com.hs.shop.service.ShopCatService;
import com.hs.shop.vo.CartDetailsVo;
import com.hs.shop.vo.CartMerchantProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private ShopCatService shopCatService;
    @Autowired
    private ProductService productService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    HttpServletRequest request;
    /*
    通过用户ID查询该用户下购物车(按店铺划分)
     */
    @RequestMapping("/selectShoppingCart")
    public String select(Model model){
        // 从session中拿值,获取userId
        User user = (User)request.getSession().getAttribute("user");
        Integer userId = user.getId();
        // 通过用户ID查询购物车
        QueryWrapper<ShopCat> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        List<ShopCat> shopCats = shopCatService.list(wrapper);
        if (shopCats.isEmpty()){
            return "/cart-empty.html";
        }
        // 购物车下商品集合
        List<CartMerchantProductVo> cartMerchantProductVos= new ArrayList<>();
        // 去重店铺ID集合
        List<Integer> merchantIds = new ArrayList<>();
        // 遍历购物车集合
        for (ShopCat shopCat:shopCats){
            Product product = productService.getById(shopCat.getProductId());
            // 通过商品ID查询店铺
            Merchant merchant = merchantService.getById(product.getMerchantId());
            // 创建carMerchantProductVo对象
            CartMerchantProductVo cartMerchantProductVo = new CartMerchantProductVo();
            cartMerchantProductVo.setProductId(product.getId());
            cartMerchantProductVo.setProductName(product.getProductName());
            cartMerchantProductVo.setBasisPrice(product.getBasisPrice());
            cartMerchantProductVo.setCount(shopCat.getCount());
            cartMerchantProductVo.setMainPhoto(product.getMainPhoto());
            cartMerchantProductVo.setMerchantId(merchant.getId());
            cartMerchantProductVo.setMerchantName(merchant.getMerchantName());
            cartMerchantProductVos.add(cartMerchantProductVo);
            if (!merchantIds.contains(merchant.getId())){
                merchantIds.add(merchant.getId());
            }
        }
        // 购物车店铺集合
        List<CartDetailsVo> cartDetailsVos = new ArrayList<>();
        // 遍历店铺ID集合，查询该店铺下所有商品
        for (Integer merchantId : merchantIds){
            // 通过店铺ID获取店铺
            Merchant merchant = merchantService.getById(merchantId);
            // 店铺商品集合
            List<CartMerchantProductVo> merchantProductVos= new ArrayList<>();
            QueryWrapper<Product> mp = new QueryWrapper<>();
            mp.eq("merchant_id",merchantId);
            List<Product> products = productService.list(mp);
            // 遍历商品获取商品名集合
            for (Product product:products){
                String productName = product.getProductName();
                // 通过店铺下商品名与购物车商品名比对，将商品对象放入购物车中店铺商品集合
                for (CartMerchantProductVo cartMerchantProductVo:cartMerchantProductVos){
                    String cartMerchantProductName = cartMerchantProductVo.getProductName();
                    if (cartMerchantProductName.equals(productName)){
                        merchantProductVos.add(cartMerchantProductVo);
                    }
                }
            }
            // 将购物车中店铺商品集合放入cartDetailsVo对象中
            CartDetailsVo cartDetailsVo = new CartDetailsVo();
            cartDetailsVo.setMerchantId(merchantId);
            cartDetailsVo.setMerchantName(merchant.getMerchantName());
            cartDetailsVo.setCartMerchantProductVos(merchantProductVos);
            cartDetailsVos.add(cartDetailsVo);
        }
        // 把店铺集合传给前端页面
        model.addAttribute("cartDetailsVos",cartDetailsVos);
        return "/cart.html";
    }
    /*
    通过id查询购物车，通过商品id查询商品信息
     */
    @RequestMapping("/selectCartById")
    public String selectById(Integer id, Model model){
        ShopCat shopCat = shopCatService.getById(id);
        Product product = productService.getById(shopCat.getProductId());
        Merchant merchant = merchantService.getById(product.getMerchantId());
        // 购物车商品详情
        CartMerchantProductVo cartMerchantProductVo = new CartMerchantProductVo();
        cartMerchantProductVo.setProductId(product.getId());
        cartMerchantProductVo.setProductName(product.getProductName());
        cartMerchantProductVo.setBasisPrice(product.getBasisPrice());
        cartMerchantProductVo.setCount(shopCat.getCount());
        cartMerchantProductVo.setMainPhoto(product.getMainPhoto());
        cartMerchantProductVo.setMerchantName(merchant.getMerchantName());
        cartMerchantProductVo.setMerchantId(merchant.getId());
        // 传给前端
        model.addAttribute(cartMerchantProductVo);
        return null;
    }

    /*
    添加购物车
     */
    @RequestMapping("/addCart")
    public String add(Integer productId, Integer count, Model model){
        // 从session中拿值,获取userId
        User user = (User)request.getSession().getAttribute("user");
        Integer userId = user.getId();
        // 创建一个对象用来存储购物车信息
        ShopCat shopCat1 = new ShopCat();
        shopCat1.setId(null);
        shopCat1.setUserId(userId);
        shopCat1.setProductId(productId);
        shopCat1.setCount(count);
        // 判断该用户购物车中是否存在需要添加的商品
        // 通过用户ID查询购物车
        QueryWrapper<ShopCat> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        List<ShopCat> shopCats = shopCatService.list(wrapper);
        // 购物车无商品的情况，将数据直接插入数据库
        if (shopCats.isEmpty()){
            shopCatService.save(shopCat1);
            model.addAttribute("mess","添加成功");
            return "/goods-detail.html";
        }
        // 购物车不为空,遍历购物车，判断购物车中商品id与要添加商品id是否相同
        for (ShopCat shopCat:shopCats){
            Integer shopCatProductId = shopCat.getProductId();
            if (shopCatProductId.equals(productId)){
                ShopCat shopCat2 = new ShopCat();
                shopCat2.setId(shopCat.getId());
                shopCat2.setUserId(userId);
                shopCat2.setProductId(productId);
                shopCat2.setCount(shopCat.getCount()+count);
                shopCatService.updateById(shopCat2);
                model.addAttribute("mess","添加成功");
                return "/goods-detail.html";
            }
        }
        // 购物车不为空,但没有此商品
        shopCatService.save(shopCat1);
        model.addAttribute("mess","添加成功");
        return "/goods-detail.html";
    }

    /*
    删除购物车商品（单条数据）,通过商品id
     */
    @RequestMapping("/deleteCart")
    public String delect(Integer productId,Model model){
        // 从session中拿值,获取userId
        User user = (User)request.getSession().getAttribute("user");
        Integer userId = user.getId();
        // 判断商品是否存在，存在
        if (productId!=null){
            QueryWrapper<ShopCat> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",userId)
                    .eq("product_id",productId);
            boolean remove = shopCatService.remove(wrapper);
            if (remove){
                model.addAttribute("mess","删除成功");
                return "forward:selectShoppingCart";
            }
            model.addAttribute("mess","删除失败");
            return "forward:selectShoppingCart";
        }
        // 不存在
        return null;
    }

}
