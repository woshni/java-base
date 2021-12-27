public class Test {
    public static void main(String[] args) {
        ListNode demo = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4))));
        ListNode next = demo.next;
        swapPairs(demo);
        "aaaaaaaxxaaaacxxxcc".contains("xxx");
        System.out.println(next);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode demo = new ListNode(1).setNext(head);
        ListNode temp = demo;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return demo.next;
    }


static class ListNode {
    int val;
    ListNode next;

    public ListNode setNext(ListNode node) {
        next = node;
        return this;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

}


