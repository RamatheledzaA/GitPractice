// ramatheledza edzisani
//Write a Java method for:
//a) Linear Search
//b) Binary Search

import java.util.Arrays;

public class test1_Practice1 {

    // linear Search implementation
    // step 1: create an array with values to search
    int [] array = {20, 1,12,6,17, 15,29};
    // step 2: initialise the target value to search for
    int target = 6 ;
    int result1 = linearSearch(array, target);
    public static int linearSearch (int[] array , int target){
        // implement a loop that goes through the loop
        for ( int i = 0 ; i < array.length ; i++){
            if ( array[i] ==target){
                return i ;
            }
        }
        return -1;
    }

    //binary implementation
    int [] binary_array = {2,4,6,8,10,12};
    int left = 0;
    int right = binary_array.length - 1;

    /*while( left  <= right  ){
        int mid = ( left + right)/ 2 ;
        if ( mid == target){


        } else if (binary_array[mid] < target) {
            left = mid + 1 ;
        }else{
            right = mid - 1 ;
        }
    }


    int result2 = binarySearch ( binary_array , target);
    public static int binarySearch(int [] binary_array , int target){
        for (int i = 0 ; i < binary_array.length ; i++){
            if(binary_array[i] == target){
                return i;
            }
        }
        return -1;
    }
*/


}


