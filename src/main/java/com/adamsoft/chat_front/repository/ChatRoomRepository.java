package com.adamsoft.chat_front.repository;




import com.adamsoft.chat_front.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
