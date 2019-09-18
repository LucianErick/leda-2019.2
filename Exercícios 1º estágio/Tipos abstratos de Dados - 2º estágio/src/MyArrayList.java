public class MyArrayList {

    private Object[] list;
    private int size;

    public MyArrayList() {
        this.size = 0;
        this.list = new Object[20];
    }

    public Object[] getList() {
        return list;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isFull() {
        return this.size == this.list.length;
    }

    public void add(Object element) {
        if (!isFull()) {
            this.list[size()] = element;
        }
        else {
            resize();
        }
        this.size++;
    }

    public void add(int index, Object element) {
        if (onBoundsOfArray(index)) {
            this.list[index] = element;
        }
        this.size++;
    }

    private void resize() {
        Object[] newList = new Object[this.list.length * 2];
        for (int i = 0; i < this.list.length; i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
    }

    public Object get(int index) {
            if (onBoundsOfArray(index)) { return this.list[index]; }
            else { throw new IllegalArgumentException(); }
    }

    public int indexOf(Object o) {
        for (int i = 0; i < getList().length; i++) {
            if (o.equals(this.list[i])) return i;
        }
        return -1;
    }

    private boolean onBoundsOfArray(int index) {
        return index >= 0 && index < this.list.length;
    }
}