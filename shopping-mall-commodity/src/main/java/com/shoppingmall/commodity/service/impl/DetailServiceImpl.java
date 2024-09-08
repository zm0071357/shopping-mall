package com.shoppingmall.commodity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.commodity.domain.dto.DetailDTO;
import com.shoppingmall.commodity.domain.dto.SwiperDTO;
import com.shoppingmall.commodity.domain.po.Detail;
import com.shoppingmall.commodity.domain.po.Swiper;
import com.shoppingmall.commodity.service.DetailService;
import com.shoppingmall.commodity.mapper.DetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86151
* @description 针对表【detail(商品详情展示图片)】的数据库操作Service实现
* @createDate 2024-09-06 15:19:40
*/
@Service
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail>
    implements DetailService{

    @Override
    public List<DetailDTO> getDetail(Integer id) {
        List<Detail> details = this.list(new QueryWrapper<Detail>().eq("commodity_id", id));
        return BeanUtil.copyToList(details, DetailDTO.class);
    }
}




