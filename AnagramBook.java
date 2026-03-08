// ramatheledza adzisani 4484298
// Write a Java program that reads words from a file and array(array) and groups anagrams.
//Write a Java program that reads words from a file called book.txt and groups all anagrams together.
/* The program must:
     Ignore punctuation.
     Ignore uppercase/lowercase differences.
     Print only groups that contain more than one word.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramBook {
    public static void main(String [] args) {
        try {
            // read from a text file
            File file = new File("C:/Users/user/IdeaProjects/My_COS211 and 212 projects/src/book.txt");
            Scanner scan = new Scanner(file);
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            while (scan.hasNext()) {
                // read the next word
                String word = scan.next().toLowerCase();

                //remove all puncuations
                word = word.replaceAll("[^a-z]", " ");

                if (word.length()== 0) {
                    continue;
                }
                //now convert array into a character array
                char[] letters = word.toCharArray();
                //sort them
                Arrays.sort(letters);

                //now create a key
                String key = new String(letters);

                // if the key is not  in map create new list
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(word);
            }
            scan.close();
            // now we have to print anagrams
            for ( ArrayList<String> group : map.values()){
                if (group.size() > 1){
                    System.out.println(group);
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading file");
        }

    }

}
