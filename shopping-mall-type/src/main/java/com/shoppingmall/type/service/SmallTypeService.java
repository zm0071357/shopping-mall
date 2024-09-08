package com.shoppingmall.type.service;

import com.shoppingmall.type.domain.dto.SmallTypeDTO;
import com.shoppingmall.type.domain.po.SmallType;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
* @author 86151
* @description 针对表【smalltype(商品小类)】的数据库操作Service
* @createDate 2024-09-06 19:55:00
*/
public interface SmallTypeService extends IService<SmallType> {

    @ApiOperation("根据大类id获取大类获取其小类")
    List<SmallTypeDTO> getByBigType(Integer id);

    @ApiOperation("根据小类id获取小类")
    SmallTypeDTO getSmall(Integer id);
}
