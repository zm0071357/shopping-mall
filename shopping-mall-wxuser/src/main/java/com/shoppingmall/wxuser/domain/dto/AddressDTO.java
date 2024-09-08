package com.shoppingmall.wxuser.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 收货地址实体
 */
@Data
public class AddressDTO {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 微信用户ID
     */
    private Long wxuserId;

    /**
     * 收货人
     */
    private String name;

    /**
     * 位置
     */
    private String location;

    /**
     * 联系方式
     */
    private String phone;
}