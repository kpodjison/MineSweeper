import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class MineSweeperWorld here.
 * 
                                                             ***************************************
 *                                                         *                                        *
 *                                                        *   @author KPODJI EMMANUEL KWASI          * 
 *                                                        *       @version (27/03/2020)              *        
 *                                                         *          @keeprunning                   *                 
 *                                                          *****************************************
 */
public class MineSweeperWorld extends World
{
    //ArrayList to hold all Blocks elements in the world
    ArrayList<Blocks> block = new ArrayList<Blocks>();

    public MineSweeperWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(15, 15, 25); 

        //nested for loop to place all Blocks() elements in the world
        /*for every iteration create a Blocks() element put into the ArrayList and add to the world*/
        for(int i=0; i < getWidth(); i++)
        {
            for(int j = 0;j < getHeight(); j++) 
            {   Blocks lay = new Blocks(); //create new Blocks() object
                block.add(lay);             //add object to ArrayList
                addObject(lay, i,j);       //place object in the world

            }

        }

        //setting up bombs
        /* Random numbers are generated for  iteration to mark specific Blocks elements as bombs*/
        List<Blocks> neigbours = new ArrayList<Blocks>();   //List to hold all elements of Blocks() in the world 
        for(int i=0; i < 20; i++)
        {    // 2 integer variables to hold randomly generated numbers
            int a;
            int b;
            //generating random integers
            a = (int)(Math.random()*getWidth());
            b = (int)(Math.random()*getWidth());
            //pushing randomly generated elements into List
            neigbours  = getObjectsAt(a, b, Blocks.class);
            //settting all randomly generated elements at the end of each iteration as bombs
            for(Blocks p: neigbours) {
                p.setBomb();

            }
        }

    }

    public void act() {
    }
}
