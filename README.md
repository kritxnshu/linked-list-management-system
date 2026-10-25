# Linked List Management System

A menu-driven Java console application for practicing core linked-list operations without using arrays or built-in list collections to store node data.

## Objective

Implement and compare both singly and doubly linked lists. Each data structure has its own menu and uses manually linked `Node` objects.

## Language Used

Java (works with Java 8 or later; tested with the installed JDK).

## Features

- Singly linked list: all 19 required operations
- Doubly linked list: all 20 required operations, including forward and backward traversal
- Input validation for non-numeric input, empty lists, missing values, invalid positions, and out-of-range positions
- 1-based positions throughout
- Bubble sort in ascending order
- Duplicate removal that keeps the first occurrence
- A comparison screen explaining the two list types

For even-length lists, **Find Middle Element** returns the second of the two middle nodes. For example, the middle of `10 -> 20 -> 30 -> 40` is `30`.

## Project Structure

```text
Linked-List-Management-System/
├── README.md
├── .gitignore
├── src/
│   ├── Main.java
│   ├── SinglyLinkedList.java
│   ├── DoublyLinkedList.java
│   └── LinkedListTest.java
└── sample-output/
    └── output.txt
```

## How to Run

From the project folder:

```bash
javac -d out src/*.java
java -cp out Main
```

## How to Run the Tests

```bash
javac -d out src/SinglyLinkedList.java src/DoublyLinkedList.java src/LinkedListTest.java
java -ea -cp out LinkedListTest
```

## Operations

Both lists support insertion at the beginning, end, position, before a value, and after a value; deletion from the beginning, end, position, and by value; search, update, count, minimum, maximum, middle, reverse, sort, and duplicate removal. The doubly linked list also supports display in both directions.

## Time Complexity

| Operation | Singly Linked List | Doubly Linked List |
| --- | --- | --- |
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) with tail |
| Search / display / count | O(n) | O(n) |
| Find min / max / middle | O(n) | O(n) |
| Reverse | O(n), O(1) extra space | O(n), O(1) extra space |
| Bubble sort | O(n²) | O(n²) |
| Remove duplicates | O(n²) | O(n²) |

## Author

Replace this line with your name before submission.
