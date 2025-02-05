package linearSearchProblem.NegativeNumber;

public class FirstNegative {

    public static void main(String[] args) {
        int[] arr = {2,6,7,4,2,-3,6};
        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0){
                System.out.println("First Negative Number Index is " + i);
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println("Not found Negative index");
        }

    }
}
