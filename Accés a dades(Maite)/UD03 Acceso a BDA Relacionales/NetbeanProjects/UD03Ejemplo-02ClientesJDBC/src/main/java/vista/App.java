/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.ConexionDB;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cliente;

/**
 *
 * @author mati
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Cliente> listadoClientes = new ArrayList();

        Scanner teclado = new Scanner(System.in);
        int opcion, opcionModif, dni;
        String nombre, apellido1, apellido2, nick, password;
        Cliente cliNuevosDatos, cliActivo;
        Cliente cliente = new Cliente();
        // accedir als metodes de la clase client, i q 
        ConexionDB conexionDB = new ConexionDB();
        Connection con = null;

        try {
            con = conexionDB.abrirConexion();

            do {
                menuPrincipal();
                opcion = introOpcion();
                switch (opcion) {
                    case 1:      //  CLIENTES 
                        do {
                            menuClientes();
                            opcion = introOpcion();
                            switch (opcion) {
                                case 1:      //  Alta cliente
                                    cliActivo = pideDatosCliente();
                                    cliActivo.insertaClienteBBDD(con);
                                    System.out.println("Cliente añadido");
                                    break;

                                case 2:    //   Modificacion cliente
                                    System.out.println("Introduce el dni del cliente a modificar");
                                    dni = teclado.nextInt();
                                    cliente = new Cliente(dni);
                                    cliActivo = cliente.buscaClienteByDNI(con);
                                    if (cliActivo == null) {
                                        System.out.println("El cliente no existe en la base de datos");
                                    } else {
                                        System.out.println("Introduce los nuevos datos del cliente: ");
                                        cliNuevosDatos = pideDatosClienteModificacion(dni);
                                        cliNuevosDatos.actualizaClienteBBDD(con);
                                        System.out.println("Cliente modificado");
                                    }
                                    break;

                                case 3:     //  Baja cliente
                                    System.out.println("Introduce el dni del cliente a eliminar");
                                    dni = teclado.nextInt();
                                    cliente = new Cliente(dni);
                                    cliActivo = cliente.buscaClienteByDNI(con);
                                    if (cliActivo == null) {
                                        System.out.println("El cliente no existe en la base de datos");

                                    } else {
                                        cliActivo.borraClienteBBDD(con);
                                        System.out.println("Cliente eliminado");
                                    }

                                    break;

                                case 4:    //  Listado de clientes
                                    cliente.listarClientes(con, listadoClientes);
                                    mostrarClientes(listadoClientes);
                                    break;

                                case 5:       // Volver
                                    break;

                                default:
                                    System.out.println("Opcion no valida");
                            }
                        } while (opcion != 5);
                        break;

                    case 0:     // Volver
                        break;

                    default:
                        System.out.println("Opcion no valida");
                }
            } while (opcion != 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionDB.cerrarConexion(con);  // Cerramos la conexion
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int introOpcion() {
        int numero;
        Scanner teclado = new Scanner(System.in);

        numero = teclado.nextInt();
        return numero;
    }

    public static void menuPrincipal() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("**************");
        System.out.println("");
        System.out.println("1---> Clientes");

        System.out.println("0---> Salir");
    }

    public static void menuClientes() {
        System.out.println("MENÚ CLIENTES");
        System.out.println("**************");
        System.out.println("");
        System.out.println("1---> Alta de clientes");
        System.out.println("2---> Modificacion de clientes");
        System.out.println("3---> Baja de clientes");
        System.out.println("4---> Listado de clientes");
        System.out.println("5---> Volver");
    }

    public static Cliente pideDatosCliente() {
        Scanner teclado = new Scanner(System.in);
        int dni;
        String nombre, apellido1, apellido2, nick, password;
        Cliente cli = null;

        System.out.println("introduce dni: ");
        dni = teclado.nextInt();
        System.out.println("introduce nombre: ");
        nombre = teclado.next();
        System.out.println("introduce apellido1: ");
        apellido1 = teclado.next();
        System.out.println("introduce apellido2: ");
        apellido2 = teclado.next();
        System.out.println("introduce nick: ");
        nick = teclado.next();
        System.out.println("introduce password: ");
        password = teclado.next();

        cli = new Cliente(dni, nombre, apellido1, apellido2, nick, password);

        return cli;
    }

    public static Cliente pideDatosClienteModificacion(int dni) {
        Scanner teclado = new Scanner(System.in);
        String nombre, apellido1, apellido2, nick, password;
        Cliente cli1;

        System.out.println("Introduce el nombre");
        nombre = teclado.next();
        System.out.println("Introduce apellido1");
        apellido1 = teclado.next();
        System.out.println("Introduce apellido2");
        apellido2 = teclado.next();
        System.out.println("Introduce el nick");
        nick = teclado.next();
        System.out.println("Introduce el password");
        password = teclado.next();

        cli1 = new Cliente(dni, nombre, apellido1, apellido2, nick, password);

        return cli1;
    }

    public static void mostrarClientes(ArrayList<Cliente> clis) {
        String moros;
        System.out.printf("%15s %15s %15s %15s %10s %10s %10s %20s\n", "DNI", "NOMBRE", "APELLIDO1", "APELLIDO2",
                "NICK", "PSSW", "SALDO", "MOROSIDAD");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < clis.size(); i++) {
            if (clis.get(i).isMoroso()) {
                moros = Boolean.toString(clis.get(i).isMoroso());
                System.out.printf("%15s %15s %15s %15s %10s %10s %10.2f %20s\n", Integer.toString(clis.get(i).getDni()), clis.get(i).getNombre(),
                        clis.get(i).getApellido1(), clis.get(i).getApellido2(), clis.get(i).getNick(), clis.get(i).getPassword(),
                        clis.get(i).getSaldo(), moros);
            } else {
                moros = Boolean.toString(clis.get(i).isMoroso());
                System.out.printf("%15s %15s %15s %15s %10s %10s %10.2f %20s\n", Integer.toString(clis.get(i).getDni()), clis.get(i).getNombre(),
                        clis.get(i).getApellido1(), clis.get(i).getApellido2(), clis.get(i).getNick(), clis.get(i).getPassword(),
                        clis.get(i).getSaldo(), moros);
            }
        }
    }

}
