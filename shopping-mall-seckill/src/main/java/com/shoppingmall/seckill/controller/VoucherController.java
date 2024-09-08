package com.shoppingmall.seckill.controller;

import com.shoppingmall.common.domain.R;
import com.shoppingmall.seckill.service.SeckillVoucherService;
import com.shoppingmall.seckill.service.VoucherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("折价券接口")
@RestController
@RequestMapping("/voucher")
public class VoucherController {

    @Resource
    private VoucherService voucherService;

    @Resource
    private SeckillVoucherService seckillVoucherService;

    @ApiOperation("购买秒杀券")
    @PostMapping("/seckill/{id}")
    public R buySecKill(@PathVariable Integer id) {
        return null;
    }

    @ApiOperation("购买折价券")
    @PostMapping("/{id}")
    public R buyCommon(@PathVariable Integer id) {
        return null;
    }

}
