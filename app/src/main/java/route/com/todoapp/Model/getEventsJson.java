package route.com.todoapp.Model;

import java.util.List;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/24/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class getEventsJson {


    /**
     * result : {"eventsListDto":[{"id":18,"eventName":"Riva","eventImage":"Events/yrnvuhxpvy95vzdl2ip3","isPopular":true,"eventCategoryId":2}]}
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private ResultEntity result;
    private Object targetUrl;
    private boolean success;
    private boolean unAuthorizedRequest;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public ResultEntity getResult() {
        return result;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public boolean getSuccess() {
        return success;
    }

    public boolean getUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public static class ResultEntity {
        /**
         * eventsListDto : [{"id":18,"eventName":"Riva","eventImage":"Events/yrnvuhxpvy95vzdl2ip3","isPopular":true,"eventCategoryId":2}]
         */

        private List<EventsListDtoEntity> eventsListDto;

        public void setEventsListDto(List<EventsListDtoEntity> eventsListDto) {
            this.eventsListDto = eventsListDto;
        }

        public List<EventsListDtoEntity> getEventsListDto() {
            return eventsListDto;
        }

        public static class EventsListDtoEntity {
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
    }
}
