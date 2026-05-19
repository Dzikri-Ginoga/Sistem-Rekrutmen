/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Recruit;

/**
 *
 * @author ACER
 */

import Controller.ControllerRecruit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputData extends JFrame{
    private JLabel lblNama, lblPath, lblWriting, lblCoding, lblInterview;
    private JTextField txNama, txWriting, txCoding, txInterview;
    private JComboBox<String> cmbPath;
    private JButton btnSimpan, btnKembali;
    
    private ControllerRecruit controller;
            
    public InputData(){
        setTitle("Input Data Kandidat Bari");
        setSize(420, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblNama = new JLabel("Nama: ");
        lblNama.setBounds(30, 30, 120, 25);
        add(lblNama);
        
        txNama = new JTextField();
        txNama.setBounds(170, 30, 200,25);
        add(txNama);
        
        lblPath = new JLabel("Path / Posisi");
        lblPath.setBounds(30, 70, 120, 25);
        add(lblPath);
        
        String[] pilihanPath = {"Android Developer", "Web Developer"};
        cmbPath = new JComboBox<>(pilihanPath);
        cmbPath.setBounds(170, 70, 200, 25);
        add(cmbPath);
        
        lblWriting = new JLabel("Nilai Writing: ");
        lblWriting.setBounds(30, 110, 120, 25);
        add(lblWriting);
        
        txWriting = new JTextField();
        txWriting.setBounds(170, 110, 200, 25);
        add(txWriting);
        
        lblCoding = new JLabel("Nilai Coding: ");
        lblCoding.setBounds(30, 150, 120, 25);
        add(lblCoding);
        
        txCoding = new JTextField();
        txCoding.setBounds(170, 150, 200, 25);
        add(txCoding);
        
        lblInterview = new JLabel("Nilai Iterview: ");
        lblInterview.setBounds(30, 190, 120, 25);
        add(lblInterview);
        
        txInterview = new JTextField();
        txInterview.setBounds(170, 190, 200, 25);
        add(txInterview);
        
        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(70, 260, 110, 30);
        add(btnSimpan);
        
        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(220, 260, 110, 30);
        add(btnKembali);
        
        controller = new ControllerRecruit(this);
        
        btnSimpan.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e){
                controller.tambahData();
            }
        });
        
        btnKembali.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
               new ViewData().setVisible(true);
           }
        });     
    }
    
    public String getInputNama() { return txNama.getText(); }
    public String getInputPath() { return cmbPath.getSelectedItem().toString(); }
    public String getInputWriting() { return txWriting.getText(); }
    public String getInputCoding() { return txCoding.getText(); }
    public String getInputInterview() { return txInterview.getText(); }
}
