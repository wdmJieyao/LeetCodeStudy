package com.lijieyao.redis.entity;

/**
 * @author LiJieYao
 * @date 2021/4/21 22:09
 * @description 力扣第五题
 */
public class LeetCode_0005 {

    /*
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     */


    public static void main(String[] args) {
        System.out.println(longestPalindrome("acc"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int ll = 0;
        int rr = 0;
        int len = 1;

        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int currentLen = (r - l + 1);
                if (len < currentLen) {
                    len = currentLen;
                    rr = r;
                    ll = l;
                }
                r++;
                l--;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int currentLen = (r - l + 1);
                if (len < currentLen) {
                    len = currentLen;
                    rr = r;
                    ll = l;
                }
                r++;
                l--;
            }
        }


        return s.substring(ll, rr + 1);
    }
}
