/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chat.data;

public class Message {
    public enum MessageType {
        CONNECT,    // Khi user mới kết nối
        TEXT,       // Tin nhắn chat thường
        DISCONNECT  // Khi user thoát
    }

    private MessageType type;
    private String sender;
    private String content;

    public Message(MessageType type, String sender, String content) {
        this.type = type;
        this.sender = sender;
        this.content = content;
    }

    public MessageType getType() { return type; }
    public String getSender() { return sender; }
    public String getContent() { return content; }
}
