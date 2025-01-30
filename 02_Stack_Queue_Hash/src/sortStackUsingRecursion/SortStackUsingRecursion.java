package sortStackUsingRecursion;

import java.util.ListIterator;
import java.util.Stack;

public class SortStackUsingRecursion {

    // sort a stack using recursion

    public static void insertwithsort(Stack <Integer> s , int x)
    {
        if(s.isEmpty() || x > s.peek()){
            s.push(x);
           return;
        }

        int temp = s.pop();
        insertwithsort(s,x);
        s.push(temp);

    }

    public static void sort(Stack <Integer > s){
        if(!s.isEmpty()){
           int x = s.pop();

           sort(s);
           insertwithsort(s,x);
        }
    }

    public static void print(Stack <Integer> s){
        ListIterator<Integer> it = s.listIterator();

        while(it.hasNext()){
            it.next();
        }
        while(it.hasPrevious()){
            System.out.println("Element are " + it.previous());
        }
    }


    public static void main(String[] args) {

       Stack<Integer> stack = new Stack<>();

       stack.push(1);
       stack.push(6);
       stack.push(3);
       stack.push(8);


       sort(stack);
       print(stack);

    }
}
