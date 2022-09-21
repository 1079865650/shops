package com.hs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
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
    private Integer colMunber;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getBasisPrice() == null ? other.getBasisPrice() == null : this.getBasisPrice().equals(other.getBasisPrice()))
            && (this.getProductStock() == null ? other.getProductStock() == null : this.getProductStock().equals(other.getProductStock()))
            && (this.getSales() == null ? other.getSales() == null : this.getSales().equals(other.getSales()))
            && (this.getColMunber() == null ? other.getColMunber() == null : this.getColMunber().equals(other.getColMunber()))
            && (this.getMainPhoto() == null ? other.getMainPhoto() == null : this.getMainPhoto().equals(other.getMainPhoto()))
            && (this.getCateIds() == null ? other.getCateIds() == null : this.getCateIds().equals(other.getCateIds()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getAttr1Id() == null ? other.getAttr1Id() == null : this.getAttr1Id().equals(other.getAttr1Id()))
            && (this.getAttr2Id() == null ? other.getAttr2Id() == null : this.getAttr2Id().equals(other.getAttr2Id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getBasisPrice() == null) ? 0 : getBasisPrice().hashCode());
        result = prime * result + ((getProductStock() == null) ? 0 : getProductStock().hashCode());
        result = prime * result + ((getSales() == null) ? 0 : getSales().hashCode());
        result = prime * result + ((getColMunber() == null) ? 0 : getColMunber().hashCode());
        result = prime * result + ((getMainPhoto() == null) ? 0 : getMainPhoto().hashCode());
        result = prime * result + ((getCateIds() == null) ? 0 : getCateIds().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getAttr1Id() == null) ? 0 : getAttr1Id().hashCode());
        result = prime * result + ((getAttr2Id() == null) ? 0 : getAttr2Id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productName=").append(productName);
        sb.append(", detail=").append(detail);
        sb.append(", basisPrice=").append(basisPrice);
        sb.append(", productStock=").append(productStock);
        sb.append(", sales=").append(sales);
        sb.append(", colMunber=").append(colMunber);
        sb.append(", mainPhoto=").append(mainPhoto);
        sb.append(", cateIds=").append(cateIds);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", attr1Id=").append(attr1Id);
        sb.append(", attr2Id=").append(attr2Id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}