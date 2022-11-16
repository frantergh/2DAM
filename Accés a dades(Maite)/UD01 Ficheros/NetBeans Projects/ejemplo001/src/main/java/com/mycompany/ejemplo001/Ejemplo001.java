/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejemplo001;

import java.util.logging.Logger;

/**
 *
 * @author frant
 */
public class Ejemplo001 {

    public static void main(String[] args) {
       String fichero ="califacio.data";
               String nombre="";
                       int conv=i;
                               double nota=7.9;
                        try{       
                            DataInputstream out=new DataInputStream(new FileInputStream(new File(fichero)));
                                       out.wruteUTF(nombre);
                                       out.writeDouble(nota);
                                       out.writeInt(conv);
                        } catch{FileNotFoundExcepyion ex){
                            Logger.getLogger(Ejemplo001.classgetName()).log(Level.SEVERE, null00)
                        }
                        }
                                       
                                       
                                       
    }
}
