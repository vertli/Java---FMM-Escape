// The "MainClass" class.
// Author: Jasmine Xiao

import java.io.*;
import java.util.*;

public class MainClass
{
    // pre: none
    // post: GUI and frame created and shown, music played
    private static void runGUI () throws IOException
    {
	try
	{
	    // Play music
	    Music bgm = new Music ();
	    bgm.playBGM ();
 
	    // Instantiate object from FMMHomePage class
	    FMMHomePage test = new FMMHomePage (bgm);

	    // Set the frame style
	    test.window.setDefaultLookAndFeelDecorated (true);

	    // Set up and display the window
	    test.setFrame ();
	}
	catch (IOException e)
	{
	}
    }


    // pre: none
    // post: GUI shown and music played
    public static void main (String[] args) throws IOException
    {
	// Methods that create and show a GUI should be
	// run from an event-dispatching thread
	javax.swing.SwingUtilities.invokeLater (new Runnable ()
	{
	    public void run ()
	    {
		try
		{
		    runGUI ();
		}
		catch (IOException e)
		{
		}
	    }
	}
	);
    }
} // MainClass class


