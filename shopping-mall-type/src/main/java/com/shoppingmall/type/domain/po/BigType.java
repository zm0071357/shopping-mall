package com.shoppingmall.type.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品大类
 */
@TableName(value ="bigtype")
@Data
public class BigType implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 图片路径
     */
    @TableField(value = "pic")
    private String pic;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}