package com.shoppingmall.seckill.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 折价券
 */
@TableName(value ="voucher")
@Data
public class Voucher implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 副标题
     */
    @TableField(value = "sub_title")
    private String subTitle;

    /**
     * 规则
     */
    @TableField(value = "rules")
    private String rules;

    /**
     * 价格
     */
    @TableField(value = "pay_value")
    private Double payValue;

    /**
     * 可抵消金额
     */
    @TableField(value = "actual_value")
    private Double actualValue;

    /**
     * 类型 1 普通券 2 秒杀券
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 状态 1 可用 2 不可用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}