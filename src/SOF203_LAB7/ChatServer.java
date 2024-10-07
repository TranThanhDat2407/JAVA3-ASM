/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_LAB7;

import java.net.*;
import java.io.*;
import javax.swing.JTextPane;

/**
 *
 * @author THANHDAT
 */
public class ChatServer {

    private Socket socket;
    private JTextPane txtChatPanel;
    private PrintWriter out;
    private BufferedReader in;

    public ChatServer() {
    }

    public ChatServer(Socket socket, JTextPane txt, PrintWriter out, BufferedReader in) {
        this.socket = socket;
        this.txtChatPanel = txt;
        this.out = out;
        this.in = in;
    }

    public ChatServer(Socket socket, JTextPane txt) throws IOException {
        this.socket = socket;
        this.txtChatPanel = txt;

        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        receive();
    }

    private void receive() {
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        String line = in.readLine();
                        if (line != null) {
                            txtChatPanel.setText(txtChatPanel.getText() + "\n" + line);
                        }
                    } catch (Exception e) {
                    }
                }
            }

        };
        t.start();
    }

    public void send(String meg) {
        String current = txtChatPanel.getText();
        txtChatPanel.setText(current + "\nSent: " + meg);
        out.println(meg);
        out.flush();
    }

    public void close() {
        try {
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
        }
    }
}
