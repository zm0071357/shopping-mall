package com.shoppingmall.wxuser.domain.dto;

import lombok.Data;

/**
 * 用户对应角色实体
 */
@Data
public class WxUserRoleDTO {
    /**
     * 微信用户ID
     */
    private Long wxuserId;

    /**
     * 角色id
     */
    private Integer roleId;
}
