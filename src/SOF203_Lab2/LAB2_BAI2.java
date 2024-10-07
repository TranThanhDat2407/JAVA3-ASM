/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author THANHDAT
 */
public class LAB2_BAI2 implements Calculator {

    private String phepTinh;
    private double valueSeTinh;

    JLabel lblSo;
    JLabel lblText;

    public LAB2_BAI2() {
        initComp();
    }

    JFrame jMain;
    int x = 5, y = 5, w = 400, h = 450;
    String[] btnName = {"1", "2", "3", "/", "sqrt",
        "4", "5", "6", "*", "%",
        "7", "8", "9", "-", "1/x",
        "0", "+/-", "C", "+", "="};
    JButton[] btnS;

    public void initComp() {
        jMain = new JFrame();
        jMain.setSize(w, h);
        jMain.setLocationRelativeTo(null);
        jMain.setDefaultCloseOperation(3);
        jMain.setTitle("Calculator");
        //main
        JPanel pMain = new JPanel();
        pMain.setLayout(null);
        //Label Casio
        JLabel lblCasio = new JLabel("Casio", JLabel.RIGHT);
        Font font1 = new Font("Tahoma", Font.BOLD, 18);
        lblCasio.setFont(font1);
        lblCasio.setBounds(x, y, w - 30, 50);
        y += 50;
        //Label số
        lblSo = new JLabel("", JLabel.RIGHT);
        Font font2 = new Font("Tahoma", Font.PLAIN, 18);
        lblSo.setForeground(Color.BLUE);
        lblSo.setFont(font2);
        lblSo.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        lblSo.setBounds(x, y, w - 30, 50);
        y += 70;
        //Label kết quả
        lblText = new JLabel("", JLabel.RIGHT);
        Font font3 = new Font("Tahoma", Font.PLAIN, 18);
        lblText.setForeground(Color.GREEN);
        lblText.setFont(font3);
        lblText.setBounds(x, y, w - 30, 50);
        y += 70;
        //btn
        JPanel pButton = new JPanel(new GridLayout(4, 5, 5, 5));
        btnS = new JButton[btnName.length];
        for (int i = 0; i < btnName.length; i++) {
            btnS[i] = new JButton(btnName[i]);
            pButton.add(btnS[i]);
            btnS[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = e.getActionCommand();
                    switch (s) {
                        case "0":
                            lblSo.setText(lblSo.getText() + "0");
                            break;
                        case "1":
                            lblSo.setText(lblSo.getText() + "1");
                            break;
                        case "2":
                            lblSo.setText(lblSo.getText() + "2");
                            break;
                        case "3":
                            lblSo.setText(lblSo.getText() + "3");
                            break;
                        case "4":
                            lblSo.setText(lblSo.getText() + "4");
                            break;
                        case "5":
                            lblSo.setText(lblSo.getText() + "5");
                            break;
                        case "6":
                            lblSo.setText(lblSo.getText() + "6");
                            break;
                        case "7":
                            lblSo.setText(lblSo.getText() + "7");
                            break;
                        case "8":
                            lblSo.setText(lblSo.getText() + "8");
                            break;
                        case "9":
                            lblSo.setText(lblSo.getText() + "9");
                            break;
                        case "C":
                            lblSo.setText("");
                            lblText.setText("");
                            break;
                        case "/":
                            phepTinh = "/";
                            if (lblText.getText().length() > 0) {
                                valueSeTinh = Double.parseDouble(lblSo.getText());
                            }
                            truValueSeTinh(phepTinh);
                            break;
                        case "+":
                            phepTinh = "+";
                            if (lblText.getText().length() > 0) {
                                valueSeTinh = Double.parseDouble(lblSo.getText());
                            }
                            truValueSeTinh(phepTinh);
                            break;
                        case "-":
                            phepTinh = "-";
                            if (lblText.getText().length() > 0) {
                                valueSeTinh = Double.parseDouble(lblSo.getText());
                            }
                            truValueSeTinh(phepTinh);
                            break;
                        case "*":
                            phepTinh = "*";
                            if (lblText.getText().length() > 0) {
                                valueSeTinh = Double.parseDouble(lblSo.getText());
                            }
                            truValueSeTinh(phepTinh);
                            break;
                        case "=":
                            if (lblSo.getText().length() > 0) {
                                double b = Double.parseDouble(lblSo.getText());
                                switch (phepTinh) {
                                    case "+":
                                        add(valueSeTinh, b);
                                        break;
                                    case "-":
                                        substract(valueSeTinh, b);
                                        break;
                                    case "*":
                                        multiply(valueSeTinh, b);
                                        break;
                                    case "/":
                                        divide(valueSeTinh, b);
                                        break;
                                }
                            }
                            break;
                        case "+/-":
                            String value = lblSo.getText();
                            if (!value.contains("-")) {
                                lblSo.setText("-" + value);
                            } else {
                                try {
                                    lblSo.setText(value.split("-")[1]);
                                } catch (IndexOutOfBoundsException de) {
                                    lblSo.setText("");
                                }
                            }
                            break;
                        case "%":
                            if (lblText.getText().length() > 0 && lblSo.getText().length() > 0) {
                                valueSeTinh = Double.parseDouble(lblSo.getText());
                                phanTram(Double.parseDouble(lblText.getText().split(" ")[0]), valueSeTinh);
                            }
                            break;
                        case "sqrt":
                            valueSeTinh = Double.parseDouble(lblSo.getText());
                            lblSo.setText(Double.toString(Math.sqrt(valueSeTinh)));
                            break;
                        case "1/x":
                            if (lblSo.getText().length() > 0) {
                                valueSeTinh = Double.parseDouble(lblSo.getText());
                                lblSo.setText(Double.toString(1 / valueSeTinh));
                            }
                            break;

                    }
                }
            });
        }
        pButton.setBounds(x, y, w - 30, 200);

        pMain.add(lblCasio);
        pMain.add(lblSo);
        pMain.add(lblText);
        pMain.add(pButton);

        jMain.add(pMain);
        jMain.setVisible(true);
    }

    public static void main(String[] args) {

        LAB2_BAI2 t = new LAB2_BAI2();
    }

    @Override
    public void add(double a, double b) {
        setResult(a + b);
    }

    @Override
    public void substract(double a, double b) {
        setResult(a - b);
    }

    @Override
    public void multiply(double a, double b) {
        setResult(a * b);
    }

    @Override
    public void divide(double a, double b) {
        setResult(a / b);
    }

    private void setResult(double result) {
        lblText.setText(Double.toString(result));
        lblSo.setText("");
    }

    private void truValueSeTinh(String pheptinh) {
        String value = lblSo.getText();
        valueSeTinh = Double.parseDouble(value);
        lblText.setText(value + " " + pheptinh);
        lblSo.setText("");
    }

    private void phanTram(double a, double b) {
        switch (phepTinh) {
            case "+":
                add((a * b) / 100, a);
                break;
            case "-":
                substract((a * b) / 100, a);
                break;
            case "*":
                multiply((a * b) / 100, a);
                break;
            case "/":
                divide((a * b) / 100, a);
                break;
        }
    }

}
