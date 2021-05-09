package classroom.recursion;

public class DeleteALinkedListUsingRecursion {

    private static class Node {
        int val;
        Node next ;
        Node(int v, Node next) {
            this.val = v;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DeleteALinkedListUsingRecursion d = new DeleteALinkedListUsingRecursion();

        Node head = new Node(0, new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null)))))));

        d.printList(head);

        head = d.delete(head, 3);
        d.printList(head);

        head = d.delete(head, 5);
        d.printList(head);

        head = d.delete(head, 0);
        d.printList(head);

        head = d.delete(head, 10);
        d.printList(head);
    }
    /**
     * delete k th node from h
     * @param h
     * @param k
     * @return
     */
    public Node delete(Node h, int k) {
        if(h == null)
            return h;
        if(k == 0)
            return h.next;

        h.next = delete(h.next, k-1);
        return h;
    }

    public void printList(Node h) {
        while (h != null) {
            System.out.print(h.val +" ");
            h = h.next;
        }
        System.out.println(" ");
    }


}
