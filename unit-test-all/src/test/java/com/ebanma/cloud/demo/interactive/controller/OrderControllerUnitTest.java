package com.ebanma.cloud.demo.interactive.controller;

import com.ebanma.cloud.demo.domain.entity.Order;
import com.ebanma.cloud.demo.interactive.request.OrderCreateRequest;
import com.ebanma.cloud.demo.interactive.validator.OrderRequestValidator;
import com.ebanma.cloud.demo.service.OrderApplicationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerUnitTest {

    //被测对象
    private OrderController controller;

    //被测对象的依赖
    @Mock
    private OrderApplicationService orderApplicationService;

    @Mock
    private OrderRequestValidator orderRequestValidator;


    @Before
    public void setUp() throws Exception {
        controller = new OrderController(orderApplicationService, orderRequestValidator);
    }


    @Test
    public void should_invoke_order_service_to_create_order_given_validation_pass(){
        //1、given
        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        doNothing().when(orderRequestValidator).validateCreate(orderCreateRequest);

        //2、when
        controller.create(orderCreateRequest);

        //3、then
        verify(orderApplicationService).create(any(Order.class));
    }

}
