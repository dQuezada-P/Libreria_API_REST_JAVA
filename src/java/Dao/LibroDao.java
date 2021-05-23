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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class LibroDao {

    /*public static void main(String args[]){
        Libro libro = new Libro();
        libro.setIsbn("2");
        libro.setTitulo("titulo");
        libro.setPrecio(2000);
        
        update(libro);
        
    }*/
    
    public LibroDao() {

    }

    public String create(Libro libro) throws SQLException {
        Connection conn = Dao.getConnection();

        try {
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

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
            conn.close();
            return sqlEx.getMessage();
        }
        //PreparedStatement
    }

    public int update(Libro libro) {
        Connection conn = Dao.getConnection();
        int rs = 0;
        try {
            String sql = "update libro set";
            sql += libro.getIsbn() == null ? "" : " isbn=?,";
            sql += libro.getTitulo() == null ? "" : " titulo=?,";
            sql += libro.getEditorial()== null ? "" : " editorial=?,";
            sql += libro.getAnno()== null ? "" : " anno=?,";
            sql += libro.getAutor1()== null ? "" : " autor1=?,";
            sql += libro.getAutor2()== null ? "" : " autor2=?,";
            sql += libro.getPrecio()== 0 ? "" : " precio=?,";
            
            sql = sql.substring(sql.length()-1).equals(",") ? sql.substring(0, sql.length()-1) : sql;
            
            sql += " where id = ?";
            //System.out.println(sql);
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            int cont = 1;
            if (libro.getIsbn() != null) {
                ps.setString(cont, libro.getIsbn());
                cont++;
            }
            if (libro.getTitulo() != null) {
                ps.setString(cont, libro.getTitulo());
                cont++;
            }
            if (libro.getEditorial() != null) {
                ps.setString(cont, libro.getEditorial());
                cont++;
            }
            if (libro.getAnno() != null) {
                ps.setString(cont, libro.getAnno());
                cont++;
            }
            if (libro.getAutor1() != null) {
                ps.setString(cont, libro.getAutor1());
                cont++;
            }
            if (libro.getAutor2() != null) {
                ps.setString(cont, libro.getAutor2());
                cont++;
            }
            if (libro.getPrecio() != 0) {
                ps.setInt(cont, libro.getPrecio());
                cont++;
            }
            if (libro.getId() != 0) {
                ps.setInt(cont, libro.getId());
                cont++;
            }
            rs = ps.executeUpdate();
            conn.close();
        }catch(SQLException sqlEx){
            System.out.println(sqlEx.getMessage());
        }
        return rs;
    }
    
    public int getLastId() {
        Connection conn = Dao.getConnection();
        int res = -1;
        try {
            String sql = "select max(id) from libro";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            res = rs.getInt(1);
            conn.close();

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
        return res;
    }

    public Libro getBook(int id) {

        Connection conn = Dao.getConnection();
        String sql = "select * from libro where id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Libro libro = new Libro(
                    rs.getString("isbn"),
                    rs.getString("titulo"),
                    rs.getString("editorial"),
                    rs.getString("anno"),
                    rs.getString("autor1"),
                    rs.getString("autor2"),
                    rs.getInt("precio"));
            libro.setId(rs.getInt("id"));
            conn.close();
            return libro;

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
            return null;
        }
    }
    
    public List<Libro> getBooks(){
        Connection conn = Dao.getConnection();
        String sql = "select * from libro";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Libro> books = new ArrayList<Libro>();
            
            while (rs.next()){
                Libro libro = new Libro(
                    rs.getString("isbn"),
                    rs.getString("titulo"),
                    rs.getString("editorial"),
                    rs.getString("anno"),
                    rs.getString("autor1"),
                    rs.getString("autor2"),
                    rs.getInt("precio"));
                libro.setId(rs.getInt("id"));
                books.add(libro);
            }
            
            conn.close();
            return books;

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
            return null;
        }
    }
    
    public int deleteBook(int id) throws SQLException{
        
        Connection conn = Dao.getConnection();
        String sql = "delete from libro where id = ?";
        int res = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeUpdate();
            conn.close();
            return res;
        }catch(SQLException sqlEx){
            return res;
        }
        
        
    }
}


