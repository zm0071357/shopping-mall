package com.shoppingmall.gateway.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.gateway.domain.dto.RoleDTO;
import com.shoppingmall.gateway.domain.po.Role;
import com.shoppingmall.gateway.domain.po.WxuserRole;
import com.shoppingmall.gateway.mapper.RoleMapper;
import com.shoppingmall.gateway.service.RoleService;
import com.shoppingmall.gateway.service.WxuserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 86151
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-09-08 15:07:08
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {
    @Resource
    private WxuserRoleService wxuserRoleService;

    @Override
    public RoleDTO getByWxUserId(Long loginId) {
        WxuserRole userRole = wxuserRoleService.getOne(new QueryWrapper<WxuserRole>().eq("wxuser_id",loginId));
        Role role = this.getById(userRole.getRoleId());
        return BeanUtil.copyProperties(role, RoleDTO.class);
    }
}




