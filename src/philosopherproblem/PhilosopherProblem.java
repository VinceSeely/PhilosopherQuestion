/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosopherproblem;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vince
 */
public class PhilosopherProblem {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) 
   {
   // TODO code application logic here
      Scanner input = new Scanner(System.in);
      System.out.println("How many Philosophers do we have today?");
      int totalPhilosophers = input.nextInt();
      input.nextLine();
      Philosopher[] myPhilosophers = new Philosopher[totalPhilosophers];
      Fork[] philosFork = new Fork[totalPhilosophers];
      for (int i = 0; i < totalPhilosophers; i++)
      {
         philosFork[i] = new Fork();
      }
      for (int i = 0; i < totalPhilosophers; i++)
      {
         //TODO: give them their forks
         myPhilosophers[i] = new Philosopher();
         myPhilosophers[i].start();
      }
      for(int i = 0; i < totalPhilosophers; i++)
      {
         try {
            myPhilosophers[i].join();
         } catch (InterruptedException ex) {
            Logger.getLogger(PhilosopherProblem.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
    
}
