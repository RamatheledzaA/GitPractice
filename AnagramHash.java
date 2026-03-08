// ramatheledza adzisani
// Write a Java program that reads words and group them in an anagram

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramHash {
    public static void main(String [] args){

        System.out.println(" Now let work on Anagrams when given a string array!");

        String[] words= {"eat","tea","tan","ate","nat","bat","listen","silent","cat","act","dog","god" };

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for ( String word : words) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            // if key is not in the map
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
                map.get(key).add(word);
            }
        }
        System.out.println(map);
    }

}
