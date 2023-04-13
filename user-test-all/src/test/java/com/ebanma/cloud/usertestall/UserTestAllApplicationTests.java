package com.ebanma.cloud.usertestall;

import com.ebanma.cloud.SimpleBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableImRegisterServer
class UserTestAllApplicationTests {

    @Test
    void contextLoads() {
    }

    // 测试自定义starter
    //@Autowired
    private SimpleBean simpleBean;

    @Test
    public void myStarterTest(){
        System.out.println("Test");
        //System.out.println(simpleBean);
    }

}
