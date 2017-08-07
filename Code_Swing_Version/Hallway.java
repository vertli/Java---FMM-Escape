// The "Hallway" class.
// Author: Jasmine Xiao

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Hallway implements ActionListener
{
    boolean riddle; // true: let student go to riddle page, false: let student go to principal page
    static Music bgm;
    static Items item;

    // Instructions Page
    static JPanel contentPane3;
    JLabel title2, paragraph;
    JButton begin;

    // Hallway Page
    static JLabel hallwayPic;
    JPanel hallway;
    JLabel space, space2;
    JButton escape, giveUp, restart, items;
    JButton[] doors;

    // Give Up Page
    static JLabel giveUpPic;
    JPanel giveUpPage;
    JLabel message;
    JButton menu;

    // Game Over Page
    static JLabel gameOverPic;
    JPanel gameOverPage;
    JLabel gameOver, space3, space4;
    JButton restart2, giveUp2;

    // Math Item Page
    static JPanel mathItem;
    JLabel course, getItem, itemName, description, space5;
    JButton next;

    // English Item Page
    static JPanel englishItem;
    JLabel course2, getItem2, itemName2, description2, space6;
    JButton next2;

    // Science Item Page
    static JPanel scienceItem;
    JLabel course3, getItem3, itemName3, description3, space7;
    JButton next3;

    // Business Item Page
    static JPanel businessItem;
    JLabel course4, getItem4, itemName4, description4, space8;
    JButton next4;

    // PhysEd Item Page
    static JPanel physedItem;
    JLabel course5, getItem5, itemName5, description5, space9;
    JButton next5;

    // Art Item Page
    static JPanel artItem;
    JLabel course6, getItem6, itemName6, description6, space10;
    JButton next6;

    // Constructor
    // pre: Music
    // post: riddle variable is initialized and all pages are set up for later use
    public Hallway (Music bgm)
    {
	riddle = false;
	item = new Items ();
	this.bgm = bgm;
	try
	{
	    bgm.playBGM ();
	}
	catch (IOException e)
	{
	}
	instructionsPage ();
	hallwayPage ();
	giveUpPage ();
	gameOverPage ();
	mathItemPage ();
	englishItemPage ();
	scienceItemPage ();
	businessItemPage ();
	physedItemPage ();
	artItemPage ();
    }


    // pre: none
    // post: instructions page is set up
    public void instructionsPage ()
    {
	// Create panel
	contentPane3 = new JPanel ();
	contentPane3.setBackground (Color.white);
	contentPane3.setLayout (new BoxLayout (contentPane3, BoxLayout.Y_AXIS));
	contentPane3.setBorder (BorderFactory.createEmptyBorder (40, 10, 10, 10));

	// Create and add Components to panel
	title2 = new JLabel ("Game Instructions");
	title2.setFont (new Font ("Pristina", Font.BOLD, 120));
	title2.setAlignmentX (Component.CENTER_ALIGNMENT);
	contentPane3.add (title2);

	paragraph = new JLabel ("");
	paragraph.setFont (new Font ("Times New Roman", Font.PLAIN, 25));
	paragraph.setForeground (Color.blue);
	paragraph.setAlignmentX (Component.CENTER_ALIGNMENT);
	contentPane3.add (paragraph);

	// Read instructions from text file
	File rules = new File ("FMMInstructions.txt");
	try
	{
	    FileReader in = new FileReader (rules);
	    BufferedReader read = new BufferedReader (in);
	    String text, everything;
	    // Surround String with "<html>" in front and </html> at the end
	    // so text on JLabel go to next line instead of going out the screen
	    everything = "<html>";

	    while ((text = read.readLine ()) != null)
	    {
		everything += text + "<br>";
	    }
	    everything += "</html>";

	    // Display instructions from text file on JLabel
	    paragraph.setText (everything);
	    read.close ();
	    in.close ();
	}
	catch (FileNotFoundException e)
	{
	    System.err.println ("FileNotFoundException: " + e.getMessage ());
	}
	catch (IOException e)
	{
	    System.err.println ("IOException: " + e.getMessage ());
	}

	// Create and add JButton to panel layout
	begin = new JButton ("Begin");
	begin.setFont (new Font ("Baskerville Old Face", Font.BOLD, 70));
	begin.setBackground (Color.white);
	begin.setAlignmentX (Component.CENTER_ALIGNMENT);
	begin.setActionCommand ("beginGame");
	begin.addActionListener (this);
	contentPane3.add (begin);
    }


    // pre: none
    // post: hallway page is set up
    public void hallwayPage ()
    {
	// Background picture
	hallwayPic = new JLabel (new ImageIcon ("backgrounds/school6.jpg"));
	hallwayPic.setLayout (new BoxLayout (hallwayPic, BoxLayout.Y_AXIS));

	// JPanel layout to contain Components inside
	hallway = new JPanel ();
	hallway.setLayout (new FlowLayout ());
	hallway.setBorder (BorderFactory.createEmptyBorder (50, 10, 50, 10));

	// Button options created, designed, and added along with other Components
	escape = new JButton ("Escape");
	giveUp = new JButton ("Give Up");
	restart = new JButton ("Restart");
	items = new JButton ("Items");

	escape.setPreferredSize (new Dimension (280, 50));
	escape.setFont (new Font ("Algerian", Font.BOLD, 30));
	escape.setForeground (Color.red);
	escape.setBackground (Color.white);
	escape.setActionCommand ("escape");
	escape.addActionListener (this);

	giveUp.setPreferredSize (new Dimension (280, 50));
	giveUp.setFont (new Font ("Algerian", Font.BOLD, 30));
	giveUp.setForeground (Color.black);
	giveUp.setBackground (Color.white);
	giveUp.setActionCommand ("giveUp");
	giveUp.addActionListener (this);

	restart.setPreferredSize (new Dimension (280, 50));
	restart.setFont (new Font ("Algerian", Font.BOLD, 30));
	restart.setForeground (Color.blue);
	restart.setBackground (Color.white);
	restart.setActionCommand ("restart");
	restart.addActionListener (this);

	items.setPreferredSize (new Dimension (280, 50));
	items.setFont (new Font ("Algerian", Font.BOLD, 30));
	items.setForeground (Color.green);
	items.setBackground (Color.white);
	items.setActionCommand ("items");
	items.addActionListener (this);

	// Space between top border and 4 buttons
	space = new JLabel (" ");
	space.setPreferredSize (new Dimension (1200, 80));
	hallway.add (space);

	hallway.add (escape);
	hallway.add (giveUp);
	hallway.add (restart);
	hallway.add (items);

	// Space between options and doors
	space2 = new JLabel (" ");
	space2.setPreferredSize (new Dimension (1200, 120));
	hallway.add (space2);

	// 6 Door Buttons for the 6 Classes
	// Regular door = the class to go in
	// Door with a "X" = locked, don't go in yet
	// Door with a "O" = passed, item obtained
	doors = new JButton [6];
	for (int i = 0 ; i < doors.length ; i++)
	{
	    ImageIcon image;
	    if (i != 0)
		image = new ImageIcon ("doors/Door" + (i + 1) + "Lock.png");

	    else
		image = new ImageIcon ("doors/Door" + (i + 1) + ".png");

	    doors [i] = new JButton (image);
	    doors [i].setPreferredSize (new Dimension (180, 318)); // width, height
	    doors [i].setBackground (Color.white);
	    doors [i].setActionCommand ("door" + (i + 1));
	    doors [i].addActionListener (this);

	    hallway.add (doors [i]);
	}

	// Add JPanel to JLabel background picture
	hallway.setOpaque (false);
	hallwayPic.add (hallway);
    }


    // pre: none
    // post: give up page is set up
    public void giveUpPage ()
    {
	// Add background image to JLabel
	giveUpPic = new JLabel (new ImageIcon ("backgrounds/school7.jpg"));
	giveUpPic.setLayout (new BoxLayout (giveUpPic, BoxLayout.Y_AXIS));

	// Create JPanel for layout of Components
	giveUpPage = new JPanel ();
	giveUpPage.setBorder (BorderFactory.createEmptyBorder (10, 10, 10, 10));

	message = new JLabel ("<html>Sorry...<br>You become a permanent<br>student at FMM..." + "</html>");
	message.setBorder (BorderFactory.createEmptyBorder (100, 0, 150, 0));
	message.setFont (new Font ("Algerian", Font.PLAIN, 85));
	message.setForeground (Color.white);
	message.setAlignmentX (Component.CENTER_ALIGNMENT);
	giveUpPage.add (message);

	menu = new JButton ("Main Menu");
	menu.setFont (new Font ("Georgia", Font.PLAIN, 80));
	menu.setBackground (Color.white);
	menu.setActionCommand ("menu");
	menu.addActionListener (this);
	giveUpPage.add (menu);

	// Add JPanel to JLabel background image
	giveUpPage.setOpaque (false);
	giveUpPic.add (giveUpPage);
    }


    // pre: none
    // post: game over page is set up
    public void gameOverPage ()
    {
	// Add background image to JLabel
	gameOverPic = new JLabel (new ImageIcon ("backgrounds/school3.jpg"));
	gameOverPic.setLayout (new BoxLayout (gameOverPic, BoxLayout.Y_AXIS));

	// JPanel for layout of Components on screen
	gameOverPage = new JPanel ();

	// Create and add Components to JPanel layout
	gameOver = new JLabel ("<html>Game Over......<br>Better Luck Next Year!</html>");
	gameOver.setFont (new Font ("Algerian", Font.PLAIN, 90));
	gameOver.setForeground (Color.white);
	gameOver.setBorder (BorderFactory.createEmptyBorder (180, 10, 120, 0));
	gameOverPage.add (gameOver);

	space3 = new JLabel (" ");
	space3.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 750));
	gameOverPage.add (space3);

	restart2 = new JButton ("Restart");
	restart2.setFont (new Font ("Georgia", Font.PLAIN, 80));
	restart2.setBackground (Color.white);
	restart2.setActionCommand ("restart");
	restart2.addActionListener (this);
	gameOverPage.add (restart2);

	space4 = new JLabel (" ");
	space4.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 770));
	gameOverPage.add (space4);

	giveUp2 = new JButton ("Give Up");
	giveUp2.setFont (new Font ("Georgia", Font.PLAIN, 80));
	giveUp2.setBackground (Color.white);
	giveUp2.setActionCommand ("giveUp");
	giveUp2.addActionListener (this);
	gameOverPage.add (giveUp2);

	// Add JPanel to JLabel background image
	gameOverPage.setOpaque (false);
	gameOverPic.add (gameOverPage);
    }


    // pre: none
    // post: math item page is set up
    public void mathItemPage ()
    {
	mathItem = new JPanel ();
	mathItem.setBackground (Color.white);

	course = new JLabel ("You passed the MATH course!");
	course.setFont (new Font ("Georgia", Font.PLAIN, 80));
	course.setBorder (BorderFactory.createEmptyBorder (50, 10, 80, 10));
	mathItem.add (course);

	getItem = new JLabel ("Here's your item:");
	getItem.setFont (new Font ("Georgia", Font.PLAIN, 80));
	mathItem.add (getItem);

	itemName = new JLabel ("calculator");
	itemName.setFont (new Font ("Algerian", Font.PLAIN, 90));
	itemName.setForeground (Color.red);
	itemName.setBorder (BorderFactory.createEmptyBorder (10, 10, 100, 10));
	mathItem.add (itemName);

	description = new JLabel ("    The object is usually rectangular.    ");
	description.setFont (new Font ("Pristina", Font.BOLD, 80));
	description.setForeground (Color.orange);
	description.setBorder (BorderFactory.createEmptyBorder (0, 0, 10, 0));
	mathItem.add (description);

	space5 = new JLabel ("  ");
	space5.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 850));
	mathItem.add (space5);

	next = new JButton ("Next");
	next.setFont (new Font ("Georgia", Font.PLAIN, 80));
	next.setActionCommand ("next");
	next.addActionListener (this);
	mathItem.add (next);

    }


    // pre: none
    // post: english item page is set up
    public void englishItemPage ()
    {
	englishItem = new JPanel ();
	englishItem.setBackground (Color.white);

	course2 = new JLabel ("You passed the ENGLISH course!");
	course2.setFont (new Font ("Georgia", Font.PLAIN, 70));
	course2.setBorder (BorderFactory.createEmptyBorder (50, 10, 80, 10));
	englishItem.add (course2);

	getItem2 = new JLabel ("Here's your item:");
	getItem2.setFont (new Font ("Georgia", Font.PLAIN, 80));
	englishItem.add (getItem2);

	itemName2 = new JLabel ("Hamlet Book");
	itemName2.setFont (new Font ("Algerian", Font.PLAIN, 90));
	itemName2.setForeground (Color.red);
	itemName2.setBorder (BorderFactory.createEmptyBorder (10, 10, 100, 10));
	englishItem.add (itemName2);

	description2 = new JLabel ("It is not about hard work , it is about working hard!");
	description2.setFont (new Font ("Pristina", Font.BOLD, 60));
	description2.setForeground (Color.orange);
	description2.setBorder (BorderFactory.createEmptyBorder (0, 0, 10, 0));
	englishItem.add (description2);

	space6 = new JLabel ("  ");
	space6.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 850));
	englishItem.add (space6);

	next2 = new JButton ("Next");
	next2.setFont (new Font ("Georgia", Font.PLAIN, 80));
	next2.setActionCommand ("next");
	next2.addActionListener (this);
	englishItem.add (next2);
    }


    // pre: none
    // post: science item page is set up
    public void scienceItemPage ()
    {
	scienceItem = new JPanel ();
	scienceItem.setBackground (Color.white);

	course3 = new JLabel ("You passed the SCIENCE course!");
	course3.setFont (new Font ("Georgia", Font.PLAIN, 70));
	course3.setBorder (BorderFactory.createEmptyBorder (50, 10, 80, 10));
	scienceItem.add (course3);

	getItem3 = new JLabel ("Here's your item:");
	getItem3.setFont (new Font ("Georgia", Font.PLAIN, 80));
	scienceItem.add (getItem3);

	itemName3 = new JLabel ("Biology Textbook");
	itemName3.setFont (new Font ("Algerian", Font.PLAIN, 90));
	itemName3.setForeground (Color.red);
	itemName3.setBorder (BorderFactory.createEmptyBorder (10, 10, 100, 10));
	scienceItem.add (itemName3);

	description3 = new JLabel ("The object has numbers and letters.");
	description3.setFont (new Font ("Pristina", Font.BOLD, 80));
	description3.setForeground (Color.orange);
	description3.setBorder (BorderFactory.createEmptyBorder (0, 0, 10, 0));
	scienceItem.add (description3);

	space7 = new JLabel ("  ");
	space7.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 850));
	scienceItem.add (space7);

	next3 = new JButton ("Next");
	next3.setFont (new Font ("Georgia", Font.PLAIN, 80));
	next3.setActionCommand ("next");
	next3.addActionListener (this);
	scienceItem.add (next3);
    }


    // pre: none
    // post: business item page is set up
    public void businessItemPage ()
    {
	businessItem = new JPanel ();
	businessItem.setBackground (Color.white);

	course4 = new JLabel ("You passed the BUSINESS course!");
	course4.setFont (new Font ("Georgia", Font.PLAIN, 70));
	course4.setBorder (BorderFactory.createEmptyBorder (50, 10, 80, 10));
	businessItem.add (course4);

	getItem4 = new JLabel ("Here's your item:");
	getItem4.setFont (new Font ("Georgia", Font.PLAIN, 80));
	businessItem.add (getItem4);

	itemName4 = new JLabel ("  $$ Money $$  ");
	itemName4.setFont (new Font ("Algerian", Font.PLAIN, 100));
	itemName4.setForeground (Color.red);
	itemName4.setBorder (BorderFactory.createEmptyBorder (10, 10, 100, 10));
	businessItem.add (itemName4);

	description4 = new JLabel ("The object can be pressed on.");
	description4.setFont (new Font ("Pristina", Font.BOLD, 80));
	description4.setForeground (Color.orange);
	description4.setBorder (BorderFactory.createEmptyBorder (0, 0, 10, 0));
	businessItem.add (description4);

	space8 = new JLabel ("  ");
	space8.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 850));
	businessItem.add (space8);

	next4 = new JButton ("Next");
	next4.setFont (new Font ("Georgia", Font.PLAIN, 80));
	next4.setActionCommand ("next");
	next4.addActionListener (this);
	businessItem.add (next4);
    }


    // pre: none
    // post: physEd item page is set up
    public void physedItemPage ()
    {
	physedItem = new JPanel ();
	physedItem.setBackground (Color.white);

	course5 = new JLabel ("You passed the PHYSED course!");
	course5.setFont (new Font ("Georgia", Font.PLAIN, 70));
	course5.setBorder (BorderFactory.createEmptyBorder (50, 10, 80, 10));
	physedItem.add (course5);

	getItem5 = new JLabel ("Here's your item:");
	getItem5.setFont (new Font ("Georgia", Font.PLAIN, 80));
	physedItem.add (getItem5);

	itemName5 = new JLabel ("Basketball");
	itemName5.setFont (new Font ("Algerian", Font.PLAIN, 90));
	itemName5.setForeground (Color.red);
	itemName5.setBorder (BorderFactory.createEmptyBorder (10, 10, 100, 10));
	physedItem.add (itemName5);

	description5 = new JLabel ("Do it now! Sometimes \"later\" becomes \"never\".");
	description5.setFont (new Font ("Pristina", Font.BOLD, 65));
	description5.setForeground (Color.orange);
	description5.setBorder (BorderFactory.createEmptyBorder (0, 0, 10, 0));
	physedItem.add (description5);

	space9 = new JLabel ("  ");
	space9.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 850));
	physedItem.add (space9);

	next5 = new JButton ("Next");
	next5.setFont (new Font ("Georgia", Font.PLAIN, 80));
	next5.setActionCommand ("next");
	next5.addActionListener (this);
	physedItem.add (next5);
    }


    // pre: none
    // post: art item page is set up
    public void artItemPage ()
    {
	artItem = new JPanel ();
	artItem.setBackground (Color.white);

	course6 = new JLabel ("You passed the ART course!");
	course6.setFont (new Font ("Georgia", Font.PLAIN, 70));
	course6.setBorder (BorderFactory.createEmptyBorder (50, 10, 80, 10));
	artItem.add (course6);

	getItem6 = new JLabel ("Here's your item:");
	getItem6.setFont (new Font ("Georgia", Font.PLAIN, 80));
	artItem.add (getItem6);

	itemName6 = new JLabel ("     Paint     ");
	itemName6.setFont (new Font ("Algerian", Font.PLAIN, 110));
	itemName6.setForeground (Color.red);
	itemName6.setBorder (BorderFactory.createEmptyBorder (10, 10, 100, 10));
	artItem.add (itemName6);

	description6 = new JLabel (" \"Enter\" = \"Input\" ");
	description6.setFont (new Font ("Pristina", Font.BOLD, 90));
	description6.setForeground (Color.orange);
	description6.setBorder (BorderFactory.createEmptyBorder (0, 0, 10, 0));
	artItem.add (description6);

	space10 = new JLabel ("  ");
	space10.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 850));
	artItem.add (space10);

	next6 = new JButton ("Next");
	next6.setFont (new Font ("Georgia", Font.PLAIN, 80));
	next6.setActionCommand ("next");
	next6.addActionListener (this);
	artItem.add (next6);
    }


    // pre: class number int given
    // post: the item page is displayed on the screen according
    // to which item is obtained. The element at the right index
    // in the getItem array of Items class is set to true
    // door pictures change
    public void passCourse (int num)
    {
	// Make changes to Items object by notifying the class that
	// num item is received
	item.getItem (num);
	switch (num)
	{
	    case 0:
		FMMHomePage.setContentPane (mathItem);
		doors [0].setIcon (new ImageIcon ("doors/door1pass.png"));
		doors [1].setIcon (new ImageIcon ("doors/door2.png"));
		break;
	    case 1:
		FMMHomePage.setContentPane (englishItem);
		doors [1].setIcon (new ImageIcon ("doors/door2pass.png"));
		doors [2].setIcon (new ImageIcon ("doors/door3.png"));
		break;
	    case 2:
		FMMHomePage.setContentPane (scienceItem);
		doors [2].setIcon (new ImageIcon ("doors/door3pass.png"));
		doors [3].setIcon (new ImageIcon ("doors/door4.png"));
		break;
	    case 3:
		FMMHomePage.setContentPane (businessItem);
		doors [3].setIcon (new ImageIcon ("doors/door4pass.png"));
		doors [4].setIcon (new ImageIcon ("doors/door5.png"));
		break;
	    case 4:
		FMMHomePage.setContentPane (physedItem);
		doors [4].setIcon (new ImageIcon ("doors/door5pass.png"));
		doors [5].setIcon (new ImageIcon ("doors/door6.png"));
		break;
	    case 5:
		FMMHomePage.setContentPane (artItem);
		doors [5].setIcon (new ImageIcon ("doors/door6pass.png"));
		riddle = true;
		break;
	}
    }


    // pre: ActionEvent object (JButton is clicked by user)
    // post: ActionEvent is handled properly according to which button is pressed
    public void actionPerformed (ActionEvent e)
    {
	String eventName = e.getActionCommand ();

	// If Begin button on instructions page is clicked, set screen to hallway page of Hallway class
	if (eventName.equals ("beginGame"))
	    FMMHomePage.setContentPane (hallwayPic);
	// When the Escape button on the hallway page is clicked,
	// display the riddle page or the principal page
	else if (eventName.equals ("escape"))
	{
	    // If student passes the last course, Art,
	    // (assuming that all the previous courses are also passed)
	    // show the riddle page, else show the principal page
	    if (riddle)
		FMMHomePage.setContentPane (new Riddle (bgm).riddle);
	    else
		FMMHomePage.setContentPane (new Riddle (bgm).principalPic);
	}
	// When the Give Up button on the hallway page or the gave over page is pressed...
	else if (eventName.equals ("giveUp"))
	{
	    // Display Permanent Student page
	    // Write the Student object permanently to text file
	    new StudentHistory ().writeStudentToFile (FMMHomePage.current);
	    FMMHomePage.setContentPane (giveUpPic);
	}
	// When the Restart button on the hallway page is pressed
	else if (eventName.equals ("restart"))
	{
	    // Make changes to Student object (increment years variable by 1)
	    FMMHomePage.current.restart ();
	    FMMHomePage.setContentPane (new Hallway (bgm).contentPane3);
	}
	// When the Items button on the hallway page is pressed
	else if (eventName.equals ("items"))
	{
	    // Call Items class and show items page
	    FMMHomePage.setContentPane (Items.background);
	}
	// When the Math door button is pressed
	else if (eventName.equals ("door1"))
	{

	    if (item.getItem [0] == false)
	    {
		// Call Math question class and set screen to question page
		MathRoom room = new MathRoom (this, bgm);
		room.display (0);
		FMMHomePage.setContentPane (room.background);
	    }
	}
	// When the English door button is pressed
	else if (eventName.equals ("door2") && item.getItem [0] == true)
	{
	    if (item.getItem [1] == false)
	    {
		// Call English question class and set screen to question page
		EngRoom room = new EngRoom (this, bgm);
		room.display (0);
		FMMHomePage.setContentPane (room.background);
	    }
	}
	// When the Science door button is pressed
	else if (eventName.equals ("door3") && item.getItem [1] == true)
	{
	    // Call Science question class and set screen to question page
	    if (item.getItem [2] == false)
	    {
		SciRoom room = new SciRoom (this, bgm);
		room.display (0);
		FMMHomePage.setContentPane (room.background);
	    }
	}
	// When the Business door button is pressed
	else if (eventName.equals ("door4") && item.getItem [2] == true)
	{
	    // Call Business question class and set screen to question page
	    if (item.getItem [3] == false)
	    {
		BusiRoom room = new BusiRoom (this, bgm);
		room.display (0);
		FMMHomePage.setContentPane (room.background);
	    }
	}
	// When the PhysEd door button is pressed
	else if (eventName.equals ("door5") && item.getItem [3] == true)
	{
	    // Call PhysEd question class and set screen to question page
	    if (item.getItem [4] == false)
	    {
		PhysEdRoom room = new PhysEdRoom (this, bgm);
		room.display (0);
		FMMHomePage.setContentPane (room.background);
	    }
	}
	// When the Art door button is pressed
	else if (eventName.equals ("door6") && item.getItem [4] == true)
	{
	    // Call Art question class and set screen to question page
	    if (item.getItem [5] == false)
	    {
		ArtRoom room = new ArtRoom (this, bgm);
		room.display (0);
		FMMHomePage.setContentPane (room.background);
	    }
	}
	// When the Main Menu button on the give up page is clicked, go
	// back to the home page
	else if (eventName.equals ("menu"))
	{
	    FMMHomePage.setContentPane (new FMMHomePage (bgm).picture);
	}
	// When the Next button on any item page is clicked,
	// go back to hallway page with door images updated
	else if (eventName.equals ("next"))
	{
	    FMMHomePage.setContentPane (hallwayPic);
	}
    }
}


