// The "StudentHistory" class.
// Author: Jasmine Xiao

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class StudentHistory implements ActionListener
{
    static File records;
    static ArrayList studentHistory, graduates, permanent;

    // Records Page
    static JLabel background;
    JPanel recordsPanel;
    JLabel gradTitle, permtTitle;
    JTextArea names1, names2;
    JTextArea years1, years2;
    JScrollPane graduateNames, permanentNames;
    JScrollPane graduateYears, permanentYears;
    JLabel prompt;
    JTextField getName;
    JButton search, clear, menu;

    // Search Page
    static JLabel background2;
    JPanel searchPage;
    JLabel space;
    JLabel nameSearched, result;
    JButton backRecords, menu2;

    // constructor
    // pre: none
    // post: student history record read from text file and stored in ArrayList
    // records page and search page are set up for use later
    public StudentHistory ()
    {
	// File object
	records = new File ("student history.txt");
	// ArrayList of all Student objects
	studentHistory = new ArrayList ();
	// ArrayList of graduates and permanent students
	graduates = new ArrayList ();
	permanent = new ArrayList ();
	// Each line on text file
	String line;

	try
	{
	    // Create stream for reading from text file
	    FileReader in = new FileReader (records);
	    BufferedReader read = new BufferedReader (in);

	    // Continue reading until the end of text file (no more line)
	    while ((line = read.readLine ()) != null)
	    {
		// Make Student object with the name on first line
		Student student = new Student (line);

		// Store number of years on second line into years variable
		if ((line = read.readLine ()) != null)
		    student.setYears (Integer.parseInt (line));

		// Change graduate variable according to boolean value on third line
		if ((line = read.readLine ()) != null)
		{
		    if (line.equals ("true"))
		    {
			student.graduate ();
			graduates.add (student);
		    }
		    else
			permanent.add (student);
		}

		// Add object to ArrayList
		studentHistory.add (student);
	    }

	    read.close ();
	    in.close ();

	    // Merge sort all ArrayList for display and searching later
	    mergeSort (graduates, 0, graduates.size () - 1, true);
	    mergeSort (permanent, 0, permanent.size () - 1, true);
	    mergeSort (studentHistory, 0, studentHistory.size () - 1, false);

	}
	catch (FileNotFoundException e)
	{
	    System.err.println ("FileNotFoundException: " + e.getMessage ());
	}
	catch (IOException e)
	{
	    System.err.println ("IOException: " + e.getMessage ());
	}

	// Set up the 2 pages for student history section
	recordPage ();
	searchPage ();
    }


    // pre: none
    // post: student history text file is deleted and a new one with the same name is created
    // so the file is now empty
    public void clearRecords ()
    {
	try
	{
	    records.delete ();
	    records.createNewFile ();
	}
	catch (IOException e)
	{
	    System.err.println ("IOException: " + e.getMessage ());
	}
    }


    // pre: Student object given
    // post: Information about that Student object is written to the
    // student history text file for permanent record-keeping
    public void writeStudentToFile (Student student)
    {
	try
	{
	    // Create output stream for writing (adding, not overwriting) to text file
	    FileWriter out = new FileWriter (records, true);
	    BufferedWriter writeFile = new BufferedWriter (out);

	    // Write name, number of years, and boolean graduate value to text file
	    writeFile.write (student.getName ());
	    writeFile.newLine ();
	    writeFile.write (Integer.toString (student.getYears ()));
	    writeFile.newLine ();
	    writeFile.write (Boolean.toString (student.getGraduate ()));
	    writeFile.newLine ();

	    writeFile.close ();
	    out.close ();
	}
	catch (IOException e)
	{
	}
    }


    // pre: none
    // post: records page is set up
    public void recordPage ()
    {
	// Create JLabel for background picture
	background = new JLabel (new ImageIcon ("backgrounds/school1.jpg"));
	background.setLayout (new BoxLayout (background, BoxLayout.Y_AXIS));

	// Create JPanel to store Components in a layout
	recordsPanel = new JPanel ();
	recordsPanel.setLayout (new FlowLayout ());
	recordsPanel.setBorder (BorderFactory.createEmptyBorder (50, 10, 50, 10));

	// Create and add Components to JPanel content pane
	// Graduates Title
	gradTitle = new JLabel ("Graduates");
	gradTitle.setFont (new Font ("Georgia", Font.BOLD, 50));
	gradTitle.setBorder (BorderFactory.createEmptyBorder (0, 500, 0, 500));
	recordsPanel.add (gradTitle);

	// Scroll Pane for Graduate Names
	names1 = new JTextArea ();
	names1.setEditable (false);
	// Store information in a String to display on text area on scroll pane
	String output = "Name";
	for (int i = 0 ; i < graduates.size () ; i++)
	{
	    output = output + "\n" + ((Student) graduates.get (i)).getName ();
	}
	names1.setFont (new Font ("Times New Roman", Font.PLAIN, 20));
	names1.setText (output);
	// JScrollPane contains the JTextArea
	graduateNames = new JScrollPane (names1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	graduateNames.setPreferredSize (new Dimension (300, 200));
	recordsPanel.add (graduateNames);

	// Scroll Pane for Graduate Years
	years1 = new JTextArea ();
	years1.setEditable (false);
	// Store information in a String to display on text area on scroll pane
	String output2 = "Year(s) Taken";
	for (int i = 0 ; i < graduates.size () ; i++)
	{
	    output2 = output2 + "\n" + ((Student) graduates.get (i)).getYears ();
	}
	years1.setFont (new Font ("Times New Roman", Font.PLAIN, 20));
	years1.setText (output2);
	// JScrollPane contains the JTextArea
	graduateYears = new JScrollPane (years1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	graduateYears.setPreferredSize (new Dimension (300, 200));
	recordsPanel.add (graduateYears);

	// Permanent Students Title
	permtTitle = new JLabel ("Permanent Students");
	permtTitle.setFont (new Font ("Georgia", Font.BOLD, 50));
	permtTitle.setBorder (BorderFactory.createEmptyBorder (0, 500, 0, 500));
	recordsPanel.add (permtTitle);

	// Scroll Pane for Permanent Students' Names
	names2 = new JTextArea ();
	names2.setEditable (false);
	// Store information in a String to display on text area on scroll pane
	String output3 = "Name";
	for (int i = 0 ; i < permanent.size () ; i++)
	{
	    output3 = output3 + "\n" + ((Student) permanent.get (i)).getName ();
	}
	names2.setFont (new Font ("Times New Roman", Font.PLAIN, 20));
	names2.setText (output3);
	// JScrollPane contains the JTextArea
	permanentNames = new JScrollPane (names2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	permanentNames.setPreferredSize (new Dimension (300, 200));
	recordsPanel.add (permanentNames);

	// Scroll Pane for Permanent Students' Years
	years2 = new JTextArea ();
	years2.setEditable (false);
	// Store information in a String to display on text area on scroll pane
	String output4 = "Year(s) Tried";
	for (int i = 0 ; i < permanent.size () ; i++)
	{
	    output4 = output4 + "\n" + ((Student) permanent.get (i)).getYears ();
	}
	years2.setFont (new Font ("Times New Roman", Font.PLAIN, 20));
	years2.setText (output4);
	// JScrollPane contains the JTextArea
	permanentYears = new JScrollPane (years2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	permanentYears.setPreferredSize (new Dimension (300, 200));
	recordsPanel.add (permanentYears);

	// Create and add the rest of the Components to the screen/content pane
	prompt = new JLabel ("Search for Name: ");
	prompt.setFont (new Font ("Georgia", Font.BOLD, 40));
	prompt.setForeground (Color.white);
	prompt.setBorder (BorderFactory.createEmptyBorder (0, 250, 0, 930));
	recordsPanel.add (prompt);

	getName = new JTextField (30);
	getName.setFont (new Font ("Georgia", Font.BOLD, 30));
	recordsPanel.add (getName);

	search = new JButton ("Search");
	search.setFont (new Font ("Georgia", Font.BOLD, 30));
	search.setBackground (Color.white);
	search.setActionCommand ("search");
	search.addActionListener (this);
	recordsPanel.add (search);

	clear = new JButton ("Clear All Records");
	clear.setBackground (Color.white);
	clear.setFont (new Font ("Georgia", Font.BOLD, 30));
	clear.setActionCommand ("clear");
	clear.addActionListener (this);
	recordsPanel.add (clear);

	menu = new JButton ("Main Menu");
	menu.setBackground (Color.white);
	menu.setFont (new Font ("Georgia", Font.BOLD, 30));
	menu.setActionCommand ("menu");
	menu.addActionListener (this);
	recordsPanel.add (menu);

	// Add panel to background picture JLabel
	recordsPanel.setOpaque (false);
	background.add (recordsPanel);
    }


    // pre: none
    // post: search page is set up
    public void searchPage ()
    {
	// Processing for the searching
	String name = getName.getText ().toLowerCase();
	int index = binarySearch (studentHistory, 0, studentHistory.size () - 1, name);
	String nameOutput = "Name Searched: " + name.toLowerCase ();
	String searchResult = "<html>";
	// If name is found...Add the information to one String
	if (index != -1)
	{
	    searchResult += "Name Found!" + "<br>";
	    searchResult += "Name: " + ((Student) studentHistory.get (index)).getName () + "<br>";
	    searchResult += "Years Taken: " + ((Student) studentHistory.get (index)).getYears () + "<br>";
	    if (((Student) studentHistory.get (index)).getGraduate () == true)
		searchResult += "Graduate :)" + "<html>";
	    else
		searchResult += "Permanent Student :(" + "</html>";
	}
	// If name is not found...
	else
	{
	    searchResult = "Sorry......Name Not Found......";
	}

	// Background picture on JLabel
	background2 = new JLabel (new ImageIcon ("backgrounds/school1.jpg"));
	background2.setLayout (new BoxLayout (background2, BoxLayout.Y_AXIS));

	// JPanel to contain Components
	searchPage = new JPanel ();
	searchPage.setLayout (new BoxLayout (searchPage, BoxLayout.Y_AXIS));
	searchPage.setBorder (BorderFactory.createEmptyBorder (10, 10, 10, 10));

	// Display the name that is searched on JLabel
	nameSearched = new JLabel (nameOutput);
	nameSearched.setFont (new Font ("Georgia", Font.BOLD, 60));
	nameSearched.setForeground (Color.black);
	nameSearched.setBorder (BorderFactory.createEmptyBorder (0, 0, 100, 0));
	nameSearched.setAlignmentX (Component.LEFT_ALIGNMENT);
	searchPage.add (nameSearched);

	// Add the result of the searching to the JLabel
	result = new JLabel (searchResult);
	result.setFont (new Font ("Georgia", Font.BOLD, 50));
	result.setBorder (BorderFactory.createEmptyBorder (0, 0, 100, 0));
	result.setAlignmentX (Component.LEFT_ALIGNMENT);
	searchPage.add (result);

	// JButton for path to go back to records page
	backRecords = new JButton ("Back");
	backRecords.setFont (new Font ("Georgia", Font.BOLD, 60));
	backRecords.setBackground (Color.white);
	backRecords.setActionCommand ("backRecords");
	backRecords.addActionListener (this);
	searchPage.add (backRecords);

	space = new JLabel (" ");
	space.setFont (new Font ("Georgia", Font.BOLD, 80));
	searchPage.add (space);

	// JButton for path to go back to home page
	menu2 = new JButton ("Main Menu");
	menu2.setFont (new Font ("Georgia", Font.BOLD, 60));
	menu2.setBackground (Color.white);
	menu2.setActionCommand ("menu");
	menu2.addActionListener (this);
	searchPage.add (menu2);

	// Add panel to background picture JLabel
	searchPage.setOpaque (false);
	background2.add (searchPage);

	result.setOpaque (true);
	result.setBackground (Color.white);
    }


    // pre: given an array filled with Student objects
    // start index, end index, and whether it should be sorted by year or not
    // post: the elements in the array are in the correct order after merge sort
    // is used (whether in the order of years or of alphabetical names)
    public static void mergeSort (ArrayList array, int start, int end, boolean byYear)
    {
	if (start < end)
	{
	    int mid = (start + end) / 2;
	    mergeSort (array, start, mid, byYear);
	    mergeSort (array, mid + 1, end, byYear);
	    if (byYear)
		mergeByYear (array, start, mid, end);
	    else
		mergeByName (array, start, mid, end);
	}
    }


    // pre: given an array filled with Student objects
    // start index, mid index, and end index
    // post: the elements in the array are in the correct order after merge sort
    // is used by years (from low to high)
    private static void mergeByYear (ArrayList array, int start, int mid, int end)
    {
	Student[] temp = new Student [array.size ()];
	int pos1 = start;
	int pos2 = mid + 1;
	int spot = start;
	// Put elements from low to high in temporary array
	while (!(pos1 > mid && pos2 > end))
	{
	    if ((pos1 > mid) || ((pos2 <= end) && (((Student) array.get (pos2)).getYears () < ((Student) array.get (pos1)).getYears ())))
	    {
		temp [spot] = ((Student) array.get (pos2));
		pos2 += 1;
	    }
	    else
	    {
		temp [spot] = ((Student) array.get (pos1));
		pos1 += 1;
	    }
	    spot += 1;
	}
	// Copy elements from temporary array to the original array
	for (int i = start ; i <= end ; i++)
	{
	    array.remove (i);
	    array.add (i, temp [i]);
	}
    }


    // pre: given an array filled with Student objects
    // start index, mid index, and end index
    // post: the elements in the array are in the correct order after merge sort
    // is used by names (alphabetical)
    private static void mergeByName (ArrayList array, int start, int mid, int end)
    {
	Student[] temp = new Student [array.size ()];
	int pos1 = start;
	int pos2 = mid + 1;
	int spot = start;
	// Put elements from low to high in temporary array
	while (!(pos1 > mid && pos2 > end))
	{
	    if ((pos1 > mid) || ((pos2 <= end) && (((Student) array.get (pos2)).getName ()
			    .compareToIgnoreCase (((Student) array.get (pos1)).getName ()) < 0)))
	    {
		temp [spot] = ((Student) array.get (pos2));
		pos2 += 1;
	    }
	    else
	    {
		temp [spot] = ((Student) array.get (pos1));
		pos1 += 1;
	    }
	    spot += 1;
	}
	// Copy elements from temporary array to the original array
	for (int i = start ; i <= end ; i++)
	{
	    array.remove (i);
	    array.add (i, temp [i]);
	}
    }


    // pre: Given array filled with Student objects, start index, end index, and the name to search for
    // post: index of the name to be searched for is returned, else -1 is returned
    public static int binarySearch (ArrayList array, int start, int end, String goal)
    {
	// Starting index should be less than ending index
	if (start > end)
	    return -1;
	else
	{
	    int mid = (start + end) / 2;
	    // If the middle element is the one to be searched for, return the index
	    if (goal.equals (((Student) array.get (mid)).getName ()))
		return mid;
	    // Binary search for the lower part of array
	    else if (goal.compareTo ((((Student) array.get (mid)).getName ())) < 0)
		return (binarySearch (array, start, mid - 1, goal));
	    // Binary search for the upper part of array
	    else
		return (binarySearch (array, mid + 1, end, goal));
	}
    }


    // pre: ActionEvent object (JButton is clicked)
    // post: ActionEvent is handled according to which JButton is clicked
    public void actionPerformed (ActionEvent e)
    {
	String event = e.getActionCommand ();

	// When the Search button on the records page is clicked
	if (event.equals ("search"))
	{
	    searchPage ();
	    FMMHomePage.setContentPane (background2);
	}
	// When the Clear All Records button on the records page is clicked
	else if (event.equals ("clear"))
	{
	    names1.setText ("Name");
	    years1.setText ("Year(s) Taken");
	    names2.setText ("Name");
	    years2.setText ("Year(s) Tried");

	    clearRecords ();
	}
	// When the Main Menu button on the records or search page is clicked
	else if (event.equals ("menu"))
	{
	    FMMHomePage.setContentPane (FMMHomePage.picture);
	}
	// When the Back button on the search page is clicked
	else if (event.equals ("backRecords"))
	{
	    FMMHomePage.setContentPane (background);
	}
    }
}
