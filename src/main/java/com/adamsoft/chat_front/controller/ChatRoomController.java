package com.adamsoft.chat_front.controller;

import com.adamsoft.chat_front.domain.ChatRoom;
import com.adamsoft.chat_front.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/create")
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomService.createChatRoom(name);
    }

    @GetMapping
    public List<ChatRoom> getAllRooms() {
        return chatRoomService.getAllRooms();
    }

    @GetMapping("/{roomId}")
    public ChatRoom getRoom(@PathVariable Long roomId) {
        return chatRoomService.findById(roomId);
    }

    @PostMapping("/{roomId}/users/{userId}")
    public void addUserToChatRoom(@PathVariable Long roomId, @PathVariable Long userId) {
        chatRoomService.addUserToChatRoom(roomId, userId);
    }
}
