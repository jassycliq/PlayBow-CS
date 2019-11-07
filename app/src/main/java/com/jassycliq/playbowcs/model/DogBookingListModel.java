package com.jassycliq.playbowcs.model;

import java.util.List;

public class DogBookingListModel {
    /**
     * success : 1
     * message : Booking Rate detail.
     * data : {"info":[{"booking_date":"2017-06-01","rate_info":[{"booking_id":"1","dog_id":"1","dog_name":"Rokey","dog_booking_no":"4","dog_booking_rate":"139","is_special_rate":"0","tips_percentage":"10","tips_amount":"13.9","total_amount":152.9,"refund_amount":76.45},{"booking_id":"2","dog_id":"2","dog_name":"Tom","dog_booking_no":"5","dog_booking_rate":"140","is_special_rate":"0","tips_percentage":"10","tips_amount":"14","total_amount":154,"refund_amount":77},{"booking_id":"3","dog_id":"3","dog_name":"Rokey","dog_booking_no":"6","dog_booking_rate":"141","is_special_rate":"0","tips_percentage":"10","tips_amount":"14.1","total_amount":155.1,"refund_amount":77.55}]},{"booking_date":"2017-06-02","rate_info":[{"booking_id":"1","dog_id":"1","dog_name":"Rokey","dog_booking_no":"4","dog_booking_rate":"184","is_special_rate":"0","tips_percentage":"10","tips_amount":"18.4","total_amount":202.4,"refund_amount":101.2},{"booking_id":"2","dog_id":"2","dog_name":"Tom","dog_booking_no":"5","dog_booking_rate":"185","is_special_rate":"0","tips_percentage":"10","tips_amount":"18.5","total_amount":203.5,"refund_amount":101.75},{"booking_id":"3","dog_id":"3","dog_name":"Rokey","dog_booking_no":"6","dog_booking_rate":"186","is_special_rate":"0","tips_percentage":"10","tips_amount":"18.6","total_amount":204.6,"refund_amount":102.3}]}]}
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
        private List<InfoBean> info;

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class InfoBean  {
            /**
             * booking_date : 2017-06-01
             * rate_info : [{"booking_id":"1","dog_id":"1","dog_name":"Rokey","dog_booking_no":"4","dog_booking_rate":"139","is_special_rate":"0","tips_percentage":"10","tips_amount":"13.9","total_amount":152.9,"refund_amount":76.45},{"booking_id":"2","dog_id":"2","dog_name":"Tom","dog_booking_no":"5","dog_booking_rate":"140","is_special_rate":"0","tips_percentage":"10","tips_amount":"14","total_amount":154,"refund_amount":77},{"booking_id":"3","dog_id":"3","dog_name":"Rokey","dog_booking_no":"6","dog_booking_rate":"141","is_special_rate":"0","tips_percentage":"10","tips_amount":"14.1","total_amount":155.1,"refund_amount":77.55}]
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
                 * booking_id : 1
                 * dog_id : 1
                 * dog_name : Rokey
                 * dog_booking_no : 4
                 * dog_booking_rate : 139
                 * is_special_rate : 0
                 * tips_percentage : 10
                 * tips_amount : 13.9
                 * total_amount : 152.9
                 * refund_amount : 76.45
                 */

                private String booking_id;
                private String dog_id;
                private String dog_name;
                private String dog_booking_no;
                private String dog_booking_rate;
                private String is_special_rate;
                private String tips_percentage;
                private String tips_amount;
                private double total_amount;
                private double refund_amount;

                public String getBooking_id() {
                    return booking_id;
                }

                public void setBooking_id(String booking_id) {
                    this.booking_id = booking_id;
                }

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

                public String getIs_special_rate() {
                    return is_special_rate;
                }

                public void setIs_special_rate(String is_special_rate) {
                    this.is_special_rate = is_special_rate;
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

                public double getTotal_amount() {
                    return total_amount;
                }

                public void setTotal_amount(double total_amount) {
                    this.total_amount = total_amount;
                }

                public double getRefund_amount() {
                    return refund_amount;
                }

                public void setRefund_amount(double refund_amount) {
                    this.refund_amount = refund_amount;
                }
            }
        }
    }
}
