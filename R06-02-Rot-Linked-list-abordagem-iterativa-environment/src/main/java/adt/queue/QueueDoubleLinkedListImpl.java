package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

   protected DoubleLinkedList<T> list;
   protected int size;

   public QueueDoubleLinkedListImpl(int size) {
      this.size = size;
      this.list = new DoubleLinkedListImpl<T>();
   }

   @Override
   public void enqueue(T element) throws QueueOverflowException {
      if (this.isFull()) {
         throw new QueueOverflowException();
      } else {
         this.list.insert(element);
      }
   }

   @Override
   public T dequeue() throws QueueUnderflowException {
      T value;
      if (this.isEmpty()) {
         throw new QueueUnderflowException();
      } else {
         value = this.list.toArray()[0];
         this.list.removeFirst();
      }
      return value;
   }

   @Override
   public T head() {
      T value;
      if (this.isEmpty()) {
         value = null;
      } else {
         value = this.list.toArray()[0];
      }
      return value;
   }

   @Override
   public boolean isEmpty() {
      return this.list.isEmpty();
   }

   @Override
   public boolean isFull() {
      return this.list.size() == size;
   }

}
