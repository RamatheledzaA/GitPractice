// ramatheledza adzisani 4484298
// Write a Java program that reads words from a file and array(array) and groups anagrams.

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramBook {
    public static void main(String [] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        try {
            // read from a text file
            File file = new File("book.txt");
            Scanner scan = new Scanner(file);

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
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
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

        // lets work on  grouping anagrams
        System.out.print(" Now let work on Anagrams when given a string array!");
        String[] words= {"eat","tea","tan","ate","nat","bat","listen","silent","cat","act","dog","god" };
        System.out.println(words);

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
