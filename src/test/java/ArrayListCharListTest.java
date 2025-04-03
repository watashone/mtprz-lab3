import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListCharListTest {
    private ArrayListCharList list;

    @BeforeEach
    public void setUp() {
        list = new ArrayListCharList();
    }

    @Test
    public void testEmptyList() {
        assertEquals(0, list.length());
        assertTrue(list.toString().equals("[]"));
    }

    @Test
    public void testAppend() {
        list.append('a');
        list.append('b');
        assertEquals(2, list.length());
        assertEquals("[a, b]", list.toString());
    }

    @Test
    public void testAppendNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> list.append(null));
    }

    @Test
    public void testInsert() {
        list.append('a');
        list.append('c');
        list.insert('b', 1);
        assertEquals(3, list.length());
        assertEquals("[a, b, c]", list.toString());
    }

    @Test
    public void testInsertAtBeginning() {
        list.insert('a', 0);
        list.insert('b', 0);
        assertEquals("[b, a]", list.toString());
    }

    @Test
    public void testInsertAtEnd() {
        list.append('a');
        list.insert('b', 1);
        assertEquals("[a, b]", list.toString());
    }

    @Test
    public void testInsertNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> list.insert(null, 0));
    }

    @Test
    public void testInsertInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('a', -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('a', 1));
    }

    @Test
    public void testDelete() {
        list.append('a');
        list.append('b');
        list.append('c');
        Character deleted = list.delete(1);
        assertEquals('b', deleted);
        assertEquals(2, list.length());
        assertEquals("[a, c]", list.toString());
    }

    @Test
    public void testDeleteInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }

    @Test
    public void testDeleteAll() {
        list.append('a');
        list.append('b');
        list.append('a');
        list.append('c');
        list.deleteAll('a');
        assertEquals(2, list.length());
        assertEquals("[b, c]", list.toString());
    }

    @Test
    public void testGet() {
        list.append('a');
        list.append('b');
        assertEquals('a', list.get(0));
        assertEquals('b', list.get(1));
    }

    @Test
    public void testGetInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testClone() {
        list.append('a');
        list.append('b');
        ArrayListCharList clone = list.clone();
        assertEquals(list.toString(), clone.toString());
        list.append('c');
        assertNotEquals(list.toString(), clone.toString());
    }

    @Test
    public void testReverse() {
        list.append('a');
        list.append('b');
        list.append('c');
        list.reverse();
        assertEquals("[c, b, a]", list.toString());
    }

    @Test
    public void testFindFirst() {
        list.append('a');
        list.append('b');
        list.append('a');
        assertEquals(0, list.findFirst('a'));
        assertEquals(1, list.findFirst('b'));
        assertEquals(-1, list.findFirst('c'));
    }

    @Test
    public void testFindLast() {
        list.append('a');
        list.append('b');
        list.append('a');
        assertEquals(2, list.findLast('a'));
        assertEquals(1, list.findLast('b'));
        assertEquals(-1, list.findLast('c'));
    }

    @Test
    public void testClear() {
        list.append('a');
        list.append('b');
        list.clear();
        assertEquals(0, list.length());
        assertEquals("[]", list.toString());
    }

    @Test
    public void testExtend() {
        list.append('a');
        ArrayListCharList other = new ArrayListCharList();
        other.append('b');
        other.append('c');
        list.extend(other);
        assertEquals(3, list.length());
        assertEquals("[a, b, c]", list.toString());
    }

    @Test
    public void testExtendWithNull() {
        list.append('a');
        list.extend(null);
        assertEquals(1, list.length());
        assertEquals("[a]", list.toString());
    }
}