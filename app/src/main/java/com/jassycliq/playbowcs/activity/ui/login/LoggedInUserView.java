package com.jassycliq.playbowcs.activity.ui.login;

import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;

/**
 * Class exposing authenticated user details to the UI.
 */
public class LoggedInUserView {
    private static LoggedInUser.DataBean dataBean;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(LoggedInUser.DataBean dataBean) {
        LoggedInUserView.dataBean = dataBean;
    }

    public static LoggedInUser.DataBean getDatabean() {
        return dataBean;
    }
}
