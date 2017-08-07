/*
 * Question Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import hsa.Console;

public class Question
{

    static Console c; // The output console

    // uses for read file
    protected File textFile;
    protected FileReader in;
    protected BufferedReader readFile;
    protected String lineOfText;

    // variable
    protected int i;
    protected int qNum;
    protected char guess;
    protected int correct;

    // array
    protected String[] question = new String [18];
    protected String[] [] choices = new String [18] [4];
    protected char[] answer = new char [18];
    protected boolean[] checkAns = new boolean [18];
    protected boolean[] questionUse = new boolean [18];

    protected Item item;

    /**
     * constructor
     * pre: Console c
     * post: Question has been created.
     */
    public Question (Console c)
    {
	this.c = c;

	init ();

	Item item = new Item (c);
	this.item = item;

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
	    System.out.println ("File does not exist or could not be found.");
	    System.err.println ("FileNotFoundException: " + e.getMessage ());
	}
	catch (IOException e)
	{
	    System.out.println ("Problem reading file.");
	    System.err.println ("IOException: " + e.getMessage ());
	}
	catch (NullPointerException e)
	{
	    System.out.println ("NullPointerException.");
	    System.err.println ("NullPointerException: " + e.getMessage ());
	}
    } // getFile method


    /**
     * Randoms a number(1~18).
     * pre: none
     * post: A number has been randomed.
     */
    protected void randomQuestion ()
    {

	Random r = new Random ();

	do
	{
	    qNum = r.nextInt (17) + 1;
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

	c.println (question [qNum]);
	c.println (choices [qNum] [0]);
	c.println (choices [qNum] [1]);
	c.println (choices [qNum] [2]);
	c.println (choices [qNum] [3]);

    } // setQuestion method


    /**
     * Asks the user inputs the guess.
     * pre: none
     * post: The user's answer has been passed into guess.
     */
    protected void getAnswer ()
    {
	c.println ();
	do
	{
	    c.print ("Please enter your answer: ");
	    this.guess = c.readLine ().toLowerCase ().charAt (0);
	}
	while (this.guess != 'a' && this.guess != 'b' && this.guess != 'c' && this.guess != 'd');
	c.println ();

    } // getAnswer method


    /**
     * Checks the user's guess is correct or not
     * pre: String teacherName
     * The message has been displayed after checking the user's guess is correct or not.
     */
    protected void checkAnswer (String teacherName)
    {

	if (answer [qNum] == (this.guess)) // if the user's guess is correct
	{
	    c.println (teacherName + ": Correct!");
	    checkAns [qNum] = true;
	}
	else // if the user's guess is not correct
	{
	    c.print (teacherName + ": Wrong!");
	    c.print (" The answer is " + this.answer [qNum]);
	    checkAns [qNum] = false;
	}

	c.println ();

    } // checkAnswer method


    /**
     * Calls randomQuestion(), setQuestion(), getAnswer() and checkAnswer() methoeds.
     * pre: String teacherName
     * post: The four methods have been called by order.
     */
    protected void showQuestion (String teacherName)
    {
	randomQuestion ();
	setQuestion ();
	getAnswer ();
	checkAnswer (teacherName);
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

	c.println ("You got " + correct + "/6 correct(s)."); // message displays

	if (correct >= 4)
	{
	    c.println ("Congratulations! You pass the course.");
	    c.print ("You got a hint, ");
	    if (correct == 6)
	    {
		c.print ("and an useless thing, check them after you leave this room.");
	    } // end if (correct == 6)
	    else
	    {
		c.println ("check it after you leave this room.");
	    } // end if (correct >= 4)
	}
	else
	{
	    c.println ("You FAILED the course!");
	    c.println ("You need to re-take a more year!");
	} // end if if (correct < 4)

	return correct;

    } // checkCorrect method
} // Question Class
