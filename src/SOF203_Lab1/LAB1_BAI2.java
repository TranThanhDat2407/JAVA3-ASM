/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author THANHDAT
 */
public class LAB1_BAI2 {

	private static JTextField txf_num1;
	private static JTextField txf_num2;
	private static JTextField txf_result;
    int x = 5, y = 5, w = 400, h = 400;
    public LAB1_BAI2() {
        initComp();
    }

    public void initComp() {
               JFrame jf = new JFrame();
	       JPanel mainPanel = new JPanel();
	       
	       JPanel panelnum1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	       JLabel lb1 = new JLabel("First Number:");
	       txf_num1 = new JTextField();
	       txf_num1.setPreferredSize(new Dimension(150, 25));
	       panelnum1.add(lb1);
	       panelnum1.add(Box.createHorizontalStrut(20));
	       panelnum1.add(txf_num1);
	       
	       JPanel panelnum2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	       JLabel lb2 = new JLabel("Second Number:");
	       txf_num2 = new JTextField();
	       txf_num2.setPreferredSize(new Dimension(150, 25));
	       panelnum2.add(lb2);
	       panelnum2.add(Box.createHorizontalStrut(3));
	       panelnum2.add(txf_num2);
	       
	       JPanel panelresult = new JPanel(new FlowLayout(FlowLayout.CENTER));
	       JLabel lb3 = new JLabel("Result:");
	       txf_result = new JTextField();
	       txf_result.setFont(new Font("Tahoma", Font.BOLD, 11));
	       txf_result.setPreferredSize(new Dimension(151, 25));
	       txf_result.setEnabled(false);
	       panelresult.add(lb3);
	       panelresult.add(Box.createHorizontalStrut(58));
	       panelresult.add(txf_result);
	       
	       
	       JPanel button = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
	       JButton btn_plus = new JButton("+");
	       JButton btn_minus = new JButton("-");
	       JButton btn_multiple = new JButton("*");
	       JButton btn_divide = new JButton("/");
	       button.add(btn_plus);
	       button.add(btn_minus);
	       button.add(btn_multiple);
	       button.add(btn_divide);
	       
	       btn_plus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float so1,so2;
					double ketqua;
					if(checkNull()) {
						so1=Float.parseFloat(txf_num1.getText());
						so2=Float.parseFloat(txf_num2.getText());
						ketqua= so1+so2;
						txf_result.setText(ketqua+"");
					}
				}
			});
			
		
	       btn_minus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float so1,so2;
					double ketqua;
					if(checkNull()) {
						so1=Float.parseFloat(txf_num1.getText());
						so2=Float.parseFloat(txf_num2.getText());
						ketqua= so1-so2;
						txf_result.setText(ketqua+"");
					}
				}
			});
			
	       btn_multiple.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float so1,so2;
					double ketqua;
					if(checkNull()) {
						so1=Float.parseFloat(txf_num1.getText());
						so2=Float.parseFloat(txf_num2.getText());
						ketqua= so1*so2;
						txf_result.setText(ketqua+"");
					}
				}
			});
			
	       btn_divide.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float so1,so2;
					double ketqua;
					if(checkNull()) {
						so1=Float.parseFloat(txf_num1.getText());
						so2=Float.parseFloat(txf_num2.getText());
						ketqua= so1/so2;
						txf_result.setText(ketqua+"");
					}
				}
			});
	       
	       
	       mainPanel.add(panelnum1);
	       mainPanel.add(panelnum2);
	       mainPanel.add(panelresult);
	       mainPanel.add(button);
	       jf.getContentPane().add(mainPanel);
	       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       jf.setVisible(true);
	       jf.setSize(300, 230);
	       jf.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        LAB1_BAI2 maytinh = new LAB1_BAI2();

    }

    public boolean checkNull() {
        if (txf_num1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "chưa nhập giá trị");
            return false;
        } else if (txf_num2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "chưa nhập giá trị");
            return false;
        } else {
            return true;
        }

    }
}
