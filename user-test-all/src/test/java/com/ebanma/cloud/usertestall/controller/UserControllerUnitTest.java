package com.ebanma.cloud.usertestall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ebanma.cloud.usertestall.domain.common.PageQuery;
import com.ebanma.cloud.usertestall.domain.common.PageResult;
import com.ebanma.cloud.usertestall.domain.common.Result;
import com.ebanma.cloud.usertestall.domain.dto.UserDTO;
import com.ebanma.cloud.usertestall.domain.dto.UserQueryDTO;
import com.ebanma.cloud.usertestall.service.ExcelService;
import com.ebanma.cloud.usertestall.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerUnitTest {

    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private ExcelService excelService;

    @Captor
    private ArgumentCaptor<PageQuery<UserQueryDTO>> argCaptor;

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
    public void delete_success() {

        // given
        Long id = 1l;
        //执行某方法返回1
        when(userService.delete(id)).thenReturn(1);

        // when
        Result result = userController.delete(id);

        // then
        verify(userService).delete(any(Long.class));
        Assert.assertEquals(result.getMessage(),"成功");
        Assert.assertEquals(result.getCode(),"00000");

    }

    @Test
    public void delete_failure() {

        // given
        Long id = 1l;
        //执行某方法返回1
        when(userService.delete(id)).thenReturn(0);

        // when
        Result result = userController.delete(id);

        // then
        verify(userService).delete(any(Long.class));
        Assert.assertEquals(result.getMessage(),"系统执行出错!");
        Assert.assertEquals(result.getCode(),"B0001");

    }


    @Test
    public void query() {

        //given
        PageResult<List<UserDTO>> listPageResult = new PageResult<>();
        List<UserDTO> userDTOS = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("lilei");
        userDTO.setPassword("12345");
        userDTO.setEmail("7899@qq.com");
        userDTO.setAge(11);
        userDTO.setPhone("12433453212");
        userDTOS.add(userDTO);
        listPageResult.setData(userDTOS);

        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setUsername("lilei");

        when(userService.query(Mockito.any(PageQuery.class))).thenReturn(listPageResult);

        //when
        Result<PageResult> query = userController.query(1, 10, new UserQueryDTO());

        //then
        verify(userService).query(any(PageQuery.class));
        Assert.assertEquals(query.getMessage(),"成功");
        Assert.assertEquals(query.getCode(),"00000");

    }

    @Test
    public void export() {

        // given
        String fileName = "fileName";
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        doNothing().when(excelService).export(fileName,userQueryDTO);

        // when
        Result<Boolean> export = userController.export(fileName, userQueryDTO);

        // then
        verify(excelService).export(any(String.class),any(UserQueryDTO.class));
        Assert.assertEquals(export.getMessage(),"成功");

    }
}