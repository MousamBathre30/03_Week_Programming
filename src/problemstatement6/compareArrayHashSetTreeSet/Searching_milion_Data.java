package problemstatement6.compareArrayHashSetTreeSet;

import java.util.HashSet;
import java.util.TreeSet;

public class Searching_milion_Data {
    // array method for searching
    public static void array(){
        int[] arr = new int[1000000];
        for(int i=0; i<1000000; i++){
            arr[i] = i;
        }
        // Searching element
        double start = System.nanoTime();
        for(int i=0; i<1000000; i++){
            if(arr[i] == 39999){
                break;
            }
        }
        double end = System.nanoTime();
        double diff = (end - start)/ 1000000;
        System.out.println("Time taken by array in searching :- " + diff + " ms");
    }

    // Tree Set implementation
    public static void treeset(){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<1000000; i++){
            set.add(i);
        }
        double start = System.nanoTime();

        if(set.contains(39999)){
            double end = System.nanoTime();
            double diff = (end - start)/1000000;
            System.out.println("Time taken by treeset for serching is " + diff + " ms");

        }
    }
    // Hash Set for million
    public static void hashset(){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<1000000; i++){
            set.add(i);
        }
        double start = System.nanoTime();
        if(set.contains(39999)){
            double end = System.nanoTime();
            double diff = (end - start)/1000000;
            System.out.println("Time taken by hashset for serching is " + diff + " ms");
        }
    }
    // Main Method
    public static void main(String[] args) {
        array();
        treeset();
        hashset();
    }
}
