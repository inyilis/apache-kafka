package com.example.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Producer {

    public static void main(String[] args) {

        // Create logger for class
        final Logger logger = LoggerFactory.getLogger(Producer.class);

        // Create properties object for Producer
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the Producer
        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 10; i++) {
            // Create the ProducerRecord
            ProducerRecord<String, String> record = new ProducerRecord<>("inyilis-punya", "data ke " + i, "Oke mantap " + i);

            // Send data - Asynchronous
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        logger.info("\nReceived record metadata: " +
                                "Topic: " + recordMetadata.topic() + ", Partition: " + recordMetadata.partition() +
                                ", Offset: " + recordMetadata.offset() + " @ Timestamp: " + recordMetadata.timestamp() + "\n");
                    } else {
                        logger.error("Error Occurred", e);
                    }
                }
            });
        }

        producer.close();

    }
}
