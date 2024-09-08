package com.shoppingmall.commodity.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 商品
 */
@TableName(value ="commodity")
@Data
public class Commodity implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 图片路径
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * 商品描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 上架时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 是否为热卖商品
     */
    @TableField(value = "is_hot")
    private Integer isHot;

    /**
     * 是否为轮播商品
     */
    @TableField(value = "is_swiper")
    private Integer isSwiper;

    /**
     * 展示排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 库存
     */
    @TableField(value = "store_num")
    private Integer storeNum;

    /**
     * 销量
     */
    @TableField(value = "sale_num")
    private Integer saleNum;

    /**
     * 价格
     */
    @TableField(value = "price")
    private Double price;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @TableField(value = "update_user")
    private String updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}