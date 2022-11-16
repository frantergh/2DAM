/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author frant
 */
public class BookController {

    static final String ET_BOOK = "book";
    static final String ET_CATEGORY = "category";
    static final String ET_TITLE = "lang";
    static final String ET_LANG = "lang";
    static final String ET_AUTHOR = "author";
    static final String ET_PRICE = "price";

    public static String getValorEtiqueta(String etiqueta, Element element) {
        Node nValue = element.getElementsByTagName(etiqueta).item(0);
        return nValue.getChildNodes().item(0).getNodeValue();

    }

    public static Element getElementEtiqueta(String etiqueta, Element element) {

        return (Element) element.getElementsByTagName(etiqueta).item(0);
        

    }
}
