/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab4;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANHDAT
 */
public class LAB4_LAB2_2 {

    JFrame fMain;
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

    public LAB4_LAB2_2() {
        initComp();
        data();
        initTable();
        fillToTable();
    }

    private boolean checkNull() {
        if (txtGia.getText().equals("") || txtID.getText().equals("") || txtNCC.getText().equals("") || txtTen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hãy nhập dữ liệu");
            return false;
        }
        return true;
    }

    private boolean checkTrung() {
        for (Product product : list) {
            if (product.getId().equals(txtID.getText())) {
                JOptionPane.showMessageDialog(null, "Trùng mã sản phẩm");
                return false;
            }
        }
        return true;
    }

    private void initTable() {
        String[] header = {"Mã SP", "Tên SP", "DVT", "Đơn giá", "Nhà cung cấp"};
        modelProducts.setColumnIdentifiers(header);
        tblProduct.setModel(modelProducts);
    }

    private void data() {
        list.add(new Product("SP01", "Dầu gội head", "Chai", "Unilevers", 34000));
        list.add(new Product("SP02", "Xà bong Omo", "Thùng", "Unilevers", 124000));
        list.add(new Product("SP03", "Dầu ăn Trường An", "Chai", "Tường An", 100000));
    }

    private void fillToTable() {
        modelProducts.setRowCount(0);
        for (Product sp : list) {
            Object[] row = new Object[]{sp.getId(), sp.getName(), sp.getDvt(), sp.getGia(), sp.getNcc()};
            modelProducts.addRow(row);
        }
    }

    public void fillForm(int index) {
        txtID.setText(list.get(index).getId());
        txtGia.setText(String.valueOf(list.get(index).getGia()));
        txtNCC.setText(list.get(index).getNcc());
        txtTen.setText(list.get(index).getName());
        cboDV.setSelectedItem(list.get(index).getDvt());
    }

    public void cleanForm() {
        txtID.setText("");
        txtTen.setText("");
        cboDV.setSelectedIndex(0);
        txtNCC.setText("");
        txtGia.setText("");
        txtID.setEnabled(true);
        index = -1;
    }

    public void initComp() {
        fMain = new JFrame();
        fMain.setSize(800, 400);
        fMain.setDefaultCloseOperation(3);
        fMain.setLocationRelativeTo(null);
        //Panel main 
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        //Panel Danh sach san pham
        JPanel pn1 = new JPanel(new FlowLayout());
        TitledBorder tt1 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Danh sách sản phẩm",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20),
                Color.RED
        );
        pn1.setBorder(tt1);
        scrollPane.setViewportView(tblProduct);
        pn1.add(scrollPane);
        pn1.setBackground(Color.cyan);
        pMain.add(pn1);
        //Panel Nhap lieu
        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        //Panel Ma san pham
        JPanel pnID = new JPanel(new FlowLayout());
        pnID.setBackground(Color.YELLOW);
        lblID = new JLabel("Mã sản phẩm");
        txtID = new JTextField();
        txtID.setPreferredSize(new Dimension(200, 25));
        lblGia = new JLabel("Đơn giá");
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
        lblTen = new JLabel("Tên sản phẩm");
        txtTen = new JTextField();
        txtTen.setPreferredSize(new Dimension(200, 25));
        lblNCC = new JLabel("Nhà cung cấp");
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
        String[] dvt = {"Chai", "Thùng", "Kg", "Lon"};
        cboDV = new JComboBox<>(dvt);
        JLabel lblDV = new JLabel("Đơn vị tính");
        pnDvt.add(Box.createHorizontalStrut(90));
        pnDvt.add(lblDV);
        pnDvt.add(Box.createHorizontalStrut(12));
        pnDvt.add(cboDV);
        pn2.add(pnID);
        pn2.add(pnTen);
        pn2.add(pnDvt);
        pMain.add(pn2);
        //Panel button
        JPanel pnBtn = new JPanel();
        pnBtn.setBackground(Color.GREEN);
        JButton btnThem = new JButton("Thêm sản phẩm");
        JButton btnXoa = new JButton("Xóa sản phẩm");
        JButton btnSua = new JButton("Điều chỉnh thông tin");
        JButton btnCleanForm = new JButton("Reset Form");
        pnBtn.add(btnThem);
        pnBtn.add(btnXoa);
        pnBtn.add(btnSua);
        pnBtn.add(btnCleanForm);
        pMain.add(pnBtn);
        //Xu ly su kien

        tblProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index = tblProduct.getSelectedRow();
                fillForm(index);
                txtID.setEnabled(false);
            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkNull() && checkTrung()) {
                    list.add(new Product(txtID.getText(), txtTen.getText(), (String) cboDV.getSelectedItem(), txtNCC.getText(), Double.parseDouble(txtGia.getText())));
                }
                fillToTable();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm muốn sửa");
                } else {
                    if (checkNull()) {
                        list.set(index, new Product(txtID.getText(), txtTen.getText(), (String) cboDV.getSelectedItem(), txtNCC.getText(), Double.parseDouble(txtGia.getText())));
                        index = -1;
                        fillToTable();
                        cleanForm();
                    }
                }

            }
        });
      btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm muốn xóa");
                } else {
                    list.remove(index);
                    index = -1;
                }
                fillToTable();
                cleanForm();
            }
        });

        btnCleanForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              cleanForm();
            }
        });

        fMain.add(pMain);
        fMain.setVisible(true);

    }

    public static void main(String[] args) {
        LAB4_LAB2_2 test = new LAB4_LAB2_2();
    }
}
