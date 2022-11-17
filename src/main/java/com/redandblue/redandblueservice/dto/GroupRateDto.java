package com.redandblue.redandblueservice.dto;

import com.redandblue.redandblueservice.entity.myBicolorSphere.GroupRate;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * dengjinming
 * 2022/11/17
 */
@Mapper
public interface GroupRateDto {

    /**
     * 获取所有组合
     *
     * @return {@link List}<{@link GroupRate}>
     *///@Insert()
    @Select(value = "SELECT * FROM group_rate ;")
    List<GroupRate> findAllGroupRate();

    /**
     * 通过code组合
     *
     * @param code 代码
     * @return {@link GroupRate}
     */
    @Select(value = "SELECT * FROM group_rate where code = #{code};")
    GroupRate findGroupRateByCode(@Param("code") String code);

    /**
     * 通过code更新组合
     *
     * @param groupRate 团队价
     * @return int
     */
    @Update(value = "UPDATE `bicolor_sphere`.`group_rate` " +
            "SET `happen_num`=#{happenNum},`all_happen_rate`=#{allHappenRate} " +
            "WHERE `code`=#{code};")
    int updateGroupRateByCode(GroupRate groupRate);
}
