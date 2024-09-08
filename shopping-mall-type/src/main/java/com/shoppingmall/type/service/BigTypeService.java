package com.shoppingmall.type.service;

import com.shoppingmall.type.domain.dto.BigTypeDTO;
import com.shoppingmall.type.domain.dto.SmallTypeDTO;
import com.shoppingmall.type.domain.po.BigType;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
* @author 86151
* @description 针对表【bigtype(商品大类)】的数据库操作Service
* @createDate 2024-09-06 19:55:00
*/
public interface BigTypeService extends IService<BigType> {

    BigTypeDTO getBig(Integer id);
}
