package com.shoppingmall.commodity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.commodity.domain.dto.SwiperDTO;
import com.shoppingmall.commodity.domain.po.Swiper;
import com.shoppingmall.commodity.service.SwiperService;
import com.shoppingmall.commodity.mapper.SwiperMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86151
* @description 针对表【swiper(商品轮播图片)】的数据库操作Service实现
* @createDate 2024-09-06 15:19:40
*/
@Service
public class SwiperServiceImpl extends ServiceImpl<SwiperMapper, Swiper>
    implements SwiperService{

    @Override
    public List<SwiperDTO> getSwiper(Integer id) {
        List<Swiper> swipers = this.list(new QueryWrapper<Swiper>().eq("commodity_id", id));
        return BeanUtil.copyToList(swipers, SwiperDTO.class);
    }
}




