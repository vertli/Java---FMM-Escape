/*
 * MathsRm Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class MathsRm extends Classroom
{
    static Console c;  // The output console

    /**
     * constructor
     * pre: Console c, Item i
     * post: MathsRm class has been selected.
     */
    public MathsRm (Console c, Item i, Music bgm) throws IOException
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

	// creates MathsQuestion class calls q.
	MathsQuestion q = new MathsQuestion (c);
	super.frame ("Maths Room", "Mr. Brown", q); // calls superclass method frame

	// checks the user can get item(s) or not
	if (super.correctNum >= 4)
	{
	    super.item.get (0);
	    if (super.correctNum == 6)
	    {
		super.item.get (6);
	    } // end if (correctNum == 6)
	} // end if (correctNum >= 4)

    } // frame method
} // MathsRm class
