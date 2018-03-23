/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab;

/**
 *
 * @author Drew
 */
abstract public class Element {
    public String name;
    
    public Element(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    abstract public Outcome compareTo(Element e);
}
