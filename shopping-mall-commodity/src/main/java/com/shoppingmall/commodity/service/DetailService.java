package com.shoppingmall.commodity.service;

import com.shoppingmall.commodity.domain.dto.DetailDTO;
import com.shoppingmall.commodity.domain.po.Detail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86151
* @description 针对表【detail(商品详情展示图片)】的数据库操作Service
* @createDate 2024-09-06 15:19:40
*/
public interface DetailService extends IService<Detail> {
    List<DetailDTO> getDetail(Integer id);
}
