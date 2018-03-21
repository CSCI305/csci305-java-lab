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

public class Lizard extends Element {
    public Lizard(String name) {
        super(name);
    }
    
    @Override
    public Outcome compareTo(Element e) {
        switch (e.getName()) {
            case "Rock": return new Outcome("Rock crushes Lizard", "Lose");
            case "Paper": return new Outcome("Lizard eats Paper", "Win");
            case "Scissors": return new Outcome("Scissors decapitates Lizard", "Lose");
            case "Lizard": return new Outcome("Lizard equals Lizard", "Tie");
            case "Spock": return new Outcome("Lizard poisons Spock", "Win");
            default: return new Outcome("Unknown comparison", "Null");
        }
    }
}
