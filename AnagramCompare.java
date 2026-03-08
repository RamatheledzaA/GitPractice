// Ramtheledza Adzisani 4484298
// this program compare the anagram sorting method and the frequency method....
// also find the time complexity for each


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramCompare {

    // ------Sorting method anagram------
    public static void SortingMethod() throws Exception{

        HashMap <String,ArrayList<String>> map = new HashMap<>();
        File file  = new File("\"C:/Users/user/IdeaProjects/My_COS211 and 212 projects/src/book.txt/");
        Scanner sc = new Scanner(file);

        while(sc.hasNext()){

            String word = sc.next().toLowerCase();// read the next word
            word = word.replaceAll("[^a-z]", ""); // remove punctuations

            if(word.length() == 0){
                continue;
            }

            // now create a character array and sort it
            char [] c = word.toCharArray();
            Arrays.sort(c);

            // now create a key
            String key = new String (word);

            // if key is not in the map
            if(!map.containsKey(key)){
                map.putIfAbsent(key , new ArrayList<>());
            }
            map.get(key).add(word);

        }
    }
    
    public static void main(String[] args)  {
        try{
            HashMap<String , ArrayList<String>> maps = new HashMap<>()
        }

    }
}
