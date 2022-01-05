package com.lijieyao.rabbitmq.hello;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 力扣第20题
 */
public class LeetCode_0020 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put('{', 2);
        map.put('[', 3);

        map.put(')', -1);
        map.put('}', -2);
        map.put(']', -3);

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (char index : s.toCharArray()) {
            if (!map.containsKey(index)) {
                continue;
            }

            Integer tempInt = map.get(index);
            if (stack.isEmpty() && tempInt <0){
                return false;
            }
            sum += tempInt;
            if (stack.isEmpty() || tempInt > 0) {
                stack.push(tempInt);
                continue;
            }

            if (stack.peek() != -tempInt){
                return false;
            }
            stack.pop();
        }
        return sum == 0;
    }
}
