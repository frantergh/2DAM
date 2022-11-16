/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package vista;

import java.io.File;
import model.Store;

/**
 *
 * @author frant
 */
public class App {

    public static void main(String[] args){
        String nomFichXml="bookstore.xml";
        File fl=new File(nomFichXml);
        Store store= new store();
        
        StoreController strCtr=new StoreController(fl);
        strCtr.recuperaXml();
        store=strCtr.leerDOM();
        
    }
}
