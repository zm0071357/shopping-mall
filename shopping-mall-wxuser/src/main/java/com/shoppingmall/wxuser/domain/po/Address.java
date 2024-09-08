package com.shoppingmall.wxuser.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 收货地址
 */
@TableName(value ="address")
@Data
public class Address implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 微信用户ID
     */
    @TableField(value = "wxuser_id")
    private Long wxuserId;

    /**
     * 收货人
     */
    @TableField(value = "name")
    private String name;

    /**
     * 位置
     */
    @TableField(value = "location")
    private String location;

    /**
     * 联系方式
     */
    @TableField(value = "phone")
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}