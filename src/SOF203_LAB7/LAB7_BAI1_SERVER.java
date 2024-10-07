/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_LAB7;

import java.io.*;
import java.net.*;

/**
 *
 * @author THANHDAT
 */
public class LAB7_BAI1_SERVER {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Server đang kết nối...");
            Socket socket = ss.accept();
            System.out.println("Server kết nối thành công!");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (true) {
                double num1 = dis.readDouble();
                double num2 = dis.readDouble();
                System.out.println("2 số nhận được từ client là: " + num1 + ", " + num2);
                double sum = num1 + num2;
                dos.writeDouble(sum);
                dos.flush();
                System.out.println("Tổng của 2 số: " + sum);
            }

        } catch (Exception e) {
        }

    }

}
