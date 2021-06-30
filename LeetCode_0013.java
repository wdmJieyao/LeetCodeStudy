package com.lijieyao.redis.entity;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode_0013 {
    private static Map<String, Integer> romanNumMap = new HashMap<>();

    static {
        romanNumMap.put("M", 1000);
        romanNumMap.put("D", 500);
        romanNumMap.put("C", 100);
        romanNumMap.put("L", 50);
        romanNumMap.put("X", 10);
        romanNumMap.put("V", 5);
        romanNumMap.put("I", 1);
    }

    /**
     * 思路：
     * 关注罗马字的两个特性
     * 1、正常的数都是大数在左小数在右；
     * 2、当有小数在左时，需将运算符倒转（9=-1+10）
     */
    public static int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer currentNum = romanNumMap.get(String.valueOf(chars[i]));
            if (i + 1 < chars.length && currentNum < romanNumMap.get(String.valueOf(chars[i + 1]))) {
                result -= currentNum;
            } else {
                result += currentNum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
