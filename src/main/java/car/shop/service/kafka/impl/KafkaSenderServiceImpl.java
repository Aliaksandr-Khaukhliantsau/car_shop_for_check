package car.shop.service.kafka.impl;

import car.shop.dto.MessageDto;
import car.shop.service.kafka.KafkaSenderService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class KafkaSenderServiceImpl implements KafkaSenderService {
    private final KafkaTemplate<String, MessageDto> kafkaTemplate;

    @Override
    public void sendMessage(String topicName, MessageDto messageDto) {
        kafkaTemplate.send(topicName, messageDto);
    }
}
