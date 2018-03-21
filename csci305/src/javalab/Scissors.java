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
public class Scissors extends Element{
    public Scissors(String name) {
        super(name);
    }
    
    @Override
    public Outcome compareTo(Element e) {
        switch (e.getName()) {
            case "Rock": return new Outcome("Rock crushes Scissors", "Lose");
            case "Paper": return new Outcome("Scissors cuts Paper", "Win");
            case "Scissors": return new Outcome("Scissors equals Scissors", "Tie");
            case "Lizard": return new Outcome("Scissors decapitates Lizard", "Win");
            case "Spock": return new Outcome("Spock smashes Scissors", "Lose");
            default: return new Outcome("Unknown comparison", "Null");
        }
    }
}
