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
public class Spock extends Element{
    public Spock(String name) {
        super(name);
    }
    
    @Override
    public Outcome compareTo(Element e) {
        switch (e.getName()) {
            case "Rock": return new Outcome("Spock vaporizes Rock", "Win");
            case "Paper": return new Outcome("Paper disproves Spock", "Lose");
            case "Scissors": return new Outcome("Spock smashes Scissors", "Win");
            case "Lizard": return new Outcome("Lizard poisons Spock", "Lose");
            case "Spock": return new Outcome("Spock equals Spock", "Tie");
            default: return new Outcome("Unknown comparison", "Null");
        }
    }
}
