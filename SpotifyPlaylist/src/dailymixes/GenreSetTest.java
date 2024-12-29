package dailymixes;

import static org.junit.Assert.*;
// -------------------------------------------------------------------------
/**
 *  tests genreset methods
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept
//the actions of those who do.
//-- Brendan Riordan (brior0506)


public class GenreSetTest extends student.TestCase
{
    //~ Fields ................................................................
    
    private GenreSet s1;
    private GenreSet s2;
    
    
    
    //~ Constructors ..........................................................
    /**
     * initializes data fields
     */
    public void setUp() {
        this.s1 = new GenreSet(20, 30, 15);
        this.s2 = new GenreSet(10, 53, 20);
    }
    //~Public  Methods ........................................................
    
    
    // ----------------------------------------------------------
    /**
     * tests getRock method
     */
    public void testGetRock() {
        assertEquals(30, s1.getRock());
        
        assertEquals(53, s2.getRock());
        
        
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests getPop method
     */
    public void testGetPop() {
        assertEquals(20, s1.getPop());
        
        assertEquals(10, s2.getPop());
    }
    
    /**
     * tests getCountry method
     */
    public void testGetCountry() {
        assertEquals(15, s1.getCountry());
        
        assertEquals(20, s2.getCountry());
    }
    /**
     * tests toString method
     */
    public void testToString() {
        assertEquals("Pop:20 Rock:30 Country:15", s1.toString());
        
        assertEquals("Pop:10 Rock:53 Country:20", s2.toString());
    }
    
    /**
     * tests equals method
     */
    public void testEquals() {
        GenreSet s = null;
        
        assertFalse(s1.equals(s));
        
        GenreSet s11 = s1;
        
        assertTrue(s1.equals(s11));
        
        String f1 = "hello";
        
        assertFalse(s1.equals(f1));
        
        assertFalse(s1.equals(s2));
        
        GenreSet s5 = new GenreSet(20, 30, 15);
        
        GenreSet s6 = new GenreSet(20, 32, 15);
        GenreSet s7 = new GenreSet(20, 30, 16);
        
        
        assertFalse(s5.equals(s6));
        
        assertFalse(s1.equals(s7));
        
        assertTrue(s1.equals(s5));
    }
    
    /**
     * tests isWithinRange method
     */
    public void testIsWithinRange() {
        GenreSet s = null;
        
        GenreSet same = s1;
        
        GenreSet s3 = new GenreSet(21, 20, 10);
        
        GenreSet s4 = new GenreSet(21, 31, 10);
        
        
        
        
        assertFalse(s1.isWithinRange(s, s2));
        
        assertFalse(s1.isWithinRange(s2, s));
        assertFalse(s1.isWithinRange(s3, s4));
        assertFalse(s1.isWithinRange(s4, s3));
        
        GenreSet higher = new GenreSet(30, 31, 20);
        
        GenreSet lower = new GenreSet(19, 25, 10);
        
        assertTrue(s1.isWithinRange(lower, higher));
        assertTrue(s1.isWithinRange(lower, same));
        
        assertFalse(s1.isWithinRange(s2, s));
        
        
        assertFalse(s1.isWithinRange(lower, s2));
    }
    
    /**
     * tests compareTo method
     */
    public void testCompareTo() {
        assertEquals(-18, s1.compareTo(s2));
        
        assertEquals(18, s2.compareTo(s1));
        
        GenreSet sequals = new GenreSet(20, 30, 15);
        
        assertEquals(0, s1.compareTo(sequals));
    }
    
   
}
