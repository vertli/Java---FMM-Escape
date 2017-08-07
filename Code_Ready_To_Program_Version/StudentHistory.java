/*
 * StudentHistory Class - Ready in Program
 * Chun Kit (Calvin) Li
 * Original Version (Swing): Jasmine Xiao
 */

import java.awt.*;
import java.io.*;
import java.util.*;
import hsa.Console;


public class StudentHistory
{
    static Console c;  // The output console

    // variable
    static File records;
    static ArrayList studentHistory, graduates, permanent;

    /**
     * constructor
     * pre: none
     * post: The StudentHistory class has been created.
     */
    public StudentHistory (Console c)
    {

	this.c = c;
	this.readRecords ();

    } // constructor


    /**
     * Read records from outside the program.
     * pre: none
     * post: Records have been read.
     */
    public void readRecords ()
    { // File object
	records = new File (".\\txtFile\\StudentHistory.txt");
	// ArrayList of Student objects
	studentHistory = new ArrayList ();
	// ArrayList of graduates and permanent students
	graduates = new ArrayList ();
	permanent = new ArrayList ();
	// Each line on text file
	String line;

	try
	{
	    // read objects
	    FileReader in = new FileReader (records);
	    BufferedReader read = new BufferedReader (in);

	    while ((line = read.readLine ()) != null)
	    {
		// Make Student object
		Student student = new Student (line);

		if ((line = read.readLine ()) != null)
		    student.setYears (Integer.parseInt (line));
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

		// Add object to array list
		studentHistory.add (student);
	    }

	    read.close ();
	    in.close ();

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
    } // readRecords methed


    /**
     * Clears the records.
     * pro: none
     * post: The records have been cleared up.
     */
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

	this.readRecords ();

    } // clearRecords method


    /**
     * Add new student information into the records.
     * pro: Student student
     * post: New student information has been added into the records.
     */
    public void writeStudentToFile (Student student)
    {
	try
	{
	    FileWriter out = new FileWriter (records, true);
	    BufferedWriter writeFile = new BufferedWriter (out);

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
	    System.err.println ("IOException: " + e.getMessage ());
	}
    } // writeStudentToFile method


    /**
     * Displays the page of StudentHistory class.
     * pre: none
     * post: The page has been displayed.
     */
    public void recordPage ()
    {

	// variable
	int x;
	char ch;

	do
	{

	    c.clear ();

	    c.setCursor (1, 1);
	    for (int i = 0 ; i < 80 ; i++)
	    {
		c.print ("-");
	    }

	    c.setCursor (2, 33);
	    c.setTextColor (Color.BLUE);
	    c.println ("Student History");


	    c.setTextColor (Color.BLACK);
	    c.setCursor (3, 1);
	    for (int i = 0 ; i < 80 ; i++)
	    {
		c.print ("-");
	    }

	    Color darkGreen = new Color (0, 128, 0);

	    c.setTextColor (darkGreen);
	    c.setCursor (4, 36);
	    c.print ("Graduates");

	    c.setTextColor (Color.BLACK);
	    c.setCursor (5, 1);
	    for (int i = 0 ; i < 80 ; i++)
	    {
		c.print ("-");
	    }

	    c.setTextColor (Color.ORANGE);
	    c.setCursor (6, 1);
	    c.print ("Name");

	    c.setCursor (6, 41);
	    c.print ("Year(s) Taken");

	    c.setCursor (7, 1);

	    x = 7;

	    c.setTextColor (Color.BLACK);
	    String output = "";
	    int num;
	    for (int i = 0 ; i < graduates.size () ; i++)
	    {
		output = output + ((Student) graduates.get (i)).getName ();

		num = ((Student) graduates.get (i)).getName ().length ();

		for (int j = 40 ; j > num ; j--)
		{
		    output = output + " ";
		}

		output = output + ((Student) graduates.get (i)).getYears () + "\n";
		x = x + 1;
	    }

	    c.print (output);

	    for (int i = 0 ; i < 80 ; i++)
	    {
		c.print ("-");
	    }
	    x = x + 1;

	    c.setTextColor (darkGreen);
	    c.setCursor (x, 31);
	    c.print ("Permanent Students");


	    x = x + 1;
	    c.setTextColor (Color.BLACK);
	    c.setCursor (x, 1);
	    for (int i = 0 ; i < 80 ; i++)
	    {
		c.print ("-");
	    }
	    x = x + 1;

	    c.setTextColor (Color.ORANGE);
	    c.setCursor (x, 1);
	    c.print ("Name");

	    c.setCursor (x, 41);
	    c.print ("Year(s) Tried");

	    x = x + 1;

	    c.setCursor (x, 1);
	    c.setTextColor (Color.BLACK);
	    output = "";
	    for (int i = 0 ; i < permanent.size () ; i++)
	    {
		output = output + ((Student) permanent.get (i)).getName ();

		num = ((Student) permanent.get (i)).getName ().length ();

		for (int j = 40 ; j > num ; j--)
		{
		    output = output + " ";
		}

		output = output + ((Student) permanent.get (i)).getYears () + "\n";
		x = x + 1;
	    }

	    c.print (output);

	    c.setCursor (x, 1);
	    for (int i = 0 ; i < 80 ; i++)
	    {
		c.print ("-");
	    }

	    c.println ("Press <s> to search page.");
	    c.println ("Press <d> to clear record.");
	    c.println ("Press <x> to leave.");

	    ch = c.getChar ();

	    if (ch == 's' || ch == 'S')
	    {
		this.searchPage ();
	    }
	    else if (ch == 'd' || ch == 'D')
	    {
		this.clearRecords ();
	    }

	}
	while (ch != 'x' && ch != 'X');

    } // recordPage method


