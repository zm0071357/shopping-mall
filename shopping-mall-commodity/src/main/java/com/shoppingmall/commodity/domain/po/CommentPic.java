package com.shoppingmall.commodity.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 评论图片
 * @TableName comment_pic
 */
@TableName(value ="comment_pic")
@Data
public class CommentPic implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 评论id
     */
    @TableField(value = "comment_id")
    private Integer commentId;

    /**
     * 图片路径
     */
    @TableField(value = "pic")
    private String pic;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}