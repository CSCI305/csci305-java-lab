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
public class RandomBot extends Player{
    private Element elements[] = new Element[5];
    
    public RandomBot(String name) {
        super(name);
        elements[0] = new Rock("Rock");
        elements[1] = new Paper("Paper");
        elements[2] = new Scissors("Scissors");
        elements[3] = new Lizard("Lizard");
        elements[4] = new Spock("Spock");
    }
    
    @Override
    public Element play() {
        return elements[(int)(Math.random() * 5)];
    }
}