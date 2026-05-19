/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Recruit;

/**
 *
 * @author ACER
 */
public class ModelRecruit implements Kalkulasi{
    private int id;
    private String nama, path, status;
    private int writing, coding, interview;
    private double score;
    
    
    
    public int getId(){
        return id;
    }
    
    public String getNama(){
        return nama;
    }

    public String getPath() {
        return path;
    }

    public String getStatus() {
        return status;
    }

    public int getWriting() {
        return writing;
    }

    public int getCoding() {
        return coding;
    }

    public int getInterview() {
        return interview;
    }

    public double getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWriting(int writing) {
        this.writing = writing;
    }

    public void setCoding(int coding) {
        this.coding = coding;
    }

    public void setInterview(int interview) {
        this.interview = interview;
    }

    public void setScore(double score) {
        this.score = score;
    }
    

    @Override
    public double hitungScore() throws  IllegalArgumentException {
        if(coding <= 0 || writing <= 0 || interview <= 0){
            throw new  IllegalArgumentException("Input harus lebih besar dari 0");
        }
        double average = (getWriting() + getCoding() + getInterview()) / 3.0;
        setScore(average);
        
        return average;
    }

    @Override
    public double hitungScore(int writing,  int coding, int interview) throws IllegalArgumentException {
        if(getWriting() <= 0 || getCoding() <= 0 || getInterview() <= 0){
            throw new  IllegalArgumentException("Input harus lebih besar dari 0");
        }
        
        setWriting(writing) ;
        setCoding(coding);
        setInterview(interview);
        
        double average = (writing + coding + interview) / 3.0;
        setScore(average);
        return average;
    }
    
    @Override
    public String tentukanStatus(){
        String result = (getScore() >= 85) ? "Diterima" : "Tidak Diterima";
        
        setStatus(result);
        
        return result;
    }
    
    @Override
    public String tentukanStatus(double score){
        setScore(score);
        
        String result = (score >= 85) ? "Diterima" : "Tidak diterima";
        
        setStatus(result);
        
        return result;
    }
}
