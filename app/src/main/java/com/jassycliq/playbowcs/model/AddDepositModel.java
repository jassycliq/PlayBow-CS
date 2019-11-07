package com.jassycliq.playbowcs.model;

public class AddDepositModel {

    /**
     * success : 1
     * message : Deposit added successfully
     * data : {"user_id":56,"ewallet_amount":"2zzr2NLIX+NAteEiyhmhiA=="}
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
         * user_id : 56
         * ewallet_amount : 2zzr2NLIX+NAteEiyhmhiA==
         */

        private int user_id;
        private String ewallet_amount;

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
    }
}

