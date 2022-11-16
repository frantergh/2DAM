/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionficheros;

import java.io.File;
import java.lang.System.Logger;
import java.util.Scanner;
import java.util.logging.Level;

/**
 *
 * 
 * 
 * @author frant
 */
public class App {
    
    GestionFicheros gf = new GestionFicheros();
   
    
 System.out.println("\n Carpeta actual es:" + gf.getCarpetaActual());
    
    //ESTABLECER UNA CARPETA COMO ACTUAL Y MOSTRAR SU CONTENIDO

    System.out.println ("\n Introduce el nombre de la carpeta de trabajo");
path = teclado.nextLine();
try{
gf.setCarpetaActual (path);
//mostrar el contenido de la carpeta actual
gf.mostrarContenido();
} catch (GestionFicherosException ex){
Logger.getLogger(App.class.getName()).1og(Level.SEVERE, null, ex);
}




public static void main(String[]args){
Scanner teclado = new Scanner (System.in);
String path;
File carpetaInicial = null;
//POR DErECTO LA CARPETA ACTUAL ES LA RAIZ DEL sISTEMA DE ARCHTVOS

GestionFicheros gf = new GestionFicheros();
System.out.println ("nCarpeta actual es: "+gf.getCarpetaActual());

//ESTABLECER UNA CARFETA COMO ACTUAL Y HOSTRAR SU CONTENIDO
System.out.println("\nIntzodiuce el nombre de la carpeta de tzabajo."
+"INDICa LA RUTA ABSOLUTA DESDE LA BAIZ");
path = teclado.nextLine();
gf.setCarpetaActual(path);//Logger.getLogger(App.class.getName()).1og(Level.SEVERE, nul1, ex);
gf.mostrarContenido();
//ENTRAR EN UNA SUBCARPETA DE LA CARPETA ACTUAL
System.out.println ("\n A que SUBCARPETA quieres entrar?. " 
+ "INDICA EL WOMBRE DE UNA CARPETA DE LA CARPETA ACTUAL ");
path = teclado.nextLine();

   try{
gf.entraA (path);
gf.mostrarContenido();
   }catch (GestionFicherosException ex){
//Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
   }
//sUBIR A LA CARPETA PADRE
System. out.println("rouseres salir del ds zectorio 5/9");
String respuesta = teclado.nextLine();
if (respuesta. equals ("S") ){
gf.amunt();
System.out.println ("1a carpeta actual ahora es: "+gf.getNombreCorto());
gf.mostrarContenido();


}
}
}