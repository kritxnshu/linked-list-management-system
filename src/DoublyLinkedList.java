public class DoublyLinkedList {
    private static class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        if (head != null) head.previous = node;
        else tail = node;
        head = node;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        node.previous = tail;
        if (tail != null) tail.next = node;
        else head = node;
        tail = node;
    }

    public boolean insertAtPosition(int value, int position) {
        if (position < 1 || position > count() + 1) return false;
        if (position == 1) {
            insertAtBeginning(value);
            return true;
        }
        if (position == count() + 1) {
            insertAtEnd(value);
            return true;
        }
        Node nextNode = nodeAt(position);
        Node node = new Node(value);
        node.previous = nextNode.previous;
        node.next = nextNode;
        nextNode.previous.next = node;
        nextNode.previous = node;
        return true;
    }

    public boolean insertAfter(int target, int value) {
        Node current = findNode(target);
        if (current == null) return false;
        if (current == tail) {
            insertAtEnd(value);
            return true;
        }
        Node node = new Node(value);
        node.previous = current;
        node.next = current.next;
        current.next.previous = node;
        current.next = node;
        return true;
    }

    public boolean insertBefore(int target, int value) {
        Node current = findNode(target);
        if (current == null) return false;
        if (current == head) {
            insertAtBeginning(value);
            return true;
        }
        Node node = new Node(value);
        node.next = current;
        node.previous = current.previous;
        current.previous.next = node;
        current.previous = node;
        return true;
    }

    public boolean deleteFromBeginning() {
        if (head == null) return false;
        head = head.next;
        if (head != null) head.previous = null;
        else tail = null;
        return true;
    }

    public boolean deleteFromEnd() {
        if (tail == null) return false;
        tail = tail.previous;
        if (tail != null) tail.next = null;
        else head = null;
        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (position < 1 || position > count()) return false;
        return deleteNode(nodeAt(position));
    }

    public boolean deleteByValue(int value) {
        Node current = findNode(value);
        return current != null && deleteNode(current);
    }

    public int search(int value) {
        int position = 1;
        for (Node current = head; current != null; current = current.next, position++) {
            if (current.data == value) return position;
        }
        return -1;
    }

    public boolean update(int oldValue, int newValue) {
        Node current = findNode(oldValue);
        if (current == null) return false;
        current.data = newValue;
        return true;
    }

    public String displayForward() {
        if (head == null) return "NULL";
        StringBuilder result = new StringBuilder("NULL <- ");
        for (Node current = head; current != null; current = current.next) {
            result.append(current.data);
            result.append(current.next == null ? " -> NULL" : " <-> ");
        }
        return result.toString();
    }

    public String displayBackward() {
        if (tail == null) return "NULL";
        StringBuilder result = new StringBuilder("NULL <- ");
        for (Node current = tail; current != null; current = current.previous) {
            result.append(current.data);
            result.append(current.previous == null ? " -> NULL" : " <-> ");
        }
        return result.toString();
    }

    public int count() {
        int total = 0;
        for (Node current = head; current != null; current = current.next) total++;
        return total;
    }

    public Integer max() {
        if (head == null) return null;
        int maximum = head.data;
        for (Node current = head.next; current != null; current = current.next) {
            if (current.data > maximum) maximum = current.data;
        }
        return maximum;
    }

    public Integer min() {
        if (head == null) return null;
        int minimum = head.data;
        for (Node current = head.next; current != null; current = current.next) {
            if (current.data < minimum) minimum = current.data;
        }
        return minimum;
    }

    // For an even-sized list, this returns the second of the two middle nodes.
    public Integer middle() {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = current.previous;
            current.previous = next;
            current = next;
        }
        Node oldHead = head;
        head = tail;
        tail = oldHead;
    }

    public void sort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            for (Node current = head; current.next != null; current = current.next) {
                if (current.data > current.next.data) {
                    int value = current.data;
                    current.data = current.next.data;
                    current.next.data = value;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public void removeDuplicates() {
        for (Node current = head; current != null; current = current.next) {
            Node runner = current.next;
            while (runner != null) {
                Node next = runner.next;
                if (runner.data == current.data) deleteNode(runner);
                runner = next;
            }
        }
    }

    private boolean deleteNode(Node node) {
        if (node == head) return deleteFromBeginning();
        if (node == tail) return deleteFromEnd();
        node.previous.next = node.next;
        node.next.previous = node.previous;
        return true;
    }

    private Node findNode(int value) {
        for (Node current = head; current != null; current = current.next) {
            if (current.data == value) return current;
        }
        return null;
    }

    private Node nodeAt(int position) {
        if (position <= count() / 2) {
            Node current = head;
            for (int currentPosition = 1; currentPosition < position; currentPosition++) current = current.next;
            return current;
        }
        Node current = tail;
        for (int currentPosition = count(); currentPosition > position; currentPosition--) current = current.previous;
        return current;
    }
}
