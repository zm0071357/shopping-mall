package com.shoppingmall.type.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.type.domain.dto.BigTypeDTO;
import com.shoppingmall.type.domain.dto.SmallTypeDTO;
import com.shoppingmall.type.domain.po.BigType;
import com.shoppingmall.type.service.BigTypeService;
import com.shoppingmall.type.mapper.BigTypeMapper;
import com.shoppingmall.type.service.SmallTypeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86151
* @description 针对表【bigtype(商品大类)】的数据库操作Service实现
* @createDate 2024-09-06 19:55:00
*/
@Service
public class BigTypeServiceImpl extends ServiceImpl<BigTypeMapper, BigType>
    implements BigTypeService {

    @Resource
    private SmallTypeService smallTypeService;

    @Override
    public BigTypeDTO getBig(Integer id) {
        BigType bigType = this.getById(id);
        BigTypeDTO bigTypeDTO = BeanUtil.copyProperties(bigType, BigTypeDTO.class);
        List<SmallTypeDTO> smallTypeList = smallTypeService.getByBigType(id);
        bigTypeDTO.setSmallTypeList(smallTypeList);
        return bigTypeDTO;
    }
}




