package com.ebanma.cloud.usertestall.controller;

import com.ebanma.cloud.usertestall.domain.common.Result;
import com.ebanma.cloud.usertestall.domain.dto.UserDTO;
import com.ebanma.cloud.usertestall.service.ExcelService;
import com.ebanma.cloud.usertestall.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerUnitTest {

    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private ExcelService excelService;

    //private static final Logger logger = LoggerFactory.getLogger(UserControllerUnitTest.class);

    @Before
    public void setUp() throws Exception {
        userController = new UserController(userService,excelService);
    }

    @Test
    public void save_success() {

        // given
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("username");
        //执行某方法返回1
        when(userService.save(userDTO)).thenReturn(1);

        // when
        Result result = userController.save(userDTO);

        // then
        verify(userService).save(any(UserDTO.class));
        Assert.assertEquals(result.getMessage(),"成功");
        Assert.assertEquals(result.getCode(),"00000");

    }

    @Test
    public void save_failure() {

        // given
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("username");
        //执行某方法返回0
        when(userService.save(userDTO)).thenReturn(0);

        // when
        Result result = userController.save(userDTO);

        // then
        verify(userService).save(any(UserDTO.class));
        Assert.assertEquals(result.getMessage(),"系统执行出错!");
        Assert.assertEquals(result.getCode(),"B0001");

    }

    @Test
    public void update_success() {

        // given
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("username");
        Long id = 1l;
        //执行某方法返回1
        when(userService.update(id,userDTO)).thenReturn(1);

        // when
        Result result = userController.update(id,userDTO);

        // then
        verify(userService).update(any(Long.class),any(UserDTO.class));
        Assert.assertEquals(result.getMessage(),"成功");
        Assert.assertEquals(result.getCode(),"00000");

    }

    @Test
    public void update_failure() {

        // given
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("username");
        Long id = 1l;
        //执行某方法返回1
        when(userService.update(id,userDTO)).thenReturn(0);

        // when
        Result result = userController.update(id,userDTO);

        // then
        verify(userService).update(any(Long.class),any(UserDTO.class));
        Assert.assertEquals(result.getMessage(),"系统执行出错!");
        Assert.assertEquals(result.getCode(),"B0001");

    }


    @Test
    public void delete() {
    }

    @Test
    public void query() {
    }

    @Test
    public void export() {
    }
}