package com.shoppingmall.commodity.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品轮播图片
 */
@Data
public class SwiperDTO implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer commodityId;

    /**
     * 图片路径
     */
    private String swiperPic;
}