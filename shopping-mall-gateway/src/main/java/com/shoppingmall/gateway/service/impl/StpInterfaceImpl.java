package com.shoppingmall.gateway.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.shoppingmall.gateway.service.RoleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限验证
 */
@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RoleService roleService;

    @ApiOperation("获取当前登录用户的权限列表")
    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    @ApiOperation("获取当前登录用户的角色列表")
    @Override
    public List<String> getRoleList(Object o, String s) {
        Long loginId = StpUtil.getLoginIdAsLong();
        String code = roleService.getByWxUserId(loginId).getCode();
        List<String> list=new ArrayList<>();
        if (code.equals("admin")) {
            list.add("admin");
        }
        list.add("common");
        log.info("登录用户Id:{},角色:{}",loginId,code);
        return list;
    }
}
