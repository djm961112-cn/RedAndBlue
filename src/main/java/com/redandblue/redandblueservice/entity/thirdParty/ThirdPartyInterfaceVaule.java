package com.redandblue.redandblueservice.entity.thirdParty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * dengjinming
 * 2022/11/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThirdPartyInterfaceVaule {
    /**
     * 状态
     */
    private int state;
    /**
     * 消息
     */
    private String message;
    /**
     * 页面数
     */
    private int pageCount;
    /**
     * 计数num
     */
    private int countNum;
    /**
     * tflag
     */
    private int Tflag;
    /**
     * 结果
     */
    private List<ThirdPartyResult> result;
}
