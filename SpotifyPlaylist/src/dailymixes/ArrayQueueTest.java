package dailymixes;

import static org.junit.Assert.*;
import queue.EmptyQueueException;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept 
//the actions of those who do.
//-- Brendan Riordan (brior0506)
// -------------------------------------------------------------------------
/**
 *  tests arrayqueue methods
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
public class ArrayQueueTest extends student.TestCase
{
    //~ Fields ................................................................
    private ArrayQueue<String> q1;
    private ArrayQueue<String> q2;
    //~ Constructors ..........................................................
    /**
     * initializes data fields
     */
    public void setUp() {
        q1 = new ArrayQueue<>();
        q2 = new ArrayQueue<>(10);
        q1.enqueue("2");
        q1.enqueue("4");
        q1.enqueue("6");
    }
    //~Public  Methods ........................................................

    /**
     * tests clear method
     */
    public void testClear() {
      
        
        assertEquals(3, q1.getSize());
        q1.clear();
        assertEquals(0, q1.getSize());
        
    }
    /**
     * tests toArray method
     */
    public void testToArray() {
        Exception e = null;
        try {
            q2.toArray();
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        assertTrue(e instanceof EmptyQueueException);
      
        Object[] a1 = q1.toArray();
        assertEquals("2", a1[0]);
        assertEquals("4", a1[1]);
        assertEquals("6", a1[2]);
    }
    
    // ----------------------------------------------------------
    /**
     * tests toString method
     */
    public void testToString() {
        assertEquals("[]", q2.toString());
        assertEquals("[2, 4, 6]", q1.toString());
    }
    
    // ----------------------------------------------------------
    /**
     * tests equals method
     */
    public void testEquals() {
        String s1 = "Hello";
        assertFalse(q1.equals(s1));
        ArrayQueue<String> q3 = q1;
        ArrayQueue<String> q4 = new ArrayQueue<>();
        ArrayQueue<String> q5 = new ArrayQueue<>();
        ArrayQueue<String> qnull = null;
        ArrayQueue<Integer> qint = new ArrayQueue<>();
        ArrayQueue<String> q6 = new ArrayQueue<>();
        
        
        assertTrue(q2.equals(q6));
        q4.enqueue("2");
        q4.enqueue("4");
        q4.enqueue("6");
        qint.enqueue(2);
        qint.enqueue(4);
        qint.enqueue(6);
        q5.enqueue("2");
        q5.enqueue("3");
        assertTrue(q1.equals(q3));
        assertTrue(q1.equals(q4));
        assertFalse(q4.equals(qint));
        assertFalse(q1.equals(q5));
        
        assertFalse(q1.equals(qnull));
        
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests dequeue method
     */
    public void testDequeue() {
        assertEquals("2", q1.dequeue());
        assertEquals(2, q1.getSize());
        assertEquals("4", q1.dequeue());
        assertEquals("6", q1.dequeue());
        assertEquals(0, q1.getSize());
        
        Exception e = null;
        try {
            q1.dequeue();
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        assertTrue(e instanceof EmptyQueueException);
        
        q2.enqueue("h");
        
        
        assertEquals("h", q2.dequeue());
    }
    
    // ----------------------------------------------------------
    /**
     * tests enqueue method
     */
    public void testEnqueue() {
        
        for (int i = 0; i < 17; i++) {
            q1.enqueue("a");
        }
        assertEquals(20, q1.getSize());
        q1.enqueue("s");
        assertEquals(41, q1.getLengthOfUnderlyingArray());
        assertEquals("2", q1.dequeue());
        q1.enqueue("e");
        assertEquals(41, q1.getLengthOfUnderlyingArray());
        q2.enqueue("a");
        q2.enqueue("b");
        assertEquals(2, q2.getSize());
    }
    
    // ----------------------------------------------------------
    /**
     * tests getFront method
     */
    public void testGetFront() {
        Exception e = null;
        try {
            q2.getFront();
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        assertTrue(e instanceof EmptyQueueException);
        
        assertEquals("2", q1.getFront());
        
        q2.enqueue("5");
        assertEquals("5", q2.getFront());
    }
    
    // ----------------------------------------------------------
    /**
     * test isEmpty method
     */
    public void testIsEmpty() {
        
        assertFalse(q1.isEmpty());
        assertTrue(q2.isEmpty());
    }
    /**
     * tests getSize method
     */
    public void testGetSize() {
        assertEquals(0, q2.getSize());
        assertEquals(3, q1.getSize());
    }
    
    /**
     * tests getLengthOFUnderlyingarray method
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(21, q1.getLengthOfUnderlyingArray());
        assertEquals(11, q2.getLengthOfUnderlyingArray());
        
        q1.clear();
        assertEquals(21, q1.getLengthOfUnderlyingArray());
        q2.clear();
        assertEquals(21, q2.getLengthOfUnderlyingArray());
    }
    
    
    
}


