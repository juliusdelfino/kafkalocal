package com.dataspark.kafkalocal;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class AppProducer {

    public static void main(String[] args) {
        runProducer();
    }

    static void runProducer() {
        Producer<byte[], String> producer = KafkaUtils.createProducer();
        for (int index = 0; index < 100; index++) {
            ProducerRecord<byte[], String> record = new ProducerRecord<byte[], String>("test",
                    "This is record " + index);
            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            }
            catch (ExecutionException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
            catch (InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
        }
    }
}
