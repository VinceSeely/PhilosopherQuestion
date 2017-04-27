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
  
   public void replaceFork()
   {
      ++sema;
   }
    
   @SuppressWarnings("empty-statement")
   public boolean grabFork (Philosopher using) throws InterruptedException
   {
      int timesRun = 0;      
      while (sema <= 0 && timesRun <= 300)
      {
        Thread.sleep(10);
        ++timesRun;
      }
      if (timesRun == 300)
         return false;
      else
         --sema;
      return true;
   }
}
