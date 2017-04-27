/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosopherproblem;

/**
 *
 * @author vince
 */
public class Philosopher extends Thread 
{
   private String curState = "";
   private Fork leftFork = null;
   private Fork rightFork = null;
   private int eatTime = 0;
   private int thinkTime = 0;
   private int ID;
   private static final int RUNTIME = 60; //in seconds
   @Override
   public void run()
   {
      //start/init timer
      while (runTime != 0)
      {
         System.out.println (ID + "THINKING");
         // TODO: think for random number of milliseconds <=1 sec
         // TODO: obtain the fork on the left
         // TODO: obtain the fork on the right
         System.out.println (ID + "EATING");
         // TODO: eat for random number of milliseconds <= 1sec
         // TODO: release the fork on the left
         // TODO: release the fork on the right
      }
   } 
   
   private void getForks() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
   @Override
   public String toString()
   {
      return "Philosopher " + ID + " ate for : " + eatTime +
         "milliseconds \nPhilosopher " + ID + " thought for: " 
         + thinkTime + "milliseconds"; 
   }

   
}
