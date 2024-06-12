package com.adamsoft.chat_front.controller;

import com.adamsoft.chat_front.domain.Message;
import com.adamsoft.chat_front.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/rooms/{roomId}/message")
    public void sendMessage(@DestinationVariable String roomId, Message message) {
        // 메시지를 데이터베이스에 저장
        messageRepository.save(message);
        // 메시지를 데이터베이스에 저장

        // 메시지를 클라이언트에 전송
        messagingTemplate.convertAndSend("/topic/rooms/" + roomId, message.getContent());
    }
}
