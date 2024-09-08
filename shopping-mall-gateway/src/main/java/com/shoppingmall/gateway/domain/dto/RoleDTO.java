package com.shoppingmall.gateway.domain.dto;

import lombok.Data;

/**
 * 角色实体
 */
@Data
public class RoleDTO {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 权限标识码
     */
    private String code;

    /**
     * 备注
     */
    private String remark;
}