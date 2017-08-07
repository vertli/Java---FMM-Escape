/*
 * ArtsQuestion Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.File;
import hsa.Console;

public class ArtsQuestion extends Question
{

    static Console c; // The output console

    /**
     * constructor
     * pre: Console c
     * post: ArtsQuestion has been selected.
     */
    public ArtsQuestion (Console c)
    {

	super (c);
	this.textFile = new File (".\\txtFile\\arts.txt");
	this.getFile ();

    } // constructor
} // ArtsQuestion Class
