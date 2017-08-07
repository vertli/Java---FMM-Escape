// The "Items" class.
// Authors:
// Processing by Calvin Li
// Swing layout by Jasmine Xiao

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Items implements ActionListener
{
    String itemExplain[];
    boolean getItem[]; // If the item is received yet or not

    // Swing layout of Items Page
    static JLabel background;
    JPanel itemsPage;
    JLabel title;
    JButton backHallway;
    JLabel classes[];
    JButton items[];
    JLabel description, space;

    // Constructor
    // pre: none
    // post: The getItem and itemExplain arrays are both initialized and items page is set up
    public Items ()
    {
	// Reserve 6 spaces for each array because only one item can be received from each class
	itemExplain = new String [6];
	getItem = new boolean [6];

	// Initialize each item description element to a hint or motivation quote
	itemExplain [0] = "The object is usually rectangular.";
	itemExplain [1] = "It is not about hard work , it is about working hard!";
	itemExplain [2] = "The object has numbers and letters.";
	itemExplain [3] = "The object can be pressed on.";
	itemExplain [4] = "Do it now! Sometimes \"later\" becomes \"never\".";
	itemExplain [5] = "\"Enter\" = \"Input\"";

	// Initialize each boolean value of getItem to false -> did not obtain it yet
	for (int i = 0 ; i < 6 ; i++)
	{
	    getItem [i] = false;
	}

	itemsPage ();
    }


    // pre: none
    // post: The items page is set up
    public void itemsPage ()
    {
	// Create background picture on JLabel
	background = new JLabel (new ImageIcon ("backgrounds/school5.jpg"));
	background.setLayout (new BoxLayout (background, BoxLayout.Y_AXIS));

	// JPanel for layout of Components
	itemsPage = new JPanel ();

	// Components to be contained inside the JPanel
	title = new JLabel ("Items");
	title.setFont (new Font ("Algerian", Font.PLAIN, 100));
	title.setForeground (Color.white);
	title.setBorder (BorderFactory.createEmptyBorder (0, 450, 40, 350));
	itemsPage.add (title);

	backHallway = new JButton ("Back");
	backHallway.setFont (new Font ("Georgia", Font.PLAIN, 30));
	backHallway.setBackground (Color.white);
	backHallway.setActionCommand ("back");
	backHallway.addActionListener (this);
	itemsPage.add (backHallway);

	// 6 headings for each item
	classes = new JLabel [6];
	classes [0] = new JLabel ("Mathematics");
	classes [1] = new JLabel ("English");
	classes [2] = new JLabel ("Science");
	classes [3] = new JLabel ("Business");
	classes [4] = new JLabel ("PhysEd");
	classes [5] = new JLabel ("Art");

	// Layout of the headings (middle of each item picture/button)
	classes [0].setBorder (BorderFactory.createEmptyBorder (0, 0, 0, 0));
	classes [1].setBorder (BorderFactory.createEmptyBorder (0, 20, 0, 30));
	classes [2].setBorder (BorderFactory.createEmptyBorder (0, 33, 0, 32));
	classes [3].setBorder (BorderFactory.createEmptyBorder (0, 25, 0, 30));
	classes [4].setBorder (BorderFactory.createEmptyBorder (0, 25, 0, 30));
	classes [5].setBorder (BorderFactory.createEmptyBorder (0, 60, 0, 80));

	// Add each heading to the JPanel
	for (int i = 0 ; i < 6 ; i++)
	{
	    classes [i].setFont (new Font ("Algerian", Font.PLAIN, 30));
	    classes [i].setForeground (Color.white);
	    itemsPage.add (classes [i]);
	}

	// Set up the 6 JButtons for the 6 items from the 6 classes
	items = new JButton [6];
	for (int i = 0 ; i < 6 ; i++)
	{
	    // Set item image to blank first
	    items [i] = new JButton (new ImageIcon ("items/empty item.jpg"));
	    items [i].setPreferredSize (new Dimension (180, 300));
	    items [i].setActionCommand ("item" + i);
	    items [i].addActionListener (this);
	    itemsPage.add (items [i]);
	}

	// Space between buttons and JLabel (item description)
	space = new JLabel ("                          ");
	space.setFont (new Font ("", Font.PLAIN, 30));
	itemsPage.add (space);

	// Display default message for item description box
	description = new JLabel ("<html>Click on an item for its description. You might get a hint or simply a motivation quote. Good Luck in Escaping!</html>");
	description.setFont (new Font ("Georgia", Font.PLAIN, 20));
	// Make the JLabel like a rectangular box
	description.setBorder (BorderFactory.createLineBorder (Color.black));
	description.setPreferredSize (new Dimension (1150, 170));
	description.setVerticalAlignment (JLabel.TOP);
	itemsPage.add (description);

	// Add JPanel to background picture
	itemsPage.setOpaque (false);
	background.add (itemsPage);
	description.setOpaque (true);
	description.setBackground (Color.white);
    }


    // pre: int item number received
    // post: boolean value in item number index of the getItem array is set to true
    // to record that the item is obtained. That button is set to the item's picture as well,
    // instead of just white empty space
    public void getItem (int num)
    {
	getItem [num] = true;
	switch (num)
	{
	    case 0:
		items [num].setIcon (new ImageIcon ("items/calculator.jpg"));
		break;
	    case 1:
		items [num].setIcon (new ImageIcon ("items/hamlet.jpg"));
		break;
	    case 2:
		items [num].setIcon (new ImageIcon ("items/biology.jpg"));
		break;
	    case 3:
		items [num].setIcon (new ImageIcon ("items/money.jpg"));
		break;
	    case 4:
		items [num].setIcon (new ImageIcon ("items/basketball.jpg"));
		break;
	    case 5:
		items [num].setIcon (new ImageIcon ("items/paint.jpg"));
		break;
	}
    }


    // pre: ActionEvent object (JButton is clicked by user)
    // post: ActionEvent is properly handled according to which button is pressed
    public void actionPerformed (ActionEvent e)
    {
	String event = e.getActionCommand ();

	// When the Back button on the items page is clicked, go back to hallway page
	if (event.equals ("back"))
	{
	    FMMHomePage.setContentPane (Hallway.hallwayPic);
	}
	// When the first item button is clicked, show its explanation if it is already obtained by
	// player or else show appropriate message
	else if (event.equals ("item0"))
	{
	    if (getItem [0] == true)
		description.setText (itemExplain [0]);
	    else
		description.setText ("Sorry...No item has been obtained from Math class");
	}
	// When the second item button is clicked, show its explanation if it is already obtained by
	// player or else show appropriate message
	else if (event.equals ("item1"))
	{
	    if (getItem [1] == true)
		description.setText (itemExplain [1]);
	    else
		description.setText ("Sorry...No item has been obtained from English class");
	}
	// When the third item button is clicked, show its explanation if it is already obtained by
	// player or else show appropriate message
	else if (event.equals ("item2"))
	{
	    if (getItem [2] == true)
		description.setText (itemExplain [2]);
	    else
		description.setText ("Sorry...No item has been obtained from Science class");
	}
	// When the fourth item button is clicked, show its explanation if it is already obtained by
	// player or else show appropriate message
	else if (event.equals ("item3"))
	{
	    if (getItem [3] == true)
		description.setText (itemExplain [3]);
	    else
		description.setText ("Sorry...No item has been obtained from Business class");
	}
	// When the fifth item button is clicked, show its explanation if it is already obtained by
	// player or else show appropriate message
	else if (event.equals ("item4"))
	{
	    if (getItem [4] == true)
		description.setText (itemExplain [4]);
	    else
		description.setText ("Sorry...No item has been obtained from PhysEd class");
	}
	// When the sixth item button is clicked, show its explanation if it is already obtained by
	// player or else show appropriate message
	else if (event.equals ("item5"))
	{
	    if (getItem [5] == true)
		description.setText (itemExplain [5]);
	    else
		description.setText ("Sorry...No item has been obtained from Art class");
	}
    }
}
