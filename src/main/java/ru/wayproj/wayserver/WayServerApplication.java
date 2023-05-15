package ru.wayproj.wayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class WayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WayServerApplication.class, args);
    }

}
