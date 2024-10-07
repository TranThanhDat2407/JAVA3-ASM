/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_LAB7;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author THANHDAT
 */
public class LAB7_BAI1_CLIENT {

    public static void main(String[] args) {
        try {
            System.out.println("Client đang kết nối...");
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Client kết nối thành công!");
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println("Số Thứ 1: ");
                dos.writeDouble(new Scanner(System.in).nextDouble());
                dos.flush();
                System.out.println("Số Thứ 2: ");
                dos.writeDouble(new Scanner(System.in).nextDouble());
                dos.flush();
                System.out.println("Tổng 2 số là: " + dis.readDouble());
                System.out.println("Tiếp tục? (Y/N)");
                String ans = new Scanner(System.in).nextLine();
                if (ans.equalsIgnoreCase("n")) {
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
}
