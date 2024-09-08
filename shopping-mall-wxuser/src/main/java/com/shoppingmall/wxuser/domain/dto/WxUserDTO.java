package com.shoppingmall.wxuser.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 微信用户实体
 */
@Data
public class WxUserDTO {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * code 用于解析唯一标识openId
     */
    private String code;

    /**
     * 名字
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别 0男 1女
     */
    private Integer sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 头像路径
     */
    private String avatar;
}