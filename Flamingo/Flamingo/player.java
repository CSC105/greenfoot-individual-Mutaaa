import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed;
    private int ySpeed;
    private int animationCount = 0;
    public boolean inTheWorld;
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor candy = getOneIntersectingObject(Candy.class);  
        switchImage();
        jumper();

    }    
    
    public void switchImage(){
        String[] str = new String[36];
        for (int i = 1; i < str.length; i++){
            str[i] = "Flamingo" + i + ".png";
            animationCount++;
            if(animationCount == 250){
                setImage(str[i]);
                animationCount = 0;
            }
            
        }
    }
    
    public void jumper(){
        int groundLevel = 445;
        boolean onGround = (getY() == groundLevel);
        
        if (!onGround) {
            ySpeed++; // adds gravity effect
            setLocation(getX(), getY()+ySpeed); // fall (rising slower or falling faster)
           if (getY()>=groundLevel) {
                
                setLocation(getX(), groundLevel); // set on ground
                Greenfoot.getKey(); // clears any key pressed during jump
           }
        }else {
            if ("space".equals(Greenfoot.getKey())) {
                
                ySpeed = -15; // add jump speed
                setLocation(getX(), getY()+ySpeed); // leave ground
                
            }
        }
    }
    
    public void retryGame(){
        inTheWorld = false;
        getWorld().removeObject(this);
        
        
        
    }
}
