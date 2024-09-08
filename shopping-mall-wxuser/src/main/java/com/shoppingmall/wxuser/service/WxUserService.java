package com.shoppingmall.wxuser.service;

import com.shoppingmall.common.domain.R;
import com.shoppingmall.wxuser.domain.dto.WxUserDTO;
import com.shoppingmall.wxuser.domain.po.WxUser;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;

/**
* @author 86151
* @description 针对表【wxuser(微信用户)】的数据库操作Service
* @createDate 2024-09-07 17:22:01
*/
public interface WxUserService extends IService<WxUser> {

    @ApiOperation("登录")
    R login(WxUserDTO wxUserDTO) throws WxErrorException;
}
