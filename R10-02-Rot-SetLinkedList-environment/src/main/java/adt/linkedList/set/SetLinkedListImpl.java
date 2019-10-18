package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {

		SingleLinkedListNode<T> atual = this.head;
		int contadorRepeticoes = 0;
		while (!atual.isNIL()) {
			contadorRepeticoes = 1;
			SingleLinkedListNode<T> auxiliar = atual;
			while (!auxiliar.isNIL()) {
                System.out.println("o auxiliar da vez eh o " + auxiliar);
			    if (atual != auxiliar && atual.getData().equals(auxiliar.getData())) {
					contadorRepeticoes++;
				}
				auxiliar = auxiliar.getNext();
			}
			if (contadorRepeticoes >= 2) {
			    SingleLinkedListNode auxTroca = atual;
                System.out.println("elimina o " + atual.getData());
			    while (!auxTroca.isNIL()) {
                    if (auxTroca.getNext().getData() == null) {
                        auxTroca.setData(null);
                    } else {
                        auxTroca.setData(auxTroca.getNext().getData());
                    }
                    auxTroca = auxTroca.getNext();
                }
			}

			atual = atual.getNext();
        }
	}
	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public static void main(String[] args) {
		SetLinkedListImpl<Integer> setLinkedList = new SetLinkedListImpl();
		setLinkedList.insert(1);
        setLinkedList.insert(3);
        setLinkedList.insert(1);
        setLinkedList.insert(1);
        setLinkedList.insert(2);
        setLinkedList.insert(3);
        System.out.println("original => " + Arrays.toString(setLinkedList.toArray()));
		setLinkedList.removeDuplicates();
		System.out.println("nova => " + Arrays.toString(setLinkedList.toArray()));
	}

}
