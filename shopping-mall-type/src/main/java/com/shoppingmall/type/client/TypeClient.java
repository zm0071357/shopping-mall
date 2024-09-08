package com.shoppingmall.type.client;

import com.shoppingmall.common.interceptor.FeignInterceptor;
import com.shoppingmall.type.domain.dto.BigTypeDTO;
import com.shoppingmall.type.domain.dto.SmallTypeDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 商品分类Feign客户端
 */
@FeignClient(value = "shopping-mall-type",configuration = FeignInterceptor.class)
public interface TypeClient {

    @ApiOperation("根据大类获取其小类")
    @GetMapping("/type/big/{id}")
    BigTypeDTO getBig(@PathVariable("id") Integer id);

    @ApiOperation("获取小类")
    @GetMapping("/type/small/{id}")
    SmallTypeDTO getSmall(@PathVariable("id") Integer id);
}
