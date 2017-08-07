/*
 * HomePage Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import hsa.Console;

public class HomePage
{
    static Console c; // The output console

    /**
     * constructor
     * pre: Console c
     * post: HomePage has been created.
     */
    public HomePage (Console c)
    {
	this.c = c;

    } // constructor


    /**
     * The menu for home page.
     * pre: none
     * post: The menu has been displayed.
     */
    public int menu ()
    {

	// variable
	int num = 1;
	int key;

	do
	{

	    c.clear ();

	    this.title ();

	    if (num == 1)
	    {
		this.firstMenu ();
	    }
	    else if (num == 2)
	    {
		this.secondMenu ();
	    }

	    c.setCursor (16, 25);
	    c.print ("Press 'w' to go up, 's' to go down");
	    char ch = c.getChar ();

	    if (ch == 's' || ch == 'S')
	    {
		if (num == 1)
		{
		    num = 2;
		}
	    }
	    else if (ch == 'w' || ch =='W')
	    {
		if (num == 2)
		{
		    num = 1;
		}
	    }

	    key = (int) ch;

	}
	while (key != 10);
	// 10 means <Enter>

	return num;

    } // menu method


    /**
     * Displays the title.
     * pre: none
     * post: The title has been displayed.
     */
    private void title ()
    {
	c.setTextColour (Color.RED);
	c.setCursor (5, 3);
	c.println ("________________      _____    ___________                                   ");
	c.setCursor (6, 3);
	c.println ("\\_   _____/     \\    /     \\   \\_   _____/ ______ ____ _____  ______   ____  ");
	c.setCursor (7, 3);
	c.println (" |    __)/  \\ /  \\  /  \\ /  \\   |    __)_ /  ___// ___\\\\__  \\ \\____ \\_/ __ \\ ");
	c.setCursor (8, 3);
	c.println (" |     \\/    Y    \\/    Y    \\  |        \\\\___ \\\\  \\___ / __ \\|  |_> >  ___/");
	c.setCursor (9, 3);
	c.println (" \\___  /\\____|__  /\\____|__  / /_______  /____  >\\___  >____  /   __/ \\___  >");
	c.setCursor (10, 3);
	c.println ("     \\/         \\/         \\/          \\/     \\/     \\/     \\/|__|        \\/");
    } // title method


    /**
     * Changes the text background colour to green for "[1] Start"
     * pre: none
     * post: The text background colour  for "[1] Start" has been changed to green;
     *       The text background colour  for "[2] Student History" has been changed to white.
     */
    private void firstMenu ()
    {

	c.setTextColour (Color.BLACK);
	c.setCursor (13, 30);
	c.setTextBackgroundColor (Color.GREEN);
	c.print ("[1] Start");
	c.setCursor (13, 39);
	c.setTextBackgroundColor (Color.WHITE);
	c.print ("");
	c.setCursor (14, 30);
	c.print ("[2] Student History");
    } // firstMenu method


    /**
     * Changes the text background colour to green for "[2] Student History"
     * pre: none
     * post: The text background colour  for "[1] Start" has been changed to white;
     *       The text background colour  for "[2] Student History" has been changed to green.
     */
    private void secondMenu ()
    {

	c.setTextColour (Color.BLACK);
	c.setCursor (13, 30);
	c.print ("[1] Start");
	c.setTextBackgroundColor (Color.GREEN);
	c.setCursor (14, 30);
	c.print ("[2] Student History");
	c.setCursor (14, 49);
	c.setTextBackgroundColor (Color.WHITE);
	c.print ("");
    } // secondMenu method
} // HomePage class


