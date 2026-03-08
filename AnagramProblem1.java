// Ramatheledza Adzisani 4484298
/* Read each word from the book.
Convert the word to lowercase.
 */

// Anagrams Using Frequency Method

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
public class AnagramProblem1 {
    public static void main(String[] args){

        try{
            // create a file that you will read from
            File file = new File("C:/Users/user/IdeaProjects/My_COS211 and 212 projects/src/book.txt/");
            Scanner sc = new Scanner(file);
            HashMap< String , ArrayList<String>> map = new HashMap<>();

            while (sc.hasNext()){
                //read the next word
                String word = sc.next().toLowerCase();
                //remove the puncuations
                word = word.replaceAll("[^a-z]" , "");


                if ( word.length() == 0){
                    continue;
                }
                // create a frequency array
                int[] frequency = new int[26];

                //create a character array
                for( char c : word.toCharArray()){
                    frequency [ c - 'a']++;
                }

                // create a key
                String key = Arrays.toString( frequency);

                // if key is not in the map
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(word);

            }
            sc.close();
            // display
            for (ArrayList<String> group : map.values()) {
                if (group.size() > 1) {
                    System.out.println(group);
                }
            }

        } catch (Exception e) {
            System.out.println("error when reading a file");
        }
    }
}
