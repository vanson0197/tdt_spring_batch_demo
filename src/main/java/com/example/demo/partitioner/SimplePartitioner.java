package com.example.demo.partitioner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplePartitioner implements Partitioner {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    List<String> fileNameList = Arrays.asList("persons.csv", "persons.excel","persons.pdf");



    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String, ExecutionContext> partitionData = new HashMap<String, ExecutionContext>();


        for (int i = 0; i < gridSize; i++) {
            ExecutionContext executionContext = new ExecutionContext();
            logger.info("Starting : Thread" + i);
            logger.info("File Name: " + fileNameList.get(i));

            // give fileName for ExecutionContext
            executionContext.putString("filename", fileNameList.get(i));
            // give a thread name for ExecutionContext
            executionContext.putString("name", "Thread" + i);

            partitionData.put("partition: " + i, executionContext);
        }

        return partitionData;
    }
}
