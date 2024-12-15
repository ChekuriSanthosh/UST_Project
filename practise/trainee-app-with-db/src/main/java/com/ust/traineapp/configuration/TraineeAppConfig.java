package com.ust.traineapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("com.ust.traineapp")
@PropertySource("app.properties")
public class TraineeAppConfig {

    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;


    @Bean
    public Connection createConnection() throws SQLException {
        Connection connection= DriverManager.getConnection(url,username,password);
        return connection;
    }


//    @Bean
//    @Lazy
//    public Connection createConnectionWithmySQL() throws SQLException {
//        Connection connection= DriverManager.getConnection(url,username,password);
//        return connection;
//    }
}

