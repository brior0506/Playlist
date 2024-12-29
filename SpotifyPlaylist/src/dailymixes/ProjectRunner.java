package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
/**
 * // -------------------------------------------------------------------------
/**
 * runs project
 * 
 *  @author brend
 *  @version Nov 8, 2024
 */
public class ProjectRunner
{
/**
 * main method to run project
 */
    public static void main(String[] args) throws FileNotFoundException, ParseException, DailyMixDataException
    {
        String songs = "./inputFiles/input7.txt";
        String playlists = "./inputFiles/playlists4.txt";
        if(args.length == 2) {
            songs = args[0];
            playlists = args[1];
        }
        
        PlaylistReader main = new PlaylistReader(songs, playlists);
        
    }
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
