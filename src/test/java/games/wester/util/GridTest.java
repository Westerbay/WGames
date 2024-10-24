package games.wester.util;

/*
 * Wester
 * This code is open source and free to use.
 *
 * You are free to copy, modify, and distribute this file without restriction.
 * No warranties are provided, and any use of this code is at your own risk.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wester
 */
public class GridTest {

    public int returnValue(int value) {
        return value;
    }

    @Test
    public void test_fill_with_same_value() {
        Grid<Integer> gridInteger = new Grid<>(new Integer[5][10], 5);
        assertEquals(5, gridInteger.get(0));
        assertEquals(5, gridInteger.get(49));
        assertEquals(5, gridInteger.get(30));

        gridInteger = new Grid<>(new Integer[5][10], -20);
        assertEquals(-20, gridInteger.get(0));
        assertEquals(-20, gridInteger.get(49));
        assertEquals(-20, gridInteger.get(30));
    }

    @Test
    public void test_fill_with_constructor() {
        Grid<GridTest> gridTest = new Grid<>(new GridTest[5][10], GridTest::new);
        assertNotEquals(gridTest.get(49), gridTest.get(30));
        assertNotEquals(gridTest.get(0), gridTest.get(30));
        assertNotEquals(gridTest.get(0), gridTest.get(49));
        assertEquals(40, gridTest.get(30).returnValue(40));
    }

    @Test
    public void test_get_one_argument_exception() {
        Grid<Integer> grid = new Grid<>(new Integer[5][10]);
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(50));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(-5));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(60));
    }

    @Test
    public void test_get_two_arguments_exception() {
        Grid<Integer> grid = new Grid<>(new Integer[5][10]);
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(5, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(4, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(-1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(5, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(-10, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(5, -10));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(60, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.get(0, 60));
    }

    @Test
    public void test_set_two_arguments_exception() {
        Grid<Integer> grid = new Grid<>(new Integer[5][10]);
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(50, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(-5, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(60, 0));
    }

    @Test
    public void test_set_three_arguments_exception() {
        Grid<Integer> grid = new Grid<>(new Integer[5][10]);
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(5, 5, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(4, 10, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(-1, 5, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(5, -1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(-10, 5, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(5, -10, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(60, 0, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> grid.set(0, 60, 0));
    }

    @Test
    public void test_setter_behaviour() {
        Grid<Integer> grid = new Grid<>(new Integer[5][10]);

        int value = 1;
        grid.set(0, 0, value);
        assertEquals(value, grid.get(0));
        assertEquals(value, grid.get(0, 0));

        value = 2;
        grid.set(2, 0, value);
        assertEquals(value, grid.get(20));
        assertEquals(value, grid.get(2, 0));

        value = 3;
        grid.set(0, 2, value);
        assertEquals(value, grid.get(2));
        assertEquals(value, grid.get(0, 2));

        value = 4;
        grid.set(1, 2, value);
        assertEquals(value, grid.get(12));
        assertEquals(value, grid.get(1, 2));
    }

}
