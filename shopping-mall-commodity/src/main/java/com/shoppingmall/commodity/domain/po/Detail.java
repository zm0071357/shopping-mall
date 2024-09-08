package com.shoppingmall.commodity.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品详情展示图片
 */
@TableName(value ="detail")
@Data
public class Detail implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    @TableField(value = "commodity_id")
    private Integer commodityId;

    /**
     * 图片路径
     */
    @TableField(value = "des_pic")
    private String desPic;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}