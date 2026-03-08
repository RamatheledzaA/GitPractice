// ramatheledza adzisani 4484298
/* Finds the largest anagram group in the book.
Prints the words in that group.
Prints the size of the group.
using the frequency method
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramProblem2 {
    public static void main(String [] args){

        try{
            HashMap<String , ArrayList<String>> map = new HashMap<>();
            File file = new File("C:/Users/user/IdeaProjects/My_COS211 and 212 projects/src/book.txt/");
            Scanner sc = new Scanner(file);

            while(sc.hasNext()){
                String word = sc.next().toLowerCase();
                word = word.replaceAll("[^a-z]", ""); // remove puncuations

                // now create a frequency array
                int[] freq = new int [26];

                // now create a character array
                for(char c : word.toCharArray()){
                    freq[c - 'a'] ++;
                }

                // dor the size of the group
                if( word.length() == 0) {
                    continue;
                }

                //create a string key
                String key = Arrays.toString(freq);

                // if the key is not in the map
                map.putIfAbsent(key , new ArrayList<>());
                map.get(key).add(word);

                // let's group the anagrams and find the largest group
                for ( ArrayList<String> group : map.values()){
                    if (group.size() > 1){
                        System.out.println(group);
                    }
                    for (int i = 0 ; i < group.size() ; i++){
                        group[i];
                        if(group[i])

                    }
                }

            }


        } catch (Exception e) {
            System.out.println(" error reading file");
        }
    }
}
