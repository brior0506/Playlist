package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
 *  Implements QueueInterface to define a queue with 
 *  an underlying array
 *  @param <T>
 * 
 *  @author brend
 *  @version Oct 31, 2024
 */
public class ArrayQueue<T> implements QueueInterface<T>
{

    
    //fields
    /**
     * sets default capacity of underlying array
     */
    public static final int DEFAULT_CAPACITY = 20;
    
    private T[] queue;
    
    private int dequeueIndex;
    
    private int enqueueIndex;
    
    private int size;
    //constructor
    
    /**
     * @param capacity
     * defines an ArrayQueue with a capacity
     * specified by client
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.queue = (T[]) new Object[capacity + 1];
        this.dequeueIndex = 0;
        this.enqueueIndex = this.queue.length - 1;
        
        this.size = 0;
    }
    
    /**
     * defines an arrayqueue with the
     * default capacity
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    
    @SuppressWarnings("unchecked")
    /**
     * expands underlying array if it is full
     */
    private void ensureCapacity() {
        if (this.isFull()) {
            
            int newLength = this.queue.length * 2 - 1;
            T[] newArr = (T[]) new Object[newLength];
            for (int i = 0; i < this.size; i++) {
                newArr[i] = this.queue[(this.dequeueIndex + i) 
                                       % this.queue.length];
            }
            
            this.queue = newArr;
            this.enqueueIndex = this.size - 1;
            this.dequeueIndex = 0;
            
        }
    }
    /**
     * properly increments index passed in based on 
     * the circular underlying array
     */
    private int incrementIndex(int index) {
        return ((index + 1) % this.queue.length);
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    /**
     * implements clear method from interface
     * completely empties underlying array
     */
    public void clear()
    {
        this.queue = (T[]) new Object[DEFAULT_CAPACITY + 1];
        this.dequeueIndex = 0;
        this.enqueueIndex = this.queue.length - 1;
        
        this.size = 0;
        
    }
    
    // ----------------------------------------------------------
    /**
     * turns queue into an array
     * @return array filled with objects in the queue
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        if (this.size == 0) {
            throw new EmptyQueueException();
        }
        T[] newArr =  (T[]) new Object[this.size];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = this.queue[(this.dequeueIndex + i) % this.queue.length];
        }
        
        return newArr;
    }
    
    @Override
    /**
     * turns queue into a string format
     * @return the queue turned string
     */
    public String toString() {
        StringBuilder s1 = new StringBuilder();
        s1.append("[");
        boolean firstEntry = true;
        for (int i = 0; i < this.size; i++) {
            if (!firstEntry) {
                s1.append(", ");
                
            }
            else {
                firstEntry = false;
            }
            
            s1.append(this.queue[(this.dequeueIndex + i)
                                 % this.queue.length].toString());
        }
        
        s1.append("]");
        return s1.toString();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    /**
     * @param obj
     * checks if this queue is equal to obj
     * @return true if equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() == obj.getClass()) {
            ArrayQueue<T> o = (ArrayQueue<T>) obj;
            if (o.size != this.size) {
                return false;
            }
            if (!this.isEmpty() && (o.getFront().getClass() 
                != this.getFront().getClass())) {
                return false;
            }
            
            return o.toString().equals(this.toString());
                
            
        }
        return false;
    }

    @Override
    /**
     * removes item from front of queue
     * @return item removed of type T
     */
    public T dequeue()
    {
        T data = this.getFront();
        this.queue[this.dequeueIndex] = null;
        this.dequeueIndex = this.incrementIndex(this.dequeueIndex);
        this.size--;
        
        return data;
    }

    @Override
    /**
     * @param newEntry
     * adds newEntry to the back of queue
     */
    
    public void enqueue(T newEntry)
    {
        ensureCapacity();
        this.enqueueIndex = this.incrementIndex(this.enqueueIndex);
        this.queue[this.enqueueIndex] = newEntry;
        this.size++;
        
    }

    @Override
    /**
     * returns item of type T that is at the front
     * of the queue
     * @return front of queue
     */
    public T getFront()
    {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return this.queue[this.dequeueIndex];
    }

    @Override
    /**
     * Checks if queue is empty
     * @return true if empty
     */
    public boolean isEmpty()
    {
        
        return this.size == 0;
    }
    
    
    
    // ----------------------------------------------------------
    /**
     * gets size of queue which is how many elements 
     * have been added
     * @return this.size
     */
    public int getSize() {
        return this.size;
    }
    // ----------------------------------------------------------
    /**
     * gets the total length of underlying array
     * @return this.queue.length
     */
    public int getLengthOfUnderlyingArray() {
        return this.queue.length;
    }
    /**
     * checks if underlying array is full
     * @return true if it is full false otherwise
     */
    private boolean isFull() {
        return (enqueueIndex + 2) % queue.length == 
            dequeueIndex;
    }
    

}
