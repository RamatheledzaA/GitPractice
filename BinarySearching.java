// Ramatheledza Adzisani 4484298
// Practical prep
// Data structure and algorithms - Binary search (array)

public class BinarySearching {
    public static void main(String[] args){

        int[] arr = {2, 3, 7, 7, 11, 15, 25};
        int target = 11;
        int result = BinarySearch(arr , target);
        int left = 0 ;
        int right = arr.length - 1;
        while ( left <= right){
            int mid = (left + right)/ 2 ;
            if(mid == target){
                
            }else if ( arr[mid] < target){
                left = mid + 1 ;

            }else {
                right = mid -1 ;

            }
        }
        if (result != -1){
            System.out.println( target + " is the target value at index " + BinarySearch(arr, target));
        }else {
            System.out.println( target + " not found");
        }

    }

    public static int BinarySearch( int[] arr , int target){
        for (int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
