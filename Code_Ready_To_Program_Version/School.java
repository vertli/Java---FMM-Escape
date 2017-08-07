/*
 * School Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class School
{

    static Console c; // The output console
    static Music bgm;

    // array
    private boolean[] check = new boolean [6];

    // variable
    private int num;
    private int time;
    private int passNum;

    private boolean pass;
    private boolean close1;
    private boolean close2;
    private boolean close3;
    private boolean close4;
    private boolean close5;
    private boolean close6;

    private String name;

    /**
     * constructor
     * pre: Console c, String name
     * post: School has been created.
     */
    public School (Console c, String name, Music bgm) throws IOException
    {
	this.c = c;
	this.name = name;
	this.time = 0;
	this.bgm = bgm;
	this.bgm.playBGM ();
    } // constructor


    /**
     * The main program of the game.
     * pre: none
     * post: The game has been started.
     */
    public void hallway () throws IOException
    {

	Item item = new Item (c);
	Student student = new Student (this.name);

	// variable
	int key;
	boolean stop = false;
	boolean passCourse = true;

	this.init ();
	c.clear ();

	do
	{

	    if (passCourse == true)
	    {
		do
		{
		    this.menu ();
		    this.menuChange ();
		    char ch = c.getChar ();
		    this.readKey (ch);

		    key = (int) ch;
		    c.clear ();

		}
		while (key != 10);
	    }
	    else
	    {
		num = 2;
		passCourse = true;
	    }


	    switch (num)
	    {
		case 0:
		    if (passNum == 6)
		    {
			Riddle riddle = new Riddle (c);
			stop = riddle.getCorrect ();
			if (stop == true)
			{
			    student.graduate ();
			}
		    }
		    else
		    {
			this.principalRm ();
		    }
		    break;
		case 1:
		    stop = true;
		    this.giveUp ();
		    break;
		case 2:
		    init ();
		    for (int i = 0 ; i < 12 ; i++)
		    {
			item.lost (i);
		    }
		    num = 0;
		    break;
		case 3:
		    item.menu ();
		    c.clear ();
		    break;
		case 4:

		    if (close1 == false)
		    {
			Classroom rm = new MathsRm (c, item, bgm);
			pass = rm.getPass ();
			c.clear ();
			if (pass == true)
			{
			    close1 = true;
			    close2 = false;
			    pass = false;
			    passNum = passNum + 1;
			}
			else
			{
			    passCourse = false;
			}
		    }
		    else
		    {
			doorClosed ();
		    }
		    break;
		case 5:
		    if (close2 == false)
		    {
			Classroom rm = new EnglishRm (c, item, bgm);
			pass = rm.getPass ();
			c.clear ();
			if (pass == true)
			{
			    close2 = true;
			    close3 = false;
			    pass = false;
			    passNum = passNum + 1;
			}
			else
			{
			    passCourse = false;
			}
		    }
		    else
		    {
			doorClosed ();
		    }
		    break;
		case 6:
		    if (close3 == false)
		    {
			Classroom rm = new ScienceRm (c, item, bgm);
			pass = rm.getPass ();
			c.clear ();
			if (pass == true)
			{
			    close3 = true;
			    close4 = false;
			    pass = false;
			    passNum = passNum + 1;
			}
			else
			{
			    passCourse = false;
			}
		    }
		    else
		    {
			doorClosed ();
		    }
		    break;
		case 7:
		    if (close4 == false)
		    {
			Classroom rm = new BusinessRm (c, item, bgm);
			pass = rm.getPass ();
			c.clear ();
			if (pass == true)
			{
			    close4 = true;
			    close5 = false;
			    pass = false;
			    passNum = passNum + 1;
			}
			else
			{
			    passCourse = false;
			}
		    }
		    else
		    {
			doorClosed ();
		    }
		    break;
		case 8:
		    if (close5 == false)
		    {
			Classroom rm = new PhysEdRm (c, item, bgm);
			pass = rm.getPass ();
			c.clear ();
			if (pass == true)
			{
			    close5 = true;
			    close6 = false;
			    pass = false;
			    passNum = passNum + 1;
			}
			else
			{
			    passCourse = false;
			}
		    }
		    else
		    {
			doorClosed ();
		    }
		    break;
		case 9:
		    if (close6 == false)
		    {
			Classroom rm = new ArtsRm (c, item, bgm);
			pass = rm.getPass ();
			c.clear ();
			if (pass == true)
			{
			    close6 = true;
			    pass = false;
			    passNum = passNum + 1;
			}
			else
			{
			    passCourse = false;
			}
		    }
		    else
		    {
			doorClosed ();
		    }
		    break;
	    }

	}
	while (stop == false);

	student.setYears (time);

	StudentHistory sH = new StudentHistory (c);
	sH.writeStudentToFile (student);

    } // hallway method


    /**
     * Re-sets everything if the user chooses "restart"
     * pre: none
     * post: Everything has been re-setted.
     */
    public void init ()
    {

	for (int i = 0 ; i < 6 ; i++)
	{
	    check [i] = false;
	}

	time = time + 1;

	passNum = 0;
	num = 0;

	pass = false;
	close1 = false;
	close2 = true;
	close3 = true;
	close4 = true;
	close5 = true;
	close6 = true;

    } // init method


    /**
     * Displays the menu.
     * pre: none
     * post: The menu has been displayed.
     */
    public void menu ()
    {

	c.setCursor (2, 20);
	c.println ("Father Michael McGivney Catholic Academy"); //40

	c.setCursor (6, 7);
	c.print ("[1] Escape"); //10
	c.setCursor (6, 24);
	c.print ("[2] Give Up"); //11
	c.setCursor (6, 40);
	c.print ("[3] Restart"); //11
	c.setCursor (6, 56);
	c.print ("[4] Items"); //9

	c.setCursor (9, 7);
	c.print ("[5] Maths Room"); // 14
	c.setCursor (9, 28);
	c.print ("[6] English Room"); //16
	c.setCursor (9, 49);
	c.print ("[7] Science Room"); //16
	c.setCursor (13, 7);
	c.print ("[8] Business Room"); //17
	c.setCursor (13, 30);
	c.print ("[9] PhysEd Room"); //15
	c.setCursor (13, 51);
	c.print ("[10] Art Room"); //13
	
	c.setCursor (18, 6);
	c.print ("Use <a> <s> <d> <w> to move the choice, press <enter> to confirm.");
    } // menu method


    /**
     * Displays the message if the user chooses "give up"
     * pre: none
     * post: The message has been displayed.
     */
    public void giveUp ()
    {
	c.clear ();
	c.println ();
	c.println ("Sorry...");
	c.println ("You become a permanent student at FMM...");
	c.println ();
	c.println ("Press any key to go back the main menu");
	char ch = c.getChar ();
    } // giveUp method


    /**
     * Changes the text background colour.
     * pre: none
     * post: The text background colour has been changed.
     */
    public void menuChange ()
    {

	c.setTextBackgroundColor (Color.GREEN);

	switch (num)
	{
	    case 0:
		c.setCursor (6, 7);
		c.print ("[1] Escape"); //10
		break;
	    case 1:
		c.setCursor (6, 24);
		c.print ("[2] Give Up"); //11
		break;
	    case 2:
		c.setCursor (6, 40);
		c.print ("[3] Restart"); //11
		break;
	    case 3:
		c.setCursor (6, 56);
		c.print ("[4] Items"); //9
		break;
	    case 4:
		c.setCursor (9, 7);
		c.print ("[5] Maths Room"); // 14
		break;
	    case 5:
		c.setCursor (9, 28);
		c.print ("[6] English Room"); //16
		break;
	    case 6:
		c.setCursor (9, 49);
		c.print ("[7] Science Room"); //16
		break;
	    case 7:
		c.setCursor (13, 7);
		c.print ("[8] Business Room"); //17
		break;
	    case 8:
		c.setCursor (13, 30);
		c.print ("[9] PhysEd Room"); //15
		break;
	    case 9:
		c.setCursor (13, 51);
		c.print ("[10] Art Room"); //13
		break;
	}


	c.setTextBackgroundColor (Color.WHITE);
	c.print ("");

    } // menuChange method


    /**
     * Changes num after the user presses a key.
     * char ch
     * num has been changed.
     */
    public void readKey (char ch)
    {
	switch (ch)
	{
	    case 'A':
	    case 'a':
		if (num > 0)
		{
		    num = num - 1;
		}
		break;
	    case 'D':
	    case 'd':
		if (num < 9)
		{
		    num = num + 1;
		}
		break;
	    case 'W':
	    case 'w':
		if (num >= 4 && num <= 6)
		{
		    num = num - 4;
		}
		else if (num >= 7 && num <= 9)
		{
		    num = num - 3;
		}
		break;
	    case 'S':
	    case 's':
		if (num >= 4 && num <= 6)
		{
		    num = num + 3;
		}
		else if (num >= 0 && num <= 2)
		{
		    num = num + 4;
		}
		else if (num == 3)
		{
		    num = 6;
		}
		break;
	} // switch ch
    } // readKey method


    /**
     * Displays a message if the door is closed.
     * pre: none
     * post: The message has been displayed.
     */
    public void doorClosed ()
    {
	c.setCursor (15, 7);
	c.println ("The door is locked!");
    } // doorClosed method


    /**
     * Displays the Principal's Room
     * pre: none
     * post: The Principal's Room has been displayed.
     */
    public void principalRm ()
    {
	c.setTextColor (Color.RED);
	c.println ("Principal's Room");
	c.setTextColor (Color.BLACK);
	c.println ();
	c.println ("    ______________________________________________________");
	c.println ("   |Mr. Paonessa:                                         |");
	c.println ("   |Your parents will be very disappointed if you do not  |");
	c.println ("   |pass all your courses.                                |");
	c.println ("   |                                                      |");
	c.println ("   |                                                      |");
	c.println ("   |         (Please press any key to continue)           |");
	c.println ("   |______________________________________________________|");

	char ch = c.getChar ();
	c.clear ();
    } // principalRm methed
} // School class
