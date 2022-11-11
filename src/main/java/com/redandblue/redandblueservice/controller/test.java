package com.redandblue.redandblueservice.controller;

import com.redandblue.redandblueservice.entity.myBicolorSphere.MyBicolorSphere;
import com.redandblue.redandblueservice.entity.response.controller.Response;
import com.redandblue.redandblueservice.util.getRedAndBlue.AnalysisThirdPartyResult;
import com.redandblue.redandblueservice.util.getRedAndBlue.GetNewRedAndBlue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * dengjinming
 * 2022/11/10
 */
@RestController
@Slf4j
@RequestMapping(value = "/test")
public class test {

    @Autowired
    GetNewRedAndBlue getNewRedAndBlue;
    @Autowired
    AnalysisThirdPartyResult analysisThirdPartyResult;

    /**
     * 获得并存储最新二色球体
     *
     * @return {@link Response}<{@link ?}>
     */
    @RequestMapping(value = "/getTheLatestBicolorSphere",method = RequestMethod.GET)
    public Response<?> getTheLatestBicolorSphere() {
        analysisThirdPartyResult.analysisThirdPartyResults();
        return Response.success();
    }

    /**
     * 获得最新推荐号码
     *
     * @return {@link Response}<{@link ?}>
     */
    @RequestMapping(value = "/getTheLatestRecommendationNumber",method = RequestMethod.GET)
    public Response<?> getTheLatestRecommendationNumber() {

        return Response.success();
    }
}
