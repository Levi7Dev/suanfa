package kuaishou;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Levi
 * @create 2023/8/8 9:40
 */
public class linklist {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

//        Node head = reverse(n1);
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }

        Node node = delK(n1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static Node delK(Node head) {
        Node dummy = new Node(-1, head);
        int k = 3;
        Node fast = dummy;
        Node slow = dummy;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void iteratorMap() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();

        iterator.next();
        iterator.remove();
    }
}

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
