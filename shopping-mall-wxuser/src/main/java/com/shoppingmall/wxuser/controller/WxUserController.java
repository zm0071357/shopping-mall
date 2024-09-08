package com.shoppingmall.wxuser.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.bean.BeanUtil;
import com.shoppingmall.common.domain.R;
import com.shoppingmall.common.utils.AliOSSUtils;
import com.shoppingmall.wxuser.domain.dto.WxUserDTO;
import com.shoppingmall.wxuser.domain.po.WxUser;
import com.shoppingmall.wxuser.service.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Api("微信用户接口")
@RestController
@RequestMapping("/wxuser")
public class WxUserController {

    @Resource
    private WxUserService wxUserService;

    @Resource
    private AliOSSUtils aliOSSUtils;

    @ApiOperation("登录")
    @PostMapping("/login")
    public R login(@RequestBody WxUserDTO wxUserDTO) throws WxErrorException {
        return wxUserService.login(wxUserDTO);
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public String logout(){
        StpUtil.logout();
        return SaResult.ok("登出成功").toString();
    }

    @ApiOperation("查看个人信息")
    @GetMapping("/{id}")
    public WxUserDTO PersonalInformation(@PathVariable("id") Long id) {
        return BeanUtil.copyProperties(wxUserService.getById(id),WxUserDTO.class);
    }

    @ApiOperation("更换头像")
    @PostMapping("/avator/{id}")
    public R UpdateAvator(@PathVariable("id") Long id, MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        WxUser user = wxUserService.getById(id);
        user.setAvatar(url);
        wxUserService.updateById(user);
        return R.ok("头像上传完成").put("url",url);
    }

    @ApiOperation("更改个人信息")
    @PutMapping("/update")
    public R UpdateInformation(@RequestBody WxUserDTO wxUserDTO) {
        if (wxUserService.updateById(BeanUtil.copyProperties(wxUserDTO, WxUser.class))) {
            return R.ok("个人信息更新完成");
        }
        return R.error("更新失败");
    }

}
