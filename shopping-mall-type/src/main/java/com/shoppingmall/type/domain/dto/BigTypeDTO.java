package com.shoppingmall.type.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * 商品大类实体
 */
@Data
public class BigTypeDTO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片路径
     */
    private String pic;

    /**
     * 小类集合
     */
    private List<SmallTypeDTO> smallTypeList;
}