package com.zuhlke.assignment;

import com.zuhlke.assignment.repository.StoreOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    StoreOrderRepository storeOrderRepository;

    @Test
    public void findAllOrders_shouldNotBeEmpty() {
        assertFalse(storeOrderRepository.findAll().isEmpty());
    }

    @Test
    public void findAllOrders_validCountShouldBe10() {
        final int validRecordCount = 5;
        assertThat(storeOrderRepository.findAll().size(), equalTo(validRecordCount));
    }
}
