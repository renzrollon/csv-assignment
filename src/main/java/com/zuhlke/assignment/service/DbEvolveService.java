package com.zuhlke.assignment.service;

import com.zuhlke.assignment.model.StoreOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbEvolveService {

    @Autowired
    StoreOrderService storeOrderService;

    @Value("${store.order.csv.file.names}")
    String storeOrderSourceFileNames;
    @Value("${db.evolve.flag}")
    boolean dbEvolveFlag;

    public void initDatabase() {
        if(!dbEvolveFlag) {
            return;
        }
        String[] sourceFiles = storeOrderSourceFileNames.split(",");

        for(String file : sourceFiles) {
            List<StoreOrder> orders = storeOrderService.loadOrdersFromCsv(file);
            storeOrderService.saveOrders(orders);
        }
    }
}
