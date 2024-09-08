package com.shoppingmall.wxuser.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.util.WxMaConfigHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.common.domain.R;
import com.shoppingmall.wxuser.domain.dto.WxUserDTO;
import com.shoppingmall.wxuser.domain.po.WxUser;
import com.shoppingmall.wxuser.domain.po.WxUserRole;
import com.shoppingmall.wxuser.service.WxUserRoleService;
import com.shoppingmall.wxuser.service.WxUserService;
import com.shoppingmall.wxuser.mapper.WxUserMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;


/**
* @author 86151
* @description 针对表【wxuser(微信用户)】的数据库操作Service实现
* @createDate 2024-09-07 17:22:01
*/
@Service
@Slf4j
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUser>
    implements WxUserService{

    @Resource
    private WxMaService wxMaService;

    @Resource
    private WxUserRoleService wxUserRoleService;

    @ApiOperation("根据openId查询微信用户")
    public WxUser getByOpenId(String openId) {
        return this.getOne(new QueryWrapper<WxUser>().eq("open_id", openId));
    }

    @Override
    public R login(WxUserDTO wxUserDTO) throws WxErrorException {
        try {
            // 解析出openId
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(wxUserDTO.getCode());
            String openId = session.getOpenid();
            log.info("openId:{}",openId);
            // 查询微信用户是否存在
            WxUser user = this.getByOpenId(openId);
            if (user != null) {
                log.info("用户存在，直接登录");
                // 登录并记录最后登录时间
                StpUtil.login(user.getId());
                user.setLastLogin(LocalDateTime.now());
                this.updateById(user);
                return R.ok()
                        .put("is_exist","yes")
                        .put("message", SaResult.ok("用户已存在,登录成功").toString())
                        .put("token", StpUtil.getTokenValue())
                        .put("loginId", StpUtil.getTokenInfo().loginId);
            }
            // 微信用户不存在
            WxUser newUser = new WxUser();
            newUser.setOpenId(openId);
            newUser.setName(wxUserDTO.getName());
            newUser.setAvatar(wxUserDTO.getAvatar());
            newUser.setLastLogin(LocalDateTime.now());
            this.save(newUser);
            // 用户角色绑定
            WxUserRole userRole = new WxUserRole();
            userRole.setWxuserId(newUser.getId());
            userRole.setRoleId(2);
            wxUserRoleService.save(userRole);
            // 登录
            StpUtil.login(newUser.getId());
            return R.ok()
                    .put("is_exist","no")
                    .put("message", SaResult.ok("用户创建,登录成功").toString())
                    .put("token",StpUtil.getTokenValue())
                    .put("loginId", StpUtil.getTokenInfo().loginId);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return R.error("登录失败");
        } finally {
            WxMaConfigHolder.remove();
        }

    }
}




