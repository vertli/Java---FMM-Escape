/*
 * EnglishQuestion Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.File;
import hsa.Console;

public class EnglishQuestion extends Question
{

    static Console c;

    /**
     * constructor
     * pre: Console c
     * post: EnglishQuestion has been selected.
     */
    public EnglishQuestion (Console c)
    {
	super (c);
	this.textFile = new File (".\\txtFile\\english.txt");
	this.getFile ();
    } // constructor
} // EnglishQuestion Class
