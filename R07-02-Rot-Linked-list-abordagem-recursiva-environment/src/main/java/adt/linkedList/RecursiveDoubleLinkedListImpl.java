package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	public RecursiveDoubleLinkedListImpl(T data,
										 RecursiveSingleLinkedListImpl<T> next,
										 RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>(getData(), getNext(),
						this);

				((RecursiveDoubleLinkedListImpl) getNext()).setPrevious(newNode);
				setNext(newNode);
				setData(element);
			}
		}
	}

	@Override
	public void removeFirst() {

		if (!isEmpty()) {
			if (getPrevious().isEmpty()) {

				setData(getNext().getData());
				setNext(getNext().getNext());
				if (getNext() != null)
					((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);

			} else
				getPrevious().removeFirst();
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (getNext().isEmpty()) {

				setData(null);
				setNext(null);
				if (getPrevious().isEmpty())
					setPrevious(null);

			} else
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
