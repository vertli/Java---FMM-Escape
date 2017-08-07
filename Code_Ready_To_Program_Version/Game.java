/*
 * Game Class - Ready in Program
 * Chun Kit (Calvin) Li
 */

import java.awt.*;
import java.io.IOException;
import hsa.Console;

public class Game
{
    static Console c; // The output console
    static Music bgm;


    // variable
    private String name;

    /**
     * constructor
     * pre: Console c, int num
     * post: Game has been created.
     */
    public Game (int num, Console c, Music bgm) throws IOException
    {

	this.c = c;
	this.bgm = bgm;

	if (num == 1)
	{
	    this.startGame ();
	}
	else if (num == 2)
	{
	    this.studentHistory ();
	}

    } // constructor


    /**
     * Starts the game.
     * pre: none
     * post: The game has been started.
     */
    private void startGame () throws IOException
    {

	this.enterName ();
	this.instruction ();

	// Create School class calls c.
	School s = new School (c, this.name, this.bgm);
	s.hallway ();

    } // startGame method


    /**
     * Asks the user enters his/her name.
     * pre: none
     * The user's name has been passed into name.
     */
    private void enterName ()
    {
	c.clear ();
	c.println ("Please enter your name and press <enter>: ");
	this.name = c.readLine ();
    } // enterName mathod


    /**
     * Displays the instruction.
     * pre: none
     * The instruction has been displayed.
     */
    private void instruction ()
    {
	c.clear ();
	c.println ();
	c.println ("You are a FMM student. Today is exam day! NO WAY!!!");
	c.println ("You will be tested on each of the 6 basic courses in the order of Math, English,\nScience, Business, PhysEd, and Art.");
	c.println ("You will not be able to skip any course, and must pass the first course to allow\naccess to the next course.");
	c.println ("In each round, you will be required to answer 6 trivia questions and if you get at least 4 out of them right, you pass that course.");
	c.println ("Each time you pass a course, you will obtain an \"item\", which is a hint for the final riddle or simply a motivation quote.");
	c.println ("Once you fail any course it is game over.");
	c.println ("You can restart but it will start from the first class (Math) again, and the \nyears you take to graduate will increment by 1.");
	c.println ("Be careful, once you press the \"give up\" button you will become a permanent \nstudent!");
	c.println ("The \"escape\" choice brings you to the riddle page, where you will get an \nunlimited number of tries to input the answer.");
	c.println ("After you pass all courses and answer the final riddle, you will finally be able\nto escape from FMM!");
	c.println ();
	c.print ("Please press any key to continue");
	char ch = c.getChar ();
    } // instruction method


    /**
     * Displays the student history.
     * pre: none
     * post: The student history has been displayed.
     */
    private void studentHistory ()
    {

	// creates StudentHistory class and calls sH
	StudentHistory sH = new StudentHistory (c);
	sH.recordPage ();

    } // studentHistory method


    /**
     * Displays game over message.
     * pre: none
     * post: the game over message has been displayed.
     */
    public void gameOver ()
    {
	c.println ("  ________");
	c.println (" /  _____/_____    _____   ____");
	c.println ("/   \\  ___\\__  \\  /     \\_/ __ \\");
	c.println ("\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/");
	c.println (" \\______  (____  /__|_|  /\\___  > ");
	c.println ("        \\/     \\/      \\/     \\/ ");
	c.println ("           ________                    ._.");
	c.println ("           \\_____  \\___  __ ___________| |");
	c.println ("            /   |   \\  \\/ // __ \\_  __ \\ |");
	c.println ("           /    |    \\   /\\  ___/|  | \\/\\|");
	c.println ("           \\_______  /\\_/  \\___  >__|   __");
	c.println ("                   \\/          \\/       \\/");
	c.println ("");
	c.println ("Better Luck Next Year!");
	c.println ("");
    } // gameOver method
} // Game class
