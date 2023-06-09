package it.unibz.archlab.digidojo.engagement.application.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Producer {

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void generate(String message) {
        String jsonMessage = messageToJson(message);
        kafkaTemplate.send("messages", jsonMessage);
    }

    private String messageToJson(String message) {
        return "{\"message\":\""+message+"\"}";
    }
}