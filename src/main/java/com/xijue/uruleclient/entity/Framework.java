package com.xijue.uruleclient.entity;

import com.bstek.urule.model.Label;

/**
 * Description： Framework
 * Date: Created in 2020/7/30 11:09
 * Version: 1.0
 */
public class Framework {

    @Label("名称")
    private String name;

    @Label("权重")
    private String weight;

    @Label("分数")
    private String score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
