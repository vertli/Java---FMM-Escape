// The "FMMHomePage" class.
// Author: Jasmine Xiao

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FMMHomePage implements ActionListener
{
    // Current student playing
    static Student current;
    static Music bgm;

    // Objects instantiated from other classes
    static Hallway hallway;

    // One and only frame
    static JFrame window;

    // Home Page
    static JLabel picture;
    JPanel contentPane;
    JLabel title, space, space2;
    JButton start, studentHistory;

    // Enter-Name Page
    static JLabel picture2;
    JPanel contentPane2;
    JLabel name, space3, space4, space5;
    JTextField setName;
    JButton instructions;

    // constructor
    // pre: Music object
    // post: Some objects initialized
    // content panes are set up in preparation for use later
    public FMMHomePage (Music bgm)
    {
	this.bgm = bgm;
	hallway = new Hallway (bgm);
	homePage ();
	enterNamePage ();
    }


    // pre: none
    // post: JFrame set up and displayed
    public void setFrame ()
    {
	// Set up the frame
	window = new JFrame ("FMM Escape");
	window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	// Add content pane to frame
	window.setContentPane (picture);

	// Size and display frame
	window.pack ();
	window.setSize (new Dimension (1200, 800));
	window.setResizable (false);
	window.setVisible (true);
    }


    // pre: given a Container object (JPanel or JLabel)
    // post: Container object used as the new content pane
    public static void setContentPane (Container pane)
    {
	window.remove (window.getContentPane ());
	window.setContentPane (pane);
	window.pack ();
	window.setSize (new Dimension (1200, 800));
	window.setVisible (true);
    }


    // pre: none
    // post: home page layout is set up
    public void homePage ()
    {
	// Background picture on JLabel
	picture = new JLabel (new ImageIcon ("backgrounds/school2.jpg"));
	picture.setLayout (new BoxLayout (picture, BoxLayout.Y_AXIS));

	// Create panel
	contentPane = new JPanel ();
	contentPane.setLayout (new BoxLayout (contentPane, BoxLayout.Y_AXIS));
	// Border arguments: Top, left, bottom, right
	contentPane.setBorder (BorderFactory.createEmptyBorder (50, 10, 50, 10));

	// Create and add Components to panel
	title = new JLabel ("FMM Escape");
	title.setFont (new Font ("Pristina", Font.BOLD, 200));
	title.setForeground (Color.red);
	title.setAlignmentX (Component.CENTER_ALIGNMENT);
	contentPane.add (title);

	space = new JLabel ("   ");
	space.setFont (new Font (" ", Font.PLAIN, 10));
	contentPane.add (space);

	start = new JButton ("Start");
	start.setFont (new Font ("Britannic Bold", Font.PLAIN, 100));
	start.setForeground (Color.blue);
	start.setAlignmentX (Component.CENTER_ALIGNMENT);
	start.setActionCommand ("start");
	start.addActionListener (this);
	contentPane.add (start);

	space2 = new JLabel ("   ");
	space2.setFont (new Font (" ", Font.PLAIN, 120));
	contentPane.add (space2);

	studentHistory = new JButton ("Student History");
	studentHistory.setFont (new Font ("Britannic Bold", Font.PLAIN, 100));
	studentHistory.setForeground (Color.black);
	studentHistory.setAlignmentX (Component.CENTER_ALIGNMENT);
	studentHistory.setActionCommand ("student history");
	studentHistory.addActionListener (this);
	contentPane.add (studentHistory);

	// Add panel to background picture
	contentPane.setOpaque (false);
	picture.add (contentPane);

	// JButtons are set to white colour
	start.setOpaque (true);
	start.setBackground (Color.white);
	studentHistory.setOpaque (true);
	studentHistory.setBackground (Color.white);
    }


    // pre: none
    // post: enter-name page is set up
    public void enterNamePage ()
    {
	// Background picture on JLabel
	picture2 = new JLabel (new ImageIcon ("backgrounds/school2.jpg"));
	picture2.setLayout (new BoxLayout (picture2, BoxLayout.Y_AXIS));

	// Create panel
	contentPane2 = new JPanel ();
	contentPane2.setLayout (new BoxLayout (contentPane2, BoxLayout.Y_AXIS));
	contentPane2.setBorder (BorderFactory.createEmptyBorder (10, 50, 50, 30));

	// Create and add Components to panel
	space3 = new JLabel ("   ");
	space3.setFont (new Font (" ", Font.PLAIN, 160));
	contentPane2.add (space3);

	name = new JLabel ("Student Name:");
	name.setBackground (Color.white);
	name.setForeground (Color.blue);
	name.setFont (new Font ("Times New Roman", Font.BOLD, 90));
	contentPane2.add (name);

	setName = new JTextField (30);
	setName.setFont (new Font ("Times New Roman", Font.PLAIN, 70));
	setName.setBackground (Color.white);
	contentPane2.add (setName);

	space4 = new JLabel ("   ");
	space4.setFont (new Font (" ", Font.PLAIN, 160));
	contentPane2.add (space4);

	instructions = new JButton ("GO!");
	instructions.setForeground (Color.white);
	instructions.setFont (new Font ("Times New Roman", Font.BOLD, 100));
	instructions.setBorder (BorderFactory.createEmptyBorder (0, 900, 0, 0));
	// Set JButton to transparent but clickable
	instructions.setOpaque (false);
	instructions.setContentAreaFilled (false);
	instructions.setBorderPainted (false);
	instructions.setActionCommand ("instructions");
	instructions.addActionListener (this);
	contentPane2.add (instructions);

	// Add panel to background picture
	contentPane2.setOpaque (false);
	picture2.add (contentPane2);
	name.setOpaque (true);
    }


    // pre: none
    // post: the Student object representing the current player is returned
    public Student getCurrentStudent ()
    {
	return current;
    }


    // pre: ActionEvent object (a JButton has been clicked, interaction from user)
    // post: ActionEvent object is handled according to the button clicked
    public void actionPerformed (ActionEvent e)
    {
	String eventName = e.getActionCommand ();

	// If the Start button on home page is clicked, set screen to enter-name page
	if (eventName.equals ("start"))
	{
	    this.setContentPane (picture2);
	}
	// If the Student History button on home page is clicked, set screen to records page
	// in StudentHistory class
	else if (eventName.equals ("student history"))
	{
	    this.setContentPane (new StudentHistory ().background);
	}
	// If the Go button on the enter-name page is clicked,
	// check if the name entered in the textfield is valid (if repeated, invalid).
	// If invalid, change screen to instructions page
	else if (eventName.equals ("instructions"))
	{
	    String input;
	    boolean valid;
	    valid = true;
	    input = setName.getText ();
	    StudentHistory test = new StudentHistory ();
	    // Check the name input from user to make sure no names in student history records
	    // are repeated
	    for (int i = 0 ; i < test.studentHistory.size () ; i++)
	    {
		if (input.equalsIgnoreCase (((Student) test.studentHistory.get (i)).getName ()))
		{
		    valid = false;
		    break;
		}
	    }

	    // Name cannot be repeated, cannot equal to invalid message or empty String
	    if (valid && !(input.equalsIgnoreCase ("Sorry...Name Taken Already :(")) && !(input.equalsIgnoreCase ("")))
	    {
		// Create Student object with valid name
		current = new Student (input);
		// Set content pane to instructions page
		this.setContentPane (hallway.contentPane3);
	    }
	    // If name is not valid, display message in textfield
	    else
		setName.setText ("Sorry...Name Taken Already :(");
	}
    }
}
