package com.springapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Notification implements NotificationInterface {

    @Autowired
    private Network network;

    @Value("${Notification.message}")
    private String message;
    @Value("${Notification.PhnNo}")
    private String PhnNo;
    @Value("${Notification.email}")
    private String email;

    public void sendemail(String email,String msg){
        if(network.isAvailable()){
            System.out.println("""
                The given mail message is sent to %s:
                %s
                """.formatted(email,msg));
        }else{
            System.out.println("Network is not there for sendind email");
        }
    }

    public void sendSMS(String phnNo,String msg){
        if(network.isAvailable()){
            System.out.println("""
                The SMS message is sent to Number %s:
                %s
                """.formatted(phnNo,msg));
        }else{
            System.out.println("Network is not there for sending sms");
        }
    }
}
