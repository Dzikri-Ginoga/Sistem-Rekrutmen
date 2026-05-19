/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Recruit;

import java.util.*;
/**
 *
 * @author ACER
 */
public interface InterfaceDAORecruit {
    public void insert(ModelRecruit recruit);
    public void update (ModelRecruit recruit);
    public void delete(int id);
    
    public List<ModelRecruit> getAll();
}
