package com.ebanma.cloud.usertestall.controller;

import com.ebanma.cloud.usertestall.domain.common.ErrorCode;
import com.ebanma.cloud.usertestall.service.ExcelService;
import com.ebanma.cloud.usertestall.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private ExcelService excelService;

    /**
     *
     *
     */

    @Test
    public void save_error() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = post("/api/user")
                .contentType("application/json;charset=utf-8")
                .content("{\n"
                        + "    \"username\":\"username\",\n"
                        + "    \"serialVersionUID\":6728497964686236776,\n"
                        + "    \"password\":\"password\",\n"
                        + "    \"email\":\"980770556@qq.com\",\n"
                        + "    \"age\":50,\n"
                        + "    \"phone\":\"13019132713\",\n"
                        + "    \"version\":1\n"
                        + "}");

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("系统执行出错!"));

    }

    @Test
    public void update() {
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