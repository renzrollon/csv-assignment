package com.zuhlke.assignment.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.Collections;
import java.util.List;

public final class CsvLoader {

    private final static Logger LOGGER = LoggerFactory.getLogger(CsvLoader.class);

    public static <T> List<T> loadCsv(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            LOGGER.error("Error reading file " + fileName, e);
            return Collections.emptyList();
        }
    }

    public static <T> List<T> loadCsv(Class<T> type, String fileName, CsvSchema schema) {
        try {
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues = mapper.readerFor(type).with(schema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            LOGGER.error("Error reading file " + fileName, e);
            return Collections.emptyList();
        }
    }
}
