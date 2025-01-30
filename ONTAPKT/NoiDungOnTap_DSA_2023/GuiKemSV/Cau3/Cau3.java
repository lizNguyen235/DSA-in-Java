import java.util.Stack;

public class Cau3 {
    private static boolean isNumber(String str) {
        return str.matches("0|([1-9][0-9]*)");
    }

    public static int calculate(String[] expression) {
        // code here
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < expression.length; i++) {
            if (isNumber(expression[i])) {
                st.push(Integer.valueOf(expression[i]));
            } else {
                if (expression[i].equals("+")) {
                    int o1 = st.pop();
                    int o2 = st.pop();
                    st.push(o2 + o1);
                } else {
                    int o1 = st.pop();
                    int o2 = st.pop();
                    st.push(o2 - o1);
                }
            }
        }
        return st.pop();
    }

    public static void main(String args[]) {
        System.out.println(calculate(new String[] { "3", "4", "+", "2", "1", "+", "-" }));
    }
}