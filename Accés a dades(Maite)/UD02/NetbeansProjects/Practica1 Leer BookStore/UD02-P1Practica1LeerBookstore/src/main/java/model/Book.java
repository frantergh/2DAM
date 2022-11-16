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
public class Book {
    
    private String category;
    private String LANG;
    private String title;
    private ArrayList<Author>autores=null;
    double price;

    @Override
    public String toString() {
        return "Book{" + "category=" + category + ", LANG=" + LANG + ", title=" + title + ", autores=" + autores + ", price=" + price + '}';
    }
     public String imprimirBook() {
        return "Book{" + "category=" + category + ", LANG=" + LANG + ", title=" + title + ", autores=" + autores + ", price=" + price + '}';
    }

    public Book(String category, String LANG, String title, double price) {
        this.category = category;
        this.LANG = LANG;
        this.title = title;
        this.price = price;
    }
    
}
