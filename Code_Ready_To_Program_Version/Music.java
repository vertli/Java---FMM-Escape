/**
 * Music Class
 * Chun Kit (Calvin) Li
 * A class for playing or stop playing music.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Random;
import sun.audio.AudioPlayer;

public class Music
{

    // save the location (path) of the music
    private String file;
    private InputStream inputStream;

    // array
    private String path[] = new String [4];


    /**
     * constructor
     * pre: none
     * post: Music class has been selected.
     */
    public Music ()
    {
	this.setting ();
    } //Constructor


    /**
     * Passes the path of .wav files into path[]
     * pre: none
     * post: The path has been passed into path[]
     */
    private void setting ()
    {
	path [0] = "/sound/BehindTheKey1.wav";
	path [1] = "/sound/BehindTheKey2.wav";
	path [2] = "/sound/BehindTheKey5.wav";
	path [3] = "/sound/BehindTheKey6.wav";
    } // setting method


    /**
     * Plays the music.
     * pre: String soundFile
     * post: The music has been played.
     */
    public void play () throws IOException
    {
	AudioPlayer.player.start (inputStream);
    } // play method


    /**
     * Stops playing the music.
     * pre: none
     * post: The music has been stopped playing.
     */
    public void stop () throws IOException
    {
	AudioPlayer.player.stop (inputStream);
    } // stop method


    /**
     * Gets the location (path) of BGM number i.
     * pre: none
     * post: The location (path) of BGM number i has been passed into inputStream.
     */
    public void number (int i) throws IOException
    {

	file = System.getProperty ("user.dir") + path [i];
	inputStream = new FileInputStream (new File (file));

    } // number method



    /**
     * Random plays BGM.
     * pre: none
     * post: One of the BGMs has been played.
     */
    public void playBGM () throws IOException
    {
	this.stop (); // stops playing any BGM if any BGM is playing
	Random r = new Random ();
	int num = r.nextInt (4); // random a number between 1 - 4 and pass into no
	this.number (num);
	this.play ();

    } // playBGM method
} // Music class
