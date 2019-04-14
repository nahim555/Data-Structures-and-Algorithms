/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histogram;

import java.util.Scanner;

/**
 *
 * @author Nahim
 */
public class Distance {
    
    public static void main(String[] args){
        
    final long startTime = System.nanoTime();
        
    int n = 6;
    
    // used to test matrix table 3
    int mat[][] = {
        {0,58,184,271,378,379},
        {58,0,167,199,351,382},
        {184,167,0,43,374,370},
        {271,199,43,0,394,390},
        {378,351,374,394,0,47},
        {379,382,370,390,47,0}
    };
    
    Scanner sc = new Scanner(System.in);
    

      
      int m[][] = new int[n][n];
      
      /*
      *example of input if n = 3 3x3 matrix:
      *  0 9 8  then enter
         9 9 0  then enter
         8 9 0  then enter
          
      */
      System.out.println("enter numbers into matrix i.e add numbers to amount of rows then enter for each column   ");
      
      for(int i =0; i<n; i++)
      {
          for(int j =0; j<n; j++)
          {
              //m[i][j] = (int)(Math.random()* 200) + 1;
              m[i][j] = sc.nextInt();
          }
      }
    
    
  
    // hold results of loop
    int[] result = new int[m.length];
    
    //min value
    int min= 0;

    
     for(int i = 0; i < m.length; i++)
      {
         for(int j = 0; j < m[i].length; j++)
         {
            System.out.print(m[i][j] + "\t");
            
            if(m[i][j]<m[i][min] && m[i][j] != 0){
                
                    //min becomes value in j as long as its larger than 0
                    min=j;
              
            }
            result[i]=m[i][min];
                    
         }
           
             
         System.out.println();
         
      }
     
     System.out.println();
     
     for(int i=0; i<result.length; i++)
     {
         
         System.out.print(result[i] + ",");
     }
     
      final long endTime = System.nanoTime();
        
      System.out.println("Total execution time: " + (endTime - startTime)/1000000);
    
}
     

    }
     
