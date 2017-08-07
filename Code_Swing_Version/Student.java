// The "Student" class.
// Author: Jasmine Xiao

import java.io.*;

public class Student
{
    // Variables for student name,
    // number of years tried,
    // and if the student graduated or not
    private String name;
    private int years;
    private boolean graduate;

    // constructor
    // pre: student name
    // post: initializes all variables
    public Student (String n)
    {
	name = n.toLowerCase ();
	years = 1;
	graduate = false;
    }


    // pre: none
    // post: returns the student name as a String
    public String getName ()
    {
	return name;
    }


    // pre: none
    // post: returns the years taken as an int
    public int getYears ()
    {
	return years;
    }


    // pre: none
    // post: returns the graduate value as a boolean
    public boolean getGraduate ()
    {
	return graduate;
    }


    // pre: new name as a String
    // post: new name replaces the old name in the name variable
    public void setName (String n)
    {
	name = n.toLowerCase ();
    }


    // pre: none
    // post: years increment by 1 each time a player restarts the game
    public void restart ()
    {
	years += 1;
    }


    // pre: number of years taken/tried
    // post: years variable is set thm int value of y
    public void setYears (int y)
    {
	years = y;
    }


    // pre: none
    // post: When the Student object's graduate value becomes true
    public void graduate ()
    {
	graduate = true;
    }


    // pre: none
    // post: returns a String of the information about the Student object
    public String toString ()
    {
	String info;
	info = name + "\n" + years + "\n" + graduate;
	return info;
    }
}
