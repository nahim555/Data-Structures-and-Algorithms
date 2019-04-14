package question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Nahim
 */
public class SVD {
    
    //Algorithm to find SVD whose run time complexity id O(n*n)
    public static void SVD_Onn(int arr[], int n){
        int maxCount = 0;
        int index = -1;
        long t1 = System.nanoTime();
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++)
            {
                if(arr[i] == arr[j])
                    count++;
            }
            
            
            if(count > maxCount)
            {
                maxCount = count;
                index = i;
        }
    }
        if(maxCount > n/2){
            System.out.println(arr[index]);
        
        }
        else
            System.out.print("no value found");
        
       
        
    }
    
    // Algorithm to find SVD whose worst runtime complexity is O(nlog(n))
    public static void SVD_Onlogn(int[] arr){
        
    Arrays.sort(arr);
    int count = 1;
    int x = arr[0];
           

    for (int i = 1; i <arr.length ; i++) {
        if(x==arr[i]){
            count++;
            if(count>arr.length/2) {
                System.out.println(x);
            }
        }else{
            x = arr[i];
            count = 1;
        }

    }
        
    
    }
    
    // Algorithm for finding SVD whose space complexity and worst case runtime is O(n) using a hashmap 
    public static void SVD_On(int[] arr){
        
         long t1 = System.nanoTime();
         long t2 = 0;
        
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                int count = map.get(arr[i]) + 1;
                if(count > arr.length / 2){
                    System.out.println(arr[i]);
                   
                    
                }else
                    map.put(arr[i], count);
                t2 = System.nanoTime();
                  
            }
            else
                map.put(arr[i], 1);
        }
            long end = t2 - t1;
        System.out.println(end);
        
      
    }
    
    public static void main(String[] args){
        
        Random rand = new Random();
        int randomNum = rand.nextInt();
        int n = 50000;
        int[] a = new int [n];
        int[] arr = {7,7,9,3,2,7,7};
        
        for(int i = 0; i < a.length; i++){
            a[i] = randomNum;
        }
        
        //testing
        
        //O(n*n)
        //SVD_Onn(a,n);
        
        //O(nlog(n))
        //SVD_Onlogn(a);
        
        //O(n)
        SVD_On(a);
    }
    
}
