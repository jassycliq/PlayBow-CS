package com.jassycliq.playbowcs.model;

public class PlayDateCheckoutModel {
    /**
     * success : 1
     * message : Booking successfully submitted. Remaining credits: $14706.6
     * data : {"ewallet_amount":"v43j0FCFKWdvUrH0iFIi/A=="}
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
         * ewallet_amount : v43j0FCFKWdvUrH0iFIi/A==
         */

        private String ewallet_amount;

        public String getEwallet_amount() {
            return ewallet_amount;
        }

        public void setEwallet_amount(String ewallet_amount) {
            this.ewallet_amount = ewallet_amount;
        }
    }
}
