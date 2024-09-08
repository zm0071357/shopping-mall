package com.shoppingmall.wxuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.wxuser.domain.po.Address;
import com.shoppingmall.wxuser.service.AddressService;
import com.shoppingmall.wxuser.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author 86151
* @description 针对表【address(收货地址)】的数据库操作Service实现
* @createDate 2024-09-07 17:22:01
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{

}




