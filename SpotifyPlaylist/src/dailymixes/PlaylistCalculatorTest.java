package dailymixes;

//Virginia Tech Honor Code Pledge:

//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
import static org.junit.Assert.*;
import list.AList;
import queue.EmptyQueueException;
/**
 * // -------------------------------------------------------------------------
/**
 *  tests PlaylistCalculator methods
 * 
 *  @author brend
 *  @version Nov 8, 2024
 */
public class PlaylistCalculatorTest extends student.TestCase
{
    //~ Fields ................................................................
    
    
    private PlaylistCalculator pc1;
    private PlaylistCalculator pc2;
    private Playlist[] p1;
    
    //~ Constructors ..........................................................
    /**
     * initializes all data fields correctly
     */
    public void setUp() {
        Playlist[] p2;
        
        ArrayQueue<Song> a1;
        ArrayQueue<Song> a2;
        a1 = new ArrayQueue<>();
        a2 = new ArrayQueue<>();
        a1.enqueue(new Song("h", 1, 22, 40, "Country"));
        a1.enqueue(new Song("k", 11, 72, 30, ""));
        a1.enqueue(new Song("j", 50, 33, 25, "Pop"));
        a1.enqueue(new Song("l", 19, 41, 15, "Rock"));
        a1.enqueue(new Song("h", 16, 72, 30, "Country"));
        a1.enqueue(new Song("h", 1, 35, 69, ""));
        
        p1 = new Playlist[PlaylistCalculator.NUM_PLAYLISTS];
        p2 = new Playlist[PlaylistCalculator.NUM_PLAYLISTS];
        p1[0] = new Playlist("Pop", 45, 30, 22, 80, 35, 40, 10);
        p1[1] = new Playlist("Rock", 20, 40, 10, 30, 70, 15, 7);
        p1[2] = new Playlist("Country", 0, 20, 38, 6, 35, 70, 9);
        p2[0] = new Playlist("Pop", 40, 10, 1, 60, 15, 10, 8);
        p2[1] = new Playlist("Rock", 15, 50, 0, 25, 85, 6, 5);
        p2[2] = new Playlist("Country", 15, 5, 60, 35, 10, 85, 4);
        
        
        pc1 = new PlaylistCalculator(a1, p1);
        pc2 = new PlaylistCalculator(a2, p2);
    }
    //~Public  Methods ........................................................
    /**
     * tests reject method
     */
    public void testReject() {
        pc1.reject();
        assertEquals(new Song("h", 1, 22, 40, "Country"),
            pc1.getRejectedTracks().getEntry(0));
        
        Exception e = null;
        try {
            pc2.reject();
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        assertTrue(e instanceof EmptyQueueException);
    }
    /**
     * tests getPlaylistForSong method when 
     * rec. playlist is valid initially
     */
    public void testGetPlaylistForSong() {
        Song s1 = new Song("h", 1, 22, 40, "Country");
        assertEquals(new Playlist("Country", 0, 20, 38, 6, 35, 70, 9),
            pc1.getPlaylistForSong(s1));
        assertNull(pc1.getPlaylistForSong(null));
        
        Song s2 = new Song("pop", 45, 30, 40, "Pop");
        Song s3 = new Song("country", 1, 20, 38, "Country");
        Song s4 = new Song("rock", 20, 40, 10, "Rock");
        
        assertEquals(new Playlist("Pop", 45, 30, 22, 80, 35, 40, 10),
            pc1.getPlaylistForSong(s2));
        assertEquals(new Playlist("Rock", 20, 40, 10, 30, 70, 15, 7),
            pc1.getPlaylistForSong(s4));
        assertEquals(new Playlist("Country", 0, 20, 38, 6, 35, 70, 9),
            pc1.getPlaylistForSong(s3));
        
        
        
    }
    
    /**
     * tests getPlaylistForSong method when the playlist 
     * name
     * isnt found initially
     */
    public void testGetPlaylistForSongNoMatch() {
        Song s2 = new Song("k", 11, 72, 30, "");
        assertNull(pc1.getPlaylistForSong(s2));
        Song s7 = new Song("a", 0, 21, 39, "");
        assertEquals(new Playlist("Country", 0, 20, 38, 6, 35, 70, 9),
            pc1.getPlaylistForSong(s7));
        
        Song s3 = new Song("a", 1, 21, 39, "RANDB");
        Song s1 = new Song("a", 90, 90, 90, "RANDB");
        
        assertEquals(new Playlist("Country", 0, 20, 38, 6, 35, 70, 9),
            pc1.getPlaylistForSong(s3));
        
        assertNull(pc1.getPlaylistForSong(s1));
        for (int i = 0; i < 9; i++) {
            pc1.getPlaylists()[2].addSong(s3);
        }
        
        assertNull(pc1.getPlaylistForSong(s3));
        
        Song s5 = new Song("a", 46, 31, 23, "");
        
        assertEquals(new Playlist("Pop", 45, 30, 22, 80, 35, 40, 10),
            pc1.getPlaylistForSong(s5));

    }
    /**
     * tests getPlaylistForSong method when rec. playlists
     * is valid but the playlist cannot accept the song
     */
    
    public void testGetPlaylistForSongFull() {
        Song s2 = new Song("k", 1, 30, 39, "Pop");
        Song s3 = new Song("a", 46, 30, 22, "Pop");
        assertNull(pc1.getPlaylistForSong(s2));
            
        for (int i = 0; i < 10; i++) {
            pc1.getPlaylists()[0].addSong(s3);
        }
        
        assertNull(pc1.getPlaylistForSong(s3));
        
    }
    
    /**
     * tests addSongToPlaylist method
     */
    public void testAddSongToPlaylist() {
        assertFalse(pc2.addSongToPlaylist());
        assertTrue(pc1.addSongToPlaylist());
        ArrayQueue<Song> temp = pc1.getQueue();
        assertEquals(new Song("k", 11, 72, 30, ""), temp.getFront());
        assertEquals(5, temp.getSize());
        Playlist[] p11 = pc1.getPlaylists();
        Song s1 = p11[2].getSongs()[0];
        assertEquals(new Song("h", 1, 22, 40, "Country"), s1);
        
        assertFalse(pc1.addSongToPlaylist());
        assertEquals(5, temp.getSize());
    }
    /**
     * tests getQueue method
     */
    public void testGetQueue() {
        assertEquals(new ArrayQueue<Song>(), pc2.getQueue());
        ArrayQueue<Song> q1 = new ArrayQueue<>();
        q1.enqueue(new Song("h", 1, 22, 40, "Country"));
        q1.enqueue(new Song("k", 11, 72, 30, ""));
        q1.enqueue(new Song("j", 50, 33, 25, "Pop"));
        q1.enqueue(new Song("l", 19, 41, 15, "Rock"));
        q1.enqueue(new Song("h", 16, 72, 30, "Country"));
        q1.enqueue(new Song("h", 1, 35, 69, ""));
        assertEquals(q1, pc1.getQueue());
    }
    /**
     * tests getPlaylistIndex method
     */
    public void testGetPlaylistIndex() {
        assertEquals(-1, pc1.getPlaylistIndex(""));
        assertEquals(0, pc1.getPlaylistIndex("Pop"));
        assertEquals(1, pc1.getPlaylistIndex("Rock"));
        assertEquals(2, pc1.getPlaylistIndex("Country"));
    }
    /**
     * tests getPlaylists method
     */
    public void testGetPlaylists() {
        Playlist[] pcopy1 = {new Playlist("Pop", 45, 30, 22, 80, 35, 40, 10)
        , new Playlist("Rock", 20, 40, 10, 30, 70, 15, 7)
        , new Playlist("Country", 0, 20, 38, 6, 35, 70, 9)};
        
        Playlist[] pcopy2 = {new Playlist("Pop", 40, 10, 1, 60, 15, 10, 8),
            new Playlist("Rock", 15, 50, 0, 25, 85, 6, 5),
            new Playlist("Country", 15, 5, 60, 35, 10, 85, 4)};
        
        for (int i = 0; i < PlaylistCalculator.NUM_PLAYLISTS; i++) {
            assertEquals(pcopy1[i], pc1.getPlaylists()[i]);
        }
        for (int i = 0; i < PlaylistCalculator.NUM_PLAYLISTS; i++) {
            assertEquals(pcopy2[i], pc2.getPlaylists()[i]);
        }
    }
    /**
     * tests getRejectedTracks method
     */
    public void testGetRejectedTracks() {
        AList<Song> b1 = new AList<>();
        assertEquals(b1, pc1.getRejectedTracks());
        for (int i = 0; i < 5; i++) {
            pc1.reject();
        }
        b1.add(new Song("h", 1, 22, 40, "Country"));
        b1.add(new Song("k", 11, 72, 30, ""));
        b1.add(new Song("j", 50, 33, 25, "Pop"));
        b1.add(new Song("l", 19, 41, 15, "Rock"));
        b1.add(new Song("h", 16, 72, 30, "Country"));
        
        assertEquals(b1, pc1.getRejectedTracks());
        
    }
    /**
     * tests PlaylistCalculator constructor
     */
    public void testPlaylistCalculator() {
        Exception e = null;
        try {
            PlaylistCalculator p4 = new PlaylistCalculator(null, this.p1);
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        assertTrue(e instanceof IllegalArgumentException);
    }
}
