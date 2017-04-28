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
public class Fork {
   private int sema = 1;
   private static final int MAX_TRIES = 300;
   private static final int SLEEP_TIME = 10; //in milliseconds
  
   public void replaceFork()
   {
      ++sema;
   }
    
   @SuppressWarnings("empty-statement")
   public boolean grabFork () throws InterruptedException
   {
      int timesRun = 0;      
      while (sema <= 0 && timesRun <= MAX_TRIES)
      {
        Thread.sleep(SLEEP_TIME);
        ++timesRun;
      }
      if (timesRun >= MAX_TRIES)
         return false;
      else
         --sema;
      return true;
   }
}
