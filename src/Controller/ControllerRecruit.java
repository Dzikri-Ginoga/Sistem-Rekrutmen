package Controller;

import View.Recruit.ViewData;
import View.Recruit.InputData;
import View.Recruit.EditData;
import Model.Recruit.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerRecruit {
    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanUpdate;
    
    InterfaceDAORecruit daoRecruit;
    List<ModelRecruit> recruitList;
    
    // Constructor untuk ViewData
    public ControllerRecruit(ViewData halamanTable){
        this.halamanTable = halamanTable;
        this.daoRecruit = new DAORecruit();
    }
    
    // Constructor untuk InputData
    public ControllerRecruit(InputData halamanInput){
        this.halamanInput = halamanInput;
        this.daoRecruit = new DAORecruit();
    }
    
    // Constructor untuk EditData
    public ControllerRecruit(EditData halamanUpdate){
        this.halamanUpdate = halamanUpdate;
        this.daoRecruit = new DAORecruit();
    }
    
    // 1. Method Tampil Data
    public void tampilkanData(){
        recruitList = daoRecruit.getAll();
        ModelTable tabel = new ModelTable(recruitList);
        halamanTable.table.setModel(tabel);
    }
    
    // 2. Method Tambah Data
    public void tambahData(){
        try {
            String nama = halamanInput.getInputNama();
            String path = halamanInput.getInputPath();
            
            if(nama.trim().isEmpty() || halamanInput.getInputWriting().isEmpty() || 
               halamanInput.getInputCoding().isEmpty() || halamanInput.getInputInterview().isEmpty()){
               JOptionPane.showMessageDialog(halamanInput, "Semua form harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
               return;
            }
            
            
            int writing   = Integer.parseInt(halamanInput.getInputWriting());
            int coding    = Integer.parseInt(halamanInput.getInputCoding());
            int interview = Integer.parseInt(halamanInput.getInputInterview());
            
            ModelRecruit recruit = new ModelRecruit();
            recruit.setNama(nama);
            recruit.setPath(path);
            recruit.setWriting(writing);
            recruit.setCoding(coding);
            recruit.setInterview(interview);
            recruit.hitungScore();
            recruit.tentukanStatus();
            
            daoRecruit.insert(recruit);
            
            JOptionPane.showMessageDialog(halamanInput, "Data berhasil ditambahkan!");
            halamanInput.dispose();
            new ViewData().setVisible(true);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(halamanInput, "Nilai harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void pindahKeEdit(int baris){
        ModelRecruit recruitYangDipilih = recruitList.get(baris);
        new EditData(recruitYangDipilih).setVisible(true);
    }
    
    public void updateData(){
        try {
            String nama = halamanUpdate.getInputNama();
            String path = halamanUpdate.getInputPath();
            
            if (halamanUpdate.getInputWriting().isEmpty() || halamanUpdate.getInputCoding().isEmpty() || halamanUpdate.getInputInterview().isEmpty()) {
                JOptionPane.showMessageDialog(halamanUpdate, "Semua form nilai harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int writing   = Integer.parseInt(halamanUpdate.getInputWriting());
            int coding    = Integer.parseInt(halamanUpdate.getInputCoding());
            int interview = Integer.parseInt(halamanUpdate.getInputInterview());

            ModelRecruit recruit = new ModelRecruit();
            recruit.setId(halamanUpdate.getRecruitId()); 
            recruit.setNama(nama);
            recruit.setPath(path);
            recruit.setWriting(writing);
            recruit.setCoding(coding);
            recruit.setInterview(interview);
            recruit.hitungScore();
            recruit.tentukanStatus();
            
            daoRecruit.update(recruit);
            
            JOptionPane.showMessageDialog(halamanUpdate, "Data kandidat berhasil diubah!");
            halamanUpdate.dispose();
            new ViewData().setVisible(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(halamanUpdate, "Input nilai tes harus berupa angka!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 5. Method Hapus Data (Dibutuhkan oleh ViewData)
    public void hapusData(int baris){
        int id = recruitList.get(baris).getId();
        
        daoRecruit.delete(id);
        JOptionPane.showMessageDialog(halamanTable, "Data kandidat berhasil dihapus!");
        tampilkanData();
    }
}