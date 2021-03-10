package com.zuhlke.assignment.util;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CsvSchemaBuilder {

    @Value("${store.order.csv.headers}")
    String storeOrderHeaders;

    public CsvSchema buildStoreOrderSchema() {
        String[] headerNames = storeOrderHeaders.split(",");

        CsvSchema.Builder schemaBuilder = CsvSchema.builder();

        for(String headerName : headerNames) {
            schemaBuilder.addColumn(headerName);
        }
        return schemaBuilder.build().withHeader();
    }
}
