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
import javax.swing.*;

public class EditData extends JFrame{
    private JLabel lblNama, lblPath, lblWriting, lblCoding, lblInterview;
    private JTextField txNama, txWriting, txCoding, txInterview;
    private JComboBox<String> cmbPath;
    private JButton btnUpdate, btnKembali;
    private ControllerRecruit controller;
    private int recruitId; 
    
    public EditData(ModelRecruit recruit){
        this.recruitId = recruit.getId(); // FIX: simpan id
        setTitle("Update Data Kandidat");
        setSize(420, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblNama = new JLabel("Nama Kandidat");
        lblNama.setBounds(30, 30, 120, 25);
        add(lblNama);

        txNama = new JTextField(recruit.getNama());
        txNama.setBounds(170, 30, 200, 25);
        txNama.setEditable(false); 
        add(txNama);

        lblPath = new JLabel("Path / Posisi");
        lblPath.setBounds(30, 70, 120, 25);
        add(lblPath);

        String[] pilihanPath = {"Android Developer", "Web Developer"};
        cmbPath = new JComboBox<>(pilihanPath);
        cmbPath.setSelectedItem(recruit.getPath());
        cmbPath.setBounds(170, 70, 200, 25);
        add(cmbPath);

        lblWriting = new JLabel("Nilai Writing");
        lblWriting.setBounds(30, 110, 120, 25);
        add(lblWriting);

        txWriting = new JTextField(String.valueOf(recruit.getWriting()));
        txWriting.setBounds(170, 110, 200, 25);
        add(txWriting);

        lblCoding = new JLabel("Nilai Coding");
        lblCoding.setBounds(30, 150, 120, 25);
        add(lblCoding);

        txCoding = new JTextField(String.valueOf(recruit.getCoding()));
        txCoding.setBounds(170, 150, 200, 25);
        add(txCoding);

        lblInterview = new JLabel("Nilai Interview");
        lblInterview.setBounds(30, 190, 120, 25);
        add(lblInterview);

        txInterview = new JTextField(String.valueOf(recruit.getInterview()));
        txInterview.setBounds(170, 190, 200, 25);
        add(txInterview);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(70, 260, 110, 30);
        add(btnUpdate);

        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(220, 260, 110, 30);
        add(btnKembali);

        controller = new ControllerRecruit(this);

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.updateData();
            }
        });

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewData().setVisible(true);
            }
        });
    }

    // Method Getter untuk mengirimkan teks perubahan ke Controller
    public int getRecruitId() { return recruitId; }
    public String getInputNama() { return txNama.getText(); }
    public String getInputPath() { return cmbPath.getSelectedItem().toString(); }
    public String getInputWriting() { return txWriting.getText(); }
    public String getInputCoding() { return txCoding.getText(); }
    public String getInputInterview() { return txInterview.getText(); }
    

}