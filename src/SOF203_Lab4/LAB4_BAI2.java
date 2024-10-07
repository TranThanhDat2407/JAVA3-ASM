/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab4;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class LAB4_BAI2 {
   
    private int index = -1;
    List<Product> list = new ArrayList<>();
    private JFrame jf = new JFrame();
    private JLabel lblMain, lblID, lblTen, lblGia, lblDV, lblNCC;
    private JTextField txtID, txtTen, txtGia, txtNCC;
    private JComboBox<String> cboDV;
    private JButton btnThem, btnSua, btnXoa;
    private DefaultTableModel modelProducts = new DefaultTableModel();
    private JTable tblProduct = new JTable();
    private JScrollPane scrollPane = new JScrollPane();

    public LAB4_BAI2() {
        initTable();
        init();
        data();
        fillToTable();
    }

    private void initTable() {
        String[] header = {"Ma SP", "Ten SP", "DVT", "Don gia", "Nha cung cap"};
        modelProducts.setColumnIdentifiers(header);
        tblProduct.setModel(modelProducts);
    }

    private void data() {
        list.add(new Product("SP01", "Dau goi head", "Chai", "Unilevers", 34000));
        list.add(new Product("SP02", "Xa bong Omo", "Thung", "Unilevers", 124000));
        list.add(new Product("SP03", "Dau an Tuong An", "Chai", "Tuong An", 100000));
    }

    private void fillToTable() {
        modelProducts.setRowCount(0);
        for (Product sp : list) {
            Object[] row = new Object[]{sp.getId(), sp.getName(), sp.getDvt(), sp.getGia(), sp.getNcc()};
            modelProducts.addRow(row);
        }
    }

    private boolean checkNull() {
        if (txtGia.equals("") || txtID.equals("") || txtNCC.equals("") || txtTen.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void init() {
        jf.setDefaultCloseOperation(3);
        jf.setLocationRelativeTo(null);
        //Panel main 
        JPanel jmain = new JPanel();
        jmain.setLayout(new BoxLayout(jmain, BoxLayout.Y_AXIS));
        //Panel Danh sach san pham
        JPanel pn1 = new JPanel(new FlowLayout());
        TitledBorder tt1 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Danh sach san pham",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20),
                Color.RED
        );
        pn1.setBorder(tt1);
        scrollPane.setViewportView(tblProduct);
        pn1.add(scrollPane);
        pn1.setBackground(Color.cyan);
        jmain.add(pn1);
        //Panel Nhap lieu
        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        //Panel Ma san pham
        JPanel pnID = new JPanel(new FlowLayout());
        pnID.setBackground(Color.YELLOW);
        lblID = new JLabel("Ma san pham");
        txtID = new JTextField();
        txtID.setPreferredSize(new Dimension(200, 25));
        lblGia = new JLabel("Don gia");
        txtGia = new JTextField();
        txtGia.setPreferredSize(new Dimension(200, 25));
        pnID.add(lblID);
        pnID.add(Box.createHorizontalStrut(10));
        pnID.add(txtID);
        pnID.add(Box.createHorizontalStrut(40));
        pnID.add(lblGia);
        pnID.add(Box.createHorizontalStrut(10));
        pnID.add(txtGia);
        //Panel Ten san pham
        JPanel pnTen = new JPanel(new FlowLayout());
        pnTen.setBackground(Color.YELLOW);
        lblTen = new JLabel("Ten san pham");
        txtTen = new JTextField();
        txtTen.setPreferredSize(new Dimension(200, 25));
        lblNCC = new JLabel("Nha cung cap");
        txtNCC = new JTextField();
        txtNCC.setPreferredSize(new Dimension(190, 25));
        pnTen.add(lblTen);
        pnTen.add(Box.createHorizontalStrut(10));
        pnTen.add(txtTen);
        pnTen.add(Box.createHorizontalStrut(30));
        pnTen.add(lblNCC);
        pnTen.add(Box.createHorizontalStrut(0));
        pnTen.add(txtNCC);
        //Panel Don vi tinh
        JPanel pnDvt = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnDvt.setBackground(Color.YELLOW);
        String[] dvt = {"Chai", "Thung", "Kg", "Lon"};
        cboDV = new JComboBox<>(dvt);
        lblDV = new JLabel("Don vi tinh");
        pnDvt.add(Box.createHorizontalStrut(90));
        pnDvt.add(lblDV);
        pnDvt.add(Box.createHorizontalStrut(12));
        pnDvt.add(cboDV);
        pn2.add(pnID);
        pn2.add(pnTen);
        pn2.add(pnDvt);
        jmain.add(pn2);
        //Panel button
        JPanel pnBtn = new JPanel();
        pnBtn.setBackground(Color.GREEN);
        btnThem = new JButton("Them san pham");
        btnXoa = new JButton("Xoa san pham");
        btnSua = new JButton("Dieu chinh thong tin");
        pnBtn.add(btnThem);
        pnBtn.add(btnXoa);
        pnBtn.add(btnSua);
        jmain.add(pnBtn);
        //Xu ly su kien
        tblProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index = tblProduct.getSelectedRow();
            }

        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkNull()) {
                    list.add(new Product(txtID.getText(), txtTen.getText(), (String) cboDV.getSelectedItem(), txtNCC.getText(), Double.parseDouble(txtGia.getText())));
                }
                fillToTable();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "Hay chon dong muon sua");
                } else {
                    if (checkNull()) {
                        list.set(index, new Product(txtID.getText(), txtTen.getText(), (String) cboDV.getSelectedItem(), txtNCC.getText(), Double.parseDouble(txtGia.getText())));
                    }
                }
                fillToTable();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index == -1){
                    JOptionPane.showMessageDialog(null, "Hay chon dong muon xoa");
                }else
                {
                    list.remove(index);
                }
                fillToTable();
            }
        });

        jf.setSize(800, 400);
        jf.setDefaultCloseOperation(3);
        jf.setLocationRelativeTo(null);
        jf.getContentPane().add(jmain);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        LAB4_BAI2 b2 = new LAB4_BAI2();
    }
}
