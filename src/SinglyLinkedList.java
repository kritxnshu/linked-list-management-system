public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = node;
    }

    public boolean insertAtPosition(int value, int position) {
        if (position < 1 || position > count() + 1) return false;
        if (position == 1) {
            insertAtBeginning(value);
            return true;
        }
        Node previous = nodeAt(position - 1);
        Node node = new Node(value);
        node.next = previous.next;
        previous.next = node;
        return true;
    }

    public boolean insertAfter(int target, int value) {
        Node current = findNode(target);
        if (current == null) return false;
        Node node = new Node(value);
        node.next = current.next;
        current.next = node;
        return true;
    }

    public boolean insertBefore(int target, int value) {
        if (head == null) return false;
        if (head.data == target) {
            insertAtBeginning(value);
            return true;
        }
        Node previous = head;
        while (previous.next != null && previous.next.data != target) previous = previous.next;
        if (previous.next == null) return false;
        Node node = new Node(value);
        node.next = previous.next;
        previous.next = node;
        return true;
    }

    public boolean deleteFromBeginning() {
        if (head == null) return false;
        head = head.next;
        return true;
    }

    public boolean deleteFromEnd() {
        if (head == null) return false;
        if (head.next == null) {
            head = null;
            return true;
        }
        Node current = head;
        while (current.next.next != null) current = current.next;
        current.next = null;
        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (position < 1 || position > count()) return false;
        if (position == 1) return deleteFromBeginning();
        Node previous = nodeAt(position - 1);
        previous.next = previous.next.next;
        return true;
    }

    public boolean deleteByValue(int value) {
        if (head == null) return false;
        if (head.data == value) return deleteFromBeginning();
        Node previous = head;
        while (previous.next != null && previous.next.data != value) previous = previous.next;
        if (previous.next == null) return false;
        previous.next = previous.next.next;
        return true;
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

    public String display() {
        if (head == null) return "NULL";
        StringBuilder result = new StringBuilder();
        for (Node current = head; current != null; current = current.next) {
            result.append(current.data).append(" -> ");
        }
        return result.append("NULL").toString();
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
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
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
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) runner.next = runner.next.next;
                else runner = runner.next;
            }
        }
    }

    private Node findNode(int value) {
        for (Node current = head; current != null; current = current.next) {
            if (current.data == value) return current;
        }
        return null;
    }

    private Node nodeAt(int position) {
        Node current = head;
        for (int currentPosition = 1; currentPosition < position; currentPosition++) current = current.next;
        return current;
    }
}
