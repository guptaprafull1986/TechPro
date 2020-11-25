package april;

import java.util.Scanner;
import java.util.Stack;

public class RobotPathDecoding {

    private static final int ROW = 1000000000;

    private static int R = 1;
    private static int C = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
//            int length = sc.nextInt();

            String op = sc.next();
            decodeOp(op);
            System.out.println("Case #" + t + " " + C + " " + R);
        }
        sc.close();
    }

    private static void decodeOp(String op) {

        Stack<Node> stack = new Stack<>();
        char[] arr = op.toCharArray();
        int i = 0;
        int times = 1;
        while (i < arr.length) {
            char c = arr[i];
            if (c == '(') {
                stack.push(new Node("" + c, times));
                i++;
                times = 1;
            } else if (c >= '2' && c <= '9') {
                times = c - '0';
                i++;
            } else if (c >= 'A' && c <= 'Z') {

                String exp = "";
                while (i < arr.length && arr[i] >= 'A' && arr[i] <= 'Z') {
                    exp += arr[i++];
                }
                stack.push(new Node(exp, times));
                times = 1;
            } else { // ')'
                i++;
                String o = new String();
                while (!stack.peek().code.equals("(")) {
                    Node n = stack.pop();
                    for (int j = 1; j <= n.times; j++) {
                        o = n.code + o;
                    }
                }
                Node n = stack.pop();
                String oo = new String();
                for (int j = 1; j <= n.times; j++) {
                    oo += o;
                }
                if (stack.isEmpty() || stack.peek().code.equals("(")) {
                    stack.push(new Node(oo, 1));
                } else {
                    stack.peek().code += oo;
                }
            }
        }

        String result = new String();
        while (!stack.isEmpty()) {
            result = stack.pop().code + result;
        }

        R = 1;
        C = 1;
        for (char c : result.toCharArray()) {
            switch (c) {
                case 'N': // up (R-1)
                    R = R == 1 ? ROW : R - 1;
                    break;
                case 'S': // down (R+1)
                    R = R == ROW ? 1 : R + 1;
                    break;
                case 'E': // right (C + 1)
                    C = C == ROW ? 1 : C + 1;

                    break;
                case 'W': // left (C - 1)
                    C = C == 1 ? ROW : C - 1;
                    break;

            }
        }
    }
}

class Node {
    int times;
    String code;

    public Node(String c, int i) {
        times = i;
        code = c;
    }
}


/**
 * Competitive Submissions
 * You have not attempted this problem.
 * Last updated: Apr 19 2020, 05:49
 * <p>
 * Problem
 * Your country's space agency has just landed a rover on a new planet, which can be thought of as a grid of squares containing 109 columns (numbered starting from 1 from west to east) and 109 rows (numbered starting from 1 from north to south). Let (w, h) denote the square in the w-th column and the h-th row. The rover begins on the square (1, 1).
 * <p>
 * The rover can be maneuvered around on the surface of the planet by sending it a program, which is a string of characters representing movements in the four cardinal directions. The robot executes each character of the string in order:
 * N: Move one unit north.
 * S: Move one unit south.
 * E: Move one unit east.
 * W: Move one unit west.
 * There is also a special instruction X(Y), where X is a number between 2 and 9 inclusive and Y is a non-empty subprogram. This denotes that the robot should repeat the subprogram Y a total of X times. For example:
 * 2(NWE) is equivalent to NWENWE.
 * 3(S2(E)) is equivalent to SEESEESEE.
 * EEEE4(N)2(SS) is equivalent to EEEENNNNSSSS.
 * <p>
 * Since the planet is a torus, the first and last columns are adjacent, so moving east from column 109 will move the rover to column 1 and moving south from row 109 will move the rover to row 1. Similarly, moving west from column 1 will move the rover to column 109 and moving north from row 1 will move the rover to row 109. Given a program that the robot will execute, determine the final position of the robot after it has finished all its movements.
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T lines follow. Each line contains a single string: the program sent to the rover.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: w h, where x is the test case number (starting from 1) and w h is the final square (w, h) the rover finishes in.
 * <p>
 * Limits
 * Time limit: 10 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * The string represents a valid program.
 * The length of each program is between 1 and 2000 characters inclusive.
 * <p>
 * Test set 1
 * The total number of moves the robot will make in a single test case is at most 104.
 * <p>
 * Test set 2
 * No additional constraints.
 * <p>
 * Sample
 * <p>
 * Input
 * <p>
 * Output
 * <p>
 * 4
 * SSSEEE
 * N
 * N3(S)N2(E)N
 * 2(3(NW)2(W2(EE)W))
 * <p>
 * <p>
 * Case #1: 4 4
 * Case #2: 1 1000000000
 * Case #3: 3 1
 * Case #4: 3 999999995
 * <p>
 * <p>
 * In Sample Case #1, the rover moves three units south, then three units east.
 * <p>
 * In Sample Case #2, the rover moves one unit north. Since the planet is a torus, this moves it into row 109.
 * <p>
 * In Sample Case #3, the program given to the rover is equivalent to NSSSNEEN.
 * <p>
 * In Sample Case #4, the program given to the rover is equivalent to NWNWNWWEEEEWWEEEEWNWNWNWWEEEEWWEEEEW.
 */