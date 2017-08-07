/*
 * ScienceQuestion Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.File;
import hsa.Console;

public class ScienceQuestion extends Question
{
    static Console c; // The output console

    /**
     * constructor
     * pre: Console c
     * post: ScienceQuestion has been selected.
     */
    public ScienceQuestion (Console c)
    {
	super (c);
	this.textFile = new File (".\\txtFile\\science.txt");
	this.getFile ();
    } // constructor
} // ScienceQuestion Class
