/*
 * PhysEdRm Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class PhysEdRm extends Classroom
{
    static Console c; // The output console

    /**
     * constructor
     * pre: Console c, Item i
     * post: PhysEdRm has been selected
     */
    public PhysEdRm (Console c, Item i, Music bgm) throws IOException
    {
	super (c, i, bgm);
	this.c = c;
	this.frame ();
    } // constructor


    /**
     * Displays the frame.
     * pre: none
     * post: The frame has been displayed.
     */
    public void frame ()
    {

	// // creates PhysEdQuestion class calls q.
	PhysEdQuestion q = new PhysEdQuestion (c);
	super.frame ("PhysEd Room", "Mr. Morelli", q); // calls superclass method frame

	// checks the user can get item(s) or not
	if (super.correctNum >= 4)
	{
	    super.item.get (4);
	    if (super.correctNum == 6)
	    {
		super.item.get (10);
	    } // end if (correctNum == 6)
	} // end if (correctNum >= 4)
    } // frame method
} // PhysEdRm class
