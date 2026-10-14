/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chat.utils;

import java.io.*;

public class FileTransferHandler {
    private static final int BUFFER_SIZE = 4096; // Gửi mỗi đợt 4KB

    // Hàm đọc file từ đĩa và ghi ra OutputStream của Socket
    public static void sendFile(File file, OutputStream os) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        
        while ((bytesRead = fis.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.flush();
        fis.close();
    }

    // Hàm nhận dữ liệu từ InputStream của Socket và ghi thành file lưu trên đĩa
    public static void receiveFile(String savePath, InputStream is, long fileSize) throws IOException {
        FileOutputStream fos = new FileOutputStream(savePath);
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        long totalRead = 0;

        while (totalRead < fileSize && (bytesRead = is.read(buffer, 0, (int) Math.min(buffer.length, fileSize - totalRead))) != -1) {
            fos.write(buffer, 0, bytesRead);
            totalRead += bytesRead;
        }
        fos.flush();
        fos.close();
    }
}
