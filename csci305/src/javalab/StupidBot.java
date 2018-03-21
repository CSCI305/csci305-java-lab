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
public class StupidBot extends Player{
    public StupidBot(String name) {
        super(name);
    }
    
    @Override
    public Element play() {
        return new Rock("Rock");
    }
}
