package car.shop.service.kafka;

import car.shop.dto.MessageDto;

public interface KafkaSenderService {

    void sendMessage(String topicName, MessageDto messageDto);
}
