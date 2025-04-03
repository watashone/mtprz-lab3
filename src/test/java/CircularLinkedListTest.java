import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularLinkedListTest {

    @Test
    public void testEmptyList() {
        CircularLinkedList list = new CircularLinkedList();
        assertEquals(0, list.length());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testAppend() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        assertEquals(1, list.length());
        assertEquals('a', list.get(0));

        list.append('b');
        assertEquals(2, list.length());
        assertEquals('b', list.get(1));
    }

    @Test
    public void testInsert() {
        CircularLinkedList list = new CircularLinkedList();
        list.insert('a', 0);
        list.insert('b', 0);
        list.insert('c', 1);
        list.insert('d', 3);

        assertEquals(4, list.length());
        assertEquals("[b, c, a, d, f]", list.toString());
    }

    @Test
    public void testDelete() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');
        list.append('c');

        assertEquals('b', list.delete(1));
        assertEquals(2, list.length());
        assertEquals("[a, c]", list.toString());

        assertEquals('a', list.delete(0));
        assertEquals(1, list.length());
    }

    @Test
    public void testDeleteAll() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');
        list.append('a');
        list.append('c');
        list.append('a');

        list.deleteAll('a');
        assertEquals(2, list.length());
        assertEquals("[b, c]", list.toString());
    }

    @Test
    public void testGet() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');
        list.append('c');

        assertEquals('a', list.get(0));
        assertEquals('b', list.get(1));
        assertEquals('c', list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testClone() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');

        CircularLinkedList clone = list.clone();
        assertEquals(list.length(), clone.length());
        assertEquals(list.toString(), clone.toString());

        clone.append('c');
        assertEquals(2, list.length());
        assertEquals(3, clone.length());
    }

    @Test
    public void testReverse() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');
        list.append('c');

        list.reverse();
        assertEquals("[c, b, a]", list.toString());

        list.reverse();
        assertEquals("[a, b, c]", list.toString());
    }

    @Test
    public void testFindFirstLast() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');
        list.append('a');
        list.append('c');

        assertEquals(0, list.findFirst('a'));
        assertEquals(2, list.findLast('a'));
        assertEquals(-1, list.findFirst('x'));
        assertEquals(-1, list.findLast('x'));
    }

    @Test
    public void testClear() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');

        list.clear();
        assertEquals(0, list.length());
        assertTrue(list.toString().equals("[]"));
    }

    @Test
    public void testExtend() {
        CircularLinkedList list1 = new CircularLinkedList();
        list1.append('a');
        list1.append('b');

        CircularLinkedList list2 = new CircularLinkedList();
        list2.append('c');
        list2.append('d');

        list1.extend(list2);
        assertEquals(4, list1.length());
        assertEquals("[a, b, c, d]", list1.toString());
        assertEquals(2, list2.length());
    }

    @Test
    public void testNullElements() {
        CircularLinkedList list = new CircularLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list.append(null));
        assertThrows(IllegalArgumentException.class, () -> list.insert(null, 0));
    }

    @Test
    public void testCircularity() {
        CircularLinkedList list = new CircularLinkedList();
        list.append('a');
        list.append('b');
        list.append('c');

        // Test that tail.next points to head
        assertEquals('a', list.get(0));
        assertEquals('b', list.get(1));
        assertEquals('c', list.get(2));
        assertEquals('a', list.get(3 % list.length())); // Wraps around
    }
}