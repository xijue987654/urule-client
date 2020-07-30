package com.xijue.uruleclient.entity;

import com.bstek.urule.model.Label;

import java.util.List;

/**
 * Description： request dto
 * Date: Created in 2020/7/30 11:07
 * Version: 1.0
 */
public class RequestDto {

    @Label("一级框架")
    private List<Framework> lists;

    public List<Framework> getLists() {
        return lists;
    }

    public void setLists(List<Framework> lists) {
        this.lists = lists;
    }

}
