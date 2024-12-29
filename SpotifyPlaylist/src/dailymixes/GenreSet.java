package dailymixes;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept 
//the actions of those who do.
//-- Brendan Riordan (brior0506)

// -------------------------------------------------------------------------
/**
 *  defines a genre set and implements comparable
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
public class GenreSet implements Comparable<GenreSet>
{
    //~ Fields ................................................................
    
    private int pop;
    
    private int rock;
    
    private int country;
    
    //~ Constructors ..........................................................
    
    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * @param pop
     * the pop percentage in genre set
     * @param rock
     * the rock percentage in genre set
     * @param country
     * the country percentage in genre set
     */
    public GenreSet(int pop, int rock, int country) {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }
    
    /**
     * @param other
     * checks if this genre set is less than or equal to other
     * @return true if all data fields in this are less
     * than or equal to data fields in other
     */
    private boolean isLessThanOrEqualTo(GenreSet other) {
        if (other == this) {
            return true;
        }
        
        
        
        return this.pop <= other.pop && this.rock <= other.rock
            && this.country <= other.country;
    }
     
    
    // ----------------------------------------------------------
    /**
     * checks if this genre set is between minGenreSet and maxGenreSet
     * @param minGenreSet
     * the minimum threshold for the data fields
     * @param maxGenreSet
     * the maximum threshold for the data fields
     * @return true if it is within the range
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet) {
        if (minGenreSet == null || maxGenreSet == null) {
            return false;
        }
        
        boolean greaterThan = minGenreSet.isLessThanOrEqualTo(this);
            
        boolean lessThan = this.isLessThanOrEqualTo(maxGenreSet);
        
        return greaterThan && lessThan;
        
        
    }
    
    /**
     * @param obj
     * checks if this genre set is equal to obj
     * @return true if they are equals
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
            
        }
        
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() == obj.getClass()) {
            GenreSet set = (GenreSet) obj;
            
            return this.pop == set.pop &&
                this.rock == set.rock &&
                this.country == set.country;
        }
        return false;
    }
    
    
    


    @Override
    /**
     * @param o
     * 
     * compares one genre set to o
     * 
     * @return an positive integer if this is greater
     * than o a negative integer if o is greater than
     * this and 0 if they are equal
     */
    public int compareTo(GenreSet o)
    {
        int thisSum = this.pop + this.rock + this.country;
        
        int oSum = o.pop + o.rock + o.country;
        
        return thisSum - oSum;
    }
    
    
    
    @Override
    /**
     * makes the genreset into a string form
     * @return this represented as a string
     */
    public String toString() {
        return "Pop:"
            + this.pop + " Rock:" + this.rock +
            " Country:" + this.country;
    }


    // ----------------------------------------------------------
    /**
     * returns this.pop.
     * @return number associated with pop variable
     */
    public int getPop()
    {
        return pop;
    }


    // ----------------------------------------------------------
    /**
     * returns this.rock
     * @return the number associated with rock 
     */
    public int getRock()
    {
        return rock;
    }


    // ----------------------------------------------------------
    /**
     * returns this.country.
     * @return the number associated with country
     */
    public int getCountry()
    {
        return country;
    }
    

}
