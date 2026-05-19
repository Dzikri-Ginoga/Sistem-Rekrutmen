/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Recruit;

/**
 *
 * @author ACER
 */

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel{
    List<ModelRecruit> daftarRecruit;
    String kolom[] = {"ID", "Nama", "Path", "Writing", "Coding", "Interview", "Score", "Status"};
    
    public ModelTable(List<ModelRecruit> daftarRecruit){
        this.daftarRecruit = daftarRecruit;
    }

    @Override
    public int getRowCount() {
        return daftarRecruit.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0:
               return daftarRecruit.get(rowIndex).getId();
           case 1: 
               return daftarRecruit.get(rowIndex).getNama();
           case 2:
               return daftarRecruit.get(rowIndex).getPath();
           case 3: 
               return daftarRecruit.get(rowIndex).getWriting();
           case 4:
               return daftarRecruit.get(rowIndex).getCoding();
           case 5:
               return daftarRecruit.get(rowIndex).getInterview();
           case 6: 
               return daftarRecruit.get(rowIndex).getScore();
           case 7: 
               return daftarRecruit.get(rowIndex).getStatus();
           default:
               return null;
       }
    }
    
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }
    
}
