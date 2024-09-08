package com.shoppingmall.type.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品小类
 */
@TableName(value ="smalltype")
@Data
public class SmallType implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 大类id
     */
    @TableField(value = "bigtype_id")
    private Integer bigtypeId;

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