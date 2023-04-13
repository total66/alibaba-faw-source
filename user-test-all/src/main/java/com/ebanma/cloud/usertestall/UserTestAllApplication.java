package com.ebanma.cloud.usertestall;

import com.ebanma.cloud.annotation.EnableRegisterServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 98077
 * @date 2023/03/22
 */
@SpringBootApplication
@ServletComponentScan
//@EnableRegisterServer
public class UserTestAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTestAllApplication.class, args);
    }

}
