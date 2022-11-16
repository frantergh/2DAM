/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.ClienteDao;
import java.sql.Connection;
import java.util.ArrayList;

public class Cliente {

    private int dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nick;
    private String password;
    private boolean moroso;
    private float saldo = 0;
    
    public Cliente(){
    }
    public Cliente(int dni){
        this.dni = dni;
    }

    public Cliente(int dni, String nombre, String apellido1, String apellido2, String nick, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nick = nick;
        this.password = password;
    }

    public void insertaClienteBBDD(Connection con) throws Exception {
        ClienteDao cliDAO = new ClienteDao();
        cliDAO.insertaCliente(con, this);
    }

    public void actualizaClienteBBDD(Connection con) throws Exception {
        ClienteDao cliDAO = new ClienteDao();
        cliDAO.actualizaCliente(con, this);
    }

    public void borraClienteBBDD(Connection con) throws Exception {
        ClienteDao cliDAO = new ClienteDao();
        cliDAO.borraCliente(con, this.dni);
    }
    public Cliente buscaClienteByDNI(Connection con) throws Exception{
        ClienteDao cliDao = new ClienteDao();
        Cliente cli;
              
        cli=cliDao.buscaClienteByDNI(con, this.getDni());
        return cli;
    }
  public void listarClientes(Connection con, ArrayList<Cliente>clis) throws Exception{
        ClienteDao cliDAO = new ClienteDao();
        cliDAO.listarClientes(con,clis);
    }
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMoroso() {
        return moroso;
    }

    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
