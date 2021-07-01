package com.lijieyao.redis.entity;

public class LeetCode_0014 {
    /*
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();
        // 首节点
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            int index = 1;
            while (index < strs.length) {
                if (i >= strs[index].length()) {
                    return result.toString();
                }
                if (currentChar != strs[index].charAt(i)) {
                    return result.toString();
                }
                index++;
            }
            result.append(currentChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

}
