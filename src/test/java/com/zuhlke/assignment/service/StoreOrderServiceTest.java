package com.zuhlke.assignment.service;

import com.zuhlke.assignment.model.StoreOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreOrderServiceTest {

    @Autowired
    StoreOrderService storeOrderService;

    @Before
    public void setup() {
        storeOrderService.deleteAll();
    }

    @Test
    public void loadAll_shouldReturnNotEmpty(){
        List<StoreOrder> orders = storeOrderService.loadOrdersFromCsv("sales.csv");

        assertFalse(orders.isEmpty());
    }

    @Test
    public void loadAll_firstEntryShouldHaveCorrectFieldValues(){
        List<StoreOrder> orders = storeOrderService.loadOrdersFromCsv("sales.csv");

        StoreOrder firstOrder = orders.get(0);

        assertThat("CA-2016-152156", equalTo(firstOrder.getOrderId()));
    }

    @Test
    public void saveEmpty_shouldNotReturnException(){
        storeOrderService.saveOrders(new ArrayList<>());
        assertTrue(storeOrderService.findAll().isEmpty());
    }

    @Test
    public void saveValidOrder_shouldSaveSuccessfully(){
        assertTrue(storeOrderService.findAll().isEmpty());
        storeOrderService.saveOrders(Collections.singletonList(stubOrder()));
        assertThat(storeOrderService.findAll().size(), equalTo(1));
    }

    private StoreOrder stubOrder() {
        StoreOrder order = new StoreOrder();
        order.setOrderId("test_id");
        order.setOrderDate(new Date());
        order.setShipDate(new Date());
        order.setQuantity(1);
        order.setProfit(BigDecimal.ZERO);
        order.setSales(BigDecimal.ZERO);
        order.setProductId("test_product");
        order.setCustomerName("test_customer");
        order.setCategory("test_category");
        order.setCustomerId("test_customer_id");


        return order;
    }


}
