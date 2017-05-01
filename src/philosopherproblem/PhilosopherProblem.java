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
 * Runs the Philosopher eating table.
 * @author vince
 */
public class PhilosopherProblem {

    /**
     * starts and runs the main logic for philosopher eating
     * @param args the command line arguments
     */
   public static void main(String[] args) 
   {
   // TODO code application logic here
      Scanner input = new Scanner(System.in);
      System.out.println("How many Philosophers do we have today?");
      int totalPhilosophers = input.nextInt();
      input.nextLine();
      System.out.println("How long are we running for today?");
      int runTime = input.nextInt();
      input.nextLine();
      Philosopher[] myPhilosophers;
      myPhilosophers = new Philosopher[totalPhilosophers];
      Fork[] philosFork = new Fork[totalPhilosophers];
      for (int i = 0; i < totalPhilosophers; i++)
      {
         philosFork[i] = new Fork();
      }
      StartProfs(totalPhilosophers, philosFork, myPhilosophers);
      try {
         Thread.sleep(runTime);
      } catch (InterruptedException ex) {
         Logger.getLogger(PhilosopherProblem.class.getName())
            .log(Level.SEVERE, null, ex);
      }
      StopPhilos(totalPhilosophers, myPhilosophers);
      printResults(totalPhilosophers, myPhilosophers);
   }
   
   /**
    * Starts all the Philosophers strings
    * @param totalPhilosophers total number of Philosophers eating
    * @param philosFork forks being used
    * @param myPhilosophers array of all philosophers
    */
   private static void StartProfs(int totalPhilosophers, 
      Fork[] philosFork,Philosopher[] myPhilosophers)
   {
      for (int i = 0; i < totalPhilosophers; i++)
      {
         //TODO: give them their forks
         myPhilosophers[i] = new Philosopher(philosFork[i], 
            philosFork[(i+1) % totalPhilosophers], i + 1);
         myPhilosophers[i].start();
      }     
   }
   
   /**
    * Stops all threads
    * @param totalPhilosophers total number of Philosophers eating
    * @param myPhilosophers array of all philosophers
    */
   private static void StopPhilos(int totalPhilosophers,
      Philosopher[] myPhilosophers)
   {
      for (int i = 0; i < totalPhilosophers; i++)
      {
         myPhilosophers[i].stop();
      }  
   }
   /**
    * PPrints out the results of each Philosophers eating and thinking 
    * @param totalPhilosophers total number of Philosophers eating
    * @param myPhilosophers array of all philosophers
    */
   private static void printResults(int totalPhilosophers, 
      Philosopher[] myPhilosophers) {
      for (int i = 0; i < totalPhilosophers; i++)
      {
         System.out.println(myPhilosophers[i]);
      }  
   }
    
}
