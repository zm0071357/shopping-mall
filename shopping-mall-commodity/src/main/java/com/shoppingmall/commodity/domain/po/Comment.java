package com.shoppingmall.commodity.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * 商品评论
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    @TableField(value = "commodity_id")
    private Integer commodityId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 评论内容
     */
    @TableField(value = "description")
    private String description;

    /**
     * 评论时间
     */
    @TableField(value = "send_time")
    private LocalDate sendTime;

    /**
     * 点赞数
     */
    @TableField(value = "like_num")
    private Integer likeNum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}