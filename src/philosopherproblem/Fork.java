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
    private Philosopher curPhilos = null;
    
    public boolean forkInUse()
    {
        return curPhilos != null;
    }
    
    public void replaceFork()
    {
        curPhilos = null;
    }
    
    public void grabFork (Philosopher using)
    {
        curPhilos = using;
    }
}
