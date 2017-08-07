/*
 * ScienceRm Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class ScienceRm extends Classroom
{
    static Console c;           // The output console

    /**
     * constructor
     * pre: Console c, Item i
     * post: ScienceRm has been selected
     */
    public ScienceRm (Console c, Item i, Music bgm) throws IOException
    {
	super (c, i, bgm);
	this.c = c;
	this.frame ();
    }


    /**
     * Displays the frame.
     * pre: none
     * post: The frame has been displayed.
     */
    public void frame ()
    {

	ScienceQuestion q = new ScienceQuestion (c);
	super.frame ("Science Room", "Ms. Dharmai", q);

	if (super.correctNum >= 4)
	{
	    super.item.get (2);
	    if (super.correctNum == 6)
	    {
		super.item.get (8);
	    } // end if (correctNum == 6)
	} // end if (correctNum >= 4)

    } // frame method
} // ScienceRm class
