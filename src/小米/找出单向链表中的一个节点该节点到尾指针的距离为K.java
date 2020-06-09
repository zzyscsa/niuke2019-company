package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 找出单向链表中的一个节点该节点到尾指针的距离为K {
    public static class ListNode {
        int m_nKey;
        ListNode m_pNext;
        ListNode(int x) {
            m_nKey = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine().trim());
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for(int i = 1; i <= 7; i++) {
            ListNode cur = new ListNode(i);
            temp.m_pNext = cur;
            temp = temp.m_pNext;
        }
        ListNode start = head.m_pNext;
        ListNode end = start;
        while(k-->0) {
            end = end.m_pNext;
        }
        while(end!=null) {
            end = end.m_pNext;
            start = start.m_pNext;
        }
        System.out.println(start.m_nKey);
    }
}
