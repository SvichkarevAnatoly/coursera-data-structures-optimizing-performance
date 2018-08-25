package textgen;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author UC San Diego MOOC team
 */
public class MyLinkedListTester {

    private static final int LONG_LIST_LENGTH = 10;

    MyLinkedList<String> shortList;
    MyLinkedList<Integer> emptyList;
    MyLinkedList<Integer> longerList;
    MyLinkedList<Integer> list1;

    @Before
    public void setUp() {
        // Feel free to use these lists, or add your own
        shortList = new MyLinkedList<>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new MyLinkedList<>();
        longerList = new MyLinkedList<>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }
        list1 = new MyLinkedList<>();
        list1.add(65);
        list1.add(21);
        list1.add(42);
    }

    /**
     * Test if the get method is working correctly.
     */
    /*You should not need to add much to this method.
     * We provide it as an example of a thorough test. */
    @Test
    public void testGet() {
        //test empty list, get should throw an exception
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException ignored) {
        }

        // test short list, first contents, then out of bounds
        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));

        try {
            shortList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            shortList.get(2);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        // test longer list contents
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
        }

        // test off the end of the longer array
        try {
            longerList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        }

    }


    /**
     * Test removing an element from the list.
     * We've included the example from the concept challenge.
     * You will want to add more tests.
     */
    @Test
    public void testRemove() {
        int a = list1.remove(0);
        assertEquals("Remove: check a is correct ", 65, a);
        assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
        assertEquals("Remove: check size is correct ", 2, list1.size());

        a = list1.remove(1);
        assertEquals("Remove: check a is correct ", 42, a);
        assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
        assertEquals("Remove: check size is correct ", 1, list1.size());
    }

    /**
     * Test adding an element into the end of the list, specifically
     * public boolean add(E element)
     */
    @Test
    public void testAddEnd() {
        assertTrue(emptyList.add(1));
        assertEquals(1, (int) emptyList.get(0));
        assertEquals(1, emptyList.size());

        assertTrue(emptyList.add(2));
        assertEquals(1, (int) emptyList.get(0));
        assertEquals(2, (int) emptyList.get(1));
        assertEquals(2, emptyList.size());
    }


    /**
     * Test the size of the list
     */
    @Test
    public void testSize() {
        assertEquals(0, emptyList.size());
        assertEquals(2, shortList.size());
        assertEquals(LONG_LIST_LENGTH, longerList.size());
        assertEquals(3, list1.size());
    }


    /**
     * Test adding an element into the list at a specified index,
     * specifically:
     * public void add(int index, E element)
     */
    @Test
    public void testAddAtIndex() {
        emptyList.add(0, 1);
        assertEquals(1, (int) emptyList.get(0));
        assertEquals(1, emptyList.size());

        emptyList.add(0, 2);
        assertEquals(2, (int) emptyList.get(0));
        assertEquals(2, emptyList.size());
    }

    /**
     * Test setting an element in the list
     */
    @Test
    public void testSet() {
        emptyList.add(5);
        assertEquals(5, (int) emptyList.set(0, 6));
        assertEquals(1, emptyList.size());
    }

    // more test methods.

    @Test(expected = IndexOutOfBoundsException.class)
    public void setLowerBound() {
        emptyList.set(-1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setUpperBound() {
        emptyList.set(5, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLowerBound() {
        emptyList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeUpperBound() {
        emptyList.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addLowerBound() {
        emptyList.add(-1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addUpperBound() {
        emptyList.add(5, 5);
    }

    @Test(expected = NullPointerException.class)
    public void addNull() {
        emptyList.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void setNull() {
        shortList.set(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throwIndexOutOfBoundsException() {
        List<String> list = new MyLinkedList<>();
        list.get(-1);
    }
}
