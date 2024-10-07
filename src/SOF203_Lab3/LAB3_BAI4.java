/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab3;

import com.sun.source.tree.Scope;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author PC
 */
public class LAB3_BAI4 {
    
    private JFrame fMain;
    private JTextField txtFirst, txtLast, txtCon, txtHight, txtSpec, txtEnroll, txtHobbies, txtSport;
    private JTextArea txtAddress;
    private JButton btnSave, btnReset, btnExit;
    private JLabel lblFirst, lblLast, lblCon, lblHight, lblSpec, lblEnroll, lblHobbies, lblSport, lblAddress, lblMain;
    
    public LAB3_BAI4() {
        init();
    }
    
    private void init() {
        fMain = new JFrame();
        fMain.setDefaultCloseOperation(3);
        fMain.setSize(600, 800);
        fMain.setLocationRelativeTo(null);
        //Panel main
        JPanel Jmain = new JPanel();
        Jmain.setLayout(new BoxLayout(Jmain, BoxLayout.Y_AXIS));
        //Panel Title
        JPanel jTitle = new JPanel();
        jTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        Font fMain = new Font("Arial", Font.BOLD, 40);
        lblMain = new JLabel("STUDENT REGISTRATOIN");
        lblMain.setFont(fMain);
        lblMain.setForeground(Color.PINK);
        jTitle.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        jTitle.add(lblMain);
        Jmain.add(jTitle);
        //Panel Personal details
        JPanel pn1 = new JPanel();
        pn1.setLayout(new BoxLayout(pn1, BoxLayout.Y_AXIS));
        pn1.setPreferredSize(new Dimension(300, 150));
        pn1.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        pn1.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Personal Details"));
        //Panel Fisrt name
        JPanel pnF = new JPanel();
        pnF.setLayout(new FlowLayout());
        lblFirst = new JLabel("First name ");
        pnF.add(lblFirst);
        txtFirst = new JTextField();
        txtFirst.setPreferredSize(new Dimension(300, 25));
        pnF.add(txtFirst);
        pn1.add(pnF);
        //Panel Last name
        JPanel pnL = new JPanel(new FlowLayout());
        lblLast = new JLabel("Last name ");
        pnL.add(lblLast);
        txtLast = new JTextField();
        txtLast.setPreferredSize(new Dimension(300, 25));
        pnL.add(txtLast);
        pn1.add(pnL);
        // Panel Contact
        JPanel pnC = new JPanel(new FlowLayout());
        lblCon = new JLabel("Contact");
        pnC.add(lblCon);
        txtCon = new JTextField();
        txtCon.setPreferredSize(new Dimension(300, 25));
        pnC.add(Box.createHorizontalStrut(10));
        pnC.add(txtCon);
        pn1.add(pnC);
        //Panel Address
        JPanel pnA = new JPanel(new FlowLayout());
        lblAddress = new JLabel("Address");
        pnA.add(lblAddress);
        txtAddress = new JTextArea(6, 28);
        JScrollPane jsp1 = new JScrollPane(txtAddress);
        jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pnA.add(Box.createHorizontalStrut(10));
        pnA.add(jsp1);
        pn1.add(pnA);
        //Panel Acamedic Details
        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        pn2.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Acamedic Details"));
        //Panel Hight
        JPanel pnH = new JPanel(new FlowLayout());
        lblHight = new JLabel("Highest Qualification");
        txtHight = new JTextField();
        txtHight.setPreferredSize(new Dimension(300, 25));
        pnH.add(lblHight);
        pnH.add(txtHight);
        pn2.add(pnH);
        //Panel Specification
        JPanel pnS = new JPanel(new FlowLayout());
        lblSpec = new JLabel("Specification");
        txtSpec = new JTextField();
        txtSpec.setPreferredSize(new Dimension(300, 25));
        pnS.add(lblSpec);
        pnS.add(Box.createHorizontalStrut(35));
        pnS.add(txtSpec);
        pn2.add(pnS);
        //Panel Enroll For 
        JPanel pnE = new JPanel(new FlowLayout());
        lblEnroll = new JLabel("Enroll For");
        txtEnroll = new JTextField();
        txtEnroll.setPreferredSize(new Dimension(300, 25));
        pnE.add(lblEnroll);
        pnE.add(Box.createHorizontalStrut(50));
        pnE.add(txtEnroll);
        pn2.add(pnE);
        //Panel Extracurricular Details
        JPanel pn3 = new JPanel();
        pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
        pn3.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Extracurricular Details"));
        //Panel Hobbies
        JPanel pnHo = new JPanel(new FlowLayout());
        lblHobbies = new JLabel("Hobbies");
        txtHobbies = new JTextField();
        txtHobbies.setPreferredSize(new Dimension(324, 20));
        pnHo.add(lblHobbies);
        pnHo.add(Box.createHorizontalStrut(30));
        pnHo.add(txtHobbies);
        pn3.add(pnHo);
        //Panel Sport
        JPanel pnSp = new JPanel(new FlowLayout());
        lblSport = new JLabel("Sport");
        txtSport = new JTextField();
        txtSport.setPreferredSize(new Dimension(324, 20));
        pnSp.add(lblSport);
        pnSp.add(Box.createHorizontalStrut(45));
        pnSp.add(txtSport);
        pn3.add(pnSp);
        //Panel button
        JPanel pn4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        pn4.setBorder(new TitledBorder(new LineBorder(Color.black), ""));
        btnSave = new JButton("Save");
        btnSave.setPreferredSize(new Dimension(80, 40));
        btnReset = new JButton("Reset");
        btnReset.setPreferredSize(new Dimension(80, 40));
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(80, 40));
        pn4.add(btnSave);
        pn4.add(btnReset);
        pn4.add(btnExit);
        
