package com.shoppingmall.commodity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.commodity.domain.dto.CommodityDTO;
import com.shoppingmall.commodity.domain.dto.DetailDTO;
import com.shoppingmall.commodity.domain.dto.SwiperDTO;
import com.shoppingmall.commodity.domain.po.Commodity;
import com.shoppingmall.commodity.service.CommodityService;
import com.shoppingmall.commodity.mapper.CommodityMapper;
import com.shoppingmall.commodity.service.DetailService;
import com.shoppingmall.commodity.service.SwiperService;
import com.shoppingmall.type.client.TypeClient;
import com.shoppingmall.type.domain.dto.BigTypeDTO;
import com.shoppingmall.type.domain.dto.SmallTypeDTO;
import io.swagger.annotations.ApiOperation;;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;;
import java.util.ArrayList;
import java.util.List;

/**
* @author 86151
* @description 针对表【commodity(商品表)】的数据库操作Service实现
* @createDate 2024-09-06 15:19:40
*/
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity>
    implements CommodityService {

    @Resource
    private DetailService detailService;

    @Resource
    private SwiperService swiperService;

    @Resource
    private TypeClient typeClient;

    @ApiOperation("根据id获取商品图片")
    public void setPicById(CommodityDTO commodityDTO,Integer id) {
        List<DetailDTO> details = detailService.getDetail(id);
        List<SwiperDTO> swipers = swiperService.getSwiper(id);
        commodityDTO.setDetailDTOS(details);
        commodityDTO.setSwiperDTOS(swipers.get(0));
    }

    @Override
    public CommodityDTO queryDetailById(Integer id) {
        Commodity commodity = this.getById(id);
        CommodityDTO commodityDTO = BeanUtil.copyProperties(commodity, CommodityDTO.class);
        setPicById(commodityDTO,id);
        return commodityDTO;
    }

    @Override
    public List<CommodityDTO> SwiperCommodity() {
        // 获取商品集合
        List<Commodity> list = this.list(new QueryWrapper<Commodity>().eq("is_swiper", 0).orderByAsc("sort"));
        List<CommodityDTO> dtoList = new ArrayList<>();
        for (Commodity commodity : list) {
            // 获取图片
            List<SwiperDTO> swipers = swiperService.getSwiper(commodity.getId());
            // 转换为CommodityDTO对象
            CommodityDTO commodityDTO = BeanUtil.copyProperties(commodity, CommodityDTO.class);
            commodityDTO.setSwiperDTOS(swipers.get(0));
            dtoList.add(commodityDTO);
        }
        return dtoList;
    }

    @Override
    public List<CommodityDTO> HotCommodity() {
        List<Commodity> list = this.list(new QueryWrapper<Commodity>().eq("is_hot", 0).orderByAsc("sale_num"));
        return BeanUtil.copyToList(list,CommodityDTO.class);
    }

    @Override
    public List<CommodityDTO> getByBigType(Integer id) {
        List<CommodityDTO> dtoList = new ArrayList<>();
        // 通过OpenFeign调用获取大类
        BigTypeDTO big = typeClient.getBig(id);
        // 通过大类获取小类
        List<SmallTypeDTO> small = big.getSmallTypeList();
        // 通过小类获取商品
        for (SmallTypeDTO smallTypeDTO : small) {
            List<Commodity> commodities = this.list(new QueryWrapper<Commodity>().eq("type", smallTypeDTO.getName()));
            List<CommodityDTO> dtos = BeanUtil.copyToList(commodities, CommodityDTO.class);
            // 加入集合
            dtoList.addAll(dtos);
        }
        return dtoList;
    }

    @Override
    public List<CommodityDTO> getBySmallType(Integer id) {
        // 通过OpenFeign调用获取小类
        SmallTypeDTO smallTypeDTO = typeClient.getSmall(id);
        List<Commodity> commodities = this.list(new QueryWrapper<Commodity>().eq("type", smallTypeDTO.getName()));
        return BeanUtil.copyToList(commodities, CommodityDTO.class);
    }

}