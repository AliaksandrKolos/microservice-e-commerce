package com.kolos.notofocationservice.data.repository;

import com.kolos.notofocationservice.data.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
