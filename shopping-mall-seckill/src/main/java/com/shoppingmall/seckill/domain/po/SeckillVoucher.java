package com.shoppingmall.seckill.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 秒杀券详细
 */
@TableName(value ="seckill_voucher")
@Data
public class SeckillVoucher implements Serializable {
    /**
     * 秒杀券id
     */
    @TableId(value = "voucher_id")
    private Integer voucherId;

    /**
     * 库存
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 生效时间
     */
    @TableField(value = "begin_time")
    private LocalDateTime beginTime;

    /**
     * 失效时间
     */
    @TableField(value = "end_time")
    private LocalDateTime endTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}