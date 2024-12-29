package dailymixes;

import static org.junit.Assert.*;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept 
//the actions of those who do.
//-- Brendan Riordan (brior0506)

// -------------------------------------------------------------------------
/**
 *  tests Song methods
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
public class SongTest extends student.TestCase
{
    //~ Fields ................................................................
    private Song s1;
    private Song s2;
    //~ Constructors ..........................................................
    /**
     * initializes data fields
     */
    public void setUp() {
        this.s1 = new Song("Hello", 20, 30, 15, "");
        this.s2 = new Song("GoodBye", 30, 44, 12, "p2");
    }
    //~Public  Methods ........................................................

    /**
     * tests getPlaylistName method
     */
    public void testGetPlaylistName() {
        assertEquals("", s1.getPlaylistName());
        
        assertEquals("p2", s2.getPlaylistName());
    }
    /**
     * tests getName method
     */
    public void testGetName() {
        assertEquals("Hello", s1.getName());
        
        assertEquals("GoodBye", s2.getName());
    }
    
    /**
     * tests getGenreSet method
     */
    public void testGetGenreSet() {
        assertEquals(new GenreSet(20, 30, 15), s1.getGenreSet());
        
        assertEquals(new GenreSet(30, 44, 12), s2.getGenreSet());
        
        
    }
    
    /**
     * tests toString method
     */
    public void testToString() {
        assertEquals("GoodBye Pop:30 Rock:44 Country:12 "
            + "Suggested: p2", s2.toString());
        
        assertEquals("No-Playlist Hello Pop:20 Rock:30 "
            + "Country:15", s1.toString());
        
        
    }
    /**
     * tests equals method
     */
    public void testEquals() {
        Song s3 = null;
        
        Song scopy = s1;
        
        assertFalse(s1.equals(s3));
        
        assertTrue(s1.equals(scopy));
        
        assertFalse(s1.equals(s2));
        
        String f1 = "hello";
        
        assertFalse(s1.equals(f1));
        
        Song s22 = new Song("GoodBye", 30, 44, 12, "p2");
        
        assertTrue(s2.equals(s22));
        
        Song s4 = new Song("GoodBye", 30, 44, 12, "p1");
        assertFalse(s2.equals(s4));
        Song s5 = new Song("GoodBye", 44, 40, 2, "p2");
        assertFalse(s2.equals(s5));
            
            
        
    }
    
    
}
