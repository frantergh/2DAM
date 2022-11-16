/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Cliente;
//import entidad.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ClienteDao {

    public void insertaCliente(Connection con, Cliente cliente) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO cliente(DNI, Nombre, Apellido1, Apellido2, Nick, "
                    + "Password, Saldo, Moroso) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, cliente.getDni());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido1());
            stmt.setString(4, cliente.getApellido2());
            stmt.setString(5, cliente.getNick());
            stmt.setString(6, cliente.getPassword());
            stmt.setFloat(7, cliente.getSaldo());
            if (cliente.isMoroso()) {
                stmt.setInt(8, 1);
            } else {
                stmt.setInt(8, 0);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al insertar cliente " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close(); // Cerramos el statement
            }
        }
    }

    public void actualizaCliente(Connection con, Cliente cliente) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE cliente SET Nombre=?,Apellido1=?,Apellido2=?,"
                    + "Nick=?,Password=?,Saldo=?,Moroso=? WHERE DNI=?");
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido1());
            stmt.setString(3, cliente.getApellido2());
            stmt.setString(4, cliente.getNick());
            stmt.setString(5, cliente.getPassword());
            stmt.setFloat(6, cliente.getSaldo());
            if (cliente.isMoroso()) {
                stmt.setInt(7, 1);
            } else {
                stmt.setInt(7, 0);
            }
            stmt.setInt(8, cliente.getDni());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar cliente " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close(); // Cerramos el statmen          
            }
        }
    }

    public void borraCliente(Connection con, int dni) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE DNI=?");
            stmt.setInt(1, dni);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Ha habido un problema al dar de baja cliente " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close(); // Ceramos el Statment
            }
        }
    }

    public Cliente buscaClienteByDNI(Connection con, int dni) throws Exception {
        Cliente cliente = new Cliente();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE DNI=?");
            stmt.setInt(1, dni);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setDni(rs.getInt("DNI"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido1(rs.getString("Apellido1"));
                cliente.setApellido2(rs.getString("Apellido2"));
                cliente.setNick(rs.getString("Nick"));
                cliente.setPassword(rs.getString("Password"));
                cliente.setSaldo(rs.getFloat("Saldo"));
                if (rs.getInt("Moroso") == 0) {
                    cliente.setMoroso(false);
                } else {
                    cliente.setMoroso(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el cliente por dni " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();  //Cerramos resultset
            }
            if (stmt != null) {
                stmt.close(); //Cerramos el statement
            }        }
        return cliente;
    }

    public void listarClientes(Connection con, ArrayList<Cliente> listaCli) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if (!listaCli.isEmpty()) {
            listaCli.removeAll(listaCli);
        }

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                obtenClienteFila(rs, cli);
                listaCli.add(cli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al buscar los clientes " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();  // Cerramos el resulset
            }
            if (stmt != null) {
                stmt.close();  // Cerrramos el Statement
            }
        }
    }

    private void obtenClienteFila(ResultSet rs, Cliente cliente) throws SQLException {
        cliente.setDni(rs.getInt("DNI"));
        cliente.setNombre(rs.getString("Nombre"));
        cliente.setApellido1(rs.getString("Apellido1"));
        cliente.setApellido2(rs.getString("Apellido2"));
        cliente.setNick(rs.getString("Nick"));
        cliente.setPassword(rs.getString("Password"));
        cliente.setSaldo(rs.getFloat("Saldo"));
        if (rs.getInt("Moroso") == 0) {
            cliente.setMoroso(false);
        } else {
            cliente.setMoroso(true);
        }
    }
}
