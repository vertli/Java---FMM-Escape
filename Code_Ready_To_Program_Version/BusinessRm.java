/*
 * BusinessRm Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class BusinessRm extends Classroom
{
    static Console c; // The output console

    /**
     * constructor
     * pre: Console c, Item i
     * post: BusinessRm has been selected
     */
    public BusinessRm (Console c, Item i, Music bgm) throws IOException
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
	// creates BusinessQuestion class calls q.
	BusinessQuestion q = new BusinessQuestion (c);
	super.frame ("Business Room", "Ms. Ng", q);
	if (super.correctNum >= 4)
	{
	    super.item.get (3);
	    if (super.correctNum == 6)
	    {
		super.item.get (9);
	    } // end if (correctNum == 6)
	} // end if (correctNum >= 4)
    } // frame method
} // BusinessRm class
