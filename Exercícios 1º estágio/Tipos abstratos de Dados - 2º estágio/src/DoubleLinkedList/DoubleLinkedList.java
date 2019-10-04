package DoubleLinkedList;

public class DoubleLinkedList {
    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void addLast(int elemento) {
        Node newNode = new Node(elemento);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = head;
        }
        else {
            addLast(this.head, elemento);
        }
    }

    private void addLast(Node node, int elemento) {
        Node newNode = new Node(elemento);
        if (node.proximo == null) {
            node.proximo = newNode;
            newNode.anterior = node;
            this.tail = newNode;
            return;
        }
        addLast(node.proximo, elemento);
    }

    public int size() {
        if (isEmpty()) return 0;
        return size(this.head);
    }

    private int size(Node node) {
        if (node.proximo == null) {
            return 1;
        }
        return 1 + size(node.proximo);
    }

    public int soma() {
        if (isEmpty()) return 0;
        return soma(this.head);
    }

    private int soma(Node node) {
        if (node.proximo == null) {
            return node.valor;
        }
        return node.valor + soma(node.proximo);
    }

    public boolean isSorted() {
        if (isEmpty()) {
            return true;
        }
        return isSorted(this.head);
    }

    private boolean isSorted(Node node) {
        if (node.proximo == null) {
            return true;
        }
        if (node.valor > node.proximo.valor) {
            return false;
        }
        return isSorted(node.proximo);
    }

    public void add(int index, int elemento) {
        int contador = 0;
        Node auxNode = this.head;
        Node newNode = new Node(elemento);
        while (auxNode.proximo != null) {
            if (contador == index) {
                auxNode.anterior.proximo = newNode;
                newNode.anterior = auxNode.anterior;
                auxNode.anterior = newNode;
                newNode.proximo = auxNode;
            }
            auxNode = auxNode.proximo;
            contador++;
        }
    }

    public void remove(int index) {
        int contador = 0;
        Node auxNode = this.head;
        if (!isEmpty()) {

            while (auxNode.proximo != null) {
                if (contador == index) {
                    if (auxNode.equals(getHead())) {
                        this.head = this.head.proximo;
                    } else {
                        auxNode.anterior.proximo = auxNode.proximo;
                        auxNode.proximo.anterior = auxNode.anterior;
                    }
                }
                auxNode = auxNode.proximo;
                contador++;
            }
        }
    }

    private boolean isEmpty(){
        return getHead() == null && getTail() == null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
