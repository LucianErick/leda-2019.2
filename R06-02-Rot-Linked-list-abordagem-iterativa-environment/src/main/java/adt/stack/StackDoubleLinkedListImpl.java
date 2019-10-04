package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		else {
			if (element != null) {
				this.top.insert(element);
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T element;
		if (this.isEmpty()) {
			element = null;
		}
		else {
			element = this.top.toArray()[this.top.size() - 1];
			this.top.removeLast();
		}
		return element;
	}

	@Override
	public T top() {
		T value;
		if (this.isEmpty()) {
			value = null;
		}
		else {
			value = this.top.toArray()[this.top.size() - 1];
		}
		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
