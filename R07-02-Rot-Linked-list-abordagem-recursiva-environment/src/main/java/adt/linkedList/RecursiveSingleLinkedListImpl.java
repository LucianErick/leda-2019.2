package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return 1 + this.next.size();
	}

	@Override
	public T search(T element) {
		if (element != null) {
			if (this.next.data == element) {
				return element;
			}
			if (this.next.data == null || isEmpty()) {
				return null;
			}
			return this.next.search(element);
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			}
			else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (getData().equals(element)) {
				setData(this.next.data);
				setNext(this.next.next);
			}
			else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[this.size()];
		toArrayRecursive(result, this, 0);
		return result;
	}

	private void toArrayRecursive(T[] array, RecursiveSingleLinkedListImpl<T> node, int contador) {
		if (!(node.isEmpty())) {
			array[contador] = node.getData();
			toArrayRecursive(array, node.next, ++contador);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}