package com.shoppingmall.commodity.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品详情展示图片
 */
@Data
public class DetailDTO implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 图片路径
     */
    private String desPic;
}