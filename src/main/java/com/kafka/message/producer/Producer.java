package com.kafka.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Value("${cloudkarafka.topic:}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> template;

    boolean send(String message) {
        this.template.send(topic, message);
        return true;
    }

}
