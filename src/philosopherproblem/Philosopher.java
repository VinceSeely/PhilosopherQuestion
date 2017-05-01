/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosopherproblem;

import java.util.Random;
import java.util.Timer;

/**
 *
 * @author vince
 */
public class Philosopher extends Thread 
{
   private Fork leftFork = null;
   private Fork rightFork = null;
   private int eatTime = 0;
   private int thinkTime = 0;
   private int id;
   private static final int RUNTIME = 60000; //in milliseconds
   private static final int MAX_TIME = 1000; //in milliseconds
   private static final int MIN_TIME = 10;
   private Random rand = new Random();


   /**
   Parameterized Constructor: Sets leftFork to left, rightFork to right, and
   id to iden.
   @param left this philosophers left fork
   @param right this philosophers right fork
   @param iden this philosophers identification number
   */
   Philosopher(Fork left, Fork right, int iden) 
   {
      leftFork = left;
      rightFork = right;
      id = iden;
   }
   
   @Override
   public void run()
   {
      boolean hasForks = false;
      //start/init timer
      while (true)
      {
         System.out.println (id + ": THINKING");
         thinking();
         while (!hasForks)
            hasForks = getForks();
         System.out.println (id + ": EATING");
         eating();
         hasForks = false;
         replaceForks();
      }
   } 
   
   /**
   Generates a random number between MIN_TIME and MAX_TIME with both being in
   milliseconds. Then increases eatTime by that value and puts the thread to
   sleep for that time.
   */
   private void eating()
   {
      int eat = rand.nextInt((MAX_TIME - MIN_TIME) + 1) + MIN_TIME;
      try{
         eatTime += eat;
         sleep(eat);
      }
      catch (InterruptedException e){
         System.out.println(id + " Eating has been interrupted.");
      }
   }
   
   /**
   Generates a random number between MIN_TIME and MAX_TIME with both being in
   milliseconds. Then increases thinkTime by that value and puts the thread
   to sleep for that time.
   */
   private void thinking()
   {
      int think = rand.nextInt((MAX_TIME - MIN_TIME) + 1) + MIN_TIME;
      try{
         thinkTime += think;
         sleep(think);
      }
      catch(InterruptedException e){
        System.out.println(id + " Thinking has been interrupted.");    
      }
   }
      
   /**
   Replaces both forks.
   */
   private void replaceForks()
   {
      leftFork.replaceFork();
      rightFork.replaceFork();
   }
   
   /**
   Attempts to get the leftFork and then the rightFork. If unable to get the
   right fork, puts the left fork back down.
   @return true if able to get both forks, false otherwise
   */
   private boolean getForks()
   {
      try{
         if(leftFork.grabFork())
         {
            if(rightFork.grabFork())
               return true;
            leftFork.replaceFork();
         }
         return false;
      }
      catch (InterruptedException e){
         return false;
      }
   }
   
   /**
   Returns the Philosopher data as a string for printing purposes.
   @return string of Philosopher data
   */
   @Override
   public String toString()
   {
      return "Philosopher " + id + " ate for: " + eatTime +
         "milliseconds \nPhilosopher " + id + " thought for: " 
         + thinkTime + " milliseconds"; 
   }
}
