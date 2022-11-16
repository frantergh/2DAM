/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class ConexionDB {

    public Connection abrirConexion() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        String urlOdbc = "jdbc:mysql://localhost:3306/clientesdb";

        String user = "root";
        String password = "";
        con = (java.sql.DriverManager.getConnection(urlOdbc, user, password));
        return con;
    }

    public void cerrarConexion(Connection con) {

        if (con != null)
      
      
      
      try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
