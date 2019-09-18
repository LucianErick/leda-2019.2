package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (!isEmpty()){
			for (T element : this.array) {
				if (element != null)
					return element;
			}
		}
		return null;
	}

	private int headPosition() {
		if (!isEmpty()) {
			for (int i = 0; i < this.array.length; i++)
				if (this.array[i].equals(head())) return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.array.length) == headPosition();
	}

	private void shiftLeft() {
		int moveLeft = 0;
		for (T t : array) {
			if (t == null) moveLeft++;
		}

		if (moveLeft > 0) {
			int k = 0;
			for (int i = moveLeft; i < this.array.length; i++) {
				this.array[k] = this.array[i];
			}
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		int head = 0;
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (isEmpty()) {
			this.tail = 0;
			head = 0;
			this.array[head] = element;
		} else {
			tail = (tail + 1) % this.array.length;
			this.array[tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		int head = headPosition();
		T value = array[head];
		if (isEmpty()){
			throw new QueueUnderflowException();}

		if (head == this.tail) {
			this.array[head] = null;
			head = -1;
			this.tail = -1;
		} else {
			this.array[head] = null;
			head = ((head + 1) % this.array.length);
		}
		return value;
	}
}
