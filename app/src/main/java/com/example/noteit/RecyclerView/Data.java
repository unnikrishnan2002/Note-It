package com.example.noteit.RecyclerView;

public class Data {
    private String heading;
    private String description;
    private int color;
    
    public Data(){}

    public Data(String heading, String description) {
        this.heading = heading;
        this.description = description;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getHeading() {
        return heading;
    }
    public String getDescription() {
        return description;
    }
    public int getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color=Integer.parseInt(color);
    }

}
