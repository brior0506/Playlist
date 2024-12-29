package dailymixes;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Brendan Riordan (brior0506)
// -------------------------------------------------------------------------
/**
 * defines a playlist that implements comparable
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
public class Playlist
    implements Comparable<Playlist>
{

    //~ Fields ................................................................
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;
    //~ Constructors ..........................................................
    
    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * @param name
     * name of playlist
     * @param minPop
     * minimum pop requirement
     * @param minRock
     * max pop requirement
     * @param minCountry
     * min country requirement
     * @param maxPop
     * max pop requirement
     * @param maxRock
     * max rock requirement
     * @param maxCountry
     * max country requirement
     * @param playlistCap
     * playist capacity
     * 
     * creates new playlist object
     */
    public Playlist(String name, int minPop, int minRock, int minCountry,
        int maxPop, int maxRock, int maxCountry,  int  playlistCap) {
        this.name = name;
        this.capacity = playlistCap;
        this.minGenreSet = new GenreSet(minPop, minRock, minCountry);
        this.maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.numberOfSongs = 0;
        this.songs = new Song[this.capacity];
    }
    //~Public  Methods ........................................................
    
    /**
     * returns spaces left based on capacity and numSongs
     * @return spaces left
     */
    public int getSpacesLeft() {
        return this.capacity - this.numberOfSongs;
    }
    
    /**
     * determines whether playlist is full
     * @return true if full
     */
    public boolean isFull() {
        return this.getSpacesLeft() == 0;
    }
    
    /**
     * @param newSong
     * adds song to playlist if it isnt full and song
     * fits requirements
     * @return true if songs was added correctly
     */
    public boolean addSong(Song newSong) {
        if (!this.isFull() && this.isQualified(newSong)) {
            this.songs[this.numberOfSongs] = newSong;
            this.numberOfSongs++;
            return true;
        }
        return false;
    }
    
    /**
     * @param s
     * checks if a song s is qualified to be added to
     * this playlist
     * @return true if qualified
     */
    public boolean isQualified(Song s) {
        return s.getGenreSet().isWithinRange(this.minGenreSet, 
            this.maxGenreSet);
    }
    
    /**
     * turns playlist into string format
     * @return string version of playlist
     */
    public String toString() {
        StringBuilder s1 = new StringBuilder();
        s1.append("Playlist: " + this.name);
        s1.append(", # of songs: ");
        s1.append(this.numberOfSongs);
        s1.append(" (cap: ");
        s1.append(this.capacity);
        s1.append("), Requires: Pop:" + this.minGenreSet.getPop());
        s1.append("%-" + this.maxGenreSet.getPop() + "%, Rock:");
        s1.append(this.minGenreSet.getRock() + "%-" + 
            this.maxGenreSet.getRock());
        s1.append("%, Country:" + this.minGenreSet.getCountry());
        s1.append("%-" + this.maxGenreSet.getCountry() + "%");
        
        return s1.toString();
    }
    
    /**
     * @param obj
     * determines whether this is equal to obj
     * @return true if the two are equal
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass() == this.getClass()) {
            Playlist o = (Playlist) obj;
            if (o.getNumberOfSongs() != this.getNumberOfSongs()) {
                return false;
            }
            for (int i = 0; i < this.getNumberOfSongs(); i++) {
                if (!this.songs[i].equals(o.getSongs()[i])) {
                    return false;
                }
            }
            return o.getMinGenreSet().equals(this.minGenreSet) &&
                o.getMaxGenreSet().equals(this.maxGenreSet) &&
                this.name.equals(o.getName()) &&
                this.capacity == o.getCapacity();
        }
        return false;
        
        
    } 
    
    @Override
    /**
     * @param other
     * compares this to other to determine order
     * @return if this is greater than obj a positive integer, if
     * this is less than obj a negative int and 0 if equal
     */
    public int compareTo(Playlist other)
    {
        if (this.capacity != other.capacity) {
            return this.capacity - other.capacity;
        }
        else if (this.getSpacesLeft() != other.getSpacesLeft()) {
            return this.getSpacesLeft() - other.getSpacesLeft();
        }
        else if (this.getMinGenreSet().compareTo(other.getMinGenreSet()) != 0) {
            return this.getMinGenreSet().compareTo(other.getMinGenreSet());
        }
        else if (this.getMaxGenreSet().compareTo(other.getMaxGenreSet()) != 0) {
            return this.getMaxGenreSet().compareTo(other.getMaxGenreSet());
        }
        else {
            return this.name.compareTo(other.getName());
        }
        
        
    }
    /**
     * gets the minGenreset
     * @return this.minGenreSet
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;
    }

    /**
     * gets the maxGenreset
     * @return this.maxGenreSet
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;
    }

    /**
     * gets songs array
     * @return this.songs
     */
    public Song[] getSongs()
    {
        return songs;
    }

    /**
     * gets capacity of playlist
     * @return this.capacity
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * gets number of songs in playists
     * @return this.numberOfSongs
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }

    /**
     * returns the name of playlist
     * @return this.name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @param name
     * sets this.name = name
     */
    public void setName(String name) {
        this.name = name;
    }


    



}
