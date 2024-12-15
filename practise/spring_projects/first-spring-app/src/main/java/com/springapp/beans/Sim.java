package com.springapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sim {

    @Autowired
    private Network network;

    @Value("${sim.providerName}")
    private String providerName;

    public void call(String phnNo){
        if (network.isAvailable())
            System.out.println("Calling "+phnNo+ " with "+providerName);
        else
            System.out.println("Couldn't make a call due to network issues");
    }

    public void sendText(String phnNo, String message){
        if (network.isAvailable())
            System.out.println("""
                                Sent
                                [
                                 %s
                                ]
                                to %s
                                with %s
                            """.formatted(message,phnNo , providerName));

        else
            System.out.println("Couldn't send the text due to network issues");


    }

}