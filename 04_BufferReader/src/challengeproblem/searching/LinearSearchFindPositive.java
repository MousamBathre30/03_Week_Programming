package challengeproblem.searching;

public class LinearSearchFindPositive {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int n= array.length;
        int [] visited = new int[n] ;
        for(int i=0; i<n; i++){
            if(array [i] > 0){
                visited[i] = -1; // visited
            }
        }

        for(int i=0; i<n; i++){
            if(visited[i] < 0) {
                System.out.println("First Mising Positive Integer   " + array[i]);
                break;
            }
        }

     }
}
