package com.nobel.baseapp.Model;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/24/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class Event {

    /**
     * id : 18
     * eventName : Riva
     * eventImage : Events/yrnvuhxpvy95vzdl2ip3
     * isPopular : true
     * eventCategoryId : 2
     */

    private int id;
    private String eventName;
    private String eventImage;
    private boolean isPopular;
    private int eventCategoryId;

    public void setId(int id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public void setIsPopular(boolean isPopular) {
        this.isPopular = isPopular;
    }

    public void setEventCategoryId(int eventCategoryId) {
        this.eventCategoryId = eventCategoryId;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventImage() {
        return eventImage;
    }

    public boolean getIsPopular() {
        return isPopular;
    }

    public int getEventCategoryId() {
        return eventCategoryId;
    }
}
