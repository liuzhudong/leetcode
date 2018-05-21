package com.jelly.code.leetcode;


/**
 * TODO
 *
 * @author liuzhudong
 * @version 1.0
 * @date 18/5/21 下午11:41
 */
public class AddTwoNumbersSolutionTest extends AddTwoNumbersSolution {

    @org.junit.Test
    public void addTwoNumbersTest() throws Exception {
        addTwoNumbers("[2,4,3]", "[5,6,4]");
        addTwoNumbers("[2,4,6]", "[5,6,4]");
        addTwoNumbers("[2]", "[5]");
        addTwoNumbers("[2]", "[8]");
        addTwoNumbers("[2,4]", "[8]");
    }

    private void addTwoNumbers(String list1, String list2) {
        ListNode l1 = stringToListNode(list1);
        ListNode l2 = stringToListNode(list2);

//        ListNode ret = new Solution().addTwoNumbers(l1, l2);
        ListNode ret = new Solution().addTwoNumbersPrefect(l1, l2);

        String out = listNodeToString(ret);

        System.out.println(String.format("Input: %s, %s ===> Output: %s", list1, list2, out));
    }

}