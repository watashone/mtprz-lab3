import java.util.ArrayList;
import java.util.Collections;

public class ArrayListCharList {
    private ArrayList<Character> list;

    public ArrayListCharList() {
        list = new ArrayList<>();
    }

    public int length() {
        return list.size();
    }

    public void append(Character element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        list.add(element);
    }

    public void insert(Character element, int index) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        list.add(index, element);
    }

    public Character delete(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return list.remove(index);
    }

    public void deleteAll(Character element) {
        list.removeIf(c -> c.equals(element));
    }

    public Character get(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return list.get(index);
    }

    public ArrayListCharList clone() {
        ArrayListCharList newList = new ArrayListCharList();
        newList.list = new ArrayList<>(this.list);
        return newList;
    }

    public void reverse() {
        Collections.reverse(list);
    }

    public int findFirst(Character element) {
        return list.indexOf(element);
    }

    public int findLast(Character element) {
        return list.lastIndexOf(element);
    }

    public void clear() {
        list.clear();
    }

    public void extend(ArrayListCharList otherList) {
        if (otherList == null) return;
        list.addAll(otherList.list);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}