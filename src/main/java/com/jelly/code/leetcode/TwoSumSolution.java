/*
 * Copyright & License.
 */

package com.jelly.code.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * <pre>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * <strong>Example:</strong>
 *
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 *
 * </pre>
 *
 * @author liuzhudong
 * @version 1.0
 * @date 18/5/17 上午9:36
 * @see <a href="https://leetcode.com/problems/two-sum/description/">Two Sum</a>
 */
public class TwoSumSolution {

    static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result.append(Integer.toString(number)).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new Solution().twoSum(nums, target);

            String out = integerArrayToString(ret);

            System.out.println(out);
        }
    }

    static class Solution {

        private static final int MIN_LENGTH = 2;

        public int[] twoSum(int[] nums, int target) {

            if (nums == null || nums.length < MIN_LENGTH) {
                throw new IllegalArgumentException("No solution");
            }

            Map<Integer, Integer> map = new HashMap<>(nums.length);

            int temp;
            for (int i = 0; i < nums.length; i++) {
                temp = target - nums[i];
                if (map.containsKey(temp)) {
                    return new int[]{map.get(temp), i};
                }
                map.put(nums[i], i);
            }

            throw new IllegalArgumentException("No two sum solution");
        }

        /**
         * 这个是目前执行效率最高的实现
         * <pre>
         *     1. 不采用 throw exception 而是 return default result
         *     2. map 初始化时可以指定初始大小为 nums.length ,当输入 nums 长度大于默认 map size 而匹配结果又在 12 之后会触发 map 扩容
         * </pre>
         */
        public int[] twoSumPrefec(int[] nums, int target) {
            int[] res = new int[2];
            if (nums == null || nums.length < MIN_LENGTH) {
                return res;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp)) {
                    res[0] = map.get(temp);
                    res[1] = i;
                    return res;
                } else {
                    map.put(nums[i], i);
                }
            }
            return res;
        }
    }

}
