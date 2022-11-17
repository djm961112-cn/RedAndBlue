package com.redandblue.redandblueservice.entity.myBicolorSphere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * dengjinming
 * 2022/11/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupRate {

    /**
     * id
     */
    private int id;
    /**
     * code编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 发生次数
     */
    private int happenNum;
    /**
     * 所有命中概率
     */
    private BigDecimal allHappenRate;
    /**
     * 近百命中概率
     */
    private BigDecimal hundredHappenRate;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
