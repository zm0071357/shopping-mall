package com.shoppingmall.commodity.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * 商品实体
 */
@Data
public class CommodityDTO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 图片路径
     */
    private String pic;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 类型
     */
    private String type;

    /**
     * 销量
     */
    private Integer saleNum;

    /**
     * 价格
     */
    private Double price;

    /**
     * 详情图片
     */
    private List<DetailDTO> detailDTOS;

    /**
     * 轮播图片
     */
    private SwiperDTO swiperDTOS;
}
