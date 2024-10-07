package SOF203_Lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LAB2_BAI1 {
    
    private static JTextField txf_name;
    private static JTextField txf_address;
    
    public static void main(String[] args) {
        
        JFrame jf = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        /////////////////////////////////////////////////////////////////
        JPanel panel_name_qualification = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lb1 = new JLabel("Name:");
        txf_name = new JTextField();
        txf_name.setPreferredSize(new Dimension(150, 25));
        JLabel lb2 = new JLabel("Qualification:");
        String[] iteam = {"Graduate", "Student"};
        JComboBox<String> cboQ = new JComboBox<>(iteam);
        panel_name_qualification.add(lb1);
        panel_name_qualification.add(Box.createHorizontalStrut(10));
        panel_name_qualification.add(txf_name);
        panel_name_qualification.add(Box.createHorizontalStrut(70));
        panel_name_qualification.add(lb2);
        panel_name_qualification.add(Box.createHorizontalStrut(10));
        panel_name_qualification.add(cboQ);

        /////////////////////////////////////////////////////////////////
        JPanel panel_address_hobby = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JLabel lb3 = new JLabel("Address:");
        txf_address = new JTextField();
        txf_address.setPreferredSize(new Dimension(150, 75));
        
        JLabel lb4 = new JLabel("Hobby:");
        JPanel panelbox_hobby = new JPanel();
        panelbox_hobby.setLayout(new BoxLayout(panelbox_hobby, BoxLayout.Y_AXIS));
        panelbox_hobby.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JCheckBox chkReading = new JCheckBox("Reading");
        JCheckBox chkSinging = new JCheckBox("Singing");
        JCheckBox chkDancing = new JCheckBox("Dancing");
        
        panel_address_hobby.add(Box.createHorizontalStrut(-20));
        panel_address_hobby.add(lb3);
        panel_address_hobby.add(Box.createHorizontalStrut(10));
        panel_address_hobby.add(txf_address);
        panel_address_hobby.add(Box.createHorizontalStrut(110));
        panel_address_hobby.add(lb4);
        panel_address_hobby.add(Box.createHorizontalStrut(10));
        panel_address_hobby.add(panelbox_hobby);
        panel_address_hobby.add(Box.createHorizontalStrut(0));
        panelbox_hobby.add(chkReading);
        panelbox_hobby.add(chkSinging);
        panelbox_hobby.add(chkDancing);

        /////////////////////////////////////////////////////////////////
        JPanel panel_sex = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lb5 = new JLabel("Sex:");
        
        JPanel panelbox_sex = new JPanel();
        panelbox_sex.setLayout(new BoxLayout(panelbox_sex, BoxLayout.Y_AXIS));
        panelbox_sex.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JRadioButton rdoMale = new JRadioButton("Male");
        JRadioButton rdoFemale = new JRadioButton("Female");
        ButtonGroup buttonGroup = new ButtonGroup();
        
        buttonGroup.add(rdoMale);
        buttonGroup.add(rdoFemale);
        
        panelbox_sex.add(rdoMale);
        panelbox_sex.add(rdoFemale);
        
        panel_sex.add(Box.createHorizontalStrut(25));
        panel_sex.add(lb5);
        panel_sex.add(Box.createHorizontalStrut(10));
        panel_sex.add(panelbox_sex);
        /////////////////////////////////////////////////////////////////

        JPanel panel_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btn_signup = new JButton("Validate");
        JButton btn_cancel = new JButton("Reset");
        panel_button.add(btn_signup);
        panel_button.add(Box.createHorizontalStrut(10));
        panel_button.add(btn_cancel);
        btn_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkNull()) {
                    String str = "";
                    str = "Name: " + txf_name.getText() + "\n";
                    str = str + "Address: " + txf_address.getText() + "\n";
                    if (rdoMale.isSelected()) {
                        str = str + "Sex: Male\n";
                    } else {
                        str = str + "Sex: Female\n";
                    }
                    
                    str = str + "Qualification: " + cboQ.getSelectedItem() + "\n";
                    
                    if (chkDancing.isSelected()) {
                        str = str + "Hobby: Dancing\n";
                    }
                    if (chkReading.isSelected()) {
                        str = str + "Hobby: Reading\n";
                    }
                    if (chkSinging.isSelected()) {
                        str = str + "Hobby: Singing\n";
                    }
                    JOptionPane.showMessageDialog(jf, str);
                }
                
            }
        }
        );
        
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txf_name.setText("");
                txf_address.setText("");
                rdoMale.setSelected(true);
                cboQ.setSelectedIndex(0);
                chkReading.setSelected(true);
                chkSinging.setSelected(false);
                chkDancing.setSelected(false);
            }
        });
        /////////////////////////////////////////////////////////////////
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(panel_name_qualification);
        
        mainPanel.add(panel_address_hobby);
        
        mainPanel.add(panel_sex);
        
        mainPanel.add(panel_button);
        
        jf.getContentPane()
                .add(mainPanel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jf.setVisible(
                true);
        jf.setSize(
                520, 300);
        jf.setLocationRelativeTo(
                null);
        jf.setResizable(
                false);
        
    }
    
    public static boolean checkNull() {
        if (txf_name.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "chưa nhập tên");
            txf_name.requestFocus();
            return false;
        }
        if (txf_name.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "chưa nhập địa chỉ");
            txf_address.requestFocus();
            return false;
        }
        
        return true;
    }
    
}
