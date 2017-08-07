/*
 * MathsQuestion Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.File;
import hsa.Console;

public class MathsQuestion extends Question
{

    static Console c;  // The output console

    /**
     * constructor
     * pre: Console c
     * post: MathssQuestion class has been selected.
     */
    public MathsQuestion (Console c)
    {
	super (c);
	this.textFile = new File (".\\txtFile\\maths.txt");
	this.getFile ();
    } // constructor
} // MathsQuestion Class
