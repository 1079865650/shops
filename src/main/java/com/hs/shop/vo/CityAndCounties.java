package com.hs.shop.vo;

import com.hs.shop.domain.Province;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 市县联动
 * @author :王文松
 * @date : 2022/9/27 8:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityAndCounties {
    private Province city;
    private List<Province> counties;
}
