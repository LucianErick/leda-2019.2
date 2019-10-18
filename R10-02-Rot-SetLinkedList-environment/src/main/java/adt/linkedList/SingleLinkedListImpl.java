package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int sizeList = 0;
		SingleLinkedListNode<T> auxHead = this.head;

		while (!auxHead.isNIL()) {
			sizeList++;
			auxHead = auxHead.getNext();
		}
		return sizeList;
	}

	@Override
	public T search(T element) {
		T node = null;
		SingleLinkedListNode<T> auxHead = this.head;

		while (!auxHead.isNIL()) {
			if (auxHead.getData().equals(element))
				node = auxHead.getData();

			auxHead = auxHead.getNext();
		}
		return node;
	}

	@Override
	public void insert(T element) {

		if (element != null) {
			if (this.isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<T>());
			} else {
				SingleLinkedListNode<T> auxHead = this.head;
				while (!auxHead.isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setData(element);
				auxHead.setNext(new SingleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !this.isEmpty()) {
			if (head.getData().equals(element)) {
				this.head = this.head.getNext();
			} else {

				SingleLinkedListNode<T> auxHead = this.head;
				boolean removed = false;
				while (!(auxHead.next == null) && !removed) {
					if (auxHead.getNext().getData().equals(element)) {
						auxHead.setNext(auxHead.getNext().getNext());
						removed = true;
					}
					auxHead = auxHead.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> auxHead = this.head;
		T[] array = (T[]) new Comparable[this.size()];

		int i = 0;
		if (!this.isEmpty()) {
			while (!auxHead.isNIL()) {
				array[i] = auxHead.getData();
				auxHead = auxHead.getNext();
				i++;
			}
		}
		return array;
	}
}