/*
 * Copyright & License.
 */

package com.jelly.code.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Two Sum
 *
 * <pre>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <strong>Example:</strong>
 *
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  Explanation: 342 + 465 = 807.
 *
 * </pre>
 *
 * @author liuzhudong
 * @version 1.0
 * @date 18/5/21 下午11:33
 */
public class AddTwoNumbersSolution {

    private static int[] stringToIntegerArray(String input) {
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

    static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(Integer.toString(node.val)).append(", ");
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.println(out);
        }
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 解决方案实现
     */
    static class Solution {

        ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                throw new IllegalArgumentException("No add two numbers solution");
            }

            ListNode temp = null;
            ListNode result = null;
            int carryFlag = 0;
            int val;

            for (int i = 0; ; i++) {

                if (l1 == null && l2 == null) {
                    if (carryFlag > 0) {
                        if (temp.next == null) {
                            temp.next = new ListNode(carryFlag);
                        } else {
                            temp = temp.next;
                            temp.next = new ListNode(carryFlag);
                        }
                    }
                    return result;
                }

                if (l1 == null) {
                    val = l2.val + carryFlag;
                    l2 = l2.next;
                } else if (l2 == null) {
                    val = l1.val + carryFlag;
                    l1 = l1.next;
                } else {
                    val = l1.val + l2.val + carryFlag;
                    l1 = l1.next;
                    l2 = l2.next;
                }

                if (val > 9) {
                    val = val % 10;
                    carryFlag = 1;
                } else {
                    carryFlag = 0;
                }

                if (i == 0) {
                    result = new ListNode(val);
                    temp = result;
                    continue;
                }

                if (temp.next == null) {
                    temp.next = new ListNode(val);
                } else {
                    temp = temp.next;
                    temp.next = new ListNode(val);
                }

            }

        }

        /**
         * 这个是目前执行效率最高的实现
         */
        ListNode addTwoNumbersPrefect(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }

    }

}
