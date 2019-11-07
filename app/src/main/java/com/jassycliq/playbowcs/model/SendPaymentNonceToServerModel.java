package com.jassycliq.playbowcs.model;

public class SendPaymentNonceToServerModel {
    /**
     * success : 1
     * message : Credits successfully added!
     * data : {"ewallet_amount":"GwYKnAvTgXcig4izsEnSBg=="}
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
         * ewallet_amount : GwYKnAvTgXcig4izsEnSBg==
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
