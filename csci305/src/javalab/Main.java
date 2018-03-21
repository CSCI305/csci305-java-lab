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
public class Main {
  public static void main(String args[]) {
    Element rock = new Rock("Rock");
    Element paper = new Paper("Paper");
    Player player = new RandomBot("Random");
    Player player2 = new IterativeBot("Iterative");
    Player player3 = new StupidBot("Stupid");
    System.out.println(rock.compareTo(paper));
    System.out.println(paper.compareTo(rock));
    System.out.println(rock.compareTo(rock));
    System.out.println(player3.play().getName());
    System.out.println(player.play().getName());
    for(int i = 0; i < 10; i++) {
        System.out.println(player2.play().getName());
    }
  }
}
