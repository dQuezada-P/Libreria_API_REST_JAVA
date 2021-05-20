/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Dao {
    public static Connection getConnection() {
        Connection connection = null;
      
        try {
            try {
                // retornar el obj connexion
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
       connection = DriverManager.getConnection("jdbc:sqlite:D:/Escritorio/Barra de Tareas/Projects/Java Api Rest/Libreria_API_REST_JAVA/src/db/libreria.db");
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return connection;
    }
}
