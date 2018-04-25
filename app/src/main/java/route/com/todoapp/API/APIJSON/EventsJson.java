package route.com.todoapp.API.APIJSON;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import route.com.todoapp.Model.Event;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/24/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class EventsJson {


    /**
     * result : {"eventsListDto":[{"id":18,"eventName":"Riva","eventImage":"Events/yrnvuhxpvy95vzdl2ip3","isPopular":true,"eventCategoryId":2}]}
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private ResultEntity result;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public ResultEntity getResult() {
        return result;
    }

    public boolean getSuccess() {
        return success;
    }

    public Object getError() {
        return error;
    }

    public boolean getUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public static class ResultEntity {
        /**
         * eventsListDto : [{"id":18,"eventName":"Riva","eventImage":"Events/yrnvuhxpvy95vzdl2ip3","isPopular":true,"eventCategoryId":2}]
         */

        @SerializedName("eventsListDto")
        private List<Event> Events;

        public List<Event> getEvents() {
            return Events;
        }

        public void setEvents(List<Event> events) {
            Events = events;
        }
    }
}