        Jmain.add(pn1);
        Jmain.add(pn2);
        Jmain.add(pn3);
        Jmain.add(pn4);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra xem các textbox có dữ liệu hay không
                if (txtFirst.getText().isEmpty() || txtLast.getText().isEmpty() || txtCon.getText().isEmpty() || txtAddress.getText().isEmpty()
                        || txtHight.getText().isEmpty() || txtSpec.getText().isEmpty() || txtEnroll.getText().isEmpty() || txtHobbies.getText().isEmpty()
                        || txtSport.getText().isEmpty()) {
                    // Hiển thị thông báo nếu có textbox chưa được nhập dữ liệu
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                } else {
                    // Tạo một chuỗi chứa thông tin đã nhập
                    String message = "Thông tin đã nhập:\n\n";
                    message += "First name: " + txtFirst.getText() + "\n";
                    message += "Last name: " + txtLast.getText() + "\n";
                    message += "Contact: " + txtCon.getText() + "\n";
                    message += "Address: " + txtAddress.getText() + "\n";
                    message += "Highest Qualification: " + txtHight.getText() + "\n";
                    message += "Specification: " + txtSpec.getText() + "\n";
                    message += "Enroll For: " + txtEnroll.getText() + "\n";
                    message += "Hobbies: " + txtHobbies.getText() + "\n";
                    message += "Sport: " + txtSport.getText() + "\n";

                    // Hiển thị thông tin đã nhập bằng hộp thoại
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xóa dữ liệu của tất cả các textbox
                txtFirst.setText("");
                txtLast.setText("");
                txtCon.setText("");
                txtAddress.setText("");
                txtHight.setText("");
                txtSpec.setText("");
                txtEnroll.setText("");
                txtHobbies.setText("");
                txtSport.setText("");
            }
        });
        
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đóng form lại
                System.exit(0);
            }
        });
        
        this.fMain.getContentPane().add(Jmain);
        this.fMain.setVisible(true);
    }
    
    public static void main(String[] args) {
        LAB3_BAI4 b4 = new LAB3_BAI4();
    }
}
