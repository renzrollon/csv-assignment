package com.zuhlke.assignment.service;

import com.zuhlke.assignment.model.StoreOrder;
import com.zuhlke.assignment.repository.StoreOrderRepository;
import com.zuhlke.assignment.util.CsvLoader;
import com.zuhlke.assignment.util.CsvSchemaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreOrderService {

    private final static Logger LOGGER = LoggerFactory.getLogger(StoreOrderService.class);

    @Autowired
    StoreOrderRepository storeOrderRepository;
    @Autowired
    CsvSchemaBuilder csvSchemaBuilder;

    public List<StoreOrder> loadOrdersFromCsv(String fileName) {
        return CsvLoader.loadCsv(
                StoreOrder.class, fileName, csvSchemaBuilder.buildStoreOrderSchema());
    }

    public void saveOrders(List<StoreOrder> orders) {
        if(orders==null) {
            return;
        }
        int saveCounter = 0;
        for(StoreOrder order : orders) {
            try {
                storeOrderRepository.save(order);
                saveCounter++;
            } catch (Exception e) {
                LOGGER.error(String.join(" ","Error saving order:", order.getOrderId()), e.getMessage());
            }
        }
        storeOrderRepository.flush();
        LOGGER.info(String.join(" ", "Saved orders:", String.valueOf(saveCounter)));
    }

    public List<StoreOrder> findAll() {
        return storeOrderRepository.findAll();
    }

    public void deleteAll() {
        storeOrderRepository.deleteAll();
    }
}
