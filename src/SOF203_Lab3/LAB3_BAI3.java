/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author THANHDAT
 */
public class LAB3_BAI3 {

    JFrame fMain;

    public LAB3_BAI3() {
        initComp();
    }

    public void initComp() {
        fMain = new JFrame();
        fMain.setDefaultCloseOperation(3);
        fMain.setSize(600, 200);
        fMain.setLocationRelativeTo(null);
        //Panel Main
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        //slider
        JPanel pSlider = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pSlider.setPreferredSize(new Dimension(300, 50));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 45); // tham số: ngang/dọc, value ít nhất, value tối đa, value bắt đầu
        slider.setMajorTickSpacing(5); // 5 đơn vị hiển thị tích chính
        slider.setMinorTickSpacing(1); // 1 đơn vị hiển thị tích phụ
        slider.setPaintTicks(true); // hiển thị tích
        slider.setPaintLabels(true); // hiển thị số tích
        pSlider.add(slider);
        //pValue
        JPanel pValue = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pValue.setPreferredSize(new Dimension(300, 800));
        JLabel lblValue = new JLabel("Giá Trị Hiện Tại: ");
        JTextField txtValue = new JTextField(10);
        JLabel lblLabel = new JLabel("Font Size");
        JButton btnValue = new JButton("Set Value");
        pValue.add(lblValue);
        pValue.add(txtValue);
        pValue.add(btnValue);
        pValue.add(lblLabel);
        //
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                txtValue.setText(String.valueOf(value));
                lblLabel.setFont(new Font("Arial", Font.PLAIN, value));
            }
        });

        btnValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(txtValue.getText());
                slider.setValue(value);
            }

        });

        fMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                int value = slider.getValue();
                txtValue.setText(String.valueOf(value));
                lblLabel.setFont(new Font("Arial", Font.PLAIN, value));
            }
        });
        //
        pMain.add(pSlider);
        pMain.add(pValue);
        fMain.add(pMain);
        fMain.setVisible(true);
    }

    public static void main(String[] args) {
        LAB3_BAI3 test = new LAB3_BAI3();
    }
}
