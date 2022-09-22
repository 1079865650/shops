package com.hs.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartMerchantProductVo {

    // 商品ID
    private Integer productId;
    // 商品名称
    private String productName;
    // 商品单价
    private BigDecimal basisPrice;
    // 同样商品数量
    private Integer count;
    // 商品图片
    private String mainPhoto;
    // 店铺ID
    private Integer merchantId;
    // 店铺名称
    private String merchantName;

}
