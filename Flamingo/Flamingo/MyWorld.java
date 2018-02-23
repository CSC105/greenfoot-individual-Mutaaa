import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{    
    private int imageCount = 0;

    private GreenfootImage bgImage = new GreenfootImage("Head01.png");
    private long lastTime = 0;
    Counter counter = new Counter();
    
    private Player player;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 601, 1, false);

        prepare();
    }

    public void act(){
        imageCount -= 5;
        drawBackgroundImage();
        long temp = System.nanoTime();
        if( (temp - lastTime)*1.0/1000000000 > 2 ){
          addObject( new Candy(player, counter), 800, 300 );
          lastTime = temp;
        }
    }

    public void drawBackgroundImage(){
        if (imageCount < -bgImage.getWidth()){
            imageCount += bgImage.getWidth();
        }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        player = new Player();
        addObject(player,95,390);
        addObject(counter,700,50);
    }
    
    public Counter getCounter(){
        return counter;
    }
}
