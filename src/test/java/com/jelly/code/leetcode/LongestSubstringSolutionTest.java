package com.jelly.code.leetcode;

import org.junit.*;
import org.junit.Test;

/**
 * TODO
 *
 * @author liuzhudong
 * @version 1.0
 * @date 18/5/22 下午2:09
 */
public class LongestSubstringSolutionTest extends LongestSubstringSolution {

    private void lengthOfLongestSubstring(String str) {
        int out = new LongestSubstringSolution.Solution().lengthOfLongestSubstring(str);

        System.out.println(String.format("Given nums = %s, return %d", str, out));
    }

    @Test
    public void lengthOfLongestSubstringTest() throws Exception {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("bbbbbbb");
        lengthOfLongestSubstring("qwwkkew");
        lengthOfLongestSubstring("asfaafwqsdfdsg");
        lengthOfLongestSubstring("dvdf");
        lengthOfLongestSubstring("");
//        StringBuilder strb = new StringBuilder(20);
//        strb.append("a");
//        strb.append("c");
//        strb.append("b");
//        System.out.println(strb.toString());
//        System.out.println(strb.length());
////        strb.setLength(1);
//        strb.delete(0,1);
//        System.out.println(strb.toString());
//        System.out.println(strb.length());
    }
}