package com.hs.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 购物车与商品的联查
 * @author :王文松
 * @date : 2022/9/24 9:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalCartVo {
    //购物车信息
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer count;

    /**
     * 下面是product的信息
     */
    private String productName;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 基础价格
     */
    private BigDecimal basisPrice;

    /**
     * 库存量
     */
    private Integer productStock;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 收藏量
     */
    private Integer colNumber;

    /**
     * 主图片
     */
    private String mainPhoto;

    /**
     * 商品所属类别id
     */
    private String cateIds;

    /**
     * 商家id，外键
     */
    private Integer merchantId;

    /**
     * 所属属性1id，外键（比如：颜色分类)
     */
    private Integer attr1Id;

    /**
     * 所属属性2id，外键（比如：内存配置)
     */
    private Integer attr2Id;

}
