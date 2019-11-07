package com.jassycliq.playbowcs.model;

import java.util.List;

public class LoginModel {


    /**
     * success : 1
     * message : Successfully Login.
     * data : {"user_id":9,"firstname":"n95P6cToEwbGM42UJswI4Q==","lastname":"v1u0weyBGoKndoBxbhDCIg==","email":"n7qQEQlRJeXsjoQ155EvRug9yd66gmjvgSEdlyNWk0o=","created_at":"2017-04-18 10:47:22","status":1,"auth_token":"4eaa90e321016174cab27b68694b1bec","notification_status":0,"ewallet_amount":"iQjZGiRW9dk9wYsxZQqxHA==","dog_profile":[{"id":"1","user_id":"9","category_id":"1","breed_id":"1","name":"Rokey","image":"http://techinnate.com/playbow/common/web/img/no_image.png","status":"1","created_at":"2017-04-10 05:20:10","updated_at":"2017-04-10 05:20:10"},{"id":"2","user_id":"9","category_id":"1","breed_id":"1","name":"Tom","image":"http://techinnate.com/playbow/common/web/img/no_image.png","status":"1","created_at":"2017-04-10 05:20:10","updated_at":"2017-04-10 05:20:10"}]}
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
         * user_id : 9
         * firstname : n95P6cToEwbGM42UJswI4Q==
         * lastname : v1u0weyBGoKndoBxbhDCIg==
         * email : n7qQEQlRJeXsjoQ155EvRug9yd66gmjvgSEdlyNWk0o=
         * created_at : 2017-04-18 10:47:22
         * status : 1
         * auth_token : 4eaa90e321016174cab27b68694b1bec
         * notification_status : 0
         * ewallet_amount : iQjZGiRW9dk9wYsxZQqxHA==
         * dog_profile : [{"id":"1","user_id":"9","category_id":"1","breed_id":"1","name":"Rokey","image":"http://techinnate.com/playbow/common/web/img/no_image.png","status":"1","created_at":"2017-04-10 05:20:10","updated_at":"2017-04-10 05:20:10"},{"id":"2","user_id":"9","category_id":"1","breed_id":"1","name":"Tom","image":"http://techinnate.com/playbow/common/web/img/no_image.png","status":"1","created_at":"2017-04-10 05:20:10","updated_at":"2017-04-10 05:20:10"}]
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
            return this.auth_token;
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

        public List<DogProfileBean> getDog_profile() {
            return dog_profile;
        }

        public void setDog_profile(List<DogProfileBean> dog_profile) {
            this.dog_profile = dog_profile;
        }

        public static class DogProfileBean {
            /**
             * id : 1
             * user_id : 9
             * category_id : 1
             * breed_id : 1
             * name : Rokey
             * image : http://techinnate.com/playbow/common/web/img/no_image.png
             * status : 1
             * created_at : 2017-04-10 05:20:10
             * updated_at : 2017-04-10 05:20:10
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