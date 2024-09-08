package com.shoppingmall.seckill.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 折价券
 */
@Data
public class VoucherDTO {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 主标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 规则
     */
    private String rules;

    /**
     * 价格
     */
    private Double payValue;

    /**
     * 可抵消金额
     */
    private Double actualValue;

    /**
     * 类型 1 普通券 2 秒杀券
     */
    private Integer type;

    /**
     * 状态 1 可用 2 不可用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}