/*
 * Student Class - Ready in Program
 * Chun Kit (Calvin) Li
 * Original Version (Swing): Jasmine Xiao
 */

import java.io.*;

public class Student implements Serializable
{
    // variable
    private String name;
    private int years;
    private boolean graduate;

    /** constructor
     * pre: student name
     * post: initializes all variables
     */
    public Student (String n)
    {
	name = n.toLowerCase ();
	years = 1;
	graduate = false;
    } // constructor


    /** constructor
     * pre: none
     * post: returns the student name as a String
     */
    public String getName ()
    {
	return name;
    } // getName method


    /**
     * returns the years taken as an int
     * pre: none
     * post: years has been returned.
     */
    public int getYears ()
    {
	return years;
    } // getYears method


    /**
     * returns the graduate value as a boolean
     * pre: none
     * post: graduate has been returned.
     */
    public boolean getGraduate ()
    {
	return graduate;
    } // getGraduate method


    /**
     * new name replaces the old name in the name variable
     * pre: String n
     * post: The new name has been replaceed the old name
     */
    public void setName (String n)
    {
	name = n.toLowerCase ();
    } // setName method


    /**
     * years increment by 1 each time a player restarts the game
     * pre: none
     * post: years has been added by 1.
     */
    public void restart ()
    {
	years += 1;
    } // restart method


    /**
     * years variable is set thm int value of y
     * pre: int y
     * post: y has been passed into years.
     */
    public void setYears (int y)
    {
	years = y;
    } // setYears method


    /**
     * When the Student object's graduate value becomes true
     * pre: none
     * post: true has been passed into graduate.
     */
    public void graduate ()
    {
	graduate = true;
    } // graduate method


    /**
     * returns a String of the info about the Student object
     * pre: none
     * post: The information has been returned.
     */
    public String toString ()
    {
	String info;
	info = name + "\n" + years + "\n" + graduate;
	return info;
    } // toString method
} // Student Class
