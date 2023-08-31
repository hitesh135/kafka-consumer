package com.kafkaconsumer.consumer;

import com.kafkaconsumer.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaMessageListener {

    @Autowired
    private SimpMessagingTemplate webSocket;

    private int cnt = 1;

    @KafkaListener(topics = "OPL-KAFKA-6", groupId = "OPL-KAFKA-CONS")
    public void consume1(String message) {
        System.out.println("CONS1 message from producer = " + message);
    }
    @KafkaListener(topics = "OPL-KAFKA-6", groupId = "OPL-KAFKA-CONS")
    public void consume2(String message) {
        System.out.println("CONS2 message from producer = " + message);
    }
    @KafkaListener(topics = "OPL-KAFKA-6", groupId = "OPL-KAFKA-CONS")
    public void consume3(String message) {
        System.out.println("CONS3 message from producer = " + message);
    }
    @KafkaListener(topics = "OPL-KAFKA-6", groupId = "OPL-KAFKA-CONS")
    public void consume4(String message) {
        System.out.println("CONS4 message from producer = " + message);
    }

    @KafkaListener(topics = "OPL-CUSTOMER", groupId = "OPL-CUSTOMER-CONS")
    public void consumeCustomer(String customer) {
        System.out.println(cnt + " :: CUSTOMER!!@@ message from producer = " + customer.toString());
        cnt++;
        Map<String, Object> map = new HashMap<>();
        map.put("ac_tk", 475848749898948l);
        map.put("rf_tk", 878454878787548l);
        map.put("userId", 67882);
        webSocket.convertAndSend("/topic/messages", customer, map);
        webSocket.convertAndSendToUser("67882","/specific", customer, map);
    }

}
