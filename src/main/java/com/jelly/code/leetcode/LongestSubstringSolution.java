/*
 * Copyright & License.
 */

package com.jelly.code.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * TODO
 *
 * @author liuzhudong
 * @version 1.0
 * @date 18/5/22 下午12:45
 */
public class LongestSubstringSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {

            int ret = new Solution().lengthOfLongestSubstring(line);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

//    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder(20);
//        stringBuilder.append("s");
//        System.out.println(stringBuilder.length());
//////        String str = "abcabcbb";
//        String str = "bbbb";
//////        String str = "qwwkew";
////
//////        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(strs));
//////        System.out.println(set);
//////        str.indexOf()
//        String[] strs = str.split("");
//        int size = strs.length;
//        HashSet<String> set = new HashSet<>();
//        StringBuilder strb = new StringBuilder(size);
//        String out = "";
//        int maxLength = 0;
//        for (int i = 0; i < size; i++) {
//
//            if (i == 0) {
//                strb.append(strs[i]);
//                set.add(strs[i]);
//                continue;
//            }
//
//            if (strs[i].equals(strs[i - 1]) || set.contains(strs[i])) {
//                String temp = strb.toString();
//                set.clear();
//                if (temp.length() > maxLength) {
//                    out = temp;
//                    maxLength = temp.length();
//                }
//                strb.delete(0, size);
//            }
//
//            strb.append(strs[i]);
//            set.add(strs[i]);
//
//        }
//        String temp = strb.toString();
//        if (temp.length() > maxLength) {
//            out = temp;
//        }
//        System.out.println(out);
//    }

    static class Solution {

        int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s.trim())) {
                return 0;
            }

            String[] strs = s.split("");
            int size = strs.length;
            Set<String> set = new HashSet<>(size);
            Queue<String> queue = new LinkedList<>();
            int maxLength = 0;
            
            for (String str : strs) {

                if (set.contains(str)) {
                    maxLength = queue.size() > maxLength ? queue.size() : maxLength;
                    while (queue.size() > 0) {
                        String val = queue.peek();
                        if (str.equals(val)) {
                            val = queue.poll();
                            set.remove(val);
                            break;
                        }
                        val = queue.poll();
                        set.remove(val);
                    }

                }

                queue.offer(str);
                set.add(str);

            }
            return queue.size() > maxLength ? queue.size() : maxLength;
        }
    }

}
