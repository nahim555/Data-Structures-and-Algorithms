/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histogram;


public class Histogram {
    
    public static void main(String[] args) {
        
        //start time
        final long startTime = System.nanoTime();
        
        int n = 10;
        int max = 100;
        int out[] = new int[n];
        
        for (int i = 0; i < n; i++) {
                int temp = (int)(Math.random()*max) + 1;
                out[temp % 10]++;
            }
        
        // print values in array
        for (int i = 1; i <= 10; i++) 
        {
             System.out.print(i + " - " + i * 10 + "| ");
            for (int j = 0; j < out[i-1]; j++) 
            {
                System.out.print("*");
            }
                System.out.println();
            }
        
        final long endTime = System.nanoTime();
        
        System.out.println("Total execution time: " + (endTime - startTime)/1000000);
    }
}
    
 