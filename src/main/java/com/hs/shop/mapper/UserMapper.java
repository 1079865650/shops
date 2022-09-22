package com.hs.shop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.hs.shop.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author carryman
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-09-20 15:17:11
* @Entity com.hs.shop.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

}




