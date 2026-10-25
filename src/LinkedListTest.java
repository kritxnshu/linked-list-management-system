public class LinkedListTest {
    public static void main(String[] args) {
        testSinglyLinkedList();
        testDoublyLinkedList();
        System.out.println("All linked-list tests passed.");
    }

    private static void testSinglyLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals(0, list.count(), "an empty singly list has no nodes");
        assertFalse(list.deleteFromBeginning(), "cannot delete from an empty singly list");

        list.insertAtEnd(20);
        list.insertAtBeginning(10);
        assertTrue(list.insertAtPosition(30, 3), "can insert at the final valid position");
        assertTrue(list.insertAfter(20, 25), "can insert after a value");
        assertTrue(list.insertBefore(10, 5), "can insert before the head");
        assertEquals("5 -> 10 -> 20 -> 25 -> 30 -> NULL", list.display(), "singly insertion order");
        assertEquals(3, list.search(20), "singly search is 1-based");
        assertTrue(list.update(25, 26), "singly update replaces the first match");
        assertEquals(30, list.max(), "singly maximum");
        assertEquals(5, list.min(), "singly minimum");
        assertEquals(20, list.middle(), "singly middle uses the second middle for even counts");

        list.reverse();
        assertEquals("30 -> 26 -> 20 -> 10 -> 5 -> NULL", list.display(), "singly reverse");
        list.sort();
        assertEquals("5 -> 10 -> 20 -> 26 -> 30 -> NULL", list.display(), "singly sort");
        list.insertAtEnd(20);
        list.insertAtEnd(5);
        list.removeDuplicates();
        assertEquals("5 -> 10 -> 20 -> 26 -> 30 -> NULL", list.display(), "singly removes duplicates");
        assertTrue(list.deleteAtPosition(3), "singly delete at a position");
        assertTrue(list.deleteByValue(26), "singly delete by value");
        assertEquals("5 -> 10 -> 30 -> NULL", list.display(), "singly deletions preserve links");
    }

    private static void testDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertFalse(list.deleteFromEnd(), "cannot delete from an empty doubly list");

        list.insertAtEnd(20);
        list.insertAtBeginning(10);
        assertTrue(list.insertAtPosition(30, 3), "doubly insert at final valid position");
        assertTrue(list.insertAfter(20, 25), "doubly insert after a value");
        assertTrue(list.insertBefore(10, 5), "doubly insert before head");
        assertEquals("NULL <- 5 <-> 10 <-> 20 <-> 25 <-> 30 -> NULL", list.displayForward(), "doubly forward display");
        assertEquals("NULL <- 30 <-> 25 <-> 20 <-> 10 <-> 5 -> NULL", list.displayBackward(), "doubly backward display");
        assertEquals(3, list.search(20), "doubly search is 1-based");
        assertTrue(list.update(25, 26), "doubly update replaces first match");
        assertEquals(30, list.max(), "doubly maximum");
        assertEquals(5, list.min(), "doubly minimum");
        assertEquals(20, list.middle(), "doubly middle uses the second middle for even counts");

        list.reverse();
        assertEquals("NULL <- 30 <-> 26 <-> 20 <-> 10 <-> 5 -> NULL", list.displayForward(), "doubly reverse reconnects both directions");
        list.sort();
        list.insertAtEnd(20);
        list.insertAtEnd(5);
        list.removeDuplicates();
        assertEquals("NULL <- 5 <-> 10 <-> 20 <-> 26 <-> 30 -> NULL", list.displayForward(), "doubly sort and duplicate removal");
        assertTrue(list.deleteAtPosition(3), "doubly delete at a position");
        assertTrue(list.deleteByValue(26), "doubly delete by value");
        assertEquals("NULL <- 5 <-> 10 <-> 30 -> NULL", list.displayForward(), "doubly deletions preserve links");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void assertFalse(boolean condition, String message) {
        assertTrue(!condition, message);
    }

    private static void assertEquals(int expected, Integer actual, String message) {
        if (actual == null || expected != actual) {
            throw new AssertionError(message + " (expected " + expected + ", got " + actual + ")");
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " (expected '" + expected + "', got '" + actual + "')");
        }
    }
}
