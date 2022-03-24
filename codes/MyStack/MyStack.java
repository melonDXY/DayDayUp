package codes.MyStack;

import java.util.*;


class MyStack {
    private int[] data;
    private int maxSize;
    private int top;
    private int size;

    MyStack(int maxSize){
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.top = -1;
        this.size = 0;
    }

    public void push(int num) {
        // if(num instanceof int){

        // }
        top++;
        data[top] = num;
        size++;
    }

    public void top(){
        if(size > 0){
            System.out.println(data[top]);
        }else{
            System.out.println("error");
        }
    }

    public void pop(){
        if(size > 0) {
            System.out.println(data[top]);
            top--;
            size--;
        }else{
            System.out.println("error");
        }
    }
}

public class Main{
    public static void main(String...args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        MyStack myStack = new MyStack(n);
        while(scanner.hasNextLine()) {
            String inpuString = scanner.nextLine();
            String[] arr = inpuString.split(" ");
            if(arr[0].equals("push")){
                myStack.push(Integer.parseInt(arr[1]));
            }
            if(arr[0].equals("pop")) {
                myStack.pop();
            }
            if(arr[0].equals("top")) {
                myStack.top();
            }
        }

    }
}
