/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author frant
 */
public class Store extends ArrayList<Book> {
    
   public ArrayList<Book> getBooks(){
   return this;
       
   } 
    public String toString(){
   String result="+";
   for ( int i=0;i< this.getBooks().size();i++){
   
      result +="\n" + this.getBooks().get(i);

   }
   return result;
    }
    public void imprimir(){
       for ( int i=0;i< this.getBooks().size();i++){
this.getBooks().get(i).imprimirBook();

       }
    }
}
