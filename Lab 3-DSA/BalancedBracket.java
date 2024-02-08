//Write a program of Balancing Brackets, use a suitable data structure to print whether the string entered is a Balanced Brackets or Unbalanced String
// Java program for checking
// balanced brackets
import java.util.*;

public class BalancedBracket {
    static boolean areBracketsBalanced(String expr)
    {
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
    public static void main(String[] args)
    {
        String expr = "( [ [ { } ] ] )";
        if (areBracketsBalanced(expr))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }
}
