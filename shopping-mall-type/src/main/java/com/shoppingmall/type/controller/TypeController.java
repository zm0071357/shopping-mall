package com.shoppingmall.type.controller;

import cn.hutool.core.bean.BeanUtil;
import com.shoppingmall.type.domain.dto.BigTypeDTO;
import com.shoppingmall.type.domain.dto.SmallTypeDTO;
import com.shoppingmall.type.domain.po.BigType;
import com.shoppingmall.type.service.BigTypeService;
import com.shoppingmall.type.service.SmallTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "商品分类接口")
@RestController
@RequestMapping("/type")
public class TypeController {

    @Resource
    private BigTypeService bigTypeService;

    @Resource
    private SmallTypeService smallTypeService;

    @ApiOperation("查询所有大类")
    @GetMapping("/big/list")
    public List<BigTypeDTO> getBigTypeList() {
        List<BigType> list = bigTypeService.list();
        return BeanUtil.copyToList(list, BigTypeDTO.class);
    }

    @ApiOperation("根据id查询大类及其小类")
    @GetMapping("/big/{id}")
    public BigTypeDTO getBigById(@PathVariable("id") Integer id) {
        return bigTypeService.getBig(id);
    }

    @ApiOperation("根据id查询小类")
    @GetMapping("/small/{id}")
    public SmallTypeDTO getSmallById(@PathVariable("id") Integer id) {
        return smallTypeService.getSmall(id);
    }

    @ApiOperation("查询所有大类及小类")
    @GetMapping("/all/list")
    public List<BigTypeDTO> allTypeList() {
        List<BigType> list = bigTypeService.list();
        List<BigTypeDTO> dtoList = BeanUtil.copyToList(list, BigTypeDTO.class);
        for (BigTypeDTO bigTypeDTO : dtoList) {
            List<SmallTypeDTO> smallTypeList = smallTypeService.getByBigType(bigTypeDTO.getId());
            bigTypeDTO.setSmallTypeList(smallTypeList);
        }
        return dtoList;
    }
}
