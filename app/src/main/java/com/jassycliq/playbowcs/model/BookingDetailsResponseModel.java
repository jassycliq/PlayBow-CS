package com.jassycliq.playbowcs.model;

import java.io.Serializable;
import java.util.List;

public class BookingDetailsResponseModel implements Serializable {
    /**
     * success : 1
     * message : Booking detail.
     * data : {"user_id":50,"ewallet_amount":"a16hYUIIgiBUdfXD4DlecQ==","pet_capacity":"45","dog_profile":[{"id":"74","user_id":"50","name":"s1","image":"http://playbowapp.com/backend/uploads/no_dog.jpg"},{"id":"75","user_id":"50","name":"s2","image":"http://playbowapp.com/backend/uploads/no_dog.jpg"},{"id":"76","user_id":"50","name":"s3","image":"http://playbowapp.com/backend/uploads/no_dog.jpg"}],"total_booking":[{"booking_date":"2017-12-08","booking_count":"5"},{"booking_date":"2017-12-11","booking_count":"3"},{"booking_date":"2017-12-12","booking_count":"1"},{"booking_date":"2017-12-13","booking_count":"2"},{"booking_date":"2017-12-14","booking_count":"1"},{"booking_date":"2017-12-15","booking_count":"1"},{"booking_date":"2017-12-18","booking_count":"1"},{"booking_date":"2017-12-19","booking_count":"1"},{"booking_date":"2017-12-20","booking_count":"1"},{"booking_date":"2017-12-21","booking_count":"1"},{"booking_date":"2017-12-22","booking_count":"1"},{"booking_date":"2017-12-25","booking_count":"1"},{"booking_date":"2017-12-26","booking_count":"1"},{"booking_date":"2017-12-27","booking_count":"1"},{"booking_date":"2018-01-10","booking_count":"1"},{"booking_date":"2018-01-11","booking_count":"1"},{"booking_date":"2018-01-12","booking_count":"1"},{"booking_date":"2018-01-17","booking_count":"1"},{"booking_date":"2018-01-18","booking_count":"1"},{"booking_date":"2018-01-19","booking_count":"1"},{"booking_date":"2018-01-24","booking_count":"1"},{"booking_date":"2018-01-25","booking_count":"1"},{"booking_date":"2018-01-26","booking_count":"1"},{"booking_date":"2018-01-31","booking_count":"1"},{"booking_date":"2018-02-01","booking_count":"1"},{"booking_date":"2018-02-02","booking_count":"1"},{"booking_date":"2018-02-07","booking_count":"1"},{"booking_date":"2018-02-08","booking_count":"1"},{"booking_date":"2018-02-09","booking_count":"1"},{"booking_date":"2018-02-14","booking_count":"1"},{"booking_date":"2018-02-21","booking_count":"1"},{"booking_date":"2018-02-22","booking_count":"1"},{"booking_date":"2018-02-23","booking_count":"1"},{"booking_date":"2018-02-28","booking_count":"1"}],"my_booking":[{"dog_id":"74","name":"s1","membership_id":"0","booking_date":"2017-12-08","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"75","name":"s2","membership_id":"0","booking_date":"2017-12-08","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"76","name":"s3","membership_id":"0","booking_date":"2017-12-08","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"74","name":"s1","membership_id":"0","booking_date":"2017-12-11","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"75","name":"s2","membership_id":"0","booking_date":"2017-12-11","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"76","name":"s3","membership_id":"0","booking_date":"2017-12-11","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"}],"my_booking_membership":[{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-12"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-13"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-18"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-19"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-20"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-25"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-26"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-27"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-01"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-02"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-03"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-08"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-09"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-10"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-15"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-16"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-17"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-22"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-23"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-24"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-29"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-30"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-31"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-05"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-06"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-07"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-12"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-13"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-14"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-19"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-20"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-21"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-26"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-27"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-28"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-05"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-06"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-07"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-12"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-13"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-14"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-19"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-20"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-21"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-26"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-27"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-28"}],"live_session":{"is_live":0,"session_duration":0},"holiday_list":[{"holiday_id":"7","date":"2017-12-25"},{"holiday_id":"8","date":"2018-01-01"}]}
     */

