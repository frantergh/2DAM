/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gestionficheros;

import java.io.File;

/**
 *
 * @author frant
 */
public class GestionFicheros {

private File carpetaActual = null;

public GestionFicheros() {
    this.carpetaActual = File.listRoots() [0];
}
public void setCarpetaActual (File carpetaActual) {
this.carpetaActual=carpetaActual ;

}
public File getCarpetaActual(){
return  this.carpetaActual ;
}
 public void mostrarContenido(){
    String[] listaFicheros = null;
    1istaFicheros = this.carpetaActual.1ist();
    for (String fichero: listaFicheros)
    System.out.println (fichero) ;
    } 

public String getNombreAbsoluto(){
return this.carpetaActual.getAbsolutePath();
}
public String getNombreCorto () {
return this.carpetaActual.getName();

}
public void entraA(String carpeta) throws GestionFicherosException{
File file=new File (this .carpetaActual, carpeta);
if (!file.exists()){
    throw new GestionFicherosException ("Ezror. El fichero no existe") ;
}
if (!file.isDirectory()){
    throw new GestionFicherosException ("Error, se esperaba una carpeta");
  }
this.carpetaActual=file;
}
public GestionFicheros(){
this.carpetaActual =File.listRoots()[0];
}
public GestionFicheros(File fl){
this.carpetaActual =fl;
}
public GestionFicheros(File fl, String f2){
    this.carpetaActual = new File (fl.getAbsolutePath()+ "/"+f2);
}

public void amunt(){
if (carpetaActual.getParentFile()!=null){
this.carpetaActual this.carpetaActual.getParentFile();
        }
}

    void setCarpetaActual(String path) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void amunt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
