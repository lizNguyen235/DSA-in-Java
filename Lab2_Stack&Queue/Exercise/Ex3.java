package Exercise;
import Stack.MyStack;
import Stack.LinkedlistImplement.LinkedListStack;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
   public static boolean check(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String is null");
        }
        MyStack<Character> stack = new LinkedListStack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (c == '(' && str.charAt(i) != ')') {
                    return false;
                }
                if (c == '[' && str.charAt(i) != ']') {
                    return false;
                }
                if (c == '{' && str.charAt(i) != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