    private int success;
    private String message;
    private DataBean data;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 50
         * ewallet_amount : a16hYUIIgiBUdfXD4DlecQ==
         * pet_capacity : 45
         * dog_profile : [{"id":"74","user_id":"50","name":"s1","image":"http://playbowapp.com/backend/uploads/no_dog.jpg"},{"id":"75","user_id":"50","name":"s2","image":"http://playbowapp.com/backend/uploads/no_dog.jpg"},{"id":"76","user_id":"50","name":"s3","image":"http://playbowapp.com/backend/uploads/no_dog.jpg"}]
         * total_booking : [{"booking_date":"2017-12-08","booking_count":"5"},{"booking_date":"2017-12-11","booking_count":"3"},{"booking_date":"2017-12-12","booking_count":"1"},{"booking_date":"2017-12-13","booking_count":"2"},{"booking_date":"2017-12-14","booking_count":"1"},{"booking_date":"2017-12-15","booking_count":"1"},{"booking_date":"2017-12-18","booking_count":"1"},{"booking_date":"2017-12-19","booking_count":"1"},{"booking_date":"2017-12-20","booking_count":"1"},{"booking_date":"2017-12-21","booking_count":"1"},{"booking_date":"2017-12-22","booking_count":"1"},{"booking_date":"2017-12-25","booking_count":"1"},{"booking_date":"2017-12-26","booking_count":"1"},{"booking_date":"2017-12-27","booking_count":"1"},{"booking_date":"2018-01-10","booking_count":"1"},{"booking_date":"2018-01-11","booking_count":"1"},{"booking_date":"2018-01-12","booking_count":"1"},{"booking_date":"2018-01-17","booking_count":"1"},{"booking_date":"2018-01-18","booking_count":"1"},{"booking_date":"2018-01-19","booking_count":"1"},{"booking_date":"2018-01-24","booking_count":"1"},{"booking_date":"2018-01-25","booking_count":"1"},{"booking_date":"2018-01-26","booking_count":"1"},{"booking_date":"2018-01-31","booking_count":"1"},{"booking_date":"2018-02-01","booking_count":"1"},{"booking_date":"2018-02-02","booking_count":"1"},{"booking_date":"2018-02-07","booking_count":"1"},{"booking_date":"2018-02-08","booking_count":"1"},{"booking_date":"2018-02-09","booking_count":"1"},{"booking_date":"2018-02-14","booking_count":"1"},{"booking_date":"2018-02-21","booking_count":"1"},{"booking_date":"2018-02-22","booking_count":"1"},{"booking_date":"2018-02-23","booking_count":"1"},{"booking_date":"2018-02-28","booking_count":"1"}]
         * my_booking : [{"dog_id":"74","name":"s1","membership_id":"0","booking_date":"2017-12-08","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"75","name":"s2","membership_id":"0","booking_date":"2017-12-08","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"76","name":"s3","membership_id":"0","booking_date":"2017-12-08","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"74","name":"s1","membership_id":"0","booking_date":"2017-12-11","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"75","name":"s2","membership_id":"0","booking_date":"2017-12-11","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"},{"dog_id":"76","name":"s3","membership_id":"0","booking_date":"2017-12-11","dog_booking_rate":"29.00","tips_percentage":"0.00","tips_amount":"0.00","is_special_rate":"0","total_amount":"29.00"}]
         * my_booking_membership : [{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-12"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-13"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-18"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-19"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-20"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-25"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-26"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2017-12-27"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-01"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-02"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-03"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-08"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-09"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-10"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-15"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-16"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-17"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-22"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-23"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-24"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-29"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-30"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-01-31"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-05"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-06"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-07"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-12"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-13"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-14"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-19"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-20"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-21"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-26"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-27"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-02-28"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-05"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-06"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-07"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-12"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-13"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-14"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-19"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-20"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-21"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-26"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-27"},{"user_id":"50","dog_id":"74","name":"s1","membership_id":"1","booking_rate":"Monthly","booking_date":"2018-03-28"}]
         * live_session : {"is_live":0,"session_duration":0}
         * holiday_list : [{"holiday_id":"7","date":"2017-12-25"},{"holiday_id":"8","date":"2018-01-01"}]
         */

        private int user_id;
        private String ewallet_amount;
        private String pet_capacity;
        private LiveSessionBean live_session;
        private List<DogProfileBean> dog_profile;
        private List<TotalBookingBean> total_booking;
        private List<MyBookingBean> my_booking;
        private List<MyBookingMembershipBean> my_booking_membership;
        private List<HolidayListBean> holiday_list;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getEwallet_amount() {
            return ewallet_amount;
        }

        public void setEwallet_amount(String ewallet_amount) {
            this.ewallet_amount = ewallet_amount;
        }

        public String getPet_capacity() {
            return pet_capacity;
        }

        public void setPet_capacity(String pet_capacity) {
            this.pet_capacity = pet_capacity;
        }

        public LiveSessionBean getLive_session() {
            return live_session;
        }

        public void setLive_session(LiveSessionBean live_session) {
            this.live_session = live_session;
        }

        public List<DogProfileBean> getDog_profile() {
            return dog_profile;
        }

        public void setDog_profile(List<DogProfileBean> dog_profile) {
            this.dog_profile = dog_profile;
        }

        public List<TotalBookingBean> getTotal_booking() {
            return total_booking;
        }

        public void setTotal_booking(List<TotalBookingBean> total_booking) {
            this.total_booking = total_booking;
        }

        public List<MyBookingBean> getMy_booking() {
            return my_booking;
        }

        public void setMy_booking(List<MyBookingBean> my_booking) {
            this.my_booking = my_booking;
        }

