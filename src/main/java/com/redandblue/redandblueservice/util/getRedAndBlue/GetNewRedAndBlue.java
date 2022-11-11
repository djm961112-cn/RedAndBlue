package com.redandblue.redandblueservice.util.getRedAndBlue;

import com.redandblue.redandblueservice.util.http.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * dengjinming
 * 2022/11/8
 */
@Component
@Slf4j
public class GetNewRedAndBlue {

    @Autowired
    HttpClientUtil httpClient;

    String url = "http://www.cwl.gov.cn/cwl_admin/front/cwlkj/search/kjxx/findDrawNotice";

    /**
     * 获得最新双色球数据
     *
     * @return {@link String}
     */
    public String getTheLatestBicolorSphere(){
        Map<String, String> param = new HashMap<>();
        Map<String, String> header=new HashMap<>();
        perfectParamAndHeader(param,header);
        String response=httpClient.doGet(url,param,header);
        log.info("response:{}",response);
        return response;
    }

    /**
     * 补全参数和头部
     *
     * @param param  参数
     * @param header 头部
     */
    public void perfectParamAndHeader(Map<String, String> param,Map<String, String> header){
        param.put("name","ssq");
        param.put("issueCount","100");//查询期数，支持30、50、100

        header.put("Connection","keep-alive");
        header.put("Accept","application/json, text/javascript, */*; q=0.01");
        header.put("Accept-Encoding","gzip, deflate");
        header.put("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,en-US;q=0.7");
        header.put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.80 Safari/537.36");
        header.put("X-Requested-With","XMLHttpRequest");
        header.put("Referer","http://www.cwl.gov.cn/ygkj/wqkjgg/ssq/");
        header.put("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,en-US;q=0.7");
        header.put("Cookie","HMF_CI=bc60b994225a9684b4a49cb8f19b1e826b15cdcc3a01051fa7bf98057c7c7f3559edb87a5d7acca2274b309291f9d6d0495b313b6ddeda8d591a3ea3990fc0b7b9; 21_vq=4");
        header.put("Host","www.cwl.gov.cn");
    }

}
