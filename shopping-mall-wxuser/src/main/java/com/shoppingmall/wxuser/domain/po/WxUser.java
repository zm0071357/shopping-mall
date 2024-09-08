package com.shoppingmall.wxuser.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 微信用户
 */
@TableName(value ="wxuser")
@Data
public class WxUser implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 唯一标识
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * 名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 性别 0男 1女
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private LocalDate birthday;

    /**
     * 头像路径
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 最后登录时间
     */
    @TableField(value = "last_login")
    private LocalDateTime lastLogin;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}