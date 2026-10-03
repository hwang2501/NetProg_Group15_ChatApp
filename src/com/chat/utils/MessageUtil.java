/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chat.utils;

import com.chat.data.Message;
import com.chat.data.Message.MessageType;

public class MessageUtil {
    private static final String DELIMITER = "||";

    // Đóng gói tin nhắn thành chuỗi gửi qua Socket
    public static String formatMessage(Message msg) {
        return msg.getType() + DELIMITER + msg.getSender() + DELIMITER + msg.getContent();
    }

    // Giải mã chuỗi nhận từ Socket thành đối tượng Message
    public static Message parseMessage(String rawData) {
        if (rawData == null || rawData.trim().isEmpty()) return null;
        String[] parts = rawData.split("\\|\\|", 3);
        if (parts.length < 3) return null;

        try {
            MessageType type = MessageType.valueOf(parts[0]);
            return new Message(type, parts[1], parts[2]);
        } catch (Exception e) {
            return null;
        }
    }

    // Hàm main dùng để test chạy thử độc lập
    public static void main(String[] args) {
        System.out.println("=== BAT DAU TEST MODULE DATA & UTILS ===");

        // 1. Test đóng gói tin nhắn (Format)
        Message originalMsg = new Message(MessageType.TEXT, "Duong", "Chao ca nhom!");
        String formattedStr = MessageUtil.formatMessage(originalMsg);
        System.out.println("[1] Chuoi sau khi dong goi: " + formattedStr);

        // 2. Test giải mã chuỗi (Parse)
        Message parsedMsg = MessageUtil.parseMessage(formattedStr);
        if (parsedMsg != null) {
            System.out.println("[2] Giai ma thanh cong:");
            System.out.println("   - Loai tin nhan: " + parsedMsg.getType());
            System.out.println("   - Nguoi gui: " + parsedMsg.getSender());
            System.out.println("   - Noi dung: " + parsedMsg.getContent());
        } else {
            System.err.println("[!] Giai ma THAT BAI!");
        }
    }
}