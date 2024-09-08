package com.shoppingmall.commodity.service;

import com.shoppingmall.commodity.domain.dto.CommodityDTO;
import com.shoppingmall.commodity.domain.po.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
* @author 86151
* @description 针对表【commodity(商品表)】的数据库操作Service
* @createDate 2024-09-06 15:19:40
*/
public interface CommodityService extends IService<Commodity> {

    @ApiOperation(value = "根据id查询商品")
    CommodityDTO queryDetailById(Integer id);

    @ApiOperation(value = "获取轮播商品")
    List<CommodityDTO> SwiperCommodity();

    @ApiOperation(value = "获取热卖商品")
    List<CommodityDTO> HotCommodity();

    @ApiOperation(value = "根据大类获取商品")
    List<CommodityDTO> getByBigType(Integer id);

    @ApiOperation(value = "根据小类获取商品")
    List<CommodityDTO> getBySmallType(Integer id);
}
