package com.jelly.code.leetcode;

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
        Solution solution = new LongestSubstringSolution.Solution();
        int out = solution.lengthOfLongestSubstring(str);
        System.out.println(String.format("Given nums = %s, return %d", str, out));
        out = solution.lengthOfLongestSubstring1(str);
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

//        String str = "dvdf";
//        int left = 0;
//        int right = 0;
//
//        String max = "";
//        String curr = "";
////        System.out.println(str.indexOf("a"));
////        System.out.println(str.indexOf("a", 2));
////        System.out.println(str.charAt(0));
//        System.out.println(curr);
//        for (; right < str.length(); ) {
//            System.out.println(right);
//            int index = curr.indexOf(str.charAt(right));
//            if (index > -1) {
//                left = left + index + 1;
//            }
//            right++;
//            curr = str.substring(left, right);
//            System.out.println(curr);
//            max = max.length() > curr.length() ? max : curr;
//
//        }
//        System.out.println(max + " " + max.length());
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int left = 0;
        int right = 1;
        String max = s.substring(left, right);
        String curr = s.substring(left, right);
        while (right < s.length()) {
            //curr = s.substring(left,right);
            if (curr.indexOf(s.charAt(right)) == -1) {
                right++;
            } else {
                //curr = s.substring(left,right);
                //System.out.println(curr);
                //max = max.length()>curr.length()? max:curr;
                left = left + 1 + curr.indexOf(s.charAt(right));
                right++;
            }
            curr = s.substring(left, right);
            max = max.length() > curr.length() ? max : curr;
        }
        return max.length();
    }

}