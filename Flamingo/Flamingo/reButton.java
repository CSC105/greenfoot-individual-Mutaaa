import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class reButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class reButton extends Button
{
    /**
     * Act - do whatever the reButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public reButton(){
      super( "reButton" );
    }
    
    public void action() 
    {
      Greenfoot.setWorld(new MyWorld());
    }    
}
