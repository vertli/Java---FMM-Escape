// The "MathQuestion" class.
// Authors:
// Miao Wang
// Jasmine Xiao

import java.awt.*;
import java.io.File;
import java.awt.event.*;

public class MathQuestion extends Question
{
    //Object decleared
    static MathRoom room;

    /**
     * constructor
     * pre: Hallway class, Music class
     * post: EnglishQuestion has been selected.
     */
    public MathQuestion (Hallway hallway, Music bgm)
    {
	super (hallway, bgm);
	this.textFile = new File ("questions/maths.txt");
	this.getFile ();
	room = new MathRoom (hallway, bgm);
    } // constructor


    // pre: ActionEvent object
    // post: When "submit" button is pressed, radio buttons' states are checked,
    // answers are checked
    public void actionPerformed (ActionEvent event)
    {
	String chose = event.getActionCommand ();

	if (chose.equals ("submit"))
	{
	    if (a.isSelected ())
	    {
		this.guess = 'a';
	    }
	    else if (b.isSelected ())
	    {
		this.guess = 'b';
	    }
	    else if (c.isSelected ())
	    {
		this.guess = 'c';
	    }
	    else if (d.isSelected ())
	    {
		this.guess = 'd';
	    }
	    else
	    {
		this.guess = 'n';
	    }
	    six = six + 1;
	    checkAnswer ();

	    // display 6 quesitons
	    if (six < 6)
	    {
		showQuestion ();
		room.display (six);
		//show question
		FMMHomePage.setContentPane (room.background);
	    }

	    // Decide if player passed or not
	    else if (six == 6)
	    {
		room.pass (this);
		// checks the user can get item or not
		if (room.pass == true)
		    hallway.passCourse (0);

		//Failed scream
		else
		    FMMHomePage.setContentPane (hallway.gameOverPic);
	    }
	}
    }
} // MathQuestion Class

