import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    private int speed;
    private int ySpeed;
    private int animationCount = 0;
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        switchImage();
        jumper();
    }    
    
    public void switchImage(){
        String[] str = new String[36];
        for (int i = 1; i < str.length; i++){
            str[i] = "Flamingo" + i + ".png";
            animationCount++;
            if(animationCount == 120){
                setImage(str[i]);
                animationCount = 0;
            }
            
        }
    }
    
    public void jumper(){
        int groundLevel = 450;
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
}
