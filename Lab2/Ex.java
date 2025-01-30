public class Ex {
    public static double Ex_recur(int n) {
        if (n == 1)
            return 3;
        return Math.pow(2, n) + Math.pow(n, 2) + Ex_recur(n - 1);
    }

    public static double Ex_Stack(int n) {
        MyStack<Double> st = new MyStack<>();

        while (n > 1) {
            st.push(Math.pow(2, n) + Math.pow(n, 2));
            n--;
        }
        double sum = 3;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }

    public static String readCharacters(String str) {
        MyStack<Character> st = new MyStack<>();
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }
        String s = "";
        s += str.charAt(0);
        while (!st.isEmpty()) {

            s += st.pop();
        }
        return s;
    }

    public static boolean checkBalance(String str) {
        MyStack<Character> st = new MyStack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
                st.push(str.charAt(i));
            }
            if (str.charAt(i) == '}') {
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }

            } else if (str.charAt(i) == ')') {
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(Ex_recur(5));
        // System.out.println(Ex_Stack(5));
        System.out.println(readCharacters("abc"));
        System.out.println(checkBalance("a + c*{a + c + (f + g) + [5 + 2 +(7-6)}"));
    }
}
