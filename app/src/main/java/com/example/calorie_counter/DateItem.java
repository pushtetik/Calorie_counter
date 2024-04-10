package com.example.calorie_counter;

import java.util.List;

public class DateItem {
    private String itemDate;
    private List<itemfrag1> subItemList;

    public DateItem(String itemDate, List<itemfrag1> subItemList) {
        this.itemDate = itemDate;
        this.subItemList = subItemList;
    }

    public String getitemDate() {
        return itemDate;
    }

    public void setitemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public List<itemfrag1> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<itemfrag1> subItemList) {
        this.subItemList = subItemList;
    }
}

