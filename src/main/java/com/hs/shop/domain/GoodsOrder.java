package com.hs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName goods_order
 */
@TableName(value ="goods_order")
@Data
public class GoodsOrder implements Serializable {

    public static void main(String[] args) {
        GoodsOrder goodsOrder = new GoodsOrder();
        Integer ispay = goodsOrder.getIspay();
    }
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id，外键
     */
    private Integer userId;

    /**
     * 商品的id，可能不止一个，双引号隔开区分
     */
    private String productIds;

    /**
     * 收货地址id，外键
     */
    private Integer deliAddressId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 订单金额
     */
    private BigDecimal orderPrice;



    /**
     * 注：以下三个状态标志(ispay,iswaitdel,iswaitrec)，按顺序，状态码组合表示为：
     * 0,0,0:等待支付状态
     * 1,1,0:等待发货状态
     * 1,0,1:等待收货状态
     * 1,0,0:已经收货，订单已完成状态
     * 1,1,1:退款/退货状态(商家已同意)
     */

    /**
     * 是否已经支付了该订单。0为未支付，1为已支付
     */
    private Integer ispay;

    /**
     * 待发货状态。0为已经发货，1为等待发货
     */
    private Integer iswaitdel;

    /**
     * 待收货状态。0为否，1为已发货，正在等待收货
     */
    private Integer iswaitrec;

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
        GoodsOrder other = (GoodsOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProductIds() == null ? other.getProductIds() == null : this.getProductIds().equals(other.getProductIds()))
            && (this.getDeliAddressId() == null ? other.getDeliAddressId() == null : this.getDeliAddressId().equals(other.getDeliAddressId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getOrderPrice() == null ? other.getOrderPrice() == null : this.getOrderPrice().equals(other.getOrderPrice()))
            && (this.getIspay() == null ? other.getIspay() == null : this.getIspay().equals(other.getIspay()))
            && (this.getIswaitdel() == null ? other.getIswaitdel() == null : this.getIswaitdel().equals(other.getIswaitdel()))
            && (this.getIswaitrec() == null ? other.getIswaitrec() == null : this.getIswaitrec().equals(other.getIswaitrec()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProductIds() == null) ? 0 : getProductIds().hashCode());
        result = prime * result + ((getDeliAddressId() == null) ? 0 : getDeliAddressId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getOrderPrice() == null) ? 0 : getOrderPrice().hashCode());
        result = prime * result + ((getIspay() == null) ? 0 : getIspay().hashCode());
        result = prime * result + ((getIswaitdel() == null) ? 0 : getIswaitdel().hashCode());
        result = prime * result + ((getIswaitrec() == null) ? 0 : getIswaitrec().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", productIds=").append(productIds);
        sb.append(", deliAddressId=").append(deliAddressId);
        sb.append(", createTime=").append(createTime);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", ispay=").append(ispay);
        sb.append(", iswaitdel=").append(iswaitdel);
        sb.append(", iswaitrec=").append(iswaitrec);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}