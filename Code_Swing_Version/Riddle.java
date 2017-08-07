// The "Riddle" class.
// Author: Jasmine Xiao

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Riddle implements ActionListener
{
    final static String answer = "keyboard"; // The only answer, constant, cannot be changed
    static Music bgm;

    // Riddle Question Page
    static JLabel riddle;
    JPanel riddlePage;
    JLabel sphinxTitle, sphinx, riddleTitle, question;
    JLabel space1, space2;
    JTextField riddleAns;
    JButton submit, backClasses;

    // Principal Speaking
    static JLabel principalPic;
    JPanel principalPage;
    JLabel principalTitle, principal, principalMessage, space5;
    JButton backClasses2;

    // Right Answer
    static JLabel rightAns;
    JPanel rightAnsPage;
    JLabel congrats, escape, free;
    JButton certificate;

    // Wrong Answer
    static JPanel wrongAnsPage;
    JLabel wrong, guessAgain;
    JLabel space3, space4;
    JButton tryAgain, giveUp;

    // Certificate
    static JButton certificatePic;
    JLabel graduate;

    // Constructor
    // pre: Music object
    // post: All pages are set up for use later
    public Riddle (Music bgm)
    {
	this.bgm = bgm;
	riddlePage ();
	rightAnsPage ();
	wrongAnsPage ();
	principalPage ();
    }


    // pre: none
    // post: The riddle question page is set up
    public void riddlePage ()
    {
	// Background picture on JLabel
	riddle = new JLabel (new ImageIcon ("backgrounds/school3.jpg"));
	riddle.setLayout (new BoxLayout (riddle, BoxLayout.Y_AXIS));

	// JPanel layout to contain Components
	riddlePage = new JPanel ();
	riddlePage.setLayout (new FlowLayout ());

	// Create Components and add them to JPanel
	riddleTitle = new JLabel ("                       RIDDLE");
	riddleTitle.setFont (new Font ("Times New Roman", Font.BOLD, 100));
	riddleTitle.setForeground (Color.yellow);
	riddleTitle.setBorder (BorderFactory.createEmptyBorder (10, 10, 10, 600));
	riddlePage.add (riddleTitle);

	sphinxTitle = new JLabel ("Sphinx");
	sphinxTitle.setFont (new Font ("Times New Roman", Font.BOLD, 30));
	sphinxTitle.setForeground (Color.orange);
	sphinxTitle.setBorder (BorderFactory.createEmptyBorder (10, 10, 10, 1000));
	riddlePage.add (sphinxTitle);

	sphinx = new JLabel (new ImageIcon ("sphinx.jpg"));
	riddlePage.add (sphinx);

	question = new JLabel ("<html>What object has keys that<br>open no locks, space but no room,<br>and you can enter but not<br>go in? (one word)</html>");
	question.setFont (new Font ("Times New Roman", Font.PLAIN, 60));
	question.setBackground (Color.white);
	riddlePage.add (question);

	// Textfield to enter answer
	riddleAns = new JTextField (10);
	riddleAns.setFont (new Font ("Times New Roman", Font.PLAIN, 80));
	riddlePage.add (riddleAns);

	space1 = new JLabel (" ");
	space1.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 900));
	riddlePage.add (space1);

	submit = new JButton ("Submit");
	submit.setFont (new Font ("Times New Roman", Font.PLAIN, 40));
	submit.setBackground (Color.white);
	submit.setActionCommand ("submit");
	submit.addActionListener (this);
	riddlePage.add (submit);

	space2 = new JLabel (" ");
	space2.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 900));
	riddlePage.add (space2);

	backClasses = new JButton ("Back");
	backClasses.setFont (new Font ("Times New Roman", Font.PLAIN, 40));
	backClasses.setBackground (Color.white);
	backClasses.setActionCommand ("backClasses");
	backClasses.addActionListener (this);
	riddlePage.add (backClasses);

	// Add JPanel to JLabel background picture
	riddlePage.setOpaque (false);
	riddle.add (riddlePage);
	question.setOpaque (true);
    }


    // pre: none
    // post: The right answer page is set up
    public void rightAnsPage ()
    {
	// Background picture
	rightAns = new JLabel (new ImageIcon ("backgrounds/school4.jpg"));
	rightAns.setLayout (new BoxLayout (rightAns, BoxLayout.Y_AXIS));

	// JPanel for Component layout
	rightAnsPage = new JPanel ();

	// Components to be created and added to JPanel layout
	congrats = new JLabel ("CONGRATULATIONS!!!");
	congrats.setBorder (BorderFactory.createEmptyBorder (100, 0, 0, 0));
	congrats.setFont (new Font ("Algerian", Font.PLAIN, 100));
	congrats.setForeground (Color.yellow);
	rightAnsPage.add (congrats);

	escape = new JLabel ("You Escaped from FMM!!!");
	escape.setBorder (BorderFactory.createEmptyBorder (100, 0, 0, 0));
	escape.setFont (new Font ("Times New Roman", Font.PLAIN, 80));
	escape.setForeground (Color.yellow);
	rightAnsPage.add (escape);

	free = new JLabel ("You are now FREE!!!");
	free.setBorder (BorderFactory.createEmptyBorder (0, 0, 100, 0));
	free.setFont (new Font ("Times New Roman", Font.PLAIN, 80));
	free.setForeground (Color.yellow);
	rightAnsPage.add (free);

	certificate = new JButton ("Get your Certificate Here!");
	certificate.setFont (new Font ("Times New Roman", Font.PLAIN, 50));
	certificate.setForeground (Color.red);
	certificate.setBackground (Color.white);
	certificate.setActionCommand ("certificate");
	certificate.addActionListener (this);
	rightAnsPage.add (certificate);

	// Add JPanel to background picture
	rightAnsPage.setOpaque (false);
	rightAns.add (rightAnsPage);
    }


    // pre: none
    // post: The wrong answer page is set up
    public void wrongAnsPage ()
    {
	// JPanel layout to contain Components
	wrongAnsPage = new JPanel ();
	wrongAnsPage.setBackground (Color.white);

	// Components to be created and added to JPanel
	wrong = new JLabel ("WRONG Answer");
	wrong.setBorder (BorderFactory.createEmptyBorder (100, 0, 0, 0));
	wrong.setFont (new Font ("Algerian", Font.PLAIN, 100));
	wrong.setForeground (Color.red);
	wrongAnsPage.add (wrong);

	guessAgain = new JLabel ("Feel free to try again!");
	guessAgain.setBorder (BorderFactory.createEmptyBorder (0, 0, 160, 0));
	guessAgain.setFont (new Font ("Algerian", Font.PLAIN, 80));
	wrongAnsPage.add (guessAgain);

	space3 = new JLabel (" ");
	space3.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 750));
	wrongAnsPage.add (space3);

	tryAgain = new JButton ("Try Again");
	tryAgain.setFont (new Font ("Times New Roman", Font.PLAIN, 70));
	tryAgain.setBackground (Color.white);
	tryAgain.setActionCommand ("tryAgain");
	tryAgain.addActionListener (this);
	wrongAnsPage.add (tryAgain);

	space4 = new JLabel (" ");
	space4.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 700));
	wrongAnsPage.add (space4);

	giveUp = new JButton ("Give Up");
	giveUp.setFont (new Font ("Times New Roman", Font.PLAIN, 70));
	giveUp.setBackground (Color.white);
	giveUp.setActionCommand ("giveUp");
	giveUp.addActionListener (this);
	wrongAnsPage.add (giveUp);
    }


    // pre: none
    // post: The principal speaking page is set up
    public void principalPage ()
    {
	// Background picture on JLabel
	principalPic = new JLabel (new ImageIcon ("backgrounds/school7.jpg"));
	principalPic.setLayout (new BoxLayout (principalPic, BoxLayout.Y_AXIS));

	// Create JPanel layout for Components
	principalPage = new JPanel ();

	// Create and add Components to JPanel layout
	principalTitle = new JLabel ("Mr. Paonessa");
	principalTitle.setFont (new Font ("Times New Roman", Font.PLAIN, 60));
	principalTitle.setForeground (Color.blue);
	principalTitle.setBorder (BorderFactory.createEmptyBorder (80, 0, 0, 800));
	principalPage.add (principalTitle);

	principal = new JLabel (new ImageIcon ("paonessa.jpg"));
	principalPage.add (principal);

	principalMessage = new JLabel ("<html>Your parents will be very<br>disappointed if you don't pass<br>all your courses!</html>");
	principalMessage.setFont (new Font ("Times New Roman", Font.PLAIN, 70));
	principalMessage.setBackground (Color.white);
	principalPage.add (principalMessage);

	space5 = new JLabel (" ");
	space5.setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 800));
	principalPage.add (space5);

	backClasses2 = new JButton ("Back");
	backClasses2.setFont (new Font ("Times New Roman", Font.PLAIN, 70));
	backClasses2.setBackground (Color.white);
	backClasses2.setActionCommand ("backClasses");
	backClasses2.addActionListener (this);
	principalPage.add (backClasses2);

	// Add JPanel to background picture JLabel
	principalPage.setOpaque (false);
	principalPic.add (principalPage);
	principalMessage.setOpaque (true);
    }


    // pre: none
    // post: The certificate page is set up
    public void certificate ()
    {
	// Certificate image on JButton
	certificatePic = new JButton (new ImageIcon ("certificate.jpg"));
	certificatePic.setLayout (new FlowLayout ());
	certificatePic.setMinimumSize (new Dimension (1200, 800));

	// Show player's name on certificate
	String name = (new FMMHomePage (bgm).getCurrentStudent ()).getName ();
	graduate = new JLabel (name);
	graduate.setFont (new Font ("Algerian", Font.PLAIN, 100));
	graduate.setForeground (Color.blue);
	graduate.setBorder (BorderFactory.createEmptyBorder (240, 0, 0, 0));
	graduate.setAlignmentX (Component.CENTER_ALIGNMENT);
	certificatePic.add (graduate);

	certificatePic.setActionCommand ("certificatePic");
	certificatePic.addActionListener (this);
    }


    // pre: ActionEvent object given (JButton is clicked)
    // post: ActionEvent is handled when JButton is clicked, according to which one
    public void actionPerformed (ActionEvent e)
    {
	String event = e.getActionCommand ();

	// When Submit button on riddle page is clicked, check answer.
	// display the right answer page if answer is correct or else
	// display the wrong answer page
	if (event.equals ("submit"))
	{
	    if ((riddleAns.getText ()).equalsIgnoreCase (answer))
		FMMHomePage.setContentPane (rightAns);
	    else
		FMMHomePage.setContentPane (wrongAnsPage);
	}
	// When Back button on riddle page or on principal page is clicked,
	// go back to hallway page of Hallway class
	else if (event.equals ("backClasses"))
	{
	    FMMHomePage.setContentPane (Hallway.hallwayPic);
	}
	// When the Get Certificate button on right answer page is clicked,
	// set up the certificate page, change the Student object to graduate
	// status, record the Student object onto text file permanently,
	// and display the certificate picture
	else if (event.equals ("certificate"))
	{
	    certificate ();
	    (FMMHomePage.current).graduate ();
	    new StudentHistory ().writeStudentToFile (FMMHomePage.current);
	    FMMHomePage.setContentPane (certificatePic);
	}
	// When the Try Again button on the wrong answer page is clicked,
	// go back to the riddle page for the player to type in the new answer
	else if (event.equals ("tryAgain"))
	{
	    FMMHomePage.setContentPane (riddle);
	}
	// When the Give Up button on the wrong answer page is clicked,
	// go to the give up page of Hallway class
	else if (event.equals ("giveUp"))
	{
	    FMMHomePage.setContentPane (Hallway.giveUpPic);
	}
	// When the certificate picture/page is clicked, the screen is set
	// to go back to the home page
	else if (event.equals ("certificatePic"))
	{
	    FMMHomePage.setContentPane (new FMMHomePage (bgm).picture);
	}
    }
}
