package DoubleLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    DoubleLinkedList doubleLinkedList;

    @BeforeEach
    void setUp() {
        doubleLinkedList = new DoubleLinkedList();
    }

    @Test
    void addLast() {
        doubleLinkedList.addLast(1);
        assertEquals(1, doubleLinkedList.getTail().valor);
        doubleLinkedList.addLast(69);
        assertEquals(69, doubleLinkedList.getTail().valor);
        doubleLinkedList.addLast(3);
        assertEquals(3, doubleLinkedList.getTail().valor);
    }

    @Test
    void size() {
        assertEquals(0, doubleLinkedList.size());
        doubleLinkedList.addLast(23);
        doubleLinkedList.addLast(69);
        doubleLinkedList.addLast(36);
        doubleLinkedList.addLast(96);
        doubleLinkedList.addLast(12);
        doubleLinkedList.addLast(2);
        assertEquals(6, doubleLinkedList.size());
    }

    @Test
    void soma() {
        assertEquals(0, doubleLinkedList.soma());
        doubleLinkedList.addLast(12);
        assertEquals(12, doubleLinkedList.soma());
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(32);
        doubleLinkedList.addLast(20);
        assertEquals(67, doubleLinkedList.soma());

    }

    @Test
    void isSorted() {
        assertTrue(doubleLinkedList.isSorted());
        doubleLinkedList.addLast(1);
        assertTrue(doubleLinkedList.isSorted());
        doubleLinkedList.addLast(1);
        assertTrue(doubleLinkedList.isSorted());
        doubleLinkedList.addLast(2);
        assertTrue(doubleLinkedList.isSorted());
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(6);
        assertTrue(doubleLinkedList.isSorted());
        doubleLinkedList.addLast(-1);
        assertFalse(doubleLinkedList.isSorted());
    }

    @Test
    void add() {
        assertNull(doubleLinkedList.getTail());
        assertNull(doubleLinkedList.getHead());
        doubleLinkedList.addLast(0);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(8);
        doubleLinkedList.addLast(10);
        assertTrue(doubleLinkedList.isSorted());
        doubleLinkedList.add(2, 23);
        assertFalse(doubleLinkedList.isSorted());
        assertEquals(53, doubleLinkedList.soma());
        assertEquals(23, doubleLinkedList.getHead().proximo.proximo.valor);
    }

    @Test
    void remove() {
        assertNull(doubleLinkedList.getTail());
        assertNull(doubleLinkedList.getHead());
        assertEquals(0, doubleLinkedList.size());
        doubleLinkedList.addLast(0);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(8);
        doubleLinkedList.addLast(10);
        assertTrue(doubleLinkedList.isSorted());
        doubleLinkedList.add(2, 23);
        assertFalse(doubleLinkedList.isSorted());
        assertEquals(53, doubleLinkedList.soma());
        assertEquals(23, doubleLinkedList.getHead().proximo.proximo.valor);
        assertEquals(7, doubleLinkedList.size());
        doubleLinkedList.remove(2);
        assertEquals(6, doubleLinkedList.size());
        doubleLinkedList.remove(2);
        assertEquals(5, doubleLinkedList.size());
        doubleLinkedList.remove(0);
        assertEquals(2, doubleLinkedList.getHead().valor);
    }
}