import java.util.ArrayList;
import java.util.List;

//ramatheledza adzisani
// this project focuses on hash set
public class Hash_Set {
    public static void main( String[] args){

        SimpleHashSet hashSet = new SimpleHashSet(10);

        hashSet.add("Charlotte");
        hashSet.add("Thomas");
        hashSet.add("Jens");
        hashSet.add("Peter");
        hashSet.add("Lisa");
        hashSet.add("Adele");
        hashSet.add("Michaela");
        hashSet.add("Bob");

        hashSet.printSet();

        System.out.println("\n'Peter' is in the set: " + hashSet.contains("Peter"));
        System.out.println("Removing 'Peter'");
        hashSet.remove("Peter");
        System.out.println("'Peter' is in the set: " + hashSet.contains("Peter"));
        System.out.println("'Adele' has hash code: " + hashSet.hashFunction("Adele"));

    }



    // Create a simplehashset class
    static class SimpleHashSet{
        private final int size ;
        private final List<List<String>> buckets ;

        SimpleHashSet(int size) {
            this.size = size;
            this.buckets = new ArrayList<>(size);

            for ( int i = 0 ; i < size ; i++) {
                buckets.add(new ArrayList<>());
            }
        }

        public void add(String value) {
            int index = Integer.parseInt(hashFunction(value));
            List<String> bucket = buckets.get(index);
            if (!bucket.contains(value)) {
                bucket.add(value);
            }
        }

        public void printSet() {
            System.out.println("Hash Set Contents:");
            for (int index = 0; index < buckets.size(); index++) {
                List<String> bucket = buckets.get(index);
                System.out.println("Bucket " + index + ": " + bucket);
            }

        }

        public boolean contains(String value) {
            int index = Integer.parseInt(hashFunction(value));
            List<String> bucket = buckets.get(index);
            return bucket.contains(value);
        }

        public void remove(String value) {
            int index = Integer.parseInt(hashFunction(value));
            List<String> bucket = buckets.get(index);
            bucket.remove(value);
        }

        public String hashFunction(String value) {
            return value;
        }
    }
    private static int hashFunction(String value) {
        int size = 0;
        return value.chars().reduce(0, Integer::sum) % size;
    }

}
