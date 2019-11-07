package com.jassycliq.playbowcs.model;

import java.io.Serializable;
import java.util.List;

public class BookingRateModel implements Serializable {
    /**
     * success : 1
     * message : Booking Rate detail.
     * data : {"details":[{"booking_date":"2017-07-25","rate_info":[{"dog_id":"571","dog_name":"tomy","dog_booking_no":"26","dog_booking_rate":"71.00","is_special_rate":0},{"dog_id":"572","dog_name":"labra","dog_booking_no":"27","dog_booking_rate":"72.00","is_special_rate":0},{"dog_id":"573","dog_name":"carry","dog_booking_no":"28","dog_booking_rate":"73.00","is_special_rate":0}]}]}
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
        private double delivery_rate_am;
        private double delivery_rate_pm;
        private double delivery_rate_ampm;

        public double getDelivery_rate_am() {
            return delivery_rate_am;
        }
        public void setDelivery_rate_am(double rate) {
            this.delivery_rate_am = rate;
        }
        public double getDelivery_rate_pm() {
            return delivery_rate_pm;
        }
        public void setDelivery_rate_pm(double rate) {
            this.delivery_rate_pm = rate;
        }
        public double getDelivery_rate_ampm() {
            return delivery_rate_ampm;
        }
        public void setDelivery_rate_ampm(double rate) {
            this.delivery_rate_ampm = rate;
        }

        private List<DetailsBean> details;

        public List<DetailsBean> getDetails() {
            return details;
        }

        public void setDetails(List<DetailsBean> details) {
            this.details = details;
        }

        public static class DetailsBean {
            /**
             * booking_date : 2017-07-25
             * rate_info : [{"dog_id":"571","dog_name":"tomy","dog_booking_no":"26","dog_booking_rate":"71.00","is_special_rate":0},{"dog_id":"572","dog_name":"labra","dog_booking_no":"27","dog_booking_rate":"72.00","is_special_rate":0},{"dog_id":"573","dog_name":"carry","dog_booking_no":"28","dog_booking_rate":"73.00","is_special_rate":0}]
             */

            private String booking_date;
            private List<RateInfoBean> rate_info;

            public String getBooking_date() {
                return booking_date;
            }

            public void setBooking_date(String booking_date) {
                this.booking_date = booking_date;
            }

            public List<RateInfoBean> getRate_info() {
                return rate_info;
            }

            public void setRate_info(List<RateInfoBean> rate_info) {
                this.rate_info = rate_info;
            }

            public static class RateInfoBean {
                /**
                 * dog_id : 571
                 * dog_name : tomy
                 * dog_booking_no : 26
                 * dog_booking_rate : 71.00
                 * is_special_rate : 0
                 */

                private String dog_id;
                private String dog_name;
                private String dog_booking_no;
                private String dog_booking_rate;
                private int is_special_rate;

                public String getDog_id() {
                    return dog_id;
                }

                public void setDog_id(String dog_id) {
                    this.dog_id = dog_id;
                }

                public String getDog_name() {
                    return dog_name;
                }

                public void setDog_name(String dog_name) {
                    this.dog_name = dog_name;
                }

                public String getDog_booking_no() {
                    return dog_booking_no;
                }

                public void setDog_booking_no(String dog_booking_no) {
                    this.dog_booking_no = dog_booking_no;
                }

                public String getDog_booking_rate() {
                    return dog_booking_rate;
                }

                public void setDog_booking_rate(String dog_booking_rate) {
                    this.dog_booking_rate = dog_booking_rate;
                }

                public int getIs_special_rate() {
                    return is_special_rate;
                }

                public void setIs_special_rate(int is_special_rate) {
                    this.is_special_rate = is_special_rate;
                }
            }
        }
    }
}
