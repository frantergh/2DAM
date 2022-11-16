/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        String urlOdbc = "jdbc:mysql://localhost:3306/clientesdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        String user="root";
        String password="";
        con = (java.sql.DriverManager.getConnection(urlOdbc, user, password));
        return con;

    }
    public void cerrarConexion(Connection con){
        if(con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
