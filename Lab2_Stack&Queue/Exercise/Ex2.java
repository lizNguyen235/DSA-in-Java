package Exercise;

import Stack.MyStack;
import Stack.LinkedlistImplement.LinkedListStack;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(reverseString("Hello World"));
    }
    public static String reverseString(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
