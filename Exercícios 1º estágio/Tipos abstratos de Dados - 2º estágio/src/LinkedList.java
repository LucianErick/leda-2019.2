import java.util.Scanner;

class LinkedList {

    private int capacidade;
    private int iterador;
    private Node head;
    private Node tail;


    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList listaEncadeada = new LinkedList();

        String operacao = "";
        while (!operacao.equals("end")) {
            operacao = sc.next();

            if (operacao.equals("add")) {
                int valor = sc.nextInt();
                sc.nextLine();
                listaEncadeada.add(valor);
            } else if (operacao.equals("remove")) {
                listaEncadeada.remove();
            } else if (operacao.equals("element")) {
                System.out.println(listaEncadeada.element());
            } else if (operacao.equals("search")) {
                int valor = sc.nextInt();
                sc.nextLine();
                System.out.println(listaEncadeada.search(valor));
            } else if (operacao.equals("print")) {
                System.out.println(listaEncadeada.print());
            }
        }
    }

    public String print() {
        String saida = this.print(this.head);
        char c = ' ';
        for (int i = 0; i < saida.length(); i++) {
            c = saida.charAt(i);
        }
        if (c == ' ' && saida.length() > 0) {
            saida = saida.substring(0, saida.length() - 1);
        }
        return saida;
    }

    private String print(Node node) {
        if (isEmpty()) {
            return "empty";
        }
        if (node == null) {
            return "";
        } else {
            return node.toString() + " " + print(node.next);
        }
    }

    public int search(int valor) {
        return search(this.head, valor, 0);
    }

    private int search(Node node, int valor, int iteracao) {
        if (node == null) {
            return -1;
        }
        if (node.value == valor) {
            return iteracao;
        }
        else {
            iteracao++;
            return search(node.next, valor, iteracao);
        }
    }

    public String element() {
        if (isEmpty()) {
            return "empty";
        }
        else {
            return Integer.toString(this.head.value);
        }
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }

        remove(this.head);
    }

    private void remove(Node node) {
        if (this.head == null) {
            System.out.println("empty");
            return;
        }

        if (node.equals(this.head)) {
            this.head = node.next;
            return;
        }
        remove(node.next);
    }

    public void add(int valor) {
        if (isEmpty()) {
            this.head = new Node(valor);
            this.tail = this.head;
        }

        else {
            this.add(this.head, valor);
        }
    }

    private void add(Node node, int valor) {
        if (node.next == null) {
            Node newNode = new Node(valor);
            node.next = newNode;
            newNode.prev = node;
        }
        else {
            add(node.next, valor);
        }
    }

    private boolean isEmpty() {
        if (this.head == null && this.tail == null) return true;
        return false;
    }
}

class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return String.format("%s", this.value);
    }
}
