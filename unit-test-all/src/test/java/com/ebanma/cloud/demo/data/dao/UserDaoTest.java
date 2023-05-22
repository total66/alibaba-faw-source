package com.ebanma.cloud.demo.data.dao;

import com.ebanma.cloud.demo.UnitTestAllApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {UnitTestAllApplication.class})
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void getIdByName(){
        Long userId = 1l;
        String userName = "test";
        Assert.assertEquals("用户标识不一致",userId,userDao.getIdByName(userName));
    }

}