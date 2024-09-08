package com.shoppingmall.commodity.domain.dto;

import lombok.Data;


/**
 * 评论图片实体
 */
@Data
public class CommentPicDTO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 评论id
     */
    private Integer commentId;

    /**
     * 图片路径
     */
    private String pic;
}