package dailymixes;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
/**
 * // -------------------------------------------------------------------------
/**
 * defines a DailyMixException
 * 
 *  @author brend
 *  @version Nov 8, 2024
 */
public class DailyMixDataException extends Exception
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................
    /**
     * @param msg
     * makes DailyMixDataException("") a valid exception that can send error message
     */
    public DailyMixDataException(String msg) {
        super(msg);
    }
    //~Public  Methods ........................................................
    
}   
