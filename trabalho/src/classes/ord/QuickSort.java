package classes.ord;

import classes.models.Pessoa;

public class QuickSort {
    private Pessoa[] vetor;
    private int nElem;

    public QuickSort(Pessoa[] vetor, int nElem) {
        this.vetor = vetor;
        this.nElem = nElem;
    }

    public void quicksort() {
        ordena(0, vetor.length - 1);
        System.out.println("qualquer coisa ai");
    }

    private void ordena(int esq, int dir) {
        int i = esq, j = dir;
        Pessoa pivo;
        Pessoa temp;

        pivo = this.vetor[(i + j) / 2];
        do {
            while (isFirst(this.vetor[i], pivo))
                i++;
            while (isFirst(pivo,this.vetor[j]))
                j--;
            if (i <= j) {

                temp = this.vetor[i];
                this.vetor[i] = this.vetor[j];
                this.vetor[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (esq < j)
            ordena(esq, j);
        if (dir > i)
            ordena(i, dir);
    }

    private boolean isFirst(Pessoa pessoa1, Pessoa pessoa2) {
        int compareCpfResult = pessoa1.getCpf().compareTo(pessoa2.getCpf());
        if (compareCpfResult < 0) {
            return true;
        } else if (compareCpfResult == 0) {
            int compareAgenciaResult = pessoa1.getAgencia().compareTo(pessoa2.getAgencia());
            if (compareAgenciaResult < 0) {
                return true;
            } else if (compareAgenciaResult == 0) {
                int compareContaResult = pessoa1.getConta().compareTo(pessoa2.getConta());
                return (compareContaResult < 0);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
