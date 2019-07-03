package com.dataspark.kafkalocal;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class AppConsumer {

    public static void main(String[] args) {

        runConsumer();
    }

    static void runConsumer() {
        Consumer<byte[], String> consumer = KafkaUtils.createConsumer();
        int noMessageFound = 0;
        while (true) {
            ConsumerRecords<byte[], String> consumerRecords = consumer.poll(1000);

            //print each record.
            consumerRecords.forEach(record -> {
                System.out.println("Record Key " + record.key());
                System.out.println("Record value " + record.value());
                System.out.println("Record partition " + record.partition());
                System.out.println("Record offset " + record.offset());
            });
            // commits the offset of record to broker.
            consumer.commitAsync();
        }
    }

}
