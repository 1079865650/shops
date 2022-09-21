package com.hs.shop.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 *
 * @TableName banner
 */
@TableName(value ="banner")
@Data
public class Banner {

  /**
   * 轮播图表主键
   */
  private Integer id;
  private String bannerImg;

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
    Banner other = (Banner) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBannerImg() == null ? other.getBannerImg() == null : this.getBannerImg().equals(other.getBannerImg()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getBannerImg() == null) ? 0 : getBannerImg().hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", bannerImg=").append(bannerImg);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}
