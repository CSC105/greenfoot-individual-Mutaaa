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
    private GreenfootSound bgSound = new GreenfootSound("bgSound.wav");

    private boolean over;
    private int count;
    private int spawnCounter = 0;
    GreenfootSound die = new GreenfootSound("die.mp3");

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 601, 1, false);
        count = 0;
        bgSound.stop();
        if(bgSound.isPlaying()){
            bgSound.stop();
        }
        prepare();
    }

    public void act(){
        imageCount -= 5;

        long temp = System.nanoTime();

        if(!over){
            drawBackgroundImage();
            if( (temp - lastTime)*1.0/1000000000 > 2 ){
                addObject( new Candy(player, counter), 800, 300 );
                //addObject(new purpleMons(player), 800,510 );
                lastTime = temp;
            }

            if (spawnCounter > 100) {
                spawnCounter = 0;
                addObject(new purpleMons(player), 810, 510);
            }
            spawnCounter++;

            
            if(!bgSound.isPlaying()){
                bgSound.play();
            }
            checkOver();

        } else if(over && count ==0) {
            count++;
            over();
        } else {
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
        player.inTheWorld = true;
        addObject(counter,700,50);
    }

    public Counter getCounter(){
        return counter;
    }

    public void checkOver(){
        if( getObjects(Player.class).size() == 0 ){
            over = true;
            stopped();
        }
    }

    public void over(){
        reButton reButton = new reButton();
        addObject(reButton,400,300);
        bgSound.stop();
        die.play();

    }

}
