// ramatheledza edzisani
//Write a Java method for:
//a) Linear Search
//b) Binary Search

public class test1_Practice1 {

    // linear Search implementation
    // step 1: create an array with values to search
    int [] array = {20, 1,12,6,17, 15,29};
    // step 2: initialise the target value to search for
    int target = 6 ;
    int result = linearSearch(array, target);
    public static int linearSearch (int[] array , int target){
        // implement a loop that goes through the loop
        for ( int i = 0 ; i < array.length ; i++){
            if ( array[i] ==target){
                return i ;
            }
        }
        return -1;
    }

    

}
