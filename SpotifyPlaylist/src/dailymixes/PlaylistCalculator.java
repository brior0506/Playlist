package dailymixes;

//Virginia Tech Honor Code Pledge:

//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
//-- Brendan Riordan (brior0506)

import java.util.Arrays;
import list.AList;
/**
 * // -------------------------------------------------------------------------
/**
 *  Defines a playlistCalulator that decides if playlist is valid
 * 
 *  @author brend
 *  @version Nov 8, 2024
 */
public class PlaylistCalculator
{
    //~ Fields ................................................................
    private Playlist[] playlists;
    /**
     * specific number of playlists in playlists
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * minimum percent song threshold can be
     */
    public static final int MIN_PERCENT = 0;
    /**
     * max percent song threshold can be
     */
    public static final int MAX_PERCENT = 100;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    //~ Constructors ..........................................................
    /**
     * @param songQueue
     * songQueue is an ArrayQueue of songs
     * @param playlists
     * build a playlistcalclulator with songQueue and playlists
     */
    public PlaylistCalculator(ArrayQueue<Song> songQueue, 
        Playlist[] playlists) {
        if (songQueue == null) {
            throw new IllegalArgumentException();
        }
        
        this.playlists = playlists;
        this.songQueue = songQueue;
        this.rejectedTracks = new AList<>();
    }
    //~Public  Methods ........................................................
    /**
     * @param nextSong
     * gets specific playlist that will take in nextSong
     * @return the specified playlist
     */
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }
        
        String suggested = nextSong.getPlaylistName();
        for (int i = 0; i < this.playlists.length; i++) {
            if (suggested.equals(this.playlists[i].getName())) {
                if (this.canAccept(this.playlists[i], nextSong)) {
                    return this.playlists[i];
                }
                else  {
                    return null;
                }
            }
        }
        Playlist maxCapac = this.getPlaylistWithMaximumCapacity(nextSong);
        
        return maxCapac;
    }
    
    /**
     * @param aSong
     * get the playlist with the max capacity that will take aSong
     * @return specified playlist
     */
    private Playlist getPlaylistWithMaximumCapacity(Song aSong) {
        Playlist[] newPlaylist = Arrays.copyOf(this.playlists, 
            this.playlists.length);
        Arrays.sort(newPlaylist);
        
        for (int i = newPlaylist.length - 1; i >= 0; i--) {
            if (this.canAccept(newPlaylist[i], aSong)) {
                return newPlaylist[i];
            }
        }
        
        return null;
        
    }
    /**
     * adds Song to suggested playlist
     * @return true if the addition is sucessfull
     */
    public boolean addSongToPlaylist() {
        System.out.println(this.rejectedTracks);
        if (this.songQueue.isEmpty()) {
            return false;
        }
        
        Playlist suggested = this.getPlaylistForSong(this.songQueue.getFront());
        if (suggested == null) {
            return false;
        }
        
        suggested.addSong(this.songQueue.dequeue());
        return true;
        
    }
    /**
     * adds a song that can't be added to rejected tracks
     */
    public void reject() {
        this.rejectedTracks.add(this.songQueue.dequeue());
        
    }
    /**
     * @param playlist
     * @param song
     * checks if playlist can accept song based on various requirements
     * @return true if can accept false if can't accept
     */
    private boolean canAccept(Playlist playlist, Song song) {
        
        return !playlist.isFull() && playlist.isQualified(song);
        
    }
    /**
     * @param playlist
     * gets the index of playlist in this.playlists array
     * @return the index of playlist
     */
    public int getPlaylistIndex(String playlist) {
        for (int i = 0; i < NUM_PLAYLISTS; i++) {
            if (playlist.equals(this.playlists[i].getName())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * gets this.songQueue
     * @return ArrayQueue<Song>
     */
    public ArrayQueue<Song> getQueue() { 
        return this.songQueue;
    }
    
    // ----------------------------------------------------------
    /**
     * gets this.playlists array
     * @return Playlist[]
     */
    public Playlist[] getPlaylists() {
        return this.playlists;
    }
    
    // ----------------------------------------------------------
    /**
     * gets rejectedTracks
     * @return AList<Song>
     */
    public AList<Song> getRejectedTracks() {
        return this.rejectedTracks;
    }
    
    
}
