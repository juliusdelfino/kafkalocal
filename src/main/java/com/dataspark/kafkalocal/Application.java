package com.dataspark.kafkalocal;

import java.util.Properties;

public class Application {

    static KafkaLocal kafka;

    public static void main(String[] args) {

        try {
            Properties kafkaProperties = new Properties();
            Properties zkProperties = new Properties();

            //load properties
            kafkaProperties.load(Class.class.getResourceAsStream("/kafkalocal.properties"));
            zkProperties.load(Class.class.getResourceAsStream("/zklocal.properties"));

            //start kafka
            kafka = new KafkaLocal(kafkaProperties, zkProperties);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
