package com.hs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName merchant
 */
@TableName(value ="merchant")
@Data
public class Merchant implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商家名
     */
    private String merchantName;

    /**
     * 商家标志图
     */
    private String merchantImage;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 商家电话
     */
    private String telphone;

    /**
     * 拥有商品的数量
     */
    private Integer productNumber;

    /**
     * 成交量
     */
    private Integer saleNumber;

    /**
     * 粉丝数量
     */
    private Integer fansCount;

    /**
     * 逻辑删除
     */
    private String deleted;

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
        Merchant other = (Merchant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMerchantName() == null ? other.getMerchantName() == null : this.getMerchantName().equals(other.getMerchantName()))
            && (this.getMerchantImage() == null ? other.getMerchantImage() == null : this.getMerchantImage().equals(other.getMerchantImage()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTelphone() == null ? other.getTelphone() == null : this.getTelphone().equals(other.getTelphone()))
            && (this.getProductNumber() == null ? other.getProductNumber() == null : this.getProductNumber().equals(other.getProductNumber()))
            && (this.getSaleNumber() == null ? other.getSaleNumber() == null : this.getSaleNumber().equals(other.getSaleNumber()))
            && (this.getFansCount() == null ? other.getFansCount() == null : this.getFansCount().equals(other.getFansCount()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMerchantName() == null) ? 0 : getMerchantName().hashCode());
        result = prime * result + ((getMerchantImage() == null) ? 0 : getMerchantImage().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTelphone() == null) ? 0 : getTelphone().hashCode());
        result = prime * result + ((getProductNumber() == null) ? 0 : getProductNumber().hashCode());
        result = prime * result + ((getSaleNumber() == null) ? 0 : getSaleNumber().hashCode());
        result = prime * result + ((getFansCount() == null) ? 0 : getFansCount().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", merchantImage=").append(merchantImage);
        sb.append(", address=").append(address);
        sb.append(", telphone=").append(telphone);
        sb.append(", productNumber=").append(productNumber);
        sb.append(", saleNumber=").append(saleNumber);
        sb.append(", fansCount=").append(fansCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}