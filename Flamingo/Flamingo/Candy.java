import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Candy extends Actor
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage candy;
    int baseX = 0;
    int candyWidth;
    private Player player;
    private Counter counter;
    
    public Candy(Player player,Counter counter) 
    {
        candy = getImage();
        candyWidth = candy.getWidth();
        getImage().scale(20,20);
        this.player = player;
        this.counter = counter;
    }    
    
    public void act(){
        setLocation( getX()-3, getY() );   
        if( getX() > 95 && getX() < 160 && player.getY() < 405 ){
            counter.addScore();
            getWorld().removeObject(this);
          
        }
    }
    
    public void moveBackward(){
        
    }
}
