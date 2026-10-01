class Solution {
    // Step 1: Deep copy without random pointer
    public Node deepcopy(Node head1) {

        Node temp1 = head1;

        Node head2 = new Node(-1);
        Node temp2 = head2;

        while (temp1 != null) {

            Node t = new Node(temp1.val);

            temp2.next = t;
            temp2 = temp2.next;

            temp1 = temp1.next;
        }
        return head2.next;
    }
    // Step 2: Merge original and copied list
    public void merge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            Node next1 = temp1.next;
            Node next2 = temp2.next;
            temp1.next = temp2;
            temp2.next = next1;
            temp1 = next1;
            temp2 = next2;
        }
    }
    // Step 3: Assign random pointers
    public void randomConnections(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null) {
            if (temp1.random == null) {
                temp2.random = null;
            } 
            else {
                temp2.random = temp1.random.next;
            }
            temp1 = temp2.next;
            if (temp1 != null) {
                temp2 = temp1.next;
            }
        }
    }
    // Step 4: Separate original and copied list
    public Node separate(Node head1) {
        Node head2 = head1.next;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if (temp1 != null) {
                temp2.next = temp1.next;
                temp2 = temp2.next;
            }
        }
        return head2;
    }
    public Node copyRandomList(Node head1) {
        if (head1 == null) {
            return null;
        }
        // Step 1
        Node head2 = deepcopy(head1);
        // Step 2
        merge(head1, head2);
        // Step 3
        randomConnections(head1, head2);
        // Step 4
        return separate(head1);
    }
}