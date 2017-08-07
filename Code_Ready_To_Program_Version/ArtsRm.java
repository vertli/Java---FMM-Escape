/*
 * ArtsRm Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class ArtsRm extends Classroom
{
    static Console c; // The output console
    static Music bgm;

    /**
     * constructor
     * pre: Console c, Item i
     * post: ArtsRm has been selected
     */
    public ArtsRm (Console c, Item i, Music bgm) throws IOException
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

	ArtsQuestion q = new ArtsQuestion (c);
	super.frame ("Arts Room", "Ms. Uberlarte", q);

	if (super.correctNum >= 4)
	{
	    super.item.get (5);
	    if (super.correctNum == 6)
	    {
		super.item.get (11);
	    } // end if (correctNum == 6)
	} // end if (correctNum >= 4)

    } // frame method
} // EnglishRm class
