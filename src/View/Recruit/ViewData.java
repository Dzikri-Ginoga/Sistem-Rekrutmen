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
import Model.Recruit.ModelRecruit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ViewData extends JFrame{
    ControllerRecruit controller;
    
    public JTable table;
    public JButton btnTambah, btnEdit, btnHapus;
    private JScrollPane scrollPane;
    private int selectedRow = -1;
    
   
    public ViewData(){
        setTitle("Sistem Rekrutmen");
        setSize(750, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 690, 250);
        add(scrollPane);
        
        btnTambah = new JButton("Tambah Kandidat");
        btnTambah.setBounds(20, 300, 160, 30);
        add(btnTambah);
        
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(200, 300, 160, 30);
        add(btnEdit);
        
        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(380, 300, 160, 30);
        add(btnHapus);
        
        controller = new ControllerRecruit(this);
        controller.tampilkanData();
        
        table.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseClicked(MouseEvent e){
                selectedRow = table.getSelectedRow();
            }
        });
        
        btnTambah.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new InputData().setVisible(true);
            }
            
        });
        
        btnEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(selectedRow != -1){
                    dispose();
                    controller.pindahKeEdit(selectedRow);
                } else{
                    JOptionPane.showMessageDialog(null, "Silahkan pilih baris data terlebih dahulu");
                }
            } 
        });
        
        btnHapus.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                if(selectedRow != -1 ){
                    int konfirmasi = JOptionPane.showConfirmDialog(null,
                            "Apakah anda yakin menghapus data ini", "Konfirmasi Hapus",
                            JOptionPane.YES_NO_OPTION);
                    if(konfirmasi == JOptionPane.YES_OPTION){
                        controller.hapusData(selectedRow);
                        selectedRow = -1;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Silahkan pi;ih baris terlebih dahulu");
                }
            }
            
        });
    }
}
