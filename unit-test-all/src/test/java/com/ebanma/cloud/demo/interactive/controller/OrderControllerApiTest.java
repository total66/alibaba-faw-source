package com.ebanma.cloud.demo.interactive.controller;

import com.ebanma.cloud.demo.interactive.validator.OrderRequestValidator;
import com.ebanma.cloud.demo.service.OrderApplicationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderApplicationService orderApplicationService;

    @MockBean
    private OrderRequestValidator orderRequestValidator;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void should_return_success_result_when_create_order_given_order_service_create() throws Exception{

    }

}