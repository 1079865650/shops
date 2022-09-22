package com.hs.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hs.shop.domain.Merchant;
import com.hs.shop.domain.Product;
import com.hs.shop.domain.ShopCat;
import com.hs.shop.domain.User;
import com.hs.shop.service.MerchantService;
import com.hs.shop.service.ProductService;
import com.hs.shop.service.ShopCatService;
import com.hs.shop.service.UserService;
import com.hs.shop.vo.CartDetailsVo;
import com.hs.shop.vo.CartMerchantProductVo;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShopApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private ShopCatService shopCatService;
    @Autowired
    private ProductService productService;
    @Autowired
    private MerchantService merchantService;
    @Test
    void contextLoads() {
// 通过用户ID查询购物车
        QueryWrapper<ShopCat> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",1);
        List<ShopCat> shopCats = shopCatService.list(wrapper);

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
        System.out.println(cartDetailsVos);
    }

    //ES 例子
    @Autowired
    RestHighLevelClient client;

    //Redis 例子1
    @Resource
    StringRedisTemplate stringRedisTemplate;
    //Redis 例子2
    @Resource
    RedisTemplate<String, Object> redisTemplate;


    //MQ例子
    @Autowired
    RabbitTemplate rabbitTemplate;


}
