package org.example.services;

import org.example.util.KafkaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@EnableScheduling
@Service
public class MessageProduceScheduler {
    @Autowired
    private KafkaUtil kafkaUtil;
    @Scheduled(cron = "*/2 * * * * *")
    public void produceMessage(){
        kafkaUtil.sendProductUpdateMessage("Test-topic", String.valueOf(Math.random()),
                Map.of(Math.random(), Math.random()).toString());
    }
}
