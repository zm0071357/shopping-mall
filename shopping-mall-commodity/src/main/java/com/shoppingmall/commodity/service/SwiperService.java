package com.shoppingmall.commodity.service;

import com.shoppingmall.commodity.domain.dto.SwiperDTO;
import com.shoppingmall.commodity.domain.po.Swiper;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
* @author 86151
* @description 针对表【swiper(商品轮播图片)】的数据库操作Service
* @createDate 2024-09-06 15:19:40
*/
public interface SwiperService extends IService<Swiper> {
    List<SwiperDTO> getSwiper(Integer id);
}
