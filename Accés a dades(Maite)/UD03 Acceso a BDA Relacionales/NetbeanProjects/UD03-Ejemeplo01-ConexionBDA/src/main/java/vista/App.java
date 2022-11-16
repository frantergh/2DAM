/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package vista;

import dao.ConexionDB;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class App {

    public static void main(String[] args) throws SQLException {

        try {
            ConexionDB conexionDB = new ConexionDB();
            System.out.print("abre");
            Connection con = conexionDB.abrirConexion();

            Statement stmt = null;
            stmt.execute("INSERT INTO cliente (dni,nombre,apellido1,apellido2,nick,password,saldo,moroso)"
                    + "VALUES(2044455, 'Maria', 'Bataller', 'Galdon', 'mari', '1234', 1000, 1);"
            );

            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement("UPDATE cliente SET apellido1 ='Blasco' WHERE DNI=?");
            pstmt.setInt(1, 20444666);

            int retorno = pstmt.executeUpdate();
            if (retorno > 0) {
                System.out.print("Registro actualizado");
            }

            System.out.print("Ccierra conexion");
            conexionDB.cerrarConexion(con);
            System.out.print("Conexion Cerrada");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
