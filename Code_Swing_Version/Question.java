// The "Question" class.
// Authors:
// Calvin Vert Li
// Miao Wang
// Jasmine Xiao

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;

public class Question implements ActionListener
{
    //Create objects
    static Hallway hallway;
    static Music bgm;

    // JPanel for the question area
    static JPanel questions;
    JButton submit;
    JLabel ques, check, result, pass, thing;
    JRadioButton a, b, c, d;
    ButtonGroup choice;

    // uses for read file
    protected File textFile;
    protected FileReader in;
    protected BufferedReader readFile;
    protected String lineOfText;

    // variable
    protected int i, six;
    protected int qNum;
    protected char guess;
    protected int correct;

    // array
    protected String[] question = new String [18];
    protected String[] [] choices = new String [18] [4];
    protected char[] answer = new char [18];
    protected boolean[] checkAns = new boolean [18];
    protected boolean[] questionUse = new boolean [18];

    /**
     * constructor
     * pre: Console c
     * post: Question has been created.
     */
    public Question (Hallway hallway, Music bgm)
    {
	init ();
	this.hallway = hallway;
	this.bgm = bgm;
    } // constructor


    /**
     * Re-sets all the checkAns and questionUse to false.
     * pre: none
     * post: false has been passed into all the checkAns and questionUse.
     */
    protected void init ()
    {
	for (i = 0 ; i < 18 ; i++)
	{
	    checkAns [i] = false;
	    questionUse [i] = false;
	} // end for (i)

    } // init method


    /**
     * Gets the question file.
     * pre: none
     * post: The question file has been getten.
     */
    protected void getFile ()
    {
	i = 0;

	try
	{
	    in = new FileReader (textFile);
	    readFile = new BufferedReader (in);

	    while ((lineOfText = readFile.readLine ()) != null)
	    {
		question [i] = lineOfText;

		if ((lineOfText = readFile.readLine ()) != null)
		{
		    choices [i] [0] = lineOfText;
		} // end if for answerA

		if ((lineOfText = readFile.readLine ()) != null)
		{
		    choices [i] [1] = lineOfText;
		} // end if for answerB

		if ((lineOfText = readFile.readLine ()) != null)
		{
		    choices [i] [2] = lineOfText;
		} // end if for answerC

		if ((lineOfText = readFile.readLine ()) != null)
		{
		    choices [i] [3] = lineOfText;
		} // end if for answerD


		if ((lineOfText = readFile.readLine ()) != null)
		{
		    answer [i] = (char) lineOfText.charAt (0);
		} // end if for answer

		i = i + 1;

	    } // end while

	    readFile.close ();
	    in.close ();
	}
	catch (FileNotFoundException e)
	{
	}
	catch (IOException e)
	{
	}
	catch (NullPointerException e)
	{
	}
    } // getFile method


    /**
     * Randoms a number(1~18).
     * pre: none
     * post: A number has been randomed.
     */
    protected void randomQuestion ()
    {
	do
	{
	    qNum = (int) (Math.random () * 18);
	}
	while (questionUse [qNum] == true);
	// make sure the question will not use it more than twice

	questionUse [qNum] = true;

    } // randomQuestion method


    /**
     * Displays the question and answer choices.
     * pre: none
     * post: The question and answer choices have been displayed.
     */
    protected void setQuestion ()
    {
	//set panel
	questions = new JPanel ();
	questions.setLayout (new BoxLayout (questions, BoxLayout.Y_AXIS));
	questions.setBorder (BorderFactory.createEmptyBorder (5, 1, 5, 1));

	// set label
	ques = new JLabel (this.question [qNum]);
	ques.setFont (new Font ("Times New Roman", Font.BOLD, 16));
	questions.add (ques);

	//set choices
	a = new JRadioButton (this.choices [qNum] [0]);
	a.setFont (new Font ("Times New Roman", Font.PLAIN, 16));
	a.setActionCommand ("a");
	a.addActionListener (this);
	questions.add (a);
	b = new JRadioButton (this.choices [qNum] [1]);
	b.setFont (new Font ("Times New Roman", Font.PLAIN, 16));
	b.setActionCommand ("b");
	b.addActionListener (this);
	questions.add (b);
	c = new JRadioButton (this.choices [qNum] [2]);
	c.setFont (new Font ("Times New Roman", Font.PLAIN, 16));
	c.setActionCommand ("c");
	c.addActionListener (this);
	questions.add (c);
	d = new JRadioButton (this.choices [qNum] [3]);
	d.setFont (new Font ("Times New Roman", Font.PLAIN, 16));
	d.setActionCommand ("d");
	d.addActionListener (this);
	questions.add (d);

	//Set button group
	choice = new ButtonGroup ();
	choice.add (a);
	choice.add (b);
	choice.add (c);
	choice.add (d);
	a.setBackground (Color.white);
	b.setBackground (Color.white);
	c.setBackground (Color.white);
	d.setBackground (Color.white);

	//Set submit button
	submit = new JButton ("Submit");
	submit.setBackground (Color.white);
	submit.setFont (new Font ("Times New Roman", Font.PLAIN, 20));
	submit.setActionCommand ("submit");
	submit.addActionListener (this);
	questions.add (submit);

	//Display how many questions were answered correctly
	result = new JLabel ("You got " + correct + "/6 correct(s).");
	questions.add (result);

	questions.setBackground (Color.white);

    } // setQuestion method


    /**
     * Decide which action to take depend on player's choice
     * pre: ActionEvent
     * post: Indicated action performed
    */
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
	    checkAnswer ();
	    if (six < 6)
	    {
		showQuestion ();
	    }
	    six += 1;
	}
    }


    /**
     * Checks the user's guess is correct or not
     * pre: none
     * post: checking the user's guess is correct or not.
     */
    protected void checkAnswer ()
    {

	if (answer [qNum] == guess) // if the user's guess is correct
	    checkAns [qNum] = true;
	else // if the user's guess is not correct
	    checkAns [qNum] = false;
    } // checkAnswer method


    /**
     * Calls randomQuestion(), setQuestion(), checkCorrect() methoeds.
     * pre: None
     * post: The 3 methods have been called by order.
     */
    protected void showQuestion ()
    {
	randomQuestion ();
	setQuestion ();
	checkCorrect ();
    } // showQuestion method


    /**
     * Displays a message to user about how many question(s) he/she got correct
     * pre: none
     * post: The message has been displayed and correct has been returned.
     */
    protected int checkCorrect ()
    {
	correct = 0;

	for (i = 0 ; i < 18 ; i++)
	{
	    if (checkAns [i] == true)
	    {
		correct = correct + 1;
	    }
	} // for

	return (correct);
    } // checkCorrect method
} // Question Class
