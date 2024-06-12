package com.adamsoft.chat_front.repository;


import com.adamsoft.chat_front.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
