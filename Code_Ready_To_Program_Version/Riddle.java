/*
 * Riddle Class - Ready in Program
 * Chun Kit (Calvin) Li
 * Original Version (Swing): Jasmine Xiao
 */

import java.awt.*;
import hsa.Console;

public class Riddle
{
    static Console c; // The output console

    // variable
    private String guess;
    private boolean correct;
    final private String answer = "keyboard";

    /**
     * constructor
     * pre: Console c
     * post: Riddle has been created.
     */
    public Riddle (Console c)
    {
	this.c = c;
	this.frame ();
    } // constructor


    /**
     * The frame (or main method) in Riddle class.
     * pre: none
     * post: The frame has been displayed.
     */
    public void frame ()
    {

	//variable
	boolean leave = false;

	correct = true;

	c.clear ();

	do
	{

	    if (correct == false)
	    {
		c.clear ();
		c.setCursor (8, 25);
		c.setTextColor (Color.RED);
		c.print ("Wrong!!!!");
	    } // end if (correct == false)

	    c.setCursor (1, 1);
	    c.setTextColor (Color.BLACK);
	    c.println ();
	    c.println ("           ___          ______________________________________________________");
	    c.println ("          /III\\        |Sphinx:                                               |");
	    c.println ("         /{= =}\\__     |What object has keys that open no locks, spacebut no  |");
	    c.println ("         |_\\-/_|  \\    |room, and you can enter but not go in? (One word)     |");
	    c.println ("         |-| |-|{ |    |Please enter your anwser and press <Enter>:           |");
	    c.println ("        /-_--_'-nn/    |                                                      |");
	    c.print ("       nnn/  nnn|      |");
	    c.setCursor (8, 79);
	    c.println ("|");
	    c.println ("                       |(Enter \"leave\" to give up)                            |");
	    c.println ("                       |______________________________________________________|");


	    c.setCursor (7, 25);
	    guess = c.readString ().toLowerCase ();

	    if (guess.equals ("leave"))
	    {
		leave = true;
		correct = false;
		c.clear ();
	    }
	    else if (guess.equals (answer))
	    {
		correct = true;
		this.gameEnd ();
	    }
	    else
	    {
		correct = false;
	    }

	}
	while (correct == false && leave == false);

    } // frame method


    /**
     * Returns correct(true or false).
     * pre: none
     * post: correct has been returned.
     */
    public boolean getCorrect ()
    {
	return correct;
    } // getCorrect method


    /**
     * Displays the message if the user finishing the game
     * pre: none
     * post: The message has been displayed.
     */
    public void gameEnd ()
    {
	c.clear ();
	c.println ("CONGRATULATIONS!!!");
	c.println ("You escaped FMM!!!");
	c.println ("You are free now!!!");
	c.println ();
	c.println ("(Please press any key to continue)");
	char ch = c.getChar ();
	c.clear ();
    } // gameEnd method
} // Riddle class
