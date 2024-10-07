/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author THANHDAT
 */
public class LAB3_BAI1 {

    JFrame fMain;
    String[] btnName = {"1", "2", "3", "4", "5",
        "6", "7", "8", "9", "10"};
    JButton[] btnS;

    public LAB3_BAI1() {
        initComp();
    }

    public void initComp() {
        fMain = new JFrame();
        fMain.setSize(600, 600);
        fMain.setDefaultCloseOperation(3);
        fMain.setLocationRelativeTo(null);
        //main
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        //panel1
        JPanel Panel1 = new JPanel();
        Panel1.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
        JButton btnRed = new JButton("RED");
        JButton btnGreen = new JButton("GREEN");
        JButton btnYellow = new JButton("YELLOW");
        Panel1.setBackground(Color.YELLOW);
        Panel1.add(btnRed);
        Panel1.add(btnGreen);
        Panel1.add(btnYellow);
//        Panel1.setBounds(x, y, w + 170, 40);
//        y += 50;
        //panel 2
        JPanel Panel2 = new JPanel();
        Panel2.setLayout(new BorderLayout(10,10));
        JButton btnNorth = new JButton("North");
        JButton btnCenter = new JButton("Center");
        JButton btnSouth = new JButton("South");
        JButton btnEast = new JButton("East");
        JButton btnWest = new JButton("West");
        Panel2.add(btnNorth, BorderLayout.NORTH);
        Panel2.add(btnCenter, BorderLayout.CENTER);
        Panel2.add(btnSouth, BorderLayout.SOUTH);
        Panel2.add(btnEast, BorderLayout.EAST);
        Panel2.add(btnWest, BorderLayout.WEST);
//        Panel2.setBounds(x, y, w + 170, 40);
        //panel 3
        JPanel Panel3 = new JPanel();
        JTextField txtComment = new JTextField("Học Sinh FPT",30);
        txtComment.setFont(new Font("Tahoma", Font.BOLD, 18));
        txtComment.setForeground(Color.GREEN);
        Panel3.add(txtComment);
        //panel 4
        JPanel Panel4 = new JPanel(new GridLayout(2, 5, 5, 5));
        btnS = new JButton[btnName.length];
        for (int i = 0; i < btnName.length; i++) {
            btnS[i] = new JButton(btnName[i]);
            Panel4.add(btnS[i]);
        }

        btnRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.setBackground(Color.RED);
            }
        });

        btnGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.setBackground(Color.GREEN);
            }
        });

        btnYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.setBackground(Color.YELLOW);
            }
        });

        btnNorth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtComment.setText("North");
            }
        });

        btnCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtComment.setText("Center");
            }
        });

        btnEast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtComment.setText("East");
            }
        });

        btnSouth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtComment.setText("South");
            }
        });

        btnWest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtComment.setText("West");
            }
        });

        pMain.add(Panel1);
        pMain.add(Panel2);
        pMain.add(Panel3);
        pMain.add(Panel4);
        fMain.getContentPane().add(pMain);
        fMain.setVisible(true);
    }

    public static void main(String[] args) {
        LAB3_BAI1 a = new LAB3_BAI1();
    }
}
