// Ramatheledza Adzisani 4484298
/* Read each word from the book.
Convert the word to lowercase.
Sort the characters of the word.
Use the sorted string as a key in a HashMap.
Insert the word into the corresponding list

 */

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

                // create a character array and soet it
                char [] letters = word.toCharArray();
                Arrays.sort(letters);

                // create a key
                String key = new String(letters);


            }




        } catch (Exception e) {
            System.out.println("error when reading a file");
        }
    }
}
