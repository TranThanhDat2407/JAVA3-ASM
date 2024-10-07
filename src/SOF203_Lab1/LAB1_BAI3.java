/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab1;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author THANHDAT
 */
public class LAB1_BAI3 {

    JFrame fMain;
    JTextField txtUsername;
    JPasswordField txtPassword, txtConfirm;
    JButton btnSignup, btnCancel;

    public LAB1_BAI3() {
        initComp();
    }

    public void initComp() {
        fMain = new JFrame("bài 3");
        fMain.setSize(400, 300);
        fMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fMain.setLocationRelativeTo(null);

        fMain.setLayout(new GridLayout(4, 1));
        //User
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(1, 2));
        JLabel lblUser = new JLabel("Username");
        txtUsername = new JTextField(20);
        userPanel.add(lblUser);
        userPanel.add(txtUsername);
        //password
        JPanel passPanel = new JPanel();
        passPanel.setLayout(new GridLayout(1, 2));
        JLabel lblPass = new JLabel("Password");
        txtPassword = new JPasswordField(20);
        passPanel.add(lblPass);
        passPanel.add(txtPassword);
        //Confirm
        JPanel conFirmPanel = new JPanel();
        conFirmPanel.setLayout(new GridLayout(1, 2));
        JLabel lblconFirm = new JLabel("ConFirm");
        txtConfirm = new JPasswordField(20);
        conFirmPanel.add(lblconFirm);
        conFirmPanel.add(txtConfirm);
        //nút bấm
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnSignup = new JButton("SignUp");
        btnCancel = new JButton("Cancel");
        btnPanel.add(btnSignup);
        btnPanel.add(btnCancel);

        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (checkNull()) {
                    if (txtPassword.getText().equals(txtConfirm.getText())) {
                        JOptionPane.showMessageDialog(null, "ok");
                    } else {
                        JOptionPane.showMessageDialog(null, "Password và Confirm không khớp mời nhập lại");
                    }
                }
            }
        });

        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        fMain.add(userPanel);
        fMain.add(passPanel);
        fMain.add(conFirmPanel);
        fMain.add(btnPanel);

        fMain.setVisible(true);

    }

    public static void main(String[] args) {
        LAB1_BAI3 bai3 = new LAB1_BAI3();
    }

    public boolean checkNull() {
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "chưa nhập giá trị");
            return false;
        } else if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "chưa nhập giá trị");
            return false;
        } else if (txtConfirm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "chưa nhập giá trị");
            return false;
        } else {
            return true;
        }
    }
}
