package slidingWindowMaximum;
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

    public static void countmaximuminWindow(int arr [] , int k){

        Deque<Integer> de = new ArrayDeque<>();
        int n = arr.length;
        int maximum = 0;
        int index=0;
        for(int i=0; i<= n-k; i++){
            maximum = arr[i];
            for(int j = 1; j < k; j++){
                if(arr[i+j] > maximum){
                    maximum = arr[i+j];
                    index = i+j;

                }
            }
            de.add(maximum);
        }

        System.out.println("maximum element  is " + de);

    }


    public static void main(String[] args) {
        int arr [] = {2,9,3,1,4,5};
        int size = 2;

        countmaximuminWindow(arr,size);
      // 9 9 3 4 5
    }
}
