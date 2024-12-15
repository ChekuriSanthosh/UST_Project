package com.springapp;

import com.springapp.beans.Phone;
import com.springapp.configuration.Appconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(Appconfig.class);
        Phone phone=context.getBean(Phone.class);
        String phnNo="7012888822";
        phone.call(phnNo);
        phone.sendText(phnNo,"Hello....When are you reaching?");
        phone.sendmail("santhoshchekuri@gmail.com","hi all this is my mail");
    }
}
