package org.example.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UpdateMessageListener {
    @KafkaListener(id = "kafka_test_1", topics = "Test-topic")
    public void consumeMiddlewareProductTopicUpdate(String message)
    {
        String[] pairs = message.replaceAll("[{}]", "").split(",");

        Map<String, String> messageMap = new HashMap<>();

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                messageMap.put(key, value);
            }
        }

        System.out.println(messageMap);
    }
}
