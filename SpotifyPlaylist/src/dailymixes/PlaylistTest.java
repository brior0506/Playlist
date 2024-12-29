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
 * tests Playlist methods
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
public class PlaylistTest extends student.TestCase
{
    //~ Fields ................................................................
    
    private Playlist p1;
    private Playlist p2;
    //~ Constructors ..........................................................
    /**
     * initializes data fields
     */
    public void setUp() {
        p1 = new Playlist("Hello", 3, 10, 7, 20, 17, 30, 6);
        
        p1.addSong(new Song("1", 5, 13, 28, "Hello"));
        p1.addSong(new Song("2", 4, 11, 20, ""));
        p1.addSong(new Song("3", 18, 16, 10, "Hello"));
        
        p2 = new Playlist("Goodbye", 20, 0, 45, 50, 10, 65, 10);
    }
    //~Public  Methods ........................................................
    /**
     * tests getMinGenreSet method
     */
    public void testGetMinGenreSet() {
        assertEquals(new GenreSet(3, 10, 7), p1.getMinGenreSet());
        assertEquals(new GenreSet(20, 0, 45), p2.getMinGenreSet());
    }
    /**
     * tests setName method
     */
    public void testSetName() {
        p1.setName("Hola");
        assertEquals("Hola", p1.getName());
        p2.setName("Adios");
        assertEquals("Adios", p2.getName());
    }
    
    /**
     * tests getSpacesLeft method
     */
    public void testGetSpacesLeft() {
        assertEquals(3, p1.getSpacesLeft());
        
        p1.addSong(new Song("4", 5, 11, 22, ""));
        
        assertEquals(2, p1.getSpacesLeft());
        
        assertEquals(10, p2.getSpacesLeft());
        
        for (int i = 0; i < p2.getCapacity(); i++) {
            p2.addSong(new Song("" + i, 30, 5, 60, ""));
        }
        
        assertEquals(0, p2.getSpacesLeft());
        
    }
    
    /**
     * tests getMaxGenreSet method
     */
    public void testGetMaxGenreSet() {
        assertEquals(new GenreSet(20, 17, 30), p1.getMaxGenreSet());
        assertEquals(new GenreSet(50, 10, 65), p2.getMaxGenreSet());
    }
    
    /**
     * test compareTo method
     */
    
    public void testCompareTo() {
        assertEquals(-4, p1.compareTo(p2));
        assertEquals(4, p2.compareTo(p1));
        
        Playlist p3 = new Playlist("90s", 30, 20, 10, 40, 30, 20, 6);
        
        assertEquals(-3, p1.compareTo(p3));
        assertEquals(3, p3.compareTo(p1));
        
        for (int i = 0; i < 3; i++) {
            p3.addSong(new Song("" + i, 35, 25, 15, "90s"));
        }
        
        assertEquals(-40, p1.compareTo(p3));
        assertEquals(40, p3.compareTo(p1));
        
        Playlist p4 = new Playlist("80s", 30, 20, 10, 35, 25, 15, 6);
        
        for (int i = 0; i < 3; i++) {
            p4.addSong(new Song("" + i, 32, 22, 12, "80s"));
        }
        
        assertEquals(15, p3.compareTo(p4));
        assertEquals(-15, p4.compareTo(p3));
        
        Playlist p5 = new Playlist("Rock", 20, 0, 45, 50, 10, 65, 10);
        
        assertEquals(-11, p2.compareTo(p5));
        assertEquals(11, p5.compareTo(p2));
    }
    
    /**
     * tests getNumberOfSongs method
     */
    public void testGetNumberOfSongs() {
        assertEquals(3, p1.getNumberOfSongs());
        assertEquals(0, p2.getNumberOfSongs());
        
        p2.addSong(new Song("f1", 21, 1, 46, "Goodbye"));
        p1.addSong(new Song("f1", 4, 11, 8, "Hello"));
        
        assertEquals(1, p2.getNumberOfSongs());
        assertEquals(4, p1.getNumberOfSongs());
    }
    
    /**
     * tests addSong method
     */
    
    public void testAddSong() {
        assertFalse(p1.addSong(new Song("44s", 0, 40, 23, "")));
        p1.addSong(new Song("f1", 4, 11, 8, "Hello"));
        p1.addSong(new Song("f2", 6, 13, 10, "Hello"));
        p1.addSong(new Song("f3", 8, 15, 12, "Hello"));
        assertFalse(p1.addSong(new Song("f4", 7, 14, 11, "Hello")));
        
        assertTrue(p2.addSong(new Song("s1", 30, 3, 59, "Goodbye")));
        assertEquals(1, p2.getNumberOfSongs());
        assertEquals(new Song("s1", 30, 3, 59, "Goodbye"), p2.getSongs()[0]);
    }
    
    /**
     * tests toString method
     */
    public void testToString() {
        //"Playlist: Favorites, # of songs: 5 (cap: 12), 
        //Requires: Pop:0%-10%, Rock:25%-35%, Country:70%-90%"
        
        assertEquals("Playlist: Hello, # of songs: 3 (cap: 6), "
            + "Requires: Pop:3%-20%, Rock:10%-17%, Country:"
            + "7%-30%", p1.toString());
        
        assertEquals("Playlist: Goodbye, # of songs: 0 (cap: 10), "
            + "Requires: Pop:20%-50%, Rock:0%-10%, Country:"
            + "45%-65%", p2.toString());
        
        
    }
    /**
     * tests isFull method
     */
    
