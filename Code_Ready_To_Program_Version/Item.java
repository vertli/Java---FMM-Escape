/*
 * Item Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import hsa.Console;

public class Item
{
    static Console c; // The output console

    // arrays
    protected String itemName[] = new String [12];
    protected String itemDetail[] = new String [12];
    protected boolean getItem[] = new boolean [12];
    protected boolean saveItem[] = new boolean [12];

    // variable
    protected int num = 0;

    /**
     * constructor
     * pre: Console c
     * post: Item has been created.
     */
    public Item (Console c)
    {

	this.c = c;

	for (int i = 0 ; i < 12 ; i++)
	{
	    getItem [i] = false;
	    saveItem [i] = false;
	} // for loop

	this.setting ();

    } // constructor


    /**
     * Sets up the name and explaintion for all the items.
     * pre: none
     * post: The  name and explaintion for all the items have been setted up.
     */
    private void setting ()
    {
	itemName [0] = " Hint #1 ";
	itemDetail [0] = "The object is usually rectangular.";

	itemName [1] = " Hint #2 ";
	itemDetail [1] = "It is not about hard work, it is about working hard!";

	itemName [2] = " Hint #3 ";
	itemDetail [2] = "The object has numbers and letters.";

	itemName [3] = " Hint #4 ";
	itemDetail [3] = "The object can be pressed.";

	itemName [4] = " Hint #5 ";
	itemDetail [4] = "Do it now! Sometimes \"later\" becomes \"never\".";

	itemName [5] = " Hint #6 ";
	itemDetail [5] = "\"Enter\" = \"Input\"";

	itemName [6] = " Calculator ";
	itemDetail [6] = "You got it when you got 100% in Maths exam. By the way, it's useless.";

	itemName [7] = " Hamlet ";
	itemDetail [7] = "You got it when you got 100% in English exam. By the way, it's useless.";

	itemName [8] = " Textbook ";
	itemDetail [8] = "It's a Biology textbook. You got it when you got 100% in Science exam.\nBy the way, it's useless.";

	itemName [9] = "  Money ";
	itemDetail [9] = "You got it when you got 100% in Business exam. By the way, it's useless...?!";

	itemName [10] = " Basketball ";
	itemDetail [10] = "You got it when you got 100% in PhysEd exam. By the way, it's useless.";

	itemName [11] = " Paint ";
	itemDetail [11] = "You got it when you got 100% in Art exam. By the way, it's useless.";

    } // setting method


    /**
     * Uses it when user gets any item.
     * pre: int i
     * post: true has been passed into getItem[i].
     */
    public void get (int i)
    {
	getItem [i] = true;
    } // get method


    /**
     * Uses it when user loses any item.
     * pre: int i
     * post: false has been passed into getItem[i].
     */
    public void lost (int i)
    {
	getItem [i] = false;
    } // get method


    /**
     * Displays the items on item's menu.
     * pre: none
     * post: The items have been displayed.
     */
    private void display ()
    {

	if (getItem [0] == true)
	{
	    c.setCursor (8, 3);
	    c.print (itemName [0]);
	}

	if (getItem [1] == true)
	{
	    c.setCursor (8, 16);
	    c.print (itemName [1]);
	}

	if (getItem [2] == true)
	{
	    c.setCursor (8, 29);
	    c.print (itemName [2]);
	}

	if (getItem [3] == true)
	{
	    c.setCursor (8, 42);
	    c.print (itemName [3]);
	}

	if (getItem [4] == true)
	{
	    c.setCursor (8, 55);
	    c.print (itemName [4]);
	}

	if (getItem [5] == true)
	{
	    c.setCursor (8, 69);
	    c.print (itemName [5]);
	}

	if (getItem [6] == true)
	{
	    c.setCursor (10, 2);
	    c.print (itemName [6]);
	}

	if (getItem [7] == true)
	{
	    c.setCursor (10, 17);
	    c.print (itemName [7]);
	}

	if (getItem [8] == true)
	{
	    c.setCursor (10, 29);
	    c.print (itemName [8]);
	}

	if (getItem [9] == true)
	{
	    c.setCursor (10, 43);
	    c.print (itemName [9]);
	}

	if (getItem [10] == true)
	{
	    c.setCursor (10, 54);
	    c.print (itemName [10]);
	}

	if (getItem [11] == true)
	{
	    c.setCursor (10, 70);
	    c.print (itemName [11]);
	}

    } // display method


    /**
     * The menu for item class.
     * pre: none
     * The menu has been displayed.
     */
    public void menu ()
    {

	// variable
	int key = 0;

	c.clear ();

	do
	{

	    do
	    {
		this.frame ();
		this.display ();
		this.menuChange ();
		char ch = c.getChar ();
		this.readKey (ch);

		key = (int) ch;

	    }
	    while (key != 10 && key != 120 && key != 88);
	    // 10 means <Enter>, 88 and 120 mean <X> and <x>

	    c.clear ();
	    this.frame ();
	    this.display ();
	    this.menuChange ();

	    if (key == 10) // 10 means <Enter>
	    {
		c.setCursor (12, 1);
		switch (num)
		{
		    case 0:
			if (getItem [0] == true)
			{
			    c.print (itemDetail [0]);
			}
			break;
		    case 1:
			if (getItem [1] == true)
			{
			    c.print (itemDetail [1]);
			}
			break;
		    case 2:
			if (getItem [2] == true)
			{
			    c.print (itemDetail [2]);
			}
			break;
		    case 3:
			if (getItem [3] == true)
			{
			    c.print (itemDetail [3]);
			}
			break;
		    case 4:
			if (getItem [4] == true)
			{
			    c.print (itemDetail [4]);
			}
			break;
		    case 5:
			if (getItem [5] == true)
			{
			    c.print (itemDetail [5]);
			}
			break;
		    case 6:
			if (getItem [6] == true)
			{
			    c.print (itemDetail [6]);
			}
			break;
		    case 7:
			if (getItem [7] == true)
			{
			    c.print (itemDetail [7]);
			}
			break;
		    case 8:
			if (getItem [8] == true)
			{
			    c.print (itemDetail [8]);
			}
			break;
		    case 9:
			if (getItem [9] == true)
			{
			    c.print (itemDetail [9]);
			}
			break;
		    case 10:
			if (getItem [10] == true)
			{
			    c.print (itemDetail [10]);
			}
			break;
		    case 11:
			if (getItem [11] == true)
			{
			    c.print (itemDetail [11]);
			}
			break;
		} // end switch... case...
		c.println ();
	    } // end if (key == 10)

	}
	while (key != 120);
    } // menu method


    /**
     * The frame for item class.
     * pre: none
     * post: The frame has been displayed.
     */
    private void frame ()
    {

	//variable
	int i;

	c.setCursor (1, 1);
	for (i = 0 ; i < 80 ; i++)
	{
	    c.print ("-");
	} // end for (i)

	c.setCursor (2, 32);
	c.print ("  ___  ___");
	c.setCursor (3, 32);
	c.print ("|  |  |__   |\\/|");
	c.setCursor (4, 32);
	c.print ("|  |  |___  |  |");

	c.setCursor (5, 1);
	for (i = 0 ; i < 80 ; i++)
	{
	    c.print ("-");
	} // end for (i)

	c.setCursor (6, 1);
	c.print ("|            |            |            |            |            |             |");
	c.setTextBackgroundColor (Color.CYAN);
	c.setCursor (6, 4);
	c.print (" Maths ");
	c.setCursor (6, 16);
	c.print (" English ");
	c.setCursor (6, 29);
	c.print (" Science ");
	c.setCursor (6, 42);
	c.print (" Business ");
	c.setCursor (6, 56);
	c.print (" PhysEd ");
	c.setCursor (6, 71);
	c.print (" Art ");

	c.setTextBackgroundColor (Color.WHITE);
	c.setCursor (7, 1);
	for (i = 0 ; i < 80 ; i++)
	{
	    c.print ("-");
	} // end for (i)

	c.setCursor (8, 1);
	c.print ("|            |            |            |            |            |             |");

	c.setCursor (9, 1);
	for (i = 0 ; i < 80 ; i++)
	{
	    c.print ("-");
	} // end for (i)

	c.setCursor (10, 1);
	c.print ("|            |            |            |            |            |             |");

	c.setCursor (11, 1);
	for (i = 0 ; i < 80 ; i++)
	{
	    c.print ("-");
	} // end for (i)


	c.setCursor (15, 1);
	for (i = 0 ; i < 80 ; i++)
	{
	    c.print ("-");
	} // end for (i)

	c.println ("Use <A> <W> <S> <D> keys to move the green box.");
	c.print ("press <Enter> to read the detail of item or press <X> to leave this page.");

	c.setCursor (18, 1);
	for (i = 0 ; i < 80 ; i++)
	{
	    c.print ("-");
	} // end for (i)

    } // frame method


    /**
     * Changes the menu if the user presses any key.
     * pre: none
     * post: The menu has been changed.
     */
    private void menuChange ()
    {
	c.setTextBackgroundColor (Color.GREEN);

	switch (num)
	{
	    case 0:
		c.setCursor (8, 3);
		if (getItem [0] == true)
		{
		    c.print (itemName [0]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 1:
		c.setCursor (8, 16);
		if (getItem [1] == true)
		{
		    c.print (itemName [1]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 2:
		c.setCursor (8, 29);
		if (getItem [2] == true)
		{
		    c.print (itemName [2]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 3:
		c.setCursor (8, 42);
		if (getItem [3] == true)
		{
		    c.print (itemName [3]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 4:
		c.setCursor (8, 55);
		if (getItem [4] == true)
		{
		    c.print (itemName [4]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 5:
		c.setCursor (8, 69);
		if (getItem [5] == true)
		{
		    c.print (itemName [5]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 6:
		c.setCursor (10, 2);
		if (getItem [6] == true)
		{
		    c.print (itemName [6]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 7:
		c.setCursor (10, 17);
		if (getItem [7] == true)
		{
		    c.print (itemName [7]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 8:
		c.setCursor (10, 29);
		if (getItem [8] == true)
		{
		    c.print (itemName [8]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 9:
		c.setCursor (10, 43);
		if (getItem [9] == true)
		{
		    c.print (itemName [9]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 10:
		c.setCursor (10, 54);
		if (getItem [10] == true)
		{
		    c.print (itemName [10]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	    case 11:
		c.setCursor (10, 70);
		if (getItem [11] == true)
		{
		    c.print (itemName [11]);
		}
		else
		{
		    c.print ("       ");
		}
		break;
	} // end switch... case...

	c.setTextBackgroundColor (Color.WHITE);
	c.print ("");

    } // menuChange method


    /**
     * Changes num after the users presses any key.
     * pre: char ch
     * post: Num has been changed.
     */
    public void readKey (char ch)
    {
	switch (ch)
	{

		// left
	    case 'A':
	    case 'a':
		if (num > 0)
		{

		    num = num - 1;

		}
		break;

		// right
	    case 'D':
	    case 'd':
		if (num < 11)
		{

		    num = num + 1;

		}
		break;

		// up
	    case 'W':
	    case 'w':
		if (num >= 6 && num <= 11)
		{

		    num = num - 6;

		}
		break;

		// down
	    case 'S':
	    case 's':
		if (num >= 0 && num <= 5)
		{

		    num = num + 6;

		}
		break;
	} // switch ch

    } // readKey method
} // Item class
