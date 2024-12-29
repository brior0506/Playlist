package dailymixes;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
// -------------------------------------------------------------------------
/**
 *  defines Song object
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
public class Song
{
    //~ Fields ................................................................
    
    private String name;
    
    private String suggestedPlaylist;
  
    private GenreSet genreSet;
    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * @param name
     * name of song
     * @param pop
     * pop percentage in associated genreset
     * @param rock
     * rock percentage in associated genreset
     * @param country
     * country percentage in associated genreset
     * @param suggested
     * suggested playlist
     * 
     * creates song object
     */
    //~ Constructors ..........................................................
    public Song(String name,  int  pop,  int rock,  
        int country,  String suggested) {
        this.genreSet = new GenreSet(pop, rock, country);
        this.name = name;
        this.suggestedPlaylist = suggested;
    }
    //~Public  Methods ........................................................
    
    @Override
    /**
     * converts the songs into string form
     * @return the string form of the song
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.name + " ");
        s.append("Pop:" + this.genreSet.getPop() + " ");
        s.append("Rock:" + this.genreSet.getRock() + " ");
        s.append("Country:" + this.genreSet.getCountry());
        if (this.suggestedPlaylist.length() == 0) {
            s.insert(0, "No-Playlist ");
        }
        else {
            s.append(" Suggested: " + this.suggestedPlaylist);
        }
        
        return s.toString();
    }
    
    /**
     * @param obj
     * checks if this song and obj are equal
     * @return if they are equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
            
        }
        
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() == obj.getClass()) {
            Song set = (Song) obj;
            
            return this.name.equals(set.name) &&
                this.suggestedPlaylist.equals( 
                set.suggestedPlaylist)
                &&
                this.genreSet.equals(set.genreSet);
        }
        return false;
    }
    
    
    
    
    // ----------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * gets name of song
     * @return this.name
     */
    public String getName()
    {
        return name;
    }
    // ----------------------------------------------------------
    /**
     * .gets suggested playlist
     * @return this.suggestedPlaylist
     */
    public String getPlaylistName()
    {
        return suggestedPlaylist;
    }
    // ----------------------------------------------------------
    /**
     * gets the genreset associated with the songs
     * @return this.genreSet
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }

    
    
}
