import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected GreenfootImage image;
    public Button(String name){
        image = new GreenfootImage(name + ".png" );
        setImage(image);
    }
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            action();     
        }
        
        if(Greenfoot.isKeyDown("r")){
            action();
        }
    }
    
    protected void action() 
    {
        
    }    
}
