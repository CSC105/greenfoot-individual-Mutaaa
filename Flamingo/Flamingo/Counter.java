import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Counter extends Actor
{
    GreenfootSound eat = new GreenfootSound("eat.mp3");
    int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score : "+score, 24, Color.PINK, Color.WHITE));
        
    }
    
    public void addScore(){
        score++;
        eat.play();
    }
}
