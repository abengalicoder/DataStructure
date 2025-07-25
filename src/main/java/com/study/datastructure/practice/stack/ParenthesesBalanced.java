package com.study.datastructure.practice.stack;

import java.util.Stack;

public class ParenthesesBalanced {

    public static void main(String[] args) {
        System.out.println("() is balanced : " + isBalanced("()"));
        System.out.println("[() is balanced : " + isBalanced("[()"));
        System.out.println("[()] is balanced : " + isBalanced("[()]"));
        System.out.println("[{()] is balanced : " + isBalanced("[{()]"));
        System.out.println("[{()}] is balanced : " + isBalanced("[{()}]"));
        System.out.println("[]{}() is balanced : " + isBalanced("[]{}()"));
        System.out.println("[[]{}() is balanced : " + isBalanced("[[]{}()"));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
