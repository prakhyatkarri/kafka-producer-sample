package com.kafka.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("/publish")
public class PublishController {

    private int id;
    @Autowired
    private Producer producer;

    @GetMapping
    String publishMessage() {
        CountDownLatch latch = new CountDownLatch(1);
        this.producer.send("Sending message id::"+this.id++);
        System.out.println("Count::"+latch.getCount());
        latch.countDown();
        return "Success";
    }
}
