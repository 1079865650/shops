package com.hs.shop.domain;

import lombok.Data;

import java.util.List;

/**
 * 封装父类商品proCategory 子类商品proCategories
 * @author :王文松
 * @date : 2022/9/22 10:10
 */
@Data
public class ProductClassification {
    private ProCategory proCategory;
    private List<ProCategory> proCategories;
}
