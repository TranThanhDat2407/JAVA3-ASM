/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author THANHDAT
 */
public class LAB2_BAI3 {

    JFrame fMain;
    JButton btnMess, btnInput, btnConfirm, btnOption;

    public LAB2_BAI3() {
        initComp();
    }

    public void initComp() {
        fMain = new JFrame();
//        fMain.setSize(400, 150);
        fMain.setDefaultCloseOperation(3);
        fMain.setTitle("JOption Pane Example");
        fMain.setLocationRelativeTo(null);
//        fMain.setLayout(new GridLayout(2, 4));
        //btn
        JPanel pMain = new JPanel();
//        pMain.setLayout(null);
        JPanel pBTN = new JPanel();
        pBTN.setLayout(new GridLayout(2, 4, 10, 10));
        btnMess = new JButton("Message Dialog");
        btnMess.setHorizontalAlignment(JButton.CENTER);
        btnInput = new JButton("Input Dialog");
        btnConfirm = new JButton("Confirm Dialog");
        btnOption = new JButton("Option Dialog");


        pBTN.add(btnMess);
        pBTN.add(btnInput);
        pBTN.add(btnConfirm);
        pBTN.add(btnOption);

        btnMess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(fMain, "Please input your name");
            }
        });

        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yourName = JOptionPane.showInputDialog("Your name is");
                if (yourName != null) {
                    JOptionPane.showMessageDialog(fMain, "Your name is " + yourName);
                }

            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yourName = JOptionPane.showInputDialog("Your name is");
                if (yourName != null) {
                    int ret = JOptionPane.showConfirmDialog(fMain, "Are you sure?",
                            "Confirm", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (ret == JOptionPane.YES_OPTION) {
                        //Xử lý trường hợp người dùng chọn Yes
                    } else {
                        //Xử lý trường hợp người dùng chọn No
                    }

                }

            }
        });

        btnOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int messageType = JOptionPane.QUESTION_MESSAGE;
                String[] options = {"Java", "C++", "VB", "PHP", "Perl"};
                int code = JOptionPane.showOptionDialog(fMain, "What language you refer?", "Option Dialog Box", 0, messageType, null, options, "PHP");
            }
        });
        pMain.add(pBTN);
        fMain.add(pMain);
        fMain.pack();
        fMain.setVisible(true);
    }

    public static void main(String[] args) {
        LAB2_BAI3 test = new LAB2_BAI3();
    }
}
