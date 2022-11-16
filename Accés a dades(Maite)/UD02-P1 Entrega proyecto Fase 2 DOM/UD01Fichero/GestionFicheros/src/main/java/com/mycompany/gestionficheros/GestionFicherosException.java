/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionficheros;

import java.io.File;

/**
 *
 * @author frant
 */
public class GestionFicherosException extends Exception {
String m;
    private File carpetaActual;

public GestionFicherosException(String mensaje){
this.m = mensaje;
}
public String toString (){
return m;
}
   public int setCarpetaActual (String carpeta){
File file =new File (carpeta);
if (!file.exists()) {
    return 1;
}
if (!file.isDirectory()) {
        return 2;
}
this.carpetaActual = file;
return 0;
}
  public void setCarpetaActual (File carpetaActual) throws GestionFicherosException{
if (carpetaActual.exists ()){
throw new GestionFicherosException ("Error. No existe azchivo");
}
if (!carpetaActual.isDirectory()){

throw new GestionFicherosException ("Error. No es un directorio");
}
this.carpetaActual = carpetaActual;
  }
   
}
