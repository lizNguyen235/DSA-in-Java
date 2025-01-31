package Exercise;

import Queue.MyQueue;
import Queue.LinkedListImplement.LinkedListQueue;
import Stack.MyStack;
import Stack.LinkedlistImplement.LinkedListStack;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    public static boolean check(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String is null");
        }
        MyStack<Character> stack = new LinkedListStack<>();
        MyQueue<Character> queue = new LinkedListQueue<>();
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.enQueue(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.deQueue()) {
                return false;
            }
        }
        return true;
    }
}
