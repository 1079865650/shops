package com.hs.shop.vo;

import com.hs.shop.domain.Province;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 省市联动
 * @author :王文松
 * @date : 2022/9/27 8:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceAndCity {
    private Province province;
    private List<CityAndCounties> cities;
}
