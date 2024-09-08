package com.shoppingmall.type.domain.dto;

import lombok.Data;


/**
 * 商品小类实体
 */
@Data
public class SmallTypeDTO{
    /**
     * ID
     */
    private Integer id;

    /**
     * 大类id
     */
    private Integer bigtypeId;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片路径
     */
    private String pic;
}