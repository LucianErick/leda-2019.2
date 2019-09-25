package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

import java.util.Random;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public static void main(String[] args) {
		QueueDoubleLinkedListImpl queue = new QueueDoubleLinkedListImpl(6);
		System.out.println(queue.isEmpty());
	}


	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T head() {
		if (this.isEmpty()) {
			return null;
		}
	}

	private int getHeadPosition() {
		if (this)
	}

	@Override
	public boolean isEmpty() {
		if (this.list.size() == 0) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (this.list.size() == size) return true;
		return false;
	}

}
