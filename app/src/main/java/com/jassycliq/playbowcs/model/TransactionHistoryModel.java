package com.jassycliq.playbowcs.model;

import java.util.List;

public class TransactionHistoryModel {
    /**
     * success : 1
     * message : User Transaction History  List.
     * data : {"user_transaction_history":[{"id":"565","user_id":"56","membership_id":"0","transaction_id":"684","transaction_type":"Withdraw","ewallet":"85.00","closing_ewallet":"6248.79","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"564","user_id":"56","membership_id":"0","transaction_id":"668","transaction_type":"Withdraw","ewallet":"83.75","closing_ewallet":"6333.79","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"563","user_id":"56","membership_id":"0","transaction_id":"883","transaction_type":"Withdraw","ewallet":"82.50","closing_ewallet":"6417.54","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"562","user_id":"56","membership_id":"0","transaction_id":"801","transaction_type":"Withdraw","ewallet":"240.00","closing_ewallet":"6500.04","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"561","user_id":"56","membership_id":"0","transaction_id":"679","transaction_type":"Withdraw","ewallet":"238.75","closing_ewallet":"6740.04","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"560","user_id":"56","membership_id":"0","transaction_id":"937","transaction_type":"Withdraw","ewallet":"237.50","closing_ewallet":"6978.79","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"559","user_id":"56","membership_id":"0","transaction_id":"622","transaction_type":"Withdraw","ewallet":"185.00","closing_ewallet":"7216.29","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"558","user_id":"56","membership_id":"0","transaction_id":"236","transaction_type":"Withdraw","ewallet":"183.75","closing_ewallet":"7401.29","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"557","user_id":"56","membership_id":"0","transaction_id":"297","transaction_type":"Withdraw","ewallet":"182.50","closing_ewallet":"7585.04","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"556","user_id":"56","membership_id":"0","transaction_id":"893","transaction_type":"Deposit","ewallet":"59.33","closing_ewallet":"7767.54","transaction_message":"Booking Amount Refund for May 24, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"555","user_id":"56","membership_id":"0","transaction_id":"372","transaction_type":"Deposit","ewallet":"58.80","closing_ewallet":"7708.21","transaction_message":"Booking Amount Refund for May 24, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"554","user_id":"56","membership_id":"0","transaction_id":"549","transaction_type":"Deposit","ewallet":"77.18","closing_ewallet":"7649.41","transaction_message":"Booking Amount Refund for May 25, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"553","user_id":"56","membership_id":"0","transaction_id":"529","transaction_type":"Deposit","ewallet":"76.65","closing_ewallet":"7572.23","transaction_message":"Booking Amount Refund for May 25, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"552","user_id":"56","membership_id":"0","transaction_id":"705","transaction_type":"Withdraw","ewallet":"154.35","closing_ewallet":"7495.58","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"551","user_id":"56","membership_id":"0","transaction_id":"597","transaction_type":"Withdraw","ewallet":"153.30","closing_ewallet":"7649.93","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"550","user_id":"56","membership_id":"0","transaction_id":"341","transaction_type":"Withdraw","ewallet":"118.65","closing_ewallet":"7803.23","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"549","user_id":"56","membership_id":"0","transaction_id":"219","transaction_type":"Withdraw","ewallet":"117.60","closing_ewallet":"7921.88","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"548","user_id":"56","membership_id":"0","transaction_id":"63","transaction_type":"Deposit","ewallet":"72.00","closing_ewallet":"8039.48","transaction_message":"Booking Amount Refund for Jun 15, 2017","transaction_datetime":"2017-05-24 05:47:13","transaction_status":"Completed"},{"id":"547","user_id":"56","membership_id":"0","transaction_id":"299","transaction_type":"Deposit","ewallet":"71.50","closing_ewallet":"7967.48","transaction_message":"Booking Amount Refund for Jun 15, 2017","transaction_datetime":"2017-05-24 05:47:13","transaction_status":"Completed"},{"id":"546","user_id":"56","membership_id":"0","transaction_id":"334","transaction_type":"Deposit","ewallet":"71.00","closing_ewallet":"7895.98","transaction_message":"Booking Amount Refund for Jun 15, 2017","transaction_datetime":"2017-05-24 05:47:13","transaction_status":"Completed"}],"total_pages":12,"next_page":2,"is_next_page_available":true}
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
         * user_transaction_history : [{"id":"565","user_id":"56","membership_id":"0","transaction_id":"684","transaction_type":"Withdraw","ewallet":"85.00","closing_ewallet":"6248.79","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"564","user_id":"56","membership_id":"0","transaction_id":"668","transaction_type":"Withdraw","ewallet":"83.75","closing_ewallet":"6333.79","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"563","user_id":"56","membership_id":"0","transaction_id":"883","transaction_type":"Withdraw","ewallet":"82.50","closing_ewallet":"6417.54","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"562","user_id":"56","membership_id":"0","transaction_id":"801","transaction_type":"Withdraw","ewallet":"240.00","closing_ewallet":"6500.04","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"561","user_id":"56","membership_id":"0","transaction_id":"679","transaction_type":"Withdraw","ewallet":"238.75","closing_ewallet":"6740.04","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"560","user_id":"56","membership_id":"0","transaction_id":"937","transaction_type":"Withdraw","ewallet":"237.50","closing_ewallet":"6978.79","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"559","user_id":"56","membership_id":"0","transaction_id":"622","transaction_type":"Withdraw","ewallet":"185.00","closing_ewallet":"7216.29","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"558","user_id":"56","membership_id":"0","transaction_id":"236","transaction_type":"Withdraw","ewallet":"183.75","closing_ewallet":"7401.29","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"557","user_id":"56","membership_id":"0","transaction_id":"297","transaction_type":"Withdraw","ewallet":"182.50","closing_ewallet":"7585.04","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:53:17","transaction_status":"Completed"},{"id":"556","user_id":"56","membership_id":"0","transaction_id":"893","transaction_type":"Deposit","ewallet":"59.33","closing_ewallet":"7767.54","transaction_message":"Booking Amount Refund for May 24, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"555","user_id":"56","membership_id":"0","transaction_id":"372","transaction_type":"Deposit","ewallet":"58.80","closing_ewallet":"7708.21","transaction_message":"Booking Amount Refund for May 24, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"554","user_id":"56","membership_id":"0","transaction_id":"549","transaction_type":"Deposit","ewallet":"77.18","closing_ewallet":"7649.41","transaction_message":"Booking Amount Refund for May 25, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"553","user_id":"56","membership_id":"0","transaction_id":"529","transaction_type":"Deposit","ewallet":"76.65","closing_ewallet":"7572.23","transaction_message":"Booking Amount Refund for May 25, 2017","transaction_datetime":"2017-05-24 05:50:22","transaction_status":"Completed"},{"id":"552","user_id":"56","membership_id":"0","transaction_id":"705","transaction_type":"Withdraw","ewallet":"154.35","closing_ewallet":"7495.58","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"551","user_id":"56","membership_id":"0","transaction_id":"597","transaction_type":"Withdraw","ewallet":"153.30","closing_ewallet":"7649.93","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"550","user_id":"56","membership_id":"0","transaction_id":"341","transaction_type":"Withdraw","ewallet":"118.65","closing_ewallet":"7803.23","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"549","user_id":"56","membership_id":"0","transaction_id":"219","transaction_type":"Withdraw","ewallet":"117.60","closing_ewallet":"7921.88","transaction_message":"Booking Amount Deducted","transaction_datetime":"2017-05-24 05:49:39","transaction_status":"Completed"},{"id":"548","user_id":"56","membership_id":"0","transaction_id":"63","transaction_type":"Deposit","ewallet":"72.00","closing_ewallet":"8039.48","transaction_message":"Booking Amount Refund for Jun 15, 2017","transaction_datetime":"2017-05-24 05:47:13","transaction_status":"Completed"},{"id":"547","user_id":"56","membership_id":"0","transaction_id":"299","transaction_type":"Deposit","ewallet":"71.50","closing_ewallet":"7967.48","transaction_message":"Booking Amount Refund for Jun 15, 2017","transaction_datetime":"2017-05-24 05:47:13","transaction_status":"Completed"},{"id":"546","user_id":"56","membership_id":"0","transaction_id":"334","transaction_type":"Deposit","ewallet":"71.00","closing_ewallet":"7895.98","transaction_message":"Booking Amount Refund for Jun 15, 2017","transaction_datetime":"2017-05-24 05:47:13","transaction_status":"Completed"}]
         * total_pages : 12
         * next_page : 2
         * is_next_page_available : true
         */

