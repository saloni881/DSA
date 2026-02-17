package Stack;
import java.util.*;
public class Balanced {
    public static String ValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) return "NO";
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            System.out.println(ValidParenthesis(s));
        }
        sc.close();
    }
}