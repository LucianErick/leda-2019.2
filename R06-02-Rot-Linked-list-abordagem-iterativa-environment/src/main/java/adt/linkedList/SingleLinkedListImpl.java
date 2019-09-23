package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) return true;
		return false;

	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode auxHead = this.head;
		while (auxHead.next != null) {
			size ++;
			auxHead = auxHead.next;
		}
		return size;
	}

	@Override
	public T search(T element) {

		SingleLinkedListNode auxHead = this.head;

		while (auxHead.next != null) {

			if (auxHead.data == element) {
				return element;
			}
			auxHead = auxHead.next;
		}

		return null;

	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode auxHead = this.head;
		while (auxHead.next != null) {
			auxHead = auxHead.next;
		}

		auxHead.next = new SingleLinkedListNode(element, null);
	}

	@Override
	public void remove(T element) {

		SingleLinkedListNode auxHead = this.head;
		while (auxHead.next != null) {
			if (auxHead.next.data == element) {
				auxHead.next = auxHead.next.next;
			}
			auxHead = auxHead.next;
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}