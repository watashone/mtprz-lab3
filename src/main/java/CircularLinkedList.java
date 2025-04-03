public class CircularLinkedList {
    private static class Node {
        Character data;
        Node next;

        Node(Character data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public CircularLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public void append(Character element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
        }
        length++;
    }

    public void insert(Character element, int index) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        if (index == length) {
            append(element);
            return;
        }

        Node newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;
    }

    public Character delete(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Character deletedValue;

        if (length == 1) {
            deletedValue = head.data;
            head = null;
            tail = null;
        } else if (index == 0) {
            deletedValue = head.data;
            head = head.next;
            tail.next = head;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            deletedValue = current.next.data;
            current.next = current.next.next;
            if (index == length - 1) {
                tail = current;
            }
        }

        length--;
        return deletedValue;
    }

    public void deleteAll(Character element) {
        if (head == null) return;

        Node current = head;
        int originalLength = length;

        for (int i = 0; i < originalLength; i++) {
            if (current.data.equals(element)) {
                delete(i);
                i--; // Adjust index after deletion
                originalLength--;
            }
            current = current.next;
        }
    }

    public Character get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public CircularLinkedList clone() {
        CircularLinkedList newList = new CircularLinkedList();
        if (head == null) return newList;

        Node current = head;
        for (int i = 0; i < length; i++) {
            newList.append(current.data);
            current = current.next;
        }

        return newList;
    }

    public void reverse() {
        if (length <= 1) return;

        Node prev = tail;
        Node current = head;
        Node next;

        for (int i = 0; i < length; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        tail = current;
    }

    public int findFirst(Character element) {
        if (head == null) return -1;

        Node current = head;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(element)) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    public int findLast(Character element) {
        if (head == null) return -1;

        int lastIndex = -1;
        Node current = head;

        for (int i = 0; i < length; i++) {
            if (current.data.equals(element)) {
                lastIndex = i;
            }
            current = current.next;
        }

        return lastIndex;
    }

    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    public void extend(CircularLinkedList otherList) {
        if (otherList == null || otherList.head == null) return;

        Node current = otherList.head;
        for (int i = 0; i < otherList.length; i++) {
            this.append(current.data);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        if (head == null) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        for (int i = 0; i < length; i++) {
            sb.append(current.data);
            if (i < length - 1) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}