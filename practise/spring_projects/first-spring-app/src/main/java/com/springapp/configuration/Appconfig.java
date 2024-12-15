package com.springapp.configuration;

import com.springapp.beans.Phone;
import com.springapp.beans.Sim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.springapp")
@PropertySource("app.properties")
public class Appconfig {

//    @Bean
//    public Sim getSimBean(){
//        return new Sim();
//    }
//
//    @Bean
//    public Phone getPhoneBean(){
//        return new Phone();
//    }

}
