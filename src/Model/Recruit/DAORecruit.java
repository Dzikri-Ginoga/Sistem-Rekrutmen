/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Recruit;
import Model.Connector;

import java.sql.*;
import java.util.*;
/**
 *
 * @author ACER
 */
public class DAORecruit implements InterfaceDAORecruit {

    @Override
    public void insert(ModelRecruit recruit) {
        try{
           
            String query = "INSERT INTO recruit (nama, path, writing, coding, interview, score, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps;
            ps = Connector.Connect().prepareStatement(query);
            ps.setString(1, recruit.getNama());
            ps.setString(2, recruit.getPath());
            ps.setInt(3, recruit.getWriting());
            ps.setInt(4, recruit.getCoding());
            ps.setInt(5, recruit.getInterview());
            ps.setDouble(6, recruit.getScore());
            ps.setString(7, recruit.getStatus());
            
            ps.executeUpdate();
            
            ps.close();

        } catch(SQLException e){
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelRecruit recruit) {
        try{
            String query = "UPDATE recruit SET nama=?, path=?, writing=?, coding=?, interview=?, score=?, status=? WHERE id=?";
            
            PreparedStatement ps;
            ps = Connector.Connect().prepareStatement(query);
            ps.setString(1, recruit.getNama());
            ps.setString(2, recruit.getPath());
            ps.setInt(3, recruit.getWriting());
            ps.setInt(4, recruit.getCoding());
            ps.setInt(5, recruit.getInterview());
            ps.setDouble(6, recruit.getScore());
            ps.setString(7, recruit.getStatus());
            ps.setInt(8, recruit.getId());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e){
             System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
        
    }

    @Override
    public void delete(int id) {
     try{
         String query = "DELETE FROM recruit WHERE id=?;";
         
         PreparedStatement ps;
         ps = Connector.Connect().prepareStatement(query);
         ps.setInt(1, id);
         
         ps.executeUpdate();
            
         ps.close();
         
     } catch(SQLException e){
        System.out.println("Input Failed: " + e.getLocalizedMessage());
     }
     
    }

    @Override
    public List<ModelRecruit> getAll() {
        List<ModelRecruit> listRecruit = null;
        
        try{
            listRecruit = new ArrayList<>();
            
            Statement statement = Connector.Connect().createStatement();
            
            String query = "SELECT * FROM recruit";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                ModelRecruit mre = new ModelRecruit();
                
                mre.setId(rs.getInt("id"));
                mre.setNama(rs.getString("nama"));
                mre.setPath(rs.getString("path"));
                mre.setWriting(rs.getInt("writing"));
                mre.setCoding(rs.getInt("coding"));
                mre.setInterview(rs.getInt("interview"));
                mre.setScore(rs.getDouble("score"));
                mre.setStatus(rs.getString("status"));
                
                listRecruit.add(mre);
            }
            statement.close();
        } catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        
        return listRecruit;
    }
    
    
    
    
    
}
