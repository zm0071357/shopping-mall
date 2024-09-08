package com.shoppingmall.commodity.controller;

import cn.hutool.core.bean.BeanUtil;
import com.shoppingmall.commodity.domain.dto.CommentDTO;
import com.shoppingmall.commodity.domain.dto.CommentPicDTO;
import com.shoppingmall.commodity.domain.po.Comment;
import com.shoppingmall.commodity.service.CommentService;
import com.shoppingmall.common.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品评论接口")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @ApiOperation("根据商品id查看商品评论")
    @GetMapping("/{id}")
    public List<CommentDTO> getByCommodity(@PathVariable Integer id) {
        return commentService.getByCommodityId(id);
    }

    @ApiOperation("发布评论")
    @PostMapping("/write")
    public R writeComment(@RequestBody CommentDTO commentDTO){
        return commentService.writeComment(commentDTO);
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/delete/{id}")
    public R deleteComment(@PathVariable Integer id) {
        commentService.removeById(id);
        return R.ok("删除成功");
    }
}

