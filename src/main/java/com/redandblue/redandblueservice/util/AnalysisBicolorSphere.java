package com.redandblue.redandblueservice.util;

import com.redandblue.redandblueservice.entity.myBicolorSphere.GroupRate;
import com.redandblue.redandblueservice.entity.myBicolorSphere.MyBicolorSphere;
import com.redandblue.redandblueservice.service.GroupRateService;
import com.redandblue.redandblueservice.service.MyBicolorSphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 分析双色球数据
 * dengjinming
 * 2022/11/17
 *
 * @author DengJinMing
 * @date 2022-11-17
 */
@Component
public class AnalysisBicolorSphere {
    @Autowired
    MyBicolorSphereService myBicolorSphereService;
    @Autowired
    GroupRateService groupRateService;

    /**
     * 分析双色球数据主方法，主要计算新增加的双色球数据红色部分所属区域，及该区域在历史上出现的频率                           
     */
    @Transactional
    public void anBicolorSphere(){
        String code= myBicolorSphereService.findLastStatisticsCode();//获取上次统计的最新的code
        List<MyBicolorSphere> myBicolorSphereList =myBicolorSphereService.findNotStatisticalCombination(code);//获取本次需要统计的双色球数据
        List<Integer> integerList = new ArrayList<>();
        int allNum=myBicolorSphereService.getBicolorSphereCount();//获取最新的双色球期数
        for (MyBicolorSphere myBicolorSphere : myBicolorSphereList){
            integerList=StringToList(myBicolorSphere.red);
            //System.out.println("integerList"+integerList);
            //分析该列表中的值归属哪个区域
            String newCode=ListToCode(integerList);
            //System.out.println("newCode:"+newCode);
            GroupRate groupRate=groupRateService.findGroupRateByCode(newCode);
            //调用dto接口将该区域的对应次数+1，出现频率重新计算
            int num=groupRate.getHappenNum()+1;//对应code出现次数+1
            groupRate.setHappenNum(num);
            BigDecimal Bnum= BigDecimal.valueOf(num);
            BigDecimal BallNum= BigDecimal.valueOf(allNum);
            BigDecimal allHappenRate= Bnum.divide(BallNum,4,BigDecimal.ROUND_HALF_UP);//出现频率重新计算
            groupRate.setAllHappenRate(allHappenRate);
            //System.out.println(groupRate);
            //最后将次数和总频率重新存储到数据库
            groupRateService.updateGroupRateByCode(groupRate);
        }
        //所有code出现频率重新计算
        List<GroupRate> groupRateList=groupRateService.findAllGroupRate();
        for (GroupRate groupRate:groupRateList){
            BigDecimal oldNum= BigDecimal.valueOf(groupRate.getHappenNum());
            BigDecimal allHappenRate=oldNum.divide(BigDecimal.valueOf(allNum),4,BigDecimal.ROUND_HALF_UP);
            groupRate.setAllHappenRate(allHappenRate);
            groupRateService.updateGroupRateByCode(groupRate);
        }
        //将最新统计过的code放进数据库中，下次作为起始使用
        String theLastNewCode=myBicolorSphereService.findNewMyBicolorSphere().getCode();
        System.out.println("theLastNewCode:"+theLastNewCode);
        MyBicolorSphere myBicolorSphere=new MyBicolorSphere();
        myBicolorSphere.setCode(theLastNewCode);
        myBicolorSphereService.setLastNewCode(myBicolorSphere);
    }

    /**
     * 列表值转换归属区域
     *
     * @param integerList 整数列表
     * @return {@link String}
     */
    public String ListToCode(List<Integer> integerList){
        Map<String, Integer> map=new HashMap<>();
        map.put("A",0);
        map.put("B",0);
        map.put("C",0);
        for (Integer integer : integerList){
            if (integer<=11){
                Integer a=map.get("A");
                a++;
                map.put("A",a);
            }else if (integer<=22){
                Integer b=map.get("B");
                b++;
                map.put("B",b);
            }else {
                Integer c=map.get("C");
                c++;
                map.put("C",c);
            }
        }
        String newCode=map.get("A").toString()+map.get("B").toString()+map.get("C").toString();
        return newCode;
    }

    /**
     * 字符串通过","转列表
     *
     * @param str str
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> StringToList(String str){
        String[] newStr=str.split(",");
        List<Integer> integerList=new ArrayList<>();
        for (int i = 0 ; i < newStr.length ; i++){
            integerList.add(Integer.valueOf(newStr[i]));
        }
        return integerList;
    }


}
