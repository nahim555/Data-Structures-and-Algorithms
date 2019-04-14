
package question2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahim
 */
public class ArrayHashTable extends HashTable {
    
     
    Object[][] table; //Create Object variable
    int chainSize = 5; //Initial size of chain
    int[] counts; //Array to store counts

  
    
    public ArrayHashTable(){
        table = new Object[capacity][]; //initialise 2D Object 
        counts = new int[capacity];
        
      
        setTable(); //set table to null;
        
        
        setCount(); //set count to 0
        
    
    }
    
    public void setTable(){
        //initialise all values in table to null
        for(int i = 0; i<capacity; i++){
            table[i] = null;
        }
    }
    
    public void setCount(){
        //initialise all counts to 0
        for(int i = 0; i < capacity; i++){
            counts[i] = 0;
        }
    }
    
   
  
    /**
     * Method to add Object to HashTable
     * @param obj
     * @return 
     */
    @Override
    boolean add(Object obj) {
        
        // generate hash code 
        int hash = obj.hashCode() % this.capacity;
        
        //check if chain arrays exists and make new one if it doesn't
        if(table[hash] == null){
            Object[] chain = new Object[chainSize];
            table[hash] = chain;
        }
        
        //check if object is already in hash table
        if(!contains(obj)){
            //Double chain capcity if max number
            if(table[hash][table[hash].length - 1] != null){
                
                // copy chain into temporary array
                Object[] tempArr = new Object[this.table[hash].length*2];
                System.arraycopy(this.table[hash], 0, tempArr, 0, this.table[hash].length);
                
                // Copy chains back doubled in size
                this.table[hash] = tempArr;
        }
            boolean addObj = false;
            int i = 0;
            while(!addObj){
                //checks if space is free.
                if(table[hash][i] == null){
                    table[hash][i] = obj;
                    counts[hash]++;
                    size++;
                    addObj = true;
                    System.out.println("Added " + table[hash][i] + " hash "
                    + hash + " to hash table. ");
                }
                i++;
            }
            
            return true;
    }
        return false;
        
    }

    /**
     * Method to check if a Object is in the Hashtable
     * @param obj
     * @return 
     */
    @Override
    boolean contains(Object obj) {
        int hash = obj.hashCode() % this.capacity;
        
        // search through chain for Object
        for(int i = 0; i < counts[hash]; i++){
            if(table[hash][i] == obj){
                System.out.println(table[hash][i] + " found at position " +
                        hash + "," + i + ".");
                return true;
            }
        }
        
        return false;
    }

    /**
     * Method to remove object from Hashtable
     * @param obj
     * @return 
     */
    @Override
    boolean remove(Object obj) {
        int hash = obj.hashCode() % this.capacity;
        
        for(int i = 0; i < counts[hash]; i++){
            if(table[hash][i] == obj){
                System.out.println("Removed " + table[hash][i] + " " + "from hash table");
                table[hash][i] = null;
                
                //Move all items back one
                for(int j = i + 1; j < counts[hash]; j++){
                    table[hash][j-1] = table[hash][j];
                }
                
                counts[hash]--;
                size--;
                
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method to test run time experiment
     */
    public static void TimingExperiment(){
        
    
        Random r = new Random();
        ArrayHashTable hTable = new ArrayHashTable();
        int a = 100;
        int n = 1000; // matrix size
        
        while(n <= 50000) {
           
            int[] numbers = new int[n];
            
            for(int j = 0; j < n; j++){
                numbers[j] = Math.abs(r.nextInt());
            }
            
            // mean and std deviation
         
            double sum = 0;
            double sumSquared = 0;
                
      
                long t1 = System.nanoTime();
                
                for(int j = 0; j < n; j++){
                    hTable.add(numbers[j]);
                }
                
                for(int j = 0; j < n; j++){
                    hTable.remove(numbers[j]);
                }

                long t2 = System.nanoTime() - t1;

                // Recording it in milli seconds to make it more interpretable
                sum += (double)t2 / 1000000.0;
                sumSquared += (t2/1000000.0) * (t2/1000000.0);
            
                double mean = sum / a;
                double variance = sumSquared / a - (mean * mean);
                double stdDev = Math.sqrt(variance);
            
                if(n < 20000){
                    n += 1000;
                }
                
                else if(n < 50001){
                    n += 5000;
                }
        }
      
    }
    
   /**
    * Main method for testing
    * @param args 
    */
    public static void main(String[] args) {
        
        //testing 
        int t = 6;
        ArrayHashTable table = new ArrayHashTable();
        
        System.out.println("Testing");
        //add values to hash table
        for(int i = 0; i < t; i++ ){
            table.add(i);
        }
       
        //check values were added correctly
        for(int i = 0; i < t; i++){
            table.contains(i);
        }
  
        //remove all values
        for(int i = 0; i < t; i++){
            table.remove(i);
        }
        
 
       TimingExperiment();
        
    }
    
    
}
