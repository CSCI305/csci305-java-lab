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
public class Paper extends Element{
    public Paper(String name) {
        super(name);
    }
    
    @Override
    public Outcome compareTo(Element e) {
        switch (e.getName()) {
            case "Rock": return new Outcome("Paper covers Rock", "Win");
            case "Paper": return new Outcome("Paper equals Paper", "Tie");
            case "Scissors": return new Outcome("Scissors cuts Paper", "Lose");
            case "Lizard": return new Outcome("Lizard eats Paper", "Lose");
            case "Spock": return new Outcome("Paper disproves Spock", "Win");
            default: return new Outcome("Unknown comparison", "Null");
        }
    }
}
