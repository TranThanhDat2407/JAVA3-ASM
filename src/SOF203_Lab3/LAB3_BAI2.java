/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class LAB3_BAI2 extends JFrame {

    private JFrame jf;
    private JTextField txtHo, txtTen, txtBiDanh;
    private JLabel lblHo, lblTen, lblBiDanh, lblMatMa, lblQue, lblSoThich, lblGhiChu;
    private JButton btnOK, btnReset, btnExit;
    private JPasswordField txtMatMa;
    private JRadioButton rNam, rNu, rKoXD;

    public LAB3_BAI2() {
        jf = new JFrame();
        JPanel Jmain = new JPanel();
        Jmain.setLayout(new BoxLayout(Jmain, BoxLayout.Y_AXIS));
        //Panel1
        JPanel pn1 = new JPanel();
        pn1.setPreferredSize(new Dimension(700, 100));
        pn1.setLayout(new BoxLayout(pn1, BoxLayout.Y_AXIS));
        Font f1 = new Font("Tahoma", Font.BOLD, 30);
        //Tao title panel
        TitledBorder tt1 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE),
                "Ho Ten",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20),
                Color.RED
        );
        pn1.setBorder(tt1);
        pn1.setBackground(new Color(0xbfffa3));
        // panel ho ten
        JPanel pnHoTen = new JPanel();
        pnHoTen.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lblHo = new JLabel("Ho: ");
        txtHo = new JTextField();
        txtHo.setPreferredSize(new Dimension(200, 25));
        lblTen = new JLabel("Ten: ");
        txtTen = new JTextField();
        txtTen.setPreferredSize(new Dimension(250, 25));
        pnHoTen.add(lblHo);
        pnHoTen.add(Box.createHorizontalStrut(10));
        pnHoTen.add(txtHo);
        pnHoTen.add(Box.createHorizontalStrut(20));
        pnHoTen.add(lblTen);
        pnHoTen.add(Box.createHorizontalStrut(10));
        pnHoTen.add(txtTen);
        pnHoTen.add(Box.createHorizontalStrut(70));
        pnHoTen.setBackground(new Color(0xbfffa3));
        pn1.add(pnHoTen);
        // panel bi danh mat ma
        JPanel pnBDMM = new JPanel();
        pnBDMM.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lblBiDanh = new JLabel("Bi danh: ");
        txtBiDanh = new JTextField();
        txtBiDanh.setPreferredSize(new Dimension(200, 25));
        lblMatMa = new JLabel("Mat ma: ");
        txtMatMa = new JPasswordField();
        txtMatMa.setPreferredSize(new Dimension(150, 25));
        pnBDMM.add(lblBiDanh);
        pnBDMM.add(Box.createHorizontalStrut(10));
        pnBDMM.add(txtBiDanh);
        pnBDMM.add(Box.createHorizontalStrut(20));
        pnBDMM.add(lblMatMa);
        pnBDMM.add(Box.createHorizontalStrut(92));
        pnBDMM.add(txtMatMa);
        pnBDMM.add(Box.createHorizontalStrut(70));
        pnBDMM.setBackground(new Color(0xbfffa3));
        pn1.add(pnBDMM);
        //Panle Gioi tinh
        JPanel pnGioiTinh = new JPanel();
        pnGioiTinh.setPreferredSize(new Dimension(700, 70));
        pnGioiTinh.setLayout(new FlowLayout(FlowLayout.LEFT));
        rNam = new JRadioButton("Nam");
        rNu = new JRadioButton("Nu");
        rKoXD = new JRadioButton("Khong xac dinh");
        ButtonGroup btnG1 = new ButtonGroup();
        btnG1.add(rNu);
        btnG1.add(rNam);
        btnG1.add(rKoXD);
        pnGioiTinh.add(Box.createHorizontalStrut(120));
        pnGioiTinh.add(rNam);
        pnGioiTinh.add(Box.createHorizontalStrut(60));
        pnGioiTinh.add(rNu);
        pnGioiTinh.add(Box.createHorizontalStrut(60));
        pnGioiTinh.add(rKoXD);
        TitledBorder tt2 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE),
                "Gioi tinh",
                TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.PLAIN, 20),
                Color.BLUE
        );
        pnGioiTinh.setBorder(tt2);
        pnGioiTinh.setBackground(new Color(0xffe599));
        //Panel Thong tin khac
        JPanel pnTTK = new JPanel();
        pnTTK.setLayout(new BoxLayout(pnTTK, BoxLayout.Y_AXIS));
        TitledBorder tt3 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE, 1),
                "Thong tin khac",
                TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20),
                new Color(0xb50c00)
        );
        pnTTK.setBorder(tt3);
        pnTTK.setPreferredSize(new Dimension(700, 250));
        pnTTK.setBackground(new Color(0xffaaa4));
        // Panel que quan
        JPanel pnQue = new JPanel();
        pnQue.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnQue.setPreferredSize(new Dimension(700, 50));
        lblQue = new JLabel("Que quan: ");
        String[] que = {"Ninh Thuan", "Khanh Hoa", "TP HCM"};
        JComboBox<String> cboQue = new JComboBox<>(que);
        pnQue.add(Box.createHorizontalStrut(50));
        pnQue.add(lblQue);
        pnQue.add(Box.createHorizontalStrut(10));
        pnQue.add(cboQue);
        pnQue.setBackground(new Color(0xffaaa4));
        pnTTK.add(pnQue);
        //Panel So thich
        JPanel pnSoThich = new JPanel();
        pnSoThich.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnSoThich.setPreferredSize(new Dimension(700, 180));
        lblSoThich = new JLabel("So Thich: ");
        JCheckBox chkAnChoi = new JCheckBox("Ăn Chơi");
        JCheckBox chkNhayMua = new JCheckBox("Nhảy Múa");
        JCheckBox chkNguNghi = new JCheckBox("Ngủ Nghỉ");
        pnSoThich.setBackground(new Color(0xffaaa4));
        pnSoThich.add(Box.createHorizontalStrut(50));
        pnSoThich.add(lblSoThich);
        pnSoThich.add(Box.createHorizontalStrut(10));
        pnSoThich.add(chkAnChoi);
        pnSoThich.add(Box.createHorizontalStrut(10));
        pnSoThich.add(chkNhayMua);
        pnSoThich.add(Box.createHorizontalStrut(10));
        pnSoThich.add(chkNguNghi);
        pnTTK.add(pnSoThich);
        //Panel Ghi Chu
        JPanel pnlGhiChu = new JPanel();
        pnlGhiChu.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlGhiChu.setPreferredSize(new Dimension(700, 500));
        pnlGhiChu.setBackground(new Color(0xffaaa4));
        lblGhiChu = new JLabel("Ghi Chu: ");

        JTextArea txtGhiChu = new JTextArea("Layout 3", 6, 20);
       
        JScrollPane JScrollPane1 = new JScrollPane(txtGhiChu);
        JScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pnlGhiChu.add(Box.createHorizontalStrut(50));
        pnlGhiChu.add(lblGhiChu);
        pnlGhiChu.add(Box.createHorizontalStrut(10));
        pnlGhiChu.add(JScrollPane1);
        pnTTK.add(pnlGhiChu);
        //Panel btn
        JPanel pnlBtn = new JPanel();
        pnlBtn.setLayout(new FlowLayout());
        btnOK = new JButton("OK");
        btnReset = new JButton("RESET");
        btnExit = new JButton("EXIT");
        pnlBtn.add(btnOK);
        pnlBtn.add(btnReset);
        pnlBtn.add(btnExit);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtHo.setText("");
                txtTen.setText("");
                txtMatMa.setText("");
                txtBiDanh.setText("");
                btnG1.clearSelection();
                cboQue.setSelectedIndex(0);
                chkNhayMua.setSelected(false);
                chkAnChoi.setSelected(false);
                chkNguNghi.setSelected(false);
                txtGhiChu.setText("");
            }
        });

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String gioiTinh = "";
        if (rNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (rNu.isSelected()) {
            gioiTinh = "Nu";
        } else if (rKoXD.isSelected()) {
            gioiTinh = "Khong xac dinh";
        }
        
        JOptionPane.showMessageDialog(jf, "Ho Ten: " + txtHo.getText() + " " + txtTen.getText() + "\n"
                + "Que Quan: " + cboQue.getSelectedItem() + "\n" +
                "Gioi Tinh: " + gioiTinh);
            }
        });

        // Jmain
        Jmain.add(pn1);
        Jmain.add(pnGioiTinh);
        Jmain.add(pnTTK);
        Jmain.add(pnlBtn);
        Jmain.add(Box.createHorizontalStrut(10));

        jf.getContentPane().add(Jmain);
        jf.setDefaultCloseOperation(3);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        LAB3_BAI2 frame = new LAB3_BAI2();
    }
}
