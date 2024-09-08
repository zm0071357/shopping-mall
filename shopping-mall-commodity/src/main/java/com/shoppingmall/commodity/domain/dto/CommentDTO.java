package com.shoppingmall.commodity.domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * 商品评论实体
 */
@Data
public class CommentDTO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer commodityId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 评论内容
     */
    private String description;

    /**
     * 评论时间
     */
    private LocalDate sendTime;

    /**
     * 点赞数
     */
    private Integer likeNum;

    /**
     * 评论图片路径集合
     */
    private List<String> pics;
}