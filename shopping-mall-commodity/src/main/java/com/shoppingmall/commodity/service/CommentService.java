package com.shoppingmall.commodity.service;

import com.shoppingmall.commodity.domain.dto.CommentDTO;
import com.shoppingmall.commodity.domain.dto.CommentPicDTO;
import com.shoppingmall.commodity.domain.po.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shoppingmall.common.domain.R;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
* @author 86151
* @description 针对表【comment(商品评论)】的数据库操作Service
* @createDate 2024-09-06 15:18:29
*/
public interface CommentService extends IService<Comment> {

    @ApiOperation("根据商品id查看商品评论")
    List<CommentDTO> getByCommodityId(Integer id);

    @ApiOperation("发布评论")
    R writeComment(CommentDTO commentDTO);

}
