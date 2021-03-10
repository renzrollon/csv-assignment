package com.zuhlke.assignment.repository;

import com.zuhlke.assignment.model.StoreOrder;
import com.zuhlke.assignment.service.DbEvolveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StoreOrderRepositoryTest {

    @Autowired
    StoreOrderRepository storeOrderRepository;

    @MockBean
    CommandLineRunner dbEvolver;

    @Test
    public void findAll_shouldReturnNone() {
        Collection<StoreOrder> orders = storeOrderRepository.findAll();

        assertThat(orders.size()).isEqualTo(0);
    }

}
