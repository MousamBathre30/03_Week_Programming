package stockSpanProblem;

import java.util.Stack;
public class StackSpan {



    public static int []  calculatedspan(int price [], int n){
         Stack <Integer> stack = new Stack<>();
        int ans [] = new int[n];

        for(int i=0; i<n; i++) {
            while ((!stack.empty() && price[stack.peek()] <= price[i])) {
                stack.pop();
            }

            ans[i] = (stack.empty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // array []

        // represent the price of the stock in each day
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        //              0  , 0 , 0 , 1 , 0 ,
        // number of days
        int n = 7 ;
        // call the method that return the array of stock span

        int ans [] ;

        ans = calculatedspan(price,n);

        for(int i=0; i<n; i++){
            System.out.println("The span is " + ans [i]);
        }

    }

}
