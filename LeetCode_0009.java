package com.lijieyao.redis.entity;

public class LeetCode_0009 {

    public static boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        if (num.contains("-") || num.contains("+")) {
            return false;
        }
        char[] chars = num.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int index = num.length() - 1; index >= 0; index--) {
            builder.append(chars[index]);
        }
        return num.equals(builder.toString());
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-101);
        System.out.println(palindrome);
    }
}
