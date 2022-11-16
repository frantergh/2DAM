/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejemplo01;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author frant
 */
public class Ejemplo01 {

    public static void main(String[] args) throws IOException {
        File f1=new File("fichero.txt");
        if (f1.createNewFile()){
        String ruta1=f1.getAbsolutePath();
        String ruta2=f1.getCanonicalPath();
        String ruta3=f1.getPath();
        
            System.out.println("ruta absoluta" + ruta1);
             System.out.println("ruta canonica" + ruta2);
              System.out.println("ruta" + ruta3);
            
        
        
        }
    }
}
