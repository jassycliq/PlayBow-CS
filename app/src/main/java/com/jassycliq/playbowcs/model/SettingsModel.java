package com.jassycliq.playbowcs.model;

public class SettingsModel {

    private int success;
    private DataBean data;

    public int getSuccess() {
        return success;
    }
    public void setSuccess(int success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }
    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String latest_version;
        private String enable_membership_feature;
        private String enable_sleepover_feature;
        private String enable_playbowlive_feature;

        public String getLatestVersion() {
            return latest_version;
        }
        public void setLatestVersion(String version) {
            this.latest_version = version;
        }

        public String getEnableMembershipFeature() {
            return enable_membership_feature;
        }
        public void setEnableMembershipFeature(String enable) {
            this.enable_membership_feature = enable;
        }

        public String getEnableSleepoverFeature() {
            return enable_sleepover_feature;
        }
        public void setEnableSleepoverFeature(String enable) {
            this.enable_sleepover_feature = enable;
        }

        public String getEnablePlaybowLiveFeature() {
            return enable_playbowlive_feature;
        }
        public void setEnablePlaybowLiveFeature(String enable) {
            this.enable_playbowlive_feature = enable;
        }
    }


}
