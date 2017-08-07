/*
 * BusinessQuestion Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.File;
import hsa.Console;

public class BusinessQuestion extends Question
{
    static Console c;  // The output console

    /**
     * constructor
     * pre: Console c
     * post: BusinessQuestion has been selected.
     */
    public BusinessQuestion (Console c)
    {
	super (c);
	this.textFile = new File (".\\txtFile\\business.txt");
	this.getFile ();
    } // constructor
} // BusinessQuestion class
