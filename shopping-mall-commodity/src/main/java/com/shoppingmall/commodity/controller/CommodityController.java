package com.shoppingmall.commodity.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.shoppingmall.commodity.domain.dto.CommodityDTO;
import com.shoppingmall.commodity.service.CommodityService;
import com.shoppingmall.common.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api("商品接口")
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Resource
    private CommodityService commodityService;

    @ApiOperation("展示轮播商品和热卖商品")
    @GetMapping("/special")
    public R special(){
        List<CommodityDTO> swipers = commodityService.SwiperCommodity();
        List<CommodityDTO> hots = commodityService.HotCommodity();
        return R.ok().put("swipers",swipers).put("hots",hots);
    }

    @ApiOperation("根据id查询商品")
    @GetMapping("/{id}")
    public CommodityDTO getById(@PathVariable("id") Integer id) {
        return commodityService.queryDetailById(id);
    }

    @ApiOperation("根据大类查询商品")
    @GetMapping("/bigtype/{id}")
    public List<CommodityDTO> getByBigType(@PathVariable("id") Integer id) {
        return commodityService.getByBigType(id);
    }

    @ApiOperation("根据小类查询商品")
    @GetMapping("/smalltype/{id}")
    public List<CommodityDTO> getBySmallType(@PathVariable("id") Integer id) {
        return commodityService.getBySmallType(id);
    }
}
