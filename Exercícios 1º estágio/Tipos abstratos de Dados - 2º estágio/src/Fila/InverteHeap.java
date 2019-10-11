package Fila;
import Fila.Fila;

import java.util.Arrays;

public class InverteHeap {

    private Fila fila;
    private Aluno[] array;

    public InverteHeap() {
        this.fila = new Fila(12);
        this.array = this.fila.getArray();
    }

    public void inserir(Aluno aluno) {
        Aluno[] novoArray = new Aluno[this.fila.getCapacity()];
        for (int i = array.length - 1; i >= 0; i--) {
            int cont = 0;
            novoArray[cont] = array[i];
        }
        this.array = novoArray;


    }

    public static void main(String[] args) {
        InverteHeap inverteHeap = new InverteHeap();
        System.out.println(Arrays.toString(inverteHeap.array));
        inverteHeap.inserir();
    }
}
