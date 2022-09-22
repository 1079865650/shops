package com.hs.shop.controller.ht_Business;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hs.shop.domain.Merchant;
import com.hs.shop.domain.R;
import com.hs.shop.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台管理系统 商家列表
 * 查询商家所有信息
 * 删除商家
 * 根据名称模糊查询
 * 改变商家状态
 * @author :王文松
 * @date : 2022/9/22 18:54
 */
@RestController
@CrossOrigin
public class BusinessList {
    @Autowired
    MerchantService merchantService;
    // 返回所有商家信息
    @RequestMapping("/businessList")
    public Object businessList(@RequestParam(defaultValue = "1") String pageCurrent){
        Page<Merchant> page1 = new Page<>(Integer.parseInt(pageCurrent), 4);
        Page<Merchant> page = merchantService.page(page1);
        return R.ok(page);
    }
    // 改变商家的状态值
    //根据名称模糊查询
    @RequestMapping("/selectBusinessByName")
    public Object selectBusinessByName(
            String businessName,@RequestParam(defaultValue = "1") String pageCurrent){
        QueryWrapper<Merchant> qw = new QueryWrapper<>();
        if(businessName!=null && ""!=businessName){qw.like("merchant_name",businessName);
        }
        Page<Merchant> page1 = new Page<>(Integer.parseInt(pageCurrent),4);
        Page<Merchant> page = merchantService.page(page1, qw);
        return R.ok(page);
    }
    // 删除商家
    @RequestMapping("/deleteBusiness")
    public Object deleteBusiness(Integer id){
        boolean b = merchantService.removeById(id);
        if(b == false){
            return R.failed(400,"删除失败!");
        }
        return R.ok("删除成功!");
    }







}