    /**
     *Displays the search page.
     *pre: none
     *post: The search page has been displayed.
     */
    public void searchPage ()
    {

	// variable
	char ch = 's';

	do
	{
	    if (ch == 's' || ch == 'S')
	    {
		c.clear ();

		c.setCursor (1, 1);
		for (int i = 0 ; i < 80 ; i++)
		{
		    c.print ("-");
		}

		c.setCursor (2, 33);
		c.setTextColor (Color.BLUE);
		c.println ("Student History");


		c.setTextColor (Color.BLACK);
		c.setCursor (3, 1);
		for (int i = 0 ; i < 80 ; i++)
		{
		    c.print ("-");
		}

		Color darkGreen = new Color (0, 128, 0);

		c.setTextColor (darkGreen);
		c.setCursor (4, 37);
		c.print ("Search");

		c.setTextColor (Color.BLACK);
		c.setCursor (5, 1);
		for (int i = 0 ; i < 80 ; i++)
		{
		    c.print ("-");
		}

		// asks the user inputs a name
		c.print ("Please enter the name: ");
		String name = c.readLine ();
		name = name.toLowerCase ();

		int index = this.binarySearch (studentHistory, 0, studentHistory.size () - 1, name);
		String nameOutput = "Name Searched: " + name.toLowerCase ();
		String searchResult = "";
		if (index != -1) // if the program finds the student's information
		{
		    searchResult += "Name Found!\n";
		    searchResult += "Name: " + ((Student) studentHistory.get (index)).getName () + "\n";
		    searchResult += "Years Taken: " + ((Student) studentHistory.get (index)).getYears () + "\n";
		    if (((Student) studentHistory.get (index)).getGraduate () == true)
			searchResult += "Graduate :)";
		    else
			searchResult += "Permanent Student :(";
		}
		else // if the program cannot find the student's information
		{
		    searchResult = "Sorry......Name Not Found......";
		}

		c.println (nameOutput);
		c.println (searchResult);
		c.println ();

		c.println ("Press <s> to re-search again.");
		c.println ("Press <x> to leave.");

		do
		{
		    ch = c.getChar ();
		}
		while (ch != 'x' && ch != 's' && ch != 'X' && ch != 'S');

	    }
	}
	while (ch != 'x' && ch != 'X');


    } // recordPage method


    /**
     * MergeSort.
     * pre: ArrayList array, int start, int end, boolean byYear
     * post: The elements in the array are in the correct order after merge sort is used.
     */
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
    } // mergeSort method


    /**
     *  MergeSort by year.
     *  pre: ArrayList array, int start, int mid, int end
     *  post: The elements in the array are in the correct order by year.
     */
    private static void mergeByYear (ArrayList array, int start, int mid, int end)
    {
	Student[] temp = new Student [array.size ()];
	int pos1 = start;
	int pos2 = mid + 1;
	int spot = start;
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
	for (int i = start ; i <= end ; i++)
	{
	    array.remove (i);
	    array.add (i, temp [i]);
	}
    } // mergeByYear method


    /**
     *  MergeSort by name.
     *  pre: ArrayList array, int start, int mid, int end
     *  post: The elements in the array are in the correct order by name.
     */
    private static void mergeByName (ArrayList array, int start, int mid, int end)
    {
	Student[] temp = new Student [array.size ()];
	int pos1 = start;
	int pos2 = mid + 1;
	int spot = start;
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
	for (int i = start ; i <= end ; i++)
	{
	    array.remove (i);
	    array.add (i, temp [i]);
	}
    } // mergeByName method



    /**
     * Binary Search.
     * pre: ArrayList array, int start, int end, String goal
     * post: The array, mid+1, end and goal have been returned if the program can find the information;
     *       -1 has been returned if the program cannot find the information.
     */
    public static int binarySearch (ArrayList array, int start, int end, String goal)
    {
	if (start > end)
	    return -1;
	else
	{
	    int mid = (start + end) / 2;
	    if (goal.equals (((Student) array.get (mid)).getName ()))
		return mid;
	    else if (goal.compareTo ((((Student) array.get (mid)).getName ())) < 0)
		return (binarySearch (array, start, mid - 1, goal));
	    else
		return (binarySearch (array, mid + 1, end, goal));
	}
    } // binarySearch method
} // StudentHistory class


