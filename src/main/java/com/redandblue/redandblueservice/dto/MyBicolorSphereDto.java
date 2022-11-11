package com.redandblue.redandblueservice.dto;

import com.redandblue.redandblueservice.entity.myBicolorSphere.MyBicolorSphere;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * dengjinming
 * 2022/11/11
 */
@Mapper
public interface MyBicolorSphereDto {

    //INSERT INTO `bicolor_sphere`.`bicolor_sphere` (`id`,`code`,`date`,`week`,`red`,`blue`,`create_time`) VALUES (1,'1','1','一','[1,2,3,4,5,6]',10,'2022-11-11 10:25:29');
    @Insert(value = "INSERT INTO " +
            "`bicolor_sphere`.`bicolor_sphere` (`id`,`code`,`date`,`week`,`red`,`blue`,`create_time`) " +
            "VALUES (#{id},#{code},#{date},#{week},#{red},#{blue},#{createTime});")
    int addBicolorSphere(MyBicolorSphere myBicolorSphere);

    @Select(value = "SELECT id FROM `bicolor_sphere`.`bicolor_sphere` WHERE `code` = #{code};")
    List<Long> findIdByCode(MyBicolorSphere myBicolorSphere);

}
