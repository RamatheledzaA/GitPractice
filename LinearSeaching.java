// Ramatheledza Adzisani 4484298
// Practical prep
// Data structure and algorithms - linear search (array)

public class LinearSeaching {
    public static void main(String[] args) {
        // create an array with values to search
        int[] Array = {70, 3, 25, 17, 44, 39, 12};
        int target = 17;

        int result = linearSearch(Array, target);

        if (result != -1){
            System.out.println( target + " is the target value at index " + linearSearch(Array, target));
        }else {
            System.out.println( target + " not found");
        }

    }

    public static int linearSearch(int [] Array , int target) {

        for (int i = 0; i < Array.length; i++) {
            if (Array[i] == target) {
                return i ;
            }
        }
        return -1;
    }
}
