/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Recruit;

/**
 *
 * @author ACER
 */
public interface Kalkulasi {
    public double hitungScore() throws IllegalArgumentException;
    public double hitungScore(int writing,  int coding, int interview) throws IllegalArgumentException;
    public String tentukanStatus();
    public String tentukanStatus(double score);
}