        private int total_pages;
        private int next_page;
        private boolean is_next_page_available;
        private List<UserTransactionHistoryBean> user_transaction_history;

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public int getNext_page() {
            return next_page;
        }

        public void setNext_page(int next_page) {
            this.next_page = next_page;
        }

        public boolean isIs_next_page_available() {
            return is_next_page_available;
        }

        public void setIs_next_page_available(boolean is_next_page_available) {
            this.is_next_page_available = is_next_page_available;
        }

        public List<UserTransactionHistoryBean> getUser_transaction_history() {
            return user_transaction_history;
        }

        public void setUser_transaction_history(List<UserTransactionHistoryBean> user_transaction_history) {
            this.user_transaction_history = user_transaction_history;
        }

        public static class UserTransactionHistoryBean {
            /**
             * id : 565
             * user_id : 56
             * membership_id : 0
             * transaction_id : 684
             * transaction_type : Withdraw
             * ewallet : 85.00
             * closing_ewallet : 6248.79
             * transaction_message : Booking Amount Deducted
             * transaction_datetime : 2017-05-24 05:53:17
             * transaction_status : Completed
             */

            private String id;
            private String user_id;
            private String membership_id;
            private String transaction_id;
            private String transaction_type;
            private String ewallet;
            private String closing_ewallet;
            private String transaction_message;
            private String transaction_datetime;
            private String transaction_status;

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

            public String getMembership_id() {
                return membership_id;
            }

            public void setMembership_id(String membership_id) {
                this.membership_id = membership_id;
            }

            public String getTransaction_id() {
                return transaction_id;
            }

            public void setTransaction_id(String transaction_id) {
                this.transaction_id = transaction_id;
            }

            public String getTransaction_type() {
                return transaction_type;
            }

            public void setTransaction_type(String transaction_type) {
                this.transaction_type = transaction_type;
            }

            public String getEwallet() {
                return ewallet;
            }

            public void setEwallet(String ewallet) {
                this.ewallet = ewallet;
            }

            public String getClosing_ewallet() {
                return closing_ewallet;
            }

            public void setClosing_ewallet(String closing_ewallet) {
                this.closing_ewallet = closing_ewallet;
            }

            public String getTransaction_message() {
                return transaction_message;
            }

            public void setTransaction_message(String transaction_message) {
                this.transaction_message = transaction_message;
            }

            public String getTransaction_datetime() {
                return transaction_datetime;
            }

            public void setTransaction_datetime(String transaction_datetime) {
                this.transaction_datetime = transaction_datetime;
            }

            public String getTransaction_status() {
                return transaction_status;
            }

            public void setTransaction_status(String transaction_status) {
                this.transaction_status = transaction_status;
            }
        }
    }
}