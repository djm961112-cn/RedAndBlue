package com.redandblue.redandblueservice.entity.myBicolorSphere;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * dengjinming
 * 2022/11/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBicolorSphere {
    //雪花算法得到的值在前端js会溢出这里改成字符型,但数据库里存的是 bigint
    @JsonSerialize(using = ToStringSerializer.class)
    @JSONField(serializeUsing = com.alibaba.fastjson.serializer.ToStringSerializer.class)
    public Long id;
    /**
     * 期数
     */
    public String code;
    /**
     * 日期
     */
    public String date;
    /**
     * 周
     */
    public String week;
    /**
     * 红色列表
     */
    public List<String> redList;
    /**
     * 红色
     */
    public String red;
    /**
     * 蓝色
     */
    public int blue;

    /**
     * 创建时间
     */
    public LocalDateTime createTime;
    /**
     * 更新时间
     */
    public LocalDateTime updateTime;
}
