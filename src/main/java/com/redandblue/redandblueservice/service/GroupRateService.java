package com.redandblue.redandblueservice.service;

import com.redandblue.redandblueservice.dto.GroupRateDto;
import com.redandblue.redandblueservice.entity.myBicolorSphere.GroupRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * dengjinming
 * 2022/11/17
 */
@Service
public class GroupRateService implements GroupRateDto {
    @Autowired
    GroupRateDto groupRateDto;

    @Override
    public List<GroupRate> findAllGroupRate(){
        return groupRateDto.findAllGroupRate();
    }

    @Override
    public GroupRate findGroupRateByCode(String code){
        return groupRateDto.findGroupRateByCode(code);
    }

    @Override
    public int updateGroupRateByCode(GroupRate groupRate){
        return groupRateDto.updateGroupRateByCode(groupRate);
    }

}
