package scanningdata;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * @author Gracie
 * @version 2-29-16
 * @author maellis1
 * @version March 2022
 */
public class ProjectRunner {
    /**
     * Creates a DataReader from default file input.txt 
     * unless a program arguments is provided
     * 
     * @param args
     *            program input
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws ParseException,
        FileNotFoundException {
        if (args.length == 1) {
            new DataReader(args[0]);
        }
        else {
            new DataReader("input.txt");
        }
    }
}
