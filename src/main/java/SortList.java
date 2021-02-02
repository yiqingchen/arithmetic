import java.util.List;

public class SortList {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 进阶：
     *
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     *
     *
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //      Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return " val=" + val ;
        }
    }


//    public ListNode sortList(ListNode head) {
//        ListNode t = new ListNode(-1);
//        ListNode pre = t.next;
//        pre.val = head.val;
//        while (head.next != null){
//            if (pre.val< head.next.val){
//                pre.val=head.next.val;
//            }
//            head = head.next;
//        }
//        return head;
//    }
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2,listNode);
        while (listNode2.next!=null){
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

//    前言
//「147. 对链表进行插入排序」要求使用插入排序的方法对链表进行排序，插入排序的时间复杂度是 O(n^2)O(n
//2
//        )，其中 nn 是链表的长度。这道题考虑时间复杂度更低的排序算法。题目的进阶问题要求达到 O(n \log n)O(nlogn) 的时间复杂度和 O(1)O(1) 的空间复杂度，时间复杂度是 O(n \log n)O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)O(n
//2
//        )），其中最适合链表的排序算法是归并排序。
//
//    归并排序基于分治算法。最容易想到的实现方式是自顶向下的递归实现，考虑到递归调用的栈空间，自顶向下归并排序的空间复杂度是 O(\log n)O(logn)。如果要达到 O(1)O(1) 的空间复杂度，则需要使用自底向上的实现方式。
//
//    方法一：自顶向下归并排序
//    对链表自顶向下归并排序的过程如下。
//
//    找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 22 步，慢指针每次移动 11 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
//
//    对两个子链表分别排序。
//
//    将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
//
//    上述过程可以通过递归实现。递归的终止条件是链表的节点个数小于或等于 11，即当链表为空或者链表只包含 11 个节点时，不需要对链表进行拆分和排序。
//
//    JavaC++JavaScriptPython3GolangC
//
//    class Solution {
//        public ListNode sortList(ListNode head) {
//            return sortList(head, null);
//        }
//
//        public ListNode sortList(ListNode head, ListNode tail) {
//            if (head == null) {
//                return head;
//            }
//            if (head.next == tail) {
//                head.next = null;
//                return head;
//            }
//            ListNode slow = head, fast = head;
//            while (fast != tail) {
//                slow = slow.next;
//                fast = fast.next;
//                if (fast != tail) {
//                    fast = fast.next;
//                }
//            }
//            ListNode mid = slow;
//            ListNode list1 = sortList(head, mid);
//            ListNode list2 = sortList(mid, tail);
//            ListNode sorted = merge(list1, list2);
//            return sorted;
//        }
//
//        public ListNode merge(ListNode head1, ListNode head2) {
//            ListNode dummyHead = new ListNode(0);
//            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
//            while (temp1 != null && temp2 != null) {
//                if (temp1.val <= temp2.val) {
//                    temp.next = temp1;
//                    temp1 = temp1.next;
//                } else {
//                    temp.next = temp2;
//                    temp2 = temp2.next;
//                }
//                temp = temp.next;
//            }
//            if (temp1 != null) {
//                temp.next = temp1;
//            } else if (temp2 != null) {
//                temp.next = temp2;
//            }
//            return dummyHead.next;
//        }
//    }
//    复杂度分析
//
//    时间复杂度：O(n \log n)O(nlogn)，其中 nn 是链表的长度。
//
//    空间复杂度：O(\log n)O(logn)，其中 nn 是链表的长度。空间复杂度主要取决于递归调用的栈空间。
//
//    方法二：自底向上归并排序
//    使用自底向上的方法实现归并排序，则可以达到 O(1)O(1) 的空间复杂度。
//
//    首先求得链表的长度 \textit{length}length，然后将链表拆分成子链表进行合并。
//
//    具体做法如下。
//
//    用 \textit{subLength}subLength 表示每次需要排序的子链表的长度，初始时 \textit{subLength}=1subLength=1。
//
//    每次将链表拆分成若干个长度为 \textit{subLength}subLength 的子链表（最后一个子链表的长度可以小于 \textit{subLength}subLength），按照每两个子链表一组进行合并，合并后即可得到若干个长度为 \textit{subLength} \times 2subLength×2 的有序子链表（最后一个子链表的长度可以小于 \textit{subLength} \times 2subLength×2）。合并两个子链表仍然使用「21. 合并两个有序链表」的做法。
//
//    将 \textit{subLength}subLength 的值加倍，重复第 2 步，对更长的有序子链表进行合并操作，直到有序子链表的长度大于或等于 \textit{length}length，整个链表排序完毕。
//
//    如何保证每次合并之后得到的子链表都是有序的呢？可以通过数学归纳法证明。
//
//    初始时 \textit{subLength}=1subLength=1，每个长度为 11 的子链表都是有序的。
//
//    如果每个长度为 \textit{subLength}subLength 的子链表已经有序，合并两个长度为 \textit{subLength}subLength 的有序子链表，得到长度为 \textit{subLength} \times 2subLength×2 的子链表，一定也是有序的。
//
//    当最后一个子链表的长度小于 \textit{subLength}subLength 时，该子链表也是有序的，合并两个有序子链表之后得到的子链表一定也是有序的。
//
//    因此可以保证最后得到的链表是有序的。
//
//    JavaC++JavaScriptPython3GolangC
//
//    class Solution {
//        public ListNode sortList(ListNode head) {
//            if (head == null) {
//                return head;
//            }
//            int length = 0;
//            ListNode node = head;
//            while (node != null) {
//                length++;
//                node = node.next;
//            }
//            ListNode dummyHead = new ListNode(0, head);
//            for (int subLength = 1; subLength < length; subLength <<= 1) {
//                ListNode prev = dummyHead, curr = dummyHead.next;
//                while (curr != null) {
//                    ListNode head1 = curr;
//                    for (int i = 1; i < subLength && curr.next != null; i++) {
//                        curr = curr.next;
//                    }
//                    ListNode head2 = curr.next;
//                    curr.next = null;
//                    curr = head2;
//                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
//                        curr = curr.next;
//                    }
//                    ListNode next = null;
//                    if (curr != null) {
//                        next = curr.next;
//                        curr.next = null;
//                    }
//                    ListNode merged = merge(head1, head2);
//                    prev.next = merged;
//                    while (prev.next != null) {
//                        prev = prev.next;
//                    }
//                    curr = next;
//                }
//            }
//            return dummyHead.next;
//        }
//
//        public ListNode merge(ListNode head1, ListNode head2) {
//            ListNode dummyHead = new ListNode(0);
//            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
//            while (temp1 != null && temp2 != null) {
//                if (temp1.val <= temp2.val) {
//                    temp.next = temp1;
//                    temp1 = temp1.next;
//                } else {
//                    temp.next = temp2;
//                    temp2 = temp2.next;
//                }
//                temp = temp.next;
//            }
//            if (temp1 != null) {
//                temp.next = temp1;
//            } else if (temp2 != null) {
//                temp.next = temp2;
//            }
//            return dummyHead.next;
//        }
//    }
//    复杂度分析
//
//    时间复杂度：O(n \log n)O(nlogn)，其中 nn 是链表的长度。
//
//    空间复杂度：O(1)O(1)。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
