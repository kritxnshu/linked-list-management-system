import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n==================================================");
            System.out.println("          LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("==================================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");

            switch (readInt("Enter your choice: ")) {
                case 1:
                    singlyMenu();
                    break;
                case 2:
                    doublyMenu();
                    break;
                case 3:
                    showComparison();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Linked List Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 4.");
            }
        }
    }

    private static void singlyMenu() {
        SinglyLinkedList list = new SinglyLinkedList();
        boolean running = true;
        while (running) {
            System.out.println("\n********** Operation on Singly Linked List **********");
            System.out.println("1. Insert at Beginning\n2. Insert at End\n3. Insert at Position");
            System.out.println("4. Insert After a Node\n5. Insert Before a Node");
            System.out.println("6. Delete from Beginning\n7. Delete from End\n8. Delete from Position");
            System.out.println("9. Delete by Value\n10. Search\n11. Update\n12. Display");
            System.out.println("13. Count Nodes\n14. Find Maximum\n15. Find Minimum");
            System.out.println("16. Find Middle Element\n17. Reverse\n18. Sort");
            System.out.println("19. Remove Duplicates\n20. Exit");

            int choice = readInt("Enter the choice: ");
            switch (choice) {
                case 1:
                    list.insertAtBeginning(readInt("Value: "));
                    success("Inserted at beginning.");
                    break;
                case 2:
                    list.insertAtEnd(readInt("Value: "));
                    success("Inserted at end.");
                    break;
                case 3:
                    insertResult(list.insertAtPosition(readInt("Value: "), readInt("Position (1-based): ")));
                    break;
                case 4:
                    insertResult(list.insertAfter(readInt("Insert after value: "), readInt("New value: ")));
                    break;
                case 5:
                    insertResult(list.insertBefore(readInt("Insert before value: "), readInt("New value: ")));
                    break;
                case 6:
                    deleteResult(list.deleteFromBeginning());
                    break;
                case 7:
                    deleteResult(list.deleteFromEnd());
                    break;
                case 8:
                    deleteResult(list.deleteAtPosition(readInt("Position (1-based): ")));
                    break;
                case 9:
                    deleteResult(list.deleteByValue(readInt("Value to delete: ")));
                    break;
                case 10:
                    showSearchResult(list.search(readInt("Value to search: ")));
                    break;
                case 11:
                    if (list.update(readInt("Current value: "), readInt("New value: "))) success("Value updated.");
                    else failure("Value not found.");
                    break;
                case 12:
                    System.out.println("List: " + list.display());
                    break;
                case 13:
                    System.out.println("Node count: " + list.count());
                    break;
                case 14:
                    showValue("Maximum", list.max());
                    break;
                case 15:
                    showValue("Minimum", list.min());
                    break;
                case 16:
                    showValue("Middle element", list.middle());
                    break;
                case 17:
                    list.reverse();
                    success("List reversed.");
                    break;
                case 18:
                    list.sort();
                    success("List sorted in ascending order.");
                    break;
                case 19:
                    list.removeDuplicates();
                    success("Duplicates removed.");
                    break;
                case 20:
                    running = false;
                    break;
                default:
                    failure("Invalid choice. Please select 1 to 20.");
            }
        }
    }

    private static void doublyMenu() {
        DoublyLinkedList list = new DoublyLinkedList();
        boolean running = true;
        while (running) {
            System.out.println("\n********** Operation on Doubly Linked List **********");
            System.out.println("1. Insert at Beginning\n2. Insert at End\n3. Insert at Position");
            System.out.println("4. Insert After a Node\n5. Insert Before a Node");
            System.out.println("6. Delete from Beginning\n7. Delete from End\n8. Delete from Position");
            System.out.println("9. Delete by Value\n10. Search\n11. Update");
            System.out.println("12. Display Forward\n13. Display Backward\n14. Count Nodes");
            System.out.println("15. Find Maximum\n16. Find Minimum\n17. Find Middle Element");
            System.out.println("18. Reverse\n19. Sort\n20. Remove Duplicates\n21. Exit");

            int choice = readInt("Enter the choice: ");
            switch (choice) {
                case 1:
                    list.insertAtBeginning(readInt("Value: "));
                    success("Inserted at beginning.");
                    break;
                case 2:
                    list.insertAtEnd(readInt("Value: "));
                    success("Inserted at end.");
                    break;
                case 3:
                    insertResult(list.insertAtPosition(readInt("Value: "), readInt("Position (1-based): ")));
                    break;
                case 4:
                    insertResult(list.insertAfter(readInt("Insert after value: "), readInt("New value: ")));
                    break;
                case 5:
                    insertResult(list.insertBefore(readInt("Insert before value: "), readInt("New value: ")));
                    break;
                case 6:
                    deleteResult(list.deleteFromBeginning());
                    break;
                case 7:
                    deleteResult(list.deleteFromEnd());
                    break;
                case 8:
                    deleteResult(list.deleteAtPosition(readInt("Position (1-based): ")));
                    break;
                case 9:
                    deleteResult(list.deleteByValue(readInt("Value to delete: ")));
                    break;
                case 10:
                    showSearchResult(list.search(readInt("Value to search: ")));
                    break;
                case 11:
                    if (list.update(readInt("Current value: "), readInt("New value: "))) success("Value updated.");
                    else failure("Value not found.");
                    break;
                case 12:
                    System.out.println("Forward: " + list.displayForward());
                    break;
                case 13:
                    System.out.println("Backward: " + list.displayBackward());
                    break;
                case 14:
                    System.out.println("Node count: " + list.count());
                    break;
                case 15:
                    showValue("Maximum", list.max());
                    break;
                case 16:
                    showValue("Minimum", list.min());
                    break;
                case 17:
                    showValue("Middle element", list.middle());
                    break;
                case 18:
                    list.reverse();
                    success("List reversed.");
                    break;
                case 19:
                    list.sort();
                    success("List sorted in ascending order.");
                    break;
                case 20:
                    list.removeDuplicates();
                    success("Duplicates removed.");
                    break;
                case 21:
                    running = false;
                    break;
                default:
                    failure("Invalid choice. Please select 1 to 21.");
            }
        }
    }

    private static void showComparison() {
        System.out.println("\nSingly vs Doubly Linked List");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Aspect             Singly Linked List       Doubly Linked List");
        System.out.println("Links per node     next only                previous and next");
        System.out.println("Backward travel    Not available            Available from tail");
        System.out.println("Memory per node    Lower                    Higher");
        System.out.println("Delete known node  Need previous node       Direct with prev/next");
        System.out.println("Reverse            Reverse next links       Swap previous/next links");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!INPUT.hasNext()) {
                System.out.println("\nInput ended. Exiting.");
                System.exit(0);
            }
            if (INPUT.hasNextInt()) return INPUT.nextInt();
            System.out.println("Please enter a whole number.");
            INPUT.next();
        }
    }

    private static void insertResult(boolean success) {
        if (success) success("Insertion completed.");
        else failure("Insertion failed: position is invalid or target value was not found.");
    }

    private static void deleteResult(boolean success) {
        if (success) success("Deletion completed.");
        else failure("Deletion failed: the list is empty, position is invalid, or value was not found.");
    }

    private static void showSearchResult(int position) {
        if (position == -1) failure("Value not found.");
        else System.out.println("Value found at position " + position + ".");
    }

    private static void showValue(String label, Integer value) {
        if (value == null) failure("The list is empty.");
        else System.out.println(label + ": " + value);
    }

    private static void success(String message) {
        System.out.println("Success: " + message);
    }

    private static void failure(String message) {
        System.out.println("Notice: " + message);
    }
}
