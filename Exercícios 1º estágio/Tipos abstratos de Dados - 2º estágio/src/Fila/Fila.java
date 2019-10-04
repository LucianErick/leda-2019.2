package Fila;

public class Fila {
    private int head;
    private int tail;
    private int capacity;
    private int[] array;

    public Fila() {
        this.head = -1;
        this.tail = -1;
        this.capacity = 20;
        this.array = new int[capacity];
    }

    public boolean enqueue(int value) {}
    public boolean dequeue() {}
    public int peek() {}


    private boolean isFull() {
        return (getTail() + 1) % getCapacity() == getHead();
    }

    private boolean isEmpty() {
        return getHead() == -1 && getTail() == -1;
    }

    private void shiftLeft(int index) {
        if (index > this.array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getCapacity() {
        return capacity;
    }

    public int[] getArray() {
        return array;
    }
}
