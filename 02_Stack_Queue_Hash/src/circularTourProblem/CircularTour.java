package circularTourProblem;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    // Function to find the starting petrol pump using a queue
    public static int getStartingPoint(int[] petrol, int[] distance, int n) {
        int totalPetrol = 0;
        int currentPetrol = 0;
        int start = 0;

        // Queue to store pump indices and their surplus petrol
        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            int surplus = petrol[i] - distance[i];
            totalPetrol += surplus;
            currentPetrol += surplus;
            queue.add(i);


            while (currentPetrol < 0 && !queue.isEmpty()) {
                int pumpIndex = queue.poll();  // Remove from the front of the queue
                currentPetrol -= (petrol[pumpIndex] - distance[pumpIndex]);
                start = pumpIndex + 1;  // Update the starting point to the next pump
            }
        }


        return (totalPetrol >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int n = petrol.length;

        int start = getStartingPoint(petrol, distance, n);
        if (start == -1) {
            System.out.println("It's not possible to complete the tour.");
        } else {
            System.out.println("Start at pump: " + start);
        }
    }
}

