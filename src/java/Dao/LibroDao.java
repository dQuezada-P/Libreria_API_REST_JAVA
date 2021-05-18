/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Class.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class LibroDao {
    
    public LibroDao(){
        
    }
    
    public String create(Libro libro) throws SQLException{
        Connection conn = Dao.getConnection();
        
        try{
            String sql = "insert into libro(isbn,titulo,editorial,anno,autor1,autor2,precio) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getEditorial());
            ps.setString(4, libro.getAnno());
            ps.setString(5, libro.getAutor1());
            ps.setString(6, libro.getAutor2());
            ps.setInt(7, libro.getPrecio());
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
            conn.close();
            
            return "";
            
        }catch(SQLException sqlEx){
            System.out.println(sqlEx.getMessage());
            conn.close();
            return sqlEx.getMessage();
        }
        //PreparedStatement
    }
    
    public int getLastId(){
        Connection conn = Dao.getConnection();
        int res = -1;
        try{
            String sql = "select max(id) from libro";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            res = rs.getInt(1);
            conn.close();
            
        }catch(SQLException sqlEx){
            System.out.println(sqlEx.getMessage());
        }
        return res;
    }
}
