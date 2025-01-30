package Exercise;
import Stack.MyStack;
import Stack.LinkedlistImplement.*;
public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(Recursion(3));
        System.out.println(myStack(3));
    }
    public static int Recursion(int n) {
        if (n == 1) {
            return 3;
        }
        return (int)Math.pow(2, n) + Recursion(n - 1) + n * n;
    }
    public static int myStack(int n) {
        MyStack<Integer> stack = new LinkedListStack<>();
        stack.push(3);
        for (int i = 2; i <= n; i++) {
            stack.push((int)Math.pow(2, i) + stack.getPeek() + i * i);
        }
        return stack.pop();
    }

}
