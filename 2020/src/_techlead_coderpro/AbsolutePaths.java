package _techlead_coderpro;

import java.util.Stack;

public class AbsolutePaths {
    public static void main(String[] args) {
        String path = "/users/tech/docs/.././desk/../";
        System.out.println(absolutePath(path));
    }

    private static String absolutePath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.isEmpty() || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        String p = "/";

        while (!stack.isEmpty()) {
            p = "/" + stack.pop() + p;
        }
        return p;
    }
}
