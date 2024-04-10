package org.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaUtil.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTopic;

    public void sendProductUpdateMessage(String topic, String key, String message) {
        try {
            LOGGER.debug("Publishing to Kafka topic {} and key {} and  message {} ", topic, key, message);
            kafkaTopic.send(topic, key, message).get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("Unable to publish to kafka ", e);
            throw new RuntimeException(e);
        }
    }
}
