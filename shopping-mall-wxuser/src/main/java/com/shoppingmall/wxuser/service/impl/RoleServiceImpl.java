package com.shoppingmall.wxuser.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.wxuser.domain.dto.RoleDTO;
import com.shoppingmall.wxuser.domain.po.Role;
import com.shoppingmall.wxuser.domain.po.WxUserRole;
import com.shoppingmall.wxuser.service.RoleService;
import com.shoppingmall.wxuser.mapper.RoleMapper;
import com.shoppingmall.wxuser.service.WxUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 86151
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-09-07 17:22:01
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




