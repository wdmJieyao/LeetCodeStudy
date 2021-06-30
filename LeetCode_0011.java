package com.lijieyao.redis.entity;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode_0011 {
    private static Map<Integer, String> romanNumMap = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer v1, Integer v2) {
            return v2.compareTo(v1);
        }
    });

    static {
        romanNumMap.put(1000, "M");
        romanNumMap.put(900, "CM");
        romanNumMap.put(500, "D");
        romanNumMap.put(400, "CD");
        romanNumMap.put(100, "C");
        romanNumMap.put(90, "XC");
        romanNumMap.put(50, "L");
        romanNumMap.put(40, "XL");
        romanNumMap.put(10, "X");
        romanNumMap.put(9, "IX");
        romanNumMap.put(5, "V");
        romanNumMap.put(4, "IV");
        romanNumMap.put(1, "I");
    }

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (Map.Entry<Integer, String> currentRoman : romanNumMap.entrySet()) {
            Integer number = currentRoman.getKey();
            String romanNumber = currentRoman.getValue();
            while (num - number >= 0) {
                num -= number;
                roman.append(romanNumber);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
}
