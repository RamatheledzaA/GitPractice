// ramatheledza adzisani 4484298
// Write a Java program that reads words and groups anagrams.

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramHash {
    public static void main(String [] args) throws Exception{

        // read a file
        File file =  new File ("book.txt") ;
        Scanner scan = new Scanner (file);
        HashMap < String,Integer> wordCount = new HashMap<>();

        while (scan.hasNext()){
            String word = scan.next().toLowerCase();
            word = word.replaceAll("[a - z]", " ");
            if (wordCount.containsKey(word)){
                wordCount.put(word , wordCount.get(word + 1));
            }else{
                wordCount.put(word , 1);
            }
        }
        scan.close();
        for (String word : wordCount.keySet()){
            System.out.println(word + ":" + wordCount.get(word));
        }

        

    }

}
