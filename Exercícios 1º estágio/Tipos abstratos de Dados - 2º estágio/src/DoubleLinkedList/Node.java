package DoubleLinkedList;

import java.util.Objects;

public class Node {
    int valor;
    Node proximo;
    Node anterior;

    public Node(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return valor == node.valor &&
                Objects.equals(proximo, node.proximo) &&
                Objects.equals(anterior, node.anterior);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, proximo, anterior);
    }
}
