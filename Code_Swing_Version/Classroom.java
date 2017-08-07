// The "Classroom" class.
// Authors:
// Miao Wang
// Jasmine Xiao

import java.awt.*;
import java.io.IOException;
import java.awt.event.*;

public class Classroom
{
    //Objects decleared
    static Music bgm;
    static Hallway hallway;

    // variables
    protected int correctNum;
    protected boolean pass;

    /**
     * constructor
     * pre: Hallway object, Music object
     * post: Classroom has been created.
     */
    public Classroom (Hallway hallway, Music bgm)
    {
	correctNum = 0;
	pass = false;
	this.hallway = hallway;
	this.bgm = bgm;
    } // constructor


    /**
     * Displays the frame for Classroom class.
     * pre: Question q
     * post: The frame has been displays.
     */
    public void pass (Question q)
    {
	correctNum = q.checkCorrect ();

	//decide if passed
	if (correctNum >= 4)
	    pass = true;
	else
	    pass = false;
    } // frame method
} // Classroom class

