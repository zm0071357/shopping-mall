package com.shoppingmall.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.gateway.domain.dto.RoleDTO;
import com.shoppingmall.gateway.domain.po.Role;
import io.swagger.annotations.ApiOperation;

import javax.management.loading.MLetContent;

/**
* @author 86151
* @description 针对表【role(角色表)】的数据库操作Service
* @createDate 2024-09-08 15:07:08
*/
public interface RoleService extends IService<Role> {

    @ApiOperation("根据用户id获取用户对应角色")
    RoleDTO getByWxUserId(Long loginId);
}
