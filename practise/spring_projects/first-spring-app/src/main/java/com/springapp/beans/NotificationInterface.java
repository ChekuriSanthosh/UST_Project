package com.springapp.beans;


public interface NotificationInterface {
    void sendemail(String email, String msg);

    void sendSMS(String PhnNo, String msg);
}
