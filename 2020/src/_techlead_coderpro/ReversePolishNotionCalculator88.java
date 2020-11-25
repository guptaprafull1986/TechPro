package _techlead_coderpro;

import java.util.Stack;

public class ReversePolishNotionCalculator88 {
    public static void main(String[] args) {
        System.out.println(calculator("123+2*-"));
    }

    static int calculator(String notion) {
        Stack<Integer> stack = new Stack<>();
        for (char c : notion.toCharArray()) {
            if (c == '*' || c == '-' || c == '+' || c == '/') {
                stack.push(opr(c, stack.pop(), stack.pop()));
            } else {
                stack.push(c - '0');
            }
        }
        return stack.peek();
    }

    private static int opr(char c, Integer y, Integer x) {
        switch (c) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;

        }
        return -1;
    }
}
