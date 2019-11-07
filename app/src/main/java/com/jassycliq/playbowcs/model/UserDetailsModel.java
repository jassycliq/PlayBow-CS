package com.jassycliq.playbowcs.model;

import java.util.List;

public class UserDetailsModel {
    /**
     * success : 1
     * message : User profile.
     * data : {"user_id":50,"firstname":"n95P6cToEwbGM42UJswI4Q==","lastname":"soiUWmXFMXvMmM8iYGk1NA==","email":"EEOdunzRb7/ZEM4oo0VUaA==","created_at":"2017-12-08 10:47:03","status":1,"auth_token":"7257e9913cfa2b4c33906b23f1d8154c","notification_status":1,"ewallet_amount":"a16hYUIIgiBUdfXD4DlecQ==","live_session":{"is_live":"0","session_duration":"0"},"dog_profile":[{"id":"74","user_id":"50","category_id":"1","breed_id":"1","name":"s1","image":"http://playbowapp.com/backend/uploads/no_dog.jpg","status":"1","created_at":"2017-11-30 04:58:50","updated_at":"2017-12-05 01:55:43"},{"id":"75","user_id":"50","category_id":"1","breed_id":"1","name":"s2","image":"http://playbowapp.com/backend/uploads/no_dog.jpg","status":"1","created_at":"2017-11-30 04:58:50","updated_at":"2017-12-05 01:55:43"},{"id":"76","user_id":"50","category_id":"1","breed_id":"1","name":"s3","image":"http://playbowapp.com/backend/uploads/no_dog.jpg","status":"1","created_at":"2017-11-30 04:58:50","updated_at":"2017-12-05 01:55:43"}]}
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
         * firstname : n95P6cToEwbGM42UJswI4Q==
         * lastname : soiUWmXFMXvMmM8iYGk1NA==
         * email : EEOdunzRb7/ZEM4oo0VUaA==
         * created_at : 2017-12-08 10:47:03
         * status : 1
         * auth_token : 7257e9913cfa2b4c33906b23f1d8154c
         * notification_status : 1
         * ewallet_amount : a16hYUIIgiBUdfXD4DlecQ==
         * live_session : {"is_live":"0","session_duration":"0"}
         * dog_profile : [{"id":"74","user_id":"50","category_id":"1","breed_id":"1","name":"s1","image":"http://playbowapp.com/backend/uploads/no_dog.jpg","status":"1","created_at":"2017-11-30 04:58:50","updated_at":"2017-12-05 01:55:43"},{"id":"75","user_id":"50","category_id":"1","breed_id":"1","name":"s2","image":"http://playbowapp.com/backend/uploads/no_dog.jpg","status":"1","created_at":"2017-11-30 04:58:50","updated_at":"2017-12-05 01:55:43"},{"id":"76","user_id":"50","category_id":"1","breed_id":"1","name":"s3","image":"http://playbowapp.com/backend/uploads/no_dog.jpg","status":"1","created_at":"2017-11-30 04:58:50","updated_at":"2017-12-05 01:55:43"}]
         */

        private int user_id;
        private String firstname;
        private String lastname;
        private String email;
        private String created_at;
        private int status;
        private String auth_token;
        private int notification_status;
        private String ewallet_amount;
        private LiveSessionBean live_session;
        //        private String live_session;
        private List<DogProfileBean> dog_profile;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAuth_token() {
            return auth_token;
        }

        public void setAuth_token(String auth_token) {
            this.auth_token = auth_token;
        }

        public int getNotification_status() {
            return notification_status;
        }

        public void setNotification_status(int notification_status) {
            this.notification_status = notification_status;
        }

        public String getEwallet_amount() {
            return ewallet_amount;
        }

        public void setEwallet_amount(String ewallet_amount) {
            this.ewallet_amount = ewallet_amount;
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

        public static class DogProfileBean {
            /**
             * id : 74
             * user_id : 50
             * category_id : 1
             * breed_id : 1
             * name : s1
             * image : http://playbowapp.com/backend/uploads/no_dog.jpg
             * status : 1
             * created_at : 2017-11-30 04:58:50
             * updated_at : 2017-12-05 01:55:43
             */

            private String id;
            private String user_id;
            private String category_id;
            private String breed_id;
            private String name;
            private String image;
            private String status;
            private String created_at;
            private String updated_at;

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

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getBreed_id() {
                return breed_id;
            }

            public void setBreed_id(String breed_id) {
                this.breed_id = breed_id;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
