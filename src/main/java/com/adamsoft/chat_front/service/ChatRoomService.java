package com.adamsoft.chat_front.service;

import com.adamsoft.chat_front.domain.ChatRoom;
import com.adamsoft.chat_front.domain.User;
import com.adamsoft.chat_front.repository.ChatRoomRepository;
import com.adamsoft.chat_front.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private UserRepository userRepository;

    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        chatRoom.setUsers(new HashSet<>());
        return chatRoomRepository.save(chatRoom);
    }

    public List<ChatRoom> getAllRooms() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom findById(Long id) {
        return chatRoomRepository.findById(id).orElse(null);
    }

    public void addUserToChatRoom(Long chatRoomId, Long userId) {
        ChatRoom chatRoom = findById(chatRoomId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        chatRoom.getUsers().add(user);
        chatRoomRepository.save(chatRoom);
    }
}
