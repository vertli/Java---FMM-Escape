/*
 * Main Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class Main
{

    static Console c; // The output console

    public static void main (String[] args) throws IOException
    {

	// variable
	int num;

	// sets up the title
	c = new Console ("FMM Escape"); // The output console

	Music bgm = new Music ();

	for (;;)
	{
	    bgm.playBGM ();

	    // creates HomePage object and calls home
	    HomePage home = new HomePage (c);

	    num = home.menu (); // calls menu() from HomePage and passes a number into num

	    // creates Game object and calls game
	    Game game = new Game (num, c, bgm);
	    
  

	} // for loop, never stop

    } // main method
} // Main class
