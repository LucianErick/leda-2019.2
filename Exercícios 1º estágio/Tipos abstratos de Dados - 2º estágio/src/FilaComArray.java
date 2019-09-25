import java.util.Scanner;

class FilaComArray {

    private int[] array;
    private int capacidade, head, tail;

    public FilaComArray(int capacidade) {
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
        this.array = new int[capacidade];
    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int tamanhoFila = sc.nextInt();
            sc.nextLine();

            FilaComArray fila = new FilaComArray(tamanhoFila);

            String operacao = "";
            while (!operacao.equals("end")) {
                operacao = sc.next();

                if (operacao.equals("add")) {
                    int valor = sc.nextInt();
                    sc.nextLine();
                    fila.add(valor);
                }

                else if (operacao.equals("remove")) {
                    fila.remove();
                }

                else if (operacao.equals("element")) {
                    System.out.println(fila.element());
                }

                else if (operacao.equals("print")){
                    String saida = fila.print();
                    char c = ' ';
                    for (int i = 0; i < saida.length(); i++) {
                        c = saida.charAt(i);
                    }
                    if (c == ' ' && saida.length() > 0) {
                        saida = saida.substring(0, saida.length() - 1);
                    }
                    System.out.println(saida);
                }
            }
    }

    private String print() {
        String saida = "";
        if (isEmpty()) {
            saida = "empty";
        }

        else if (!isEmpty()){
            for (int i = this.head; i <= this.tail; i++) {
                saida += this.array[i] + " ";
            }
        }
        return saida;
    }

    private String element() {
        String saida = "";
        if (isEmpty()) {
            saida = "empty";
        }
        else {
            saida = Integer.toString(this.array[this.head]);
        }
        return saida;
    }

    private void remove() {
        if (isEmpty()) {
            System.out.println("empty");
        }
        else {
            if (this.head == this.tail) {
                this.head = -1;
                this.tail = -1;

            }
            else {
                this.head = ((this.head + 1) % this.capacidade);
                shiftLeft();
            }
        }
    }

    private void add(int valor) {

        if (isEmpty() && this.array.length != 0) {
            this.head = 0;
            this.tail = 0;
            this.array[head] = valor;
        }
        else if (isFull()) {
            System.out.println("full");
        }
        else {
            if (this.array.length > 0) {
                this.tail = (this.tail + 1) % this.capacidade;
                this.array[this.tail] = valor;
            }
        }
    }

    private boolean isFull() {
        if (array.length == 0) {
            return false;
        }
        return (this.tail + 1) % this.capacidade == this.head;
    }

    private boolean isEmpty() {
        return (this.head == -1 && this.tail == -1);
    }

    private void shiftLeft() {
        int temp = 0;
        for(int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.tail] = temp;
        this.tail--;
    }
}