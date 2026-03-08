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

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        File file = new File("C:/Users/user/IdeaProjects/My_COS211 and 212 projects/src/book.txt/");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();// read the next word
            word = word.replaceAll("[^a-z]", ""); // remove punctuations

            if (word.length() == 0) {
                continue;
            }

            // now create a character array and sort it
            char[] c = word.toCharArray();
            Arrays.sort(c);

            // now create a key
            String key = new String(word);

            // if key is not in the map
            if (!map.containsKey(key)){

                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);

            }
            else {

                map.get(key).add(word);
            }
        }
        sc.close();
        PrintLargestGroup(map);
    }

    // -------Frequency method------
    public static void FrequencyMethod() throws Exception{
        HashMap <String,ArrayList<String>> map = new HashMap<>();
        File file = new File("C:/Users/user/IdeaProjects/My_COS211 and 212 projects/src/book.txt/");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()){
            String word = sc.next().toLowerCase();
            word = word.replaceAll("[^a-z]" , ""); // removes puntuations

            if ( word.length() == 0){
                continue;
            }
            // lets create a frequency array
            int[] freq = new int[26] ;// 26 indicates that total number of alphebatical letters

            // now create a character array
            for( char c : word.toCharArray()){
                freq[c - 'a']++;
            }

            // now create a key
            String key = Arrays.toString(freq);
            // if the key is not in the map
            map.putIfAbsent(key , new ArrayList<>());
            map.get(key).add(word);
        }
        sc.close();
        PrintLargestGroup(map);
    }
    // print the largest group in the anagram and print the smallest group in the anagram
    public static void PrintLargestGroup(HashMap <String,ArrayList<String>> map){

        ArrayList<String> LargestGroup = new ArrayList<>();
        ArrayList<String> SmallestGroup = new ArrayList<>();
        for(ArrayList<String> group : map.values()){
            if( group.size() > LargestGroup.size()){
                LargestGroup = group;
            }else {
                SmallestGroup = group;
            }
        }
        System.out.println("-------------The Smallest group-------");
        System.out.println(SmallestGroup);
        System.out.println("Size: " + SmallestGroup.size());

        System.out.println("-------------The Largest group-------");
        System.out.println(LargestGroup);
        System.out.println("Size: " + LargestGroup.size());

    }

    // ----- time complexity of all the algorithms
    public static void main(String[] args) throws Exception {

        // time complexity for sorting method
        System.out.println("------Sorting Method Time Complexity------");
        long startSort = System.nanoTime();
        SortingMethod();
        long endSort = System.nanoTime();

        System.out.println(" Sorting method time : " + (endSort - startSort) + "ns");

        System.out.println("-------------------------------");

        // time complexity for frequency method
        System.out.println("------Frequency Method Time Complexity------");
        long startfreq = System.nanoTime();
        FrequencyMethod();
        long endfreq = System.nanoTime();

        System.out.println(" Frequency method time : " + (endfreq - startfreq) + "ns");



    }

}
