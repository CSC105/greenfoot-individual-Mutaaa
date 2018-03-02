import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class purpleMons here.
 * 
 * @Kornkanok Sangwichien
 * @version (a version number or a date)
 */
public class PurpleMons extends Actor
{
    /**
     * Act - do whatever the purpleMons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage purpleMons;
    int baseX = 0;
    int purpleMonsWidth;
    private Player player;
    
    public PurpleMons(Player player) 
    {
        purpleMons = getImage();
        purpleMonsWidth = purpleMons.getWidth();
        getImage().scale(40,40);
        this.player = player;
    }   
    
    public void act() 
    {
        setLocation( getX()-3, getY() );   
        if( player.inTheWorld && getX() > 95 && getX() < 132 && player.getY() > 400 ){
            player.retryGame();
        }
    }    
}
