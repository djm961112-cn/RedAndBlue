package com.redandblue.redandblueservice.util.getRedAndBlue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.redandblue.redandblueservice.entity.myBicolorSphere.MyBicolorSphere;
import com.redandblue.redandblueservice.entity.thirdParty.*;
import com.redandblue.redandblueservice.service.MyBicolorSphereService;
import com.redandblue.redandblueservice.util.DateUtil;
import com.redandblue.redandblueservice.util.SnowIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * dengjinming
 * 2022/11/10
 */
@Component
public class AnalysisThirdPartyResult {

    @Autowired
    GetNewRedAndBlue getNewRedAndBlue;
    @Autowired
    DateUtil dateUtil;
    @Autowired
    MyBicolorSphereService myBicolorSphereService;

    /**
     * 分析存储第三方双色球结果
     *
     * @return {@link List}<{@link MyBicolorSphere}>
     */
    public void analysisThirdPartyResults(){
        List<MyBicolorSphere> myBicolorSphereList=new ArrayList<>();
        String jsonstring=getNewRedAndBlue.getTheLatestBicolorSphere();//获取第三方的数据
        JSONObject jsonObject = JSON.parseObject(jsonstring);//将String转换成Json
        String result=jsonObject.getString("result");
        myBicolorSphereList = JSON.parseArray(result,MyBicolorSphere.class);
        SnowIdUtil snowIdUtil=new SnowIdUtil(0,0);
        for (MyBicolorSphere myBicolorSphere : myBicolorSphereList){
            myBicolorSphere.setId(snowIdUtil.nextId());
            myBicolorSphere.setCreateTime(dateUtil.getNow());
            if (myBicolorSphereService.findIdByCode(myBicolorSphere).size()==0){
                myBicolorSphereService.addBicolorSphere(myBicolorSphere);
            }
        }
    }
}