    public void testIsFull() {
        assertFalse(p1.isFull());
        p1.addSong(new Song("f1", 4, 11, 8, "Hello"));
        p1.addSong(new Song("f2", 6, 13, 10, "Hello"));
        p1.addSong(new Song("f3", 8, 15, 12, "Hello"));
        
        assertTrue(p1.isFull());
    }
    
    /**
     * tests equals method
     */
    public void testEquals() {
        Playlist p3 = p1;
        assertTrue(p1.equals(p3));
        
        Playlist pnull = null;
        assertFalse(p1.equals(pnull));
        assertFalse(p1.equals(p2));
        
        Playlist p4 = new Playlist("10s", 3, 10, 7, 20, 17, 30, 4);
        
        p4.addSong(new Song("1", 5, 13, 28, "Hello"));
        p4.addSong(new Song("2", 4, 11, 20, ""));
        p4.addSong(new Song("3", 18, 16, 17, "Hello"));
        
        assertFalse(p1.equals(p4));
     //p1 = new Playlist("Hello",3, 10, 7, 20, 17, 30, 6);

        Playlist p5 = new Playlist("10s", 1, 8, 7, 20, 17, 30, 4);
        
        p5.addSong(new Song("1", 5, 13, 28, "Hello"));
        p5.addSong(new Song("2", 4, 11, 20, ""));
        p5.addSong(new Song("3", 18, 16, 10, "Hello"));
        
        assertFalse(p1.equals(p5));
        
        Playlist p6 = new Playlist("10s", 3, 10, 7, 19, 25, 35, 4);
        
        p6.addSong(new Song("1", 5, 13, 28, "Hello"));
        p6.addSong(new Song("2", 4, 11, 20, ""));
        p6.addSong(new Song("3", 18, 16, 10, "Hello"));
        
        assertFalse(p1.equals(p6));
        
        Playlist p7 = new Playlist("10s", 3, 10, 7, 20, 17, 30, 4);
        
        p7.addSong(new Song("1", 5, 13, 28, "Hello"));
        p7.addSong(new Song("2", 4, 11, 20, ""));
        p7.addSong(new Song("3", 18, 16, 10, "Hello"));
        
        assertFalse(p1.equals(p7));
        
        
        Playlist p8 = new Playlist("Hello", 3, 10, 7, 20, 17, 30, 4);
        
        p8.addSong(new Song("1", 5, 13, 28, "Hello"));
        p8.addSong(new Song("2", 4, 11, 20, ""));
        p8.addSong(new Song("3", 18, 16, 10, "Hello"));
        
        assertFalse(p1.equals(p8));
        
        Playlist p9 = new Playlist("Hello", 3, 10, 7, 20, 17, 30, 6);
        
        p9.addSong(new Song("1", 5, 13, 28, "Hello"));
        p9.addSong(new Song("2", 4, 11, 20, ""));
        p9.addSong(new Song("3", 18, 16, 10, "Hello"));
        
        assertTrue(p1.equals(p9));
        
        String s1 = "H";
        
        assertFalse(p1.equals(s1));
        
    }
    
    /**
     * tests getSongs method
     */
    
    public void testGetSongs() {
        Song[] testSong1 = new Song[p1.getCapacity()];
        Song[] testSong2 = new Song[p2.getCapacity()];
        
        testSong1[0] = new Song("1", 5, 13, 28, "Hello");
        testSong1[1] = new Song("2", 4, 11, 20, "");
        testSong1[2] = new Song("3", 18, 16, 10, "Hello");
        
        for (int i = 0; i < p1.getCapacity(); i++) {
            assertEquals(testSong1[i], p1.getSongs()[i]);
        }
        
        for (int i = 0; i < p2.getCapacity(); i++) {
            assertEquals(testSong2[i], p2.getSongs()[i]);
        }
            
        
        
        
    }
    
    /**
     * tests getCapacity method
     */
    public void testGetCapacity() {
        assertEquals(6, p1.getCapacity());
        
        assertEquals(10, p2.getCapacity());
    }
    
    /**
     * tests getName method
     */
    public void testGetName() {
        assertEquals("Hello", p1.getName());
        assertEquals("Goodbye", p2.getName());
    }
    /**
     * tests isQualified method
     */
    public void testIsQualified() {
      //p1 = new Playlist("Hello",3, 10, 7, 20, 17, 30, 6);
        Song s1 = new Song("s1", 2, 14, 10, "Hello");
        Song s2 = new Song("s2", 5, 9, 10, "Hello");
        Song s3 = new Song("s3", 5, 14, 6, "Hello");
        Song s4 = new Song("s4", 21, 14, 10, "Hello");
        Song s5 = new Song("s5", 5, 18, 10, "Hello");
        Song s6 = new Song("s6", 5, 14, 31, "Hello");
        Song s7 = new Song("s7", 3, 17, 7, "Hello");
        Song s8 = new Song("s8", 20, 10, 30, "Hello");
        
        assertFalse(p1.isQualified(s1));
        assertFalse(p1.isQualified(s2));
        assertFalse(p1.isQualified(s3));
        assertFalse(p1.isQualified(s4));
        assertFalse(p1.isQualified(s5));
        assertFalse(p1.isQualified(s6));
        assertTrue(p1.isQualified(s7));
        assertTrue(p1.isQualified(s8));
    }
}
