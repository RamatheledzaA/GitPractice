// ramatheledza adzisani 4484298
// Write a Java program that reads words from a file and array(array) and groups anagrams.

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramHash {
    public static void main(String [] args) {

        try {
            // read from a text file
            File file = new File("book.txt");
            Scanner scan = new Scanner(file);
            HashMap<String, ArrayList<String>> maps = new HashMap<>();

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
            }
            scan.close();

            
        }

        // lets work on  grouping anagrams
        String[] words= {"eat","tea","tan","ate","nat","bat","listen","silent","cat","act","dog","god" };
        HashMap<String , ArrayList<String>> map = new HashMap<>();
        for ( String word : words) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        System.out.println(map);

    }

}
