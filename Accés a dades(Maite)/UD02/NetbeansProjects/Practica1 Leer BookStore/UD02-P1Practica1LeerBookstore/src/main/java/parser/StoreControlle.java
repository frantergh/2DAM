/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import model.Store;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author frant
 */
public class StoreControlle {
     static final String ET_BOOKSTORE="bookstore";
    private File fichXml;
    private Store store;
    private Document doc;

    public StoreControlle() {
        this.store= new Store();
    }

    public StoreControlle(File fichXml) {
        this.fichXml = fichXml;
        this.store= new Store();
    }
    
    public StoreControlle(Store store, File fichxml) {
                this.fichXml = fichXml;
                this.store= store;
                
    }
    public void recuperaXml(){
    
    this.doc=(Document)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.fichXml);
    this.doc.getDocumentElement().normalize();
            
    }
    public Store leerDOM(){
    Element bookStore=this.doc.getDocumentElement();
    NodeList listaBooks=listaBooks.getChildNodes();
    this.store.clear();
       
    for(int i=0;i<listaBooks.getLength();i++){
    
        if(listaBooks.item(i).getNodeType()==Node.ELEMENT_NODE){

        //LEER BOOK
        this.store.add(BookController.leerBook(Element)listaBooks.item(i)));
        }
    }
         
    }   

