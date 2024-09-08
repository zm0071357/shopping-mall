package com.shoppingmall.commodity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shoppingmall.commodity.domain.dto.CommentDTO;
import com.shoppingmall.commodity.domain.dto.CommentPicDTO;
import com.shoppingmall.commodity.domain.po.Comment;
import com.shoppingmall.commodity.domain.po.CommentPic;
import com.shoppingmall.commodity.service.CommentPicService;
import com.shoppingmall.commodity.service.CommentService;
import com.shoppingmall.commodity.mapper.CommentMapper;
import com.shoppingmall.common.domain.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 86151
* @description 针对表【comment(商品评论)】的数据库操作Service实现
* @createDate 2024-09-06 15:18:29
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Resource
    private CommentPicService picService;

    @Override
    public List<CommentDTO> getByCommodityId(Integer id) {
        // 查询对应商品评论
        List<Comment> list = this.list(new QueryWrapper<Comment>().eq("commodity_id", id));
        List<CommentDTO> dtoList = BeanUtil.copyToList(list, CommentDTO.class);

        /*
        // 查询评论图片 多次操作数据库 降低性能
        for (CommentDTO commentDTO : dtoList) {
            List<CommentPic> picList = picService.list(new QueryWrapper<CommentPic>().eq("comment_id", commentDTO.getId()));
            List<CommentPicDTO> picdtoList = BeanUtil.copyToList(picList, CommentPicDTO.class);
            if (picdtoList != null && !picdtoList.isEmpty()) {
                commentDTO.setPics(picdtoList);
            }
        }
        */

        // 查询所有评论id
        List<Integer> commentIds = dtoList.stream()
                .map(CommentDTO::getId)
                .toList();
        // 查询所有评论图片
        List<CommentPic> allPics = picService.list(new QueryWrapper<CommentPic>().in("comment_id", commentIds));
        // 按评论id分组
        Map<Integer, List<CommentPicDTO>> picsMap = allPics.stream()
                .map(pic -> BeanUtil.copyProperties(pic, CommentPicDTO.class))
                .collect(Collectors.groupingBy(CommentPicDTO::getCommentId));
        // 图片保存至评论DTO对象
        for (CommentDTO commentDTO : dtoList) {
            List<CommentPicDTO> pictoList = picsMap.get(commentDTO.getId());
            if (pictoList != null && !pictoList.isEmpty()) {
                List<String> picList = pictoList.stream()
                        .map(CommentPicDTO::getPic)
                        .collect(Collectors.toList());
                commentDTO.setPics(picList);
            }
        }
        return dtoList;
    }

    @Override
    public R writeComment(CommentDTO commentDTO) {
        // 保存评论
        Comment comment = BeanUtil.copyProperties(commentDTO, Comment.class);
        comment.setSendTime(LocalDate.now());
        comment.setLikeNum(0);
        this.save(comment);

        // 保存评论图片
        List<String> pics = commentDTO.getPics();
        if (pics != null && !pics.isEmpty()) {
            for (String pic : pics) {
                CommentPic commentPic = new CommentPic();
                commentPic.setCommentId(comment.getId());
                commentPic.setPic(pic);
                picService.save(commentPic);
            }
        }
        return R.ok("发布成功");
    }
}




