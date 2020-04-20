import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Blocks here.
 *                                                           ***************************************
 *                                                          *                                       *
 *                                                        *   @author KPODJI EMMANUEL KWASI         * 
 *                                                        *       @version (27/03/2020)             *        
 *                                                         *          @keeprunning                  *                 
 *                                                         *****************************************
 */
public class Blocks extends Actor
{    
    //creating a sound object
    private GreenfootSound explode = new GreenfootSound("sounds/sbomb.wav");

    public boolean isBomb=false; 
    public boolean isFlag=false; 
    private boolean isOpen = false;

    //global List created
    List<Blocks> block = new ArrayList<Blocks>();

    //mutator method for setBomb
    public void setBomb()
    {  
        isBomb=true;

    }

    //accessor method to getBomb()
    public boolean getBomb()
    {
        return isBomb;
    }

    //mutator method opened blocks
    public void setOpen()
    {  
        isOpen=true;

    }

    //accessor method for opened blocks
    public boolean getOpen()
    {
        return isOpen;
    }
    //mutator method marking flagged blocks
    public void setFlag()
    {  
        isFlag=true;

    }
    //accessor method marking flagged blocks
    public boolean getFlag()
    {
        return isFlag;
    }

    /**
     * Act - do whatever the Blocks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        showFlag();
        showBombs();
        showBlocks();

    } 

    //function to show flag when a button is clicked
    public void showFlag()
    {
        //mouse info method
        MouseInfo mi = Greenfoot.getMouseInfo();
        //check if a Blocks object is clicked 
        if(Greenfoot.mouseClicked(this) )
        {  //if the rigth mouse button was pressed and if the block isn't opened
            if(this.getOpen()==false && mi.getButton()==3)
            {
                if(this.getFlag()==false) 
                {
                    this.setImage("BlockFlagged.png");
                    this.setFlag();

                }
                else 
                {
                    setImage("Block.png");
                    this.setFlag();
                }

            }
        }
    }
    /**showing all bombs
     *show all bombs in the world when a single bomb is accidentally clicked*/
    public void showBombs()
    {    MouseInfo mi = Greenfoot.getMouseInfo();//getting mouse information

        /*check if a Blocks() element is clicked and mouse button is left mouse button and the element is marked as a bomb*/
        if(Greenfoot.mouseClicked(this)== true  && mi.getButton()==1 && this.getBomb()==true && this.getFlag()==false)
        {
            block =getWorld().getObjects(Blocks.class); // assign all objects of Blocks in the world to the global List variable

            //loop to traverse the whole world to show all Blocks() element marked as bombs
            for( Blocks z : block) {
                {
                    if(z.getBomb()==true)
                    {
                        z.setImage("Bomb.png");//change the image of marked Blocks() elements

                    }
                }
            }
            explode.play(); //play explode sound after all bombs have been showed
             Greenfoot.stop(); //stop the entire game (that's means player lossed)
        }

    }   

    /**
     * method to get the number of bombs surrounding a block that's not marked as a bomb*/
    public int surroundingBombs(Blocks b)
    {
        List<Blocks> neigbours = b.getNeighbours(1, true,Blocks.class);
        int totalBombs = 0; //variable to hold the number of bombs found

        for(Blocks q: neigbours) {
            if(q.getBomb()==true)
                totalBombs++;
        }

        return totalBombs;

    }

    /**
    show numbered blocks and  floods a region with empty bombs when an empty block is clicked*/
    public void showBlocks( )
    {
        List<Blocks> neigbours = new ArrayList<Blocks>();
        MouseInfo mi = Greenfoot.getMouseInfo();
        int a,b; 
        if(Greenfoot.mouseClicked(this) && this.getBomb()==false &&  mi.getButton()==1  && this.getFlag()==false  )
        {  //using variables a and b to get X and Y positions of a clicked block from the world
            a=getX();
            b=getY();
            block  = getWorld().getObjectsAt(a, b, Blocks.class); //assigning the retrieve block object the global block variable

            for(Blocks q: block) 
            { 
                setBlockImage(q);

            }

        }

    }

    //method to set the image of all blocks and also unvail all empty blocks and its neigbours if a block has zero surrounding bombs
    private void setBlockImage(Blocks b){
        b.setOpen();
        int num = b.surroundingBombs(b);
        b.setImage("BlockClicked[" + num + "].png");
        if(num == 0 ){
            List<Blocks> neigbours = b.getNeighbours(1, true, Blocks.class);
            //recursive fuction to fill all empty blocks and it's empty neigbours
            for(Blocks q : neigbours)
            {
                if(q.getOpen()==false)
                    setBlockImage(q);
            }
        } 
    }

   
}
