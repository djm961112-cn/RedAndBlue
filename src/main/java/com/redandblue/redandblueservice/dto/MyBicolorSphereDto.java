package com.redandblue.redandblueservice.dto;

import com.redandblue.redandblueservice.entity.myBicolorSphere.MyBicolorSphere;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * dengjinming
 * 2022/11/11
 */
@Mapper
public interface MyBicolorSphereDto {

    /**
     * 添加双色球数据
     *
     * @param myBicolorSphere
     * @return int
     */
    @Insert(value = "INSERT INTO " +
            "`bicolor_sphere`.`bicolor_sphere` (`id`,`code`,`date`,`week`,`red`,`blue`,`create_time`) " +
            "VALUES (#{id},#{code},#{date},#{week},#{red},#{blue},#{createTime});")
    int addBicolorSphere(MyBicolorSphere myBicolorSphere);

    /**
     * 通过code找到id
     *
     * @param myBicolorSphere 我二色球体
     * @return {@link List}<{@link Long}>
     */
    @Select(value = "SELECT id FROM `bicolor_sphere`.`bicolor_sphere` WHERE `code` = #{code};")
    List<Long> findIdByCode(MyBicolorSphere myBicolorSphere);

    /**
     * 找到未统计组合
     *
     * @param code 代码
     * @return {@link List}<{@link MyBicolorSphere}>
     */
    @Select(value = "SELECT * FROM bicolor_sphere where code > #{code};")
    List<MyBicolorSphere> findNotStatisticalCombination(@Param("code") String code);

    /**
     * 找到最新的十组组合
     *
     * @return {@link List}<{@link MyBicolorSphere}>
     */
    @Select(value = "SELECT * FROM bicolor_sphere ORDER BY `code` DESC LIMIT 10;")
    List<MyBicolorSphere> findTenBicolorSphere();

    /**
     * 找到上次统计的code
     *
     * @return {@link String}
     */
    @Select(value = "SELECT code FROM bicolor_sphere_temp WHERE id=1;")
    String findLastStatisticsCode();

    /**
     * 存储最新统计过的code
     *
     * @param myBicolorSphere 我二色球体
     * @return int
     */
    @Select(value = "UPDATE `bicolor_sphere`.`bicolor_sphere_temp` " +
            "SET `code` = #{code} " +
            "WHERE `id` = 1;")
    void setLastNewCode(MyBicolorSphere myBicolorSphere);

    /**
     * 获取双色球总期数
     *
     * @return int
     */
    @Select(value = "SELECT COUNT(id) FROM bicolor_sphere;")
    int getBicolorSphereCount();

    /**
     * 找到最新的双色球数据
     *
     * @return {@link MyBicolorSphere}
     */
    @Select(value = "SELECT * FROM bicolor_sphere ORDER BY `code` DESC LIMIT 1;")
    MyBicolorSphere findNewMyBicolorSphere();
}
