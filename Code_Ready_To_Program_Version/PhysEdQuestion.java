/*
 * PhysEdQuestion Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.File;
import hsa.Console;

public class PhysEdQuestion extends Question
{
    static Console c; // The output console

    /**
     * constructor
     * pre: Console c
     * post: PhysEdQuestion has been selected.
     */
    public PhysEdQuestion (Console c)
    {
	super (c);
	this.textFile = new File (".\\txtFile\\physEd.txt");
	this.getFile ();
    } // constructor
} // PhysEdQuestion Class
