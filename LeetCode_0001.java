package com.qhee.ztt.entity;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author LiJieYao
 * @description 力扣第一题
 * @date 2021/4/15 18:39
 */
public class LeetCode_0001 {

    /*
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        // 暴力破解  方法一
        // int[] result = methodOne(nums, target);
        int[] result = methodTwo(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 暴力破解法
     */
    public static int[] methodOne(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k < length; k++) {
                if (nums[i] + nums[k] == target) {
                    return new int[]{i, k};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 哈希算法优化
     */
    public static int[] methodTwo(int[] nums, int target) {
        HashMap<Integer, Integer> tempNum = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (tempNum.containsKey(target - nums[i])) {
                return new int[]{tempNum.get(target - nums[i]), i};
            }
            tempNum.put(nums[i], i);
        }
        return new int[0];
    }
}
