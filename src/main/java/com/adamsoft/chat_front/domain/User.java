package com.adamsoft.chat_front.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<ChatRoom> chatRooms;

    // Getters and setters
}
