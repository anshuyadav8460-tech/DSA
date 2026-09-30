class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp);
            temp = temp.next;
        }
        int i = left - 1;
        int j = right - 1;
        while (i < j) {
            ListNode t1 = arr.get(i);
            ListNode t2 = arr.get(j);
            arr.set(i, t2);
            arr.set(j, t1);
            i++;
            j--;
        }
        for (int k = 0; k < arr.size() - 1; k++) {
            arr.get(k).next = arr.get(k + 1);
        }
        arr.get(arr.size() - 1).next = null;
        return arr.get(0);
    }
}