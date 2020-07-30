package com.xijue.uruleclient.entity;

import com.bstek.urule.model.Label;

/**
 * Description： ResponseDto
 * Date: Created in 2020/7/30 11:10
 * Version: 1.0
 */
public class ResponseDto {

    @Label("总分数")
    private String sumScore;

    public String getSumScore() {
        return sumScore;
    }

    public void setSumScore(String sumScore) {
        this.sumScore = sumScore;
    }
}
