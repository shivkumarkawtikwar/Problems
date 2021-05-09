package classroom;


import java.util.Stack;

public class PalindromeLinkedList {

    private static class Node {
        int val;
        Node next ;
        Node(int v, Node next) {
            this.val = v;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        PalindromeLinkedList p = new PalindromeLinkedList();

        Node head = new Node(0, new Node(1, new Node(2, new Node(3, new Node(2, new Node(1, new Node(0, null)))))));

        boolean isPal = p.isPalindromeWithStack(head);
        System.out.println(isPal);

        System.out.println(p.isPalindromeWithRecursion(head, head) != null);

    }

    private boolean isPalindromeWithStack(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop())
                return false;
            temp = temp.next;
        }
        return true;
    }

    private Node isPalindromeWithRecursion(Node head, Node current) {
        if (current == null)
            return head;

        Node rev = isPalindromeWithRecursion(head, current.next);
        if(rev != null) {
            if(rev.val != current.val)
                return null;
            return rev.next;
        }
        return null;
    }
}
