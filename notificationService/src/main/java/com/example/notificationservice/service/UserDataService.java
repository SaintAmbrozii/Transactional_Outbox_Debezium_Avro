package com.example.notificationservice.service;


import com.example.notificationservice.domain.UserData;
import com.example.notificationservice.repo.UserDataRepo;
import contacts_outbox.UserDataEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserDataService {

    private final UserDataRepo userDataRepo;

    public UserDataService(UserDataRepo userDataRepo) {
        this.userDataRepo = userDataRepo;
    }

    public List<UserData> findAll() {
        return userDataRepo.findAll();
    }

    @KafkaListener(topics = "v1.public.contacts")
    public void KafkaListener(UserDataEvent event, @Header(KafkaHeaders.RECEIVED_KEY) String key,
                              @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                              @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                              Acknowledgment acknowledgment) {

        log.info("Consuming message from Kafka: {}. Key: {}. Partition: {}. Topic: {}",
                event, key, partition, topic);

      UserData newData =  UserData.builder().name(event.getName().toString())
                .phone(event.getPhone().toString()).build();

      userDataRepo.save(newData);

      acknowledgment.acknowledge();



    }


}
