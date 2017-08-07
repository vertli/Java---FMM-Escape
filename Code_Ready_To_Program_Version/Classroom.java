/*
 * Classroom Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public abstract class Classroom
{
    static Console c; // The output console
    static Music bgm;

    // variable
    protected Item item;
    protected int correctNum;
    protected boolean pass = false;

    /**
     * constructor
     * pre: Console c, Item i
     * post: Classroom has been created.
     */
    public Classroom (Console c, Item i, Music bgm) throws IOException
    {
	this.c = c;
	this.item = i;
	this.bgm = bgm;
	this.bgm.playBGM ();

    } // constructor


    /**
     * Displays the frame for Classroom class.
     * pre: String className, String teacherName, Question q
     * post: The frame has been displays.
     */
    public void frame (String className, String teacherName, Question q)
    {

	//variable
	char ch;

	for (int i = 1 ; i < 7 ; i++)
	{
	    c.clear ();
	    c.setCursor (1, 1);
	    c.print (className);

	    c.setCursor (3, 1);
	    c.print ("Teacher: " + teacherName);


	    c.setCursor (5, 1);
	    c.println ("Question " + i);
	    q.showQuestion (teacherName);

	    c.setCursor (18, 25);
	    c.print ("Please press any key to continue");
	    ch = c.getChar ();
	} // for loop

	c.clear ();
	c.setCursor (1, 1);
	c.print (className);

	c.setCursor (3, 1);
	c.print ("Teacher: " + teacherName);


	c.setCursor (5, 1);
	c.print (teacherName + ": ");
	correctNum = q.checkCorrect ();
	if (correctNum >= 4)
	{
	    this.pass = true;
	}
	else
	{
	    this.pass = false;
	}

	c.setCursor (10, 25);
	c.print ("Please press any key to continue");
	ch = c.getChar ();

    } // frame method


    /**
     * Retruns pass.
     * pre: none
     * post: pass has been retruned.
     */
    public boolean getPass ()
    {
	return this.pass;
    } // getPass method


    /**
     * Re-sets all the items.
     * pre: none
     * post: All the items has been re-setted.
     */
    public void restart ()
    {
	for (int i = 0 ; i < 12 ; i++)
	{
	    item.lost (i);
	}
    } // restart method
} // Classroom class
