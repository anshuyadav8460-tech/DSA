class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            while (st.size() > 0 && st.peek().val < temp.val) {
                st.pop();
            }
            st.push(temp);
            temp = temp.next;
        }
        ListNode newHead = null;
        while (st.size() > 0) {
            ListNode node = st.pop();
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}