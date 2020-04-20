import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MinesweeperIntroScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinesweeperIntroScreen extends World
{

    /**
     * Constructor for objects of class MinesweeperIntroScreen.
     * 
     */
    public MinesweeperIntroScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(375, 375, 1); 
  
    }
 
         
    public void act() {
        // Start the game if the user clicks the mouse anywhere
        MouseInfo mi = Greenfoot.getMouseInfo();

    
        if(Greenfoot.mouseClicked(this))
        {
            MineSweeperWorld world = new MineSweeperWorld();
            Greenfoot.setWorld(world);
        }

    }

 
}