package com.hs.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailsVo {

    // 店铺名称
    private String merchantName;
    // 店铺ID
    private Integer merchantId;
    // 店铺商品集合
    private List<CartMerchantProductVo> cartMerchantProductVos;
}
