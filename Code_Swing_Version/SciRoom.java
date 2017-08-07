// The "SciRoom" class.
// Authors:
// Miao Wang
// Jasmine Xiao

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;

public class SciRoom extends Classroom
{
    //Objects decleared
    static JLabel background;
    static SciQuestion question;
    Box horizontalBox;
    JButton fill1, fill2;

    /**
     * constructor
     * pre: Hallway class, Music class
     * post: SciRoom has been selected
     */
    public SciRoom (Hallway hallway, Music bgm)
    {
	// inheret parent class
	super (hallway, bgm);
	// Inititlize filler button
	fill1 = new JButton ("Left");
	fill2 = new JButton ("Right");
    } // constructor


    /**
    *Displays the Panel.
    *pre:none
    *post:The panel has been displayed.
    */
    public void display (int num)
    {
	// new JLabel made each time
	background = new JLabel (new ImageIcon ("classrooms/sciPic.jpg"));
	background.setLayout (new BoxLayout (background, BoxLayout.Y_AXIS));

	// create the SciQuestion object
	if (num == 0)
	    question = new SciQuestion (hallway, bgm);

	// Make JPanel of one random question
	question.showQuestion ();

	// Question box placed in middle of screen
	horizontalBox = Box.createHorizontalBox ();
	horizontalBox.add (fill1);
	horizontalBox.add (Box.createGlue ());
	horizontalBox.add (question.questions);
	horizontalBox.add (Box.createGlue ());
	horizontalBox.add (fill2);
	fill1.setVisible (false);
	fill2.setVisible (false);

	// add question box to display
	background.add (horizontalBox);

    } // display method
} // SciRoom class