        public List<MyBookingMembershipBean> getMy_booking_membership() {
            return my_booking_membership;
        }

        public void setMy_booking_membership(List<MyBookingMembershipBean> my_booking_membership) {
            this.my_booking_membership = my_booking_membership;
        }

        public List<HolidayListBean> getHoliday_list() {
            return holiday_list;
        }

        public void setHoliday_list(List<HolidayListBean> holiday_list) {
            this.holiday_list = holiday_list;
        }

        public static class LiveSessionBean {
            /**
             * is_live : 0
             * session_duration : 0
             */

            private String is_live;
            private String session_duration;

            public String getIs_live() {
                return is_live;
            }

            public void setIs_live(String is_live) {
                this.is_live = is_live;
            }

            public String getSession_duration() {
                return session_duration;
            }

            public void setSession_duration(String session_duration) {
                this.session_duration = session_duration;
            }
        }

        public static class DogProfileBean implements Serializable {
            /**
             * id : 74
             * user_id : 50
             * name : s1
             * image : http://playbowapp.com/backend/uploads/no_dog.jpg
             */

            private String id;
            private String user_id;
            private String name;
            private String image;
            private boolean isSelected = true;

            public boolean isSelected() {
                return isSelected;
            }

            public void setSelected(boolean selected) {
                isSelected = selected;
            }


            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

        public static class TotalBookingBean {
            /**
             * booking_date : 2017-12-08
             * booking_count : 5
             */

            private String booking_date;
            private String booking_count;

            public String getBooking_date() {
                return booking_date;
            }

            public void setBooking_date(String booking_date) {
                this.booking_date = booking_date;
            }

            public String getBooking_count() {
                return booking_count;
            }

            public void setBooking_count(String booking_count) {
                this.booking_count = booking_count;
            }
        }

        public static class MyBookingBean {
            /**
             * dog_id : 74
             * name : s1
             * membership_id : 0
             * booking_date : 2017-12-08
             * dog_booking_rate : 29.00
             * tips_percentage : 0.00
             * tips_amount : 0.00
             * is_special_rate : 0
             * total_amount : 29.00
             */

            private String dog_id;
            private String name;
            private String membership_id;
            private String booking_date;
            private String dog_booking_rate;
            private String tips_percentage;
            private String tips_amount;
            private String is_special_rate;
            private String total_amount;
            private int delivery_option;

            public int getDelivery_option() {return delivery_option; }

            public void setDelivery_option(int option) {this.delivery_option = option; }

            public String getDog_id() {
                return dog_id;
            }

            public void setDog_id(String dog_id) {
                this.dog_id = dog_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMembership_id() {
                return membership_id;
            }

            public void setMembership_id(String membership_id) {
                this.membership_id = membership_id;
            }

            public String getBooking_date() {
                return booking_date;
            }

            public void setBooking_date(String booking_date) {
                this.booking_date = booking_date;
            }

            public String getDog_booking_rate() {
                return dog_booking_rate;
            }

            public void setDog_booking_rate(String dog_booking_rate) {
                this.dog_booking_rate = dog_booking_rate;
            }

            public String getTips_percentage() {
                return tips_percentage;
            }

            public void setTips_percentage(String tips_percentage) {
                this.tips_percentage = tips_percentage;
            }

            public String getTips_amount() {
                return tips_amount;
            }

            public void setTips_amount(String tips_amount) {
                this.tips_amount = tips_amount;
            }

            public String getIs_special_rate() {
                return is_special_rate;
            }

            public void setIs_special_rate(String is_special_rate) {
                this.is_special_rate = is_special_rate;
            }

            public String getTotal_amount() {
                return total_amount;
            }

            public void setTotal_amount(String total_amount) {
                this.total_amount = total_amount;
            }
        }

        public static class MyBookingMembershipBean {
            /**
             * user_id : 50
             * dog_id : 74
             * name : s1
             * membership_id : 1
             * booking_rate : Monthly
             * booking_date : 2017-12-12
             */

            private String user_id;
            private String dog_id;
            private String name;
            private String membership_id;
            private String booking_rate;
            private String booking_date;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getDog_id() {
                return dog_id;
            }

            public void setDog_id(String dog_id) {
                this.dog_id = dog_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMembership_id() {
                return membership_id;
            }

            public void setMembership_id(String membership_id) {
                this.membership_id = membership_id;
            }

            public String getBooking_rate() {
                return booking_rate;
            }

            public void setBooking_rate(String booking_rate) {
                this.booking_rate = booking_rate;
            }

            public String getBooking_date() {
                return booking_date;
            }

            public void setBooking_date(String booking_date) {
                this.booking_date = booking_date;
            }
        }

        public static class HolidayListBean {
            /**
             * holiday_id : 7
             * date : 2017-12-25
             */

            private String holiday_id;
            private String date;

            public String getHoliday_id() {
                return holiday_id;
            }

            public void setHoliday_id(String holiday_id) {
                this.holiday_id = holiday_id;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
