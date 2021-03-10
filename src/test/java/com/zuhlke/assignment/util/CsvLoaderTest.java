package com.zuhlke.assignment.util;

import com.zuhlke.assignment.model.StoreOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(BlockJUnit4ClassRunner.class)
public class CsvLoaderTest {

    @Test
    public void load(){
        List<StoreOrder> orders = CsvLoader.loadCsv(StoreOrder.class, "sales.csv");

        assertFalse(orders.isEmpty());
    }
}
