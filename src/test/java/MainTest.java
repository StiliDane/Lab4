import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void lessThan100() {
        assertTrue(Main.lessThan100(new int[]{1, 2, 3}));
        assertFalse(Main.lessThan100(new int[]{1, 200, 3}));
    }

    @Test
    public void DynArrayTest1() {
        DynArray arr = new DynArray(Arrays.asList(1, 2, 3));
        assertEquals(3, arr.length());
    }

    @Test
    public void DynArrayTest2() {
        DynArray arr = new DynArray(Arrays.asList(1, 2, 3));
        assertEquals(2, arr.get(1));
    }

    @Test
    public void DynArrayTest3() {
        DynArray arr = new DynArray();
        assertEquals(0, arr.length());
    }

    @Test
    public void DynArrayTest4() {
        DynArray arr = new DynArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(10, arr.length());
    }

    @Test
    public void equalsTest1() {
        DynArray arr1 = new DynArray(Arrays.asList(1, 2));
        DynArray arr2 = new DynArray(Arrays.asList(1, 2));
        assertTrue(arr1.equals(arr2));
    }

    @Test
    public void equalsTest2() {
        DynArray arr1 = new DynArray(Arrays.asList(1, 2));
        DynArray arr2 = new DynArray(Arrays.asList(1, 3));
        assertFalse(arr1.equals(arr2));
    }

    @Test
    public void equalsTest3() {
        DynArray arr = new DynArray(Arrays.asList(1, 2));
        assertFalse(arr.equals("Not an array"));
    }

    @Test
    public void equalsTest4() {
        DynArray arr1 = new DynArray(Arrays.asList(1));
        DynArray arr2 = new DynArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        arr2.remove(10);
        arr2.remove(9);
        arr2.remove(8);
        arr2.remove(7);
        arr2.remove(6);
        arr2.remove(5);
        arr2.remove(4);
        arr2.remove(3);
        arr2.remove(2);
        arr2.remove(1);
        assertFalse(arr1.equals(arr2));
    }

    @Test
    public void equalEltsTest1() {
        DynArray arr1 = new DynArray(Arrays.asList(5, 6));
        DynArray arr2 = new DynArray(Arrays.asList(5, 6));
        assertTrue(arr1.equalElts(arr2));
    }

    @Test
    public void equalEltsTest2() {
        DynArray arr1 = new DynArray(Arrays.asList(5, 6));
        DynArray arr2 = new DynArray(Arrays.asList(6, 5));
        assertFalse(arr1.equalElts(arr2));
    }

    @Test
    public void equalEltsTest3() {
        DynArray arr1 = new DynArray(Arrays.asList(1, 2));
        DynArray arr2 = new DynArray(Arrays.asList(1, 2, 3));
        assertFalse(arr1.equalElts(arr2));
    }

    @Test
    public void equalEltsTest4() {
        DynArray arr = new DynArray(Arrays.asList(1, 2));
        assertFalse(arr.equalElts("Not an array"));
    }

    @Test
    public void emptyTest1() {
        DynArray arr = DynArray.empty();
        assertEquals(0, arr.length());
    }

    @Test
    public void lengthTest1() {
        DynArray arr = new DynArray(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, arr.length());
    }

    @Test
    public void getTest1() {
        DynArray arr = new DynArray(Arrays.asList(7, 8, 9));
        assertEquals(9, arr.get(2));
    }

    @Test
    public void getTest2() {
        DynArray arr = new DynArray();
        assertThrows(NoSuchElementException.class, () -> arr.get(0));
    }

    @Test
    public void setTest1() {
        DynArray arr = new DynArray(Arrays.asList(1, 2));
        arr.set(0, 99);
        assertEquals(99, arr.get(0));
    }

    @Test
    public void insertTest1() {
        DynArray arr = new DynArray(Arrays.asList(1, 2));
        arr.insert(1, 99);
        assertEquals(99, arr.get(1));
    }

    @Test
    public void insertTest2() {
        DynArray arr = new DynArray(Arrays.asList(1, 2));
        arr.insert(1, 99);
        assertEquals(3, arr.length());
    }

    @Test
    public void insertTest3() {
        DynArray arr = new DynArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        arr.addToEnd(10);
        arr.insert(5, 99);
        assertEquals(99, arr.get(5));
    }

    @Test
    public void addToEndTest1() {
        DynArray arr = new DynArray(Arrays.asList(1));
        arr.addToEnd(2);
        assertEquals(2, arr.get(1));
    }

    @Test
    public void addToEndTest2() {
        DynArray arr = new DynArray(Arrays.asList(1));
        arr.addToEnd(2);
        assertEquals(2, arr.length());
    }

    @Test
    public void addToEndTest3() {
        DynArray arr = new DynArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        arr.addToEnd(10);
        arr.addToEnd(11);
        assertEquals(11, arr.length());
    }

    @Test
    public void addToStartTest1() {
        DynArray arr = new DynArray(Arrays.asList(2));
        arr.addToStart(1);
        assertEquals(1, arr.get(0));
    }

    @Test
    public void addToStartTest2() {
        DynArray arr = new DynArray(Arrays.asList(2));
        arr.addToStart(1);
        assertEquals(2, arr.length());
    }

    @Test
    public void addToStartTest3() {
        DynArray arr = new DynArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        arr.addToEnd(10);
        arr.addToStart(0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void removeTest1() {
        DynArray arr = new DynArray(Arrays.asList(1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(-1));
    }

    @Test
    public void removeTest2() {
        DynArray arr = new DynArray(Arrays.asList(1, 2));
        arr.remove(1);
        assertEquals(new DynArray(List.of(1)), arr);
    }
}