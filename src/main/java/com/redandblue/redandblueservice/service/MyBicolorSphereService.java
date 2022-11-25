package com.redandblue.redandblueservice.service;

import com.redandblue.redandblueservice.dto.MyBicolorSphereDto;
import com.redandblue.redandblueservice.entity.myBicolorSphere.MyBicolorSphere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * dengjinming
 * 2022/11/11
 */
@Service
public class MyBicolorSphereService implements MyBicolorSphereDto {

    @Autowired
    private MyBicolorSphereDto myBicolorSphereDto;

    @Override
    public int addBicolorSphere(MyBicolorSphere myBicolorSphere){
        return myBicolorSphereDto.addBicolorSphere(myBicolorSphere);
    }

    @Override
    public List<Long> findIdByCode(MyBicolorSphere myBicolorSphere){
        return myBicolorSphereDto.findIdByCode(myBicolorSphere);
    }

    @Override
    public List<MyBicolorSphere> findNotStatisticalCombination(String code){
        return myBicolorSphereDto.findNotStatisticalCombination(code);
    }

    @Override
    public List<MyBicolorSphere> findTenBicolorSphere(){
        return myBicolorSphereDto.findTenBicolorSphere();
    }

    @Override
    public String findLastStatisticsCode(){
        return myBicolorSphereDto.findLastStatisticsCode();
    }

    @Override
    public void setLastNewCode(MyBicolorSphere myBicolorSphere){
        myBicolorSphereDto.setLastNewCode(myBicolorSphere);
    }

    @Override
    public int getBicolorSphereCount(){
        return myBicolorSphereDto.getBicolorSphereCount();
    }

    @Override
    public MyBicolorSphere findNewMyBicolorSphere(){
        return myBicolorSphereDto.findNewMyBicolorSphere();
    }
}
