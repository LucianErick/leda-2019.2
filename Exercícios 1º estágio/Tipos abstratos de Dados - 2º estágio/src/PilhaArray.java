import java.util.Scanner;

public class PilhaArray {

    private int[] array;
    private int capacidade, top;

    public PilhaArray(int capacidade) {
        this.capacidade = capacidade;
        this.top = -1;
        this.array = new int[capacidade];
    }

    private boolean isFull() {
        if (this.top == this.capacidade - 1) return true;
        return false;
    }

    private boolean isEmpty() {
        if (this.top == -1) return true;
        return false;
    }

    public String print() {
        String saida = "";
        if (isEmpty()) {
            saida = "empty";
        }
        else {
            for (int i = 0; i <= top; i++) {
                saida += this.array[i] + " ";
            }
            if (saida.length() > 0) {
                saida = saida.substring(0, saida.length() - 1);
            }
        }
        return saida;
    }

    public String peek() {
        String saida = "";
        if (isEmpty()) {
            saida = "empty";
        }
        else {
            saida = Integer.toString(this.array[this.top]);
        }
        return saida;
    }

    public void push(int valor) {
        if (isFull()) {
            System.out.println("full");
        }
        else {
            this.top++;
            this.array[this.top] = valor;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("empty");
        }
        this.top--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanhoPilha = sc.nextInt();
        sc.nextLine();

        PilhaArray pilha = new PilhaArray(tamanhoPilha);


        String operacao = "";
        int top = -1;

        while (!operacao.equals("end")) {
            operacao = sc.next();

            if (operacao.equals("pop")) {
                pilha.pop();
            }
            else if (operacao.equals("push")) {
                int valor = sc.nextInt();
                sc.nextLine();
                pilha.push(valor);
            }
            else if (operacao.equals("peek")) {
                System.out.println(pilha.peek());
            }
            else if (operacao.equals("print")){
                System.out.println(pilha.print());
            }
        }
    }
}
