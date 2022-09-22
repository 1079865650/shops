package com.hs.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hs.shop.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author carryman
* @description 针对表【product】的数据库操作Service
* @createDate 2022-09-20 15:17:11
*/
public interface ProductService extends IService<Product> {

    /**
     * 分页查询某商家的所有商品
     * @param currPage 当前页码
     * @param pageSize 每页展示数据条数
     * @param id  商家id
     * @return  返回一个IPage<Product>类型的数据
     */
    public IPage<Product> findByPage(Integer currPage,Integer pageSize,Integer id);

}
