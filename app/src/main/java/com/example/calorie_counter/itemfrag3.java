package com.example.calorie_counter;

public class itemfrag3 {
    private String title,count,countCalories;
    int image;


    public itemfrag3 (String title, String count, String countCalories, int image)
    {
        this.image=image;
        this.title=title;
        this.count=count;
        this.countCalories=countCalories;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCountCalories() {
        return countCalories;
    }
    public void setCountCalories(int CountCalories) {
        this.countCalories=countCalories;
    }
    public int getimage() {
        return this.image;
    }
    public void setimage(int image) {
        this.image=image;
    }
}
