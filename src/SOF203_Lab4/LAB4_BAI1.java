/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author THANHDAT
 */
public class LAB4_BAI1 {

    private String filePath;
    JFrame fMain;

    public LAB4_BAI1() throws HeadlessException {
        initComp();
    }

    public void initComp() {
        fMain = new JFrame();
        fMain.setSize(600, 400);
        fMain.setDefaultCloseOperation(3);
        fMain.setLocationRelativeTo(null);
        //MenuBar
        JMenuBar jMenu = new JMenuBar();
        //MenuFile
        JMenu jMenuFile = new JMenu("File");

        UIManager.put("MenuItem.acceleratorFont", new Font("Tahoma", Font.BOLD, 12));
        UIManager.put("MenuItem.acceleratorForeground", Color.BLACK);

        JMenuItem itemNew = new JMenuItem("New");
        itemNew.setIcon(new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\folder-regular-24.png"));
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));

        JMenuItem itemOpen = new JMenuItem("Open");
        itemOpen.setIcon(new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\user-solid-24.png"));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));

        JMenuItem itemSave = new JMenuItem("Save");
        itemSave.setIcon(new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\save-regular-24.png"));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));

        jMenuFile.add(itemNew);
        jMenuFile.add(itemOpen);
        jMenuFile.add(itemSave);
        //MenuColor
        JMenu jMenuColor = new JMenu("Color");
        JCheckBoxMenuItem itemRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem itemGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem itemBlue = new JCheckBoxMenuItem("Blue");
        JMenuItem itemTextColor = new JMenuItem("Text Color");
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(itemRed);
        colorGroup.add(itemGreen);
        colorGroup.add(itemBlue);
        jMenuColor.add(itemRed);
        jMenuColor.add(itemGreen);
        jMenuColor.add(itemBlue);
        jMenuColor.addSeparator();
        jMenuColor.add(itemTextColor);
        //MenuSystem
        JMenu jMenuSystem = new JMenu("System");
        JMenuItem itemAboutUs = new JMenuItem("About Us");
        itemAboutUs.setIcon(new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\user-solid-24.png"));
        itemAboutUs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.setIcon(new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\power-off-regular-24.png"));
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
        jMenuSystem.add(itemAboutUs);
        jMenuSystem.add(itemExit);
        //pMain
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        //IconPanel
        JPanel pIcon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon openIcon = new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\folder-plus-solid-24.png");
        ImageIcon userIcon = new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\user-solid-24.png");
        ImageIcon powerIcon = new ImageIcon("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\ICON\\power-off-regular-24.png");
        JButton btnOpen = new JButton(openIcon);
        JButton btnUser = new JButton(userIcon);
        JButton btnPower = new JButton(powerIcon);
        pIcon.add(btnOpen);
        pIcon.add(btnUser);
        pIcon.add(btnPower);
        //JEditorPane
        JEditorPane jEdit = new JEditorPane();
        //JTXT
        JPanel pText = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtText = new JTextField("Foly - Java 3");
        txtText.setFont(new Font("Tahoma", Font.BOLD, 18));
        txtText.setHorizontalAlignment(JTextField.CENTER);
        txtText.setPreferredSize(new Dimension(580, 50));
        pText.add(txtText);
        //Event
        itemRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtText.setBackground(Color.red);
            }
        });

        itemGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtText.setBackground(Color.GREEN);
            }
        });

        itemBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtText.setBackground(Color.BLUE);
            }
        });

        itemTextColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(fMain, "Chọn Màu", txtText.getForeground());
                if (selectedColor != null) {
                    txtText.setBackground(selectedColor);
                    colorGroup.clearSelection();
                }
            }
        });

        itemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jEdit.setText("");
                jEdit.requestFocus();
            }
        });

        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fChooser = new JFileChooser();
                fChooser.setCurrentDirectory(new File("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\"));
                int result = fChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        filePath = fChooser.getSelectedFile().getAbsolutePath();
                        jEdit.setPage("file:///" + filePath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        itemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filePath != null) {
                    try {
                        PrintWriter writer = new PrintWriter(filePath);
                        writer.write(jEdit.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(null, "Lưu file thành công.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không có file nào đang mở.");
                }
            }
        });

        itemAboutUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "Program Demo Menu";
                str += "\nAuthor: Dat";
                str += "\nLast Update: 3/10/2024";
                str += "\nEducation: Fpoly";
                JOptionPane.showMessageDialog(null, str, "About us", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fChooser = new JFileChooser();
                fChooser.setCurrentDirectory(new File("D:\\SOF203.01_PS37451_TranThanhDat_KiemTra\\BAI1\\"));
                int result = fChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        filePath = fChooser.getSelectedFile().getAbsolutePath();
                        jEdit.setPage("file:///" + filePath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String str = "Program Demo Menu";
                str += "\nAuthor: Dat";
                str += "\nLast Update: 3/10/2024";
                str += "\nEducation: Fpoly";
                JOptionPane.showMessageDialog(null, str, "About us", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnPower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //
        jMenu.add(jMenuFile);
        jMenu.add(jMenuColor);
        jMenu.add(jMenuSystem);
        fMain.setJMenuBar(jMenu);
        pMain.add(pIcon);
        pMain.add(jEdit);
        pMain.add(pText);
        fMain.add(pMain);
        fMain.setVisible(true);
    }

    public static void main(String[] args) {
        LAB4_BAI1 test = new LAB4_BAI1();
    }
}
