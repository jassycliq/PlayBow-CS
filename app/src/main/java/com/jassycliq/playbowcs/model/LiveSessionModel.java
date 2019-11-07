package com.jassycliq.playbowcs.model;

import androidx.annotation.Nullable;

import java.util.List;

public class LiveSessionModel {


    /**
     * success : 1
     * message : Dog session viewed successfully.
     * data : {"sessions":[{"id":"17","canine_id":"1","user_id":"17","dog_id":"31","session_duration":"5","start_date_time":"2017-12-04 00:00:07","status":"2","view_status":"0","created_date":"2017-12-04 10:37:01","name":"dog 1"},{"id":"18","canine_id":"1","user_id":"17","dog_id":"31","session_duration":"1440","start_date_time":"2017-12-04 00:00:36","status":"1","view_status":"1","created_date":"2017-12-04 12:39:42","name":"dog 1"}]}
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
        private List<SessionsBean> sessions;

        @Nullable
        public List<SessionsBean> getSessions() {
            if (sessions == null) {
                return null;
            } else {
                return sessions;
            }
        }

        public void setSessions(List<SessionsBean> sessions) {
            this.sessions = sessions;
        }

        public static class SessionsBean {
            /**
             * id : 17
             * canine_id : 1
             * user_id : 17
             * dog_id : 31
             * session_duration : 5
             * start_date_time : 2017-12-04 00:00:07
             * status : 2
             * view_status : 0
             * created_date : 2017-12-04 10:37:01
             * name : dog 1
             */

            private String id;
            private String canine_id;
            private String user_id;
            private String dog_id;
            private String session_duration;
            private String start_date_time;
            private String status;
            private String view_status;
            private String created_date;
            private String created_time;
            private String name;
            private String ownership;
            private String dog_name;
            private String pbl_video;
            private String pbl_gif;
            private String is_expired;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCanine_id() {
                return canine_id;
            }

            public void setCanine_id(String canine_id) {
                this.canine_id = canine_id;
            }

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

            public String getSession_duration() {
                return session_duration;
            }

            public void setSession_duration(String session_duration) {
                this.session_duration = session_duration;
            }

            public String getStart_date_time() {
                return start_date_time;
            }

            public void setStart_date_time(String start_date_time) {
                this.start_date_time = start_date_time;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getView_status() {
                return view_status;
            }

            public void setView_status(String view_status) {
                this.view_status = view_status;
            }

            public String getCreated_date() {
                return created_date;
            }

            public void setCreated_date(String created_date) {
                this.created_date = created_date;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOwnership() {
                return ownership;
            }

            public void setOwnership(String ownership) {
                this.ownership = ownership;
            }

            public String getDogName() {
                return dog_name;
            }

            public void setDogName(String dog_name) {
                this.dog_name = dog_name;
            }

            public String getPbl_video() {
                return pbl_video;
            }

            public void setPbl_video(String pbl_video) {
                this.pbl_video = pbl_video;
            }

            public String getPbl_gif() {
                return pbl_gif;
            }

            public void setPbl_gif(String pbl_gif) {
                this.pbl_gif = pbl_gif;
            }

            public String getIs_expired() {
                return is_expired;
            }

            public void setIs_expired(String is_expired) {
                this.is_expired = is_expired;
            }

            public String getCreated_time() {
                return created_time;
            }

            public void setCreated_time(String created_time) {
                this.created_time = created_time;
            }
        }
    }
}
