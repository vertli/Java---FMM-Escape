/*
 * EnglishRm Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class EnglishRm extends Classroom
{
    static Console c;  // The output console
    static Music bgm;

    /**
     * constructor
     * pre: Console c, Item i
     * post: EnglishRm has been selected
     */
    public EnglishRm (Console c, Item i, Music bgm) throws IOException
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

	// creates EnglishQuestion class calls q.
	EnglishQuestion q = new EnglishQuestion (c);
	super.frame ("English Room", "Ms. Chan", q); // calls superclass method frame

	// checks the user can get item(s) or not
	if (super.correctNum >= 4)
	{
	    super.item.get (1);
	    if (super.correctNum == 6)
	    {
		super.item.get (7);
	    } // end if (correctNum == 6)
	} // end if (correctNum >= 4)

    } // frame method
} // EnglishRm class
