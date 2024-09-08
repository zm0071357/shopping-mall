package com.shoppingmall.type.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.type.domain.dto.SmallTypeDTO;
import com.shoppingmall.type.domain.po.SmallType;
import com.shoppingmall.type.service.SmallTypeService;
import com.shoppingmall.type.mapper.SmallTypeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86151
* @description 针对表【smalltype(商品小类)】的数据库操作Service实现
* @createDate 2024-09-06 19:55:00
*/
@Service
public class SmallTypeServiceImpl extends ServiceImpl<SmallTypeMapper, SmallType>
    implements SmallTypeService {

    @Override
    public List<SmallTypeDTO> getByBigType(Integer id) {
        List<SmallType> smallTypes = this.list(new QueryWrapper<SmallType>().eq("bigtype_id", id));
        return BeanUtil.copyToList(smallTypes, SmallTypeDTO.class);
    }

    @Override
    public SmallTypeDTO getSmall(Integer id) {
        return BeanUtil.copyProperties(this.getById(id),SmallTypeDTO.class);
    }

}




