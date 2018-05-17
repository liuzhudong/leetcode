package com.jelly.code.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author liuzhudong
 * @version 1.0
 * @date 18/5/17 上午10:07
 */
public class TwoSumSolutionTest extends TwoSumSolution {

    @Test
    public void twoSumTest() throws Exception {
        twoSum("[2, 7, 11, 15]", "9");
        twoSum("[2, 7, 11, 15]", "13");
        twoSum("[2, 7, 11, 15]", "17");
        twoSum("[2, 7, 11, 15]", "18");
        twoSum("[2, 7, 11, 15, 10]", "17");
        twoSum("[2]", "17");
    }

    private void twoSum(String numstr, String targetstr) {
        int[] nums = stringToIntegerArray(numstr);
        int target = Integer.parseInt(targetstr);

        int[] ret = new Solution().twoSum(nums, target);

        String out = integerArrayToString(ret);

        System.out.println(String.format("Given nums = %s, target = %d, return %s", numstr, target, out));
    }
}