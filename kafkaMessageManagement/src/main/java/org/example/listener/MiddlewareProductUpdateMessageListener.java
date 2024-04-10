package org.example.listener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MiddlewareProductUpdateMessageListener {
    @KafkaListener(id = "kafka_test_1", topics = "Test-topic")
    public void consumeMiddlewareProductTopicUpdate(String message)
    {
        Map<String, String> messageMap = new ObjectMapper().convertValue(message, new TypeReference<>() {});
        System.out.println(messageMap);
    }
}
