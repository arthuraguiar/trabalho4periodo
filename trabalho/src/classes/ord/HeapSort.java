package classes.ord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import classes.models.Pessoa;
import classes.search.PesquisaBinaria;
import utils.DataFetcher;

public class HeapSort {
    private DataFetcher dataFetcher = new DataFetcher();
    private Pessoa[] pessoas;

    public void rotinaHeapArquivo(String inputFileName, int inputRegisterSize, String outputFileName) throws Exception {
        long startTime = System.currentTimeMillis();

        pessoas = dataFetcher.getPessoasFromFile(inputFileName, inputRegisterSize);
        heapSort(inputRegisterSize);
        dataFetcher.writeFile(outputFileName, pessoas);

        String[] cpfs = dataFetcher.getCpfsFromFile("src/basedados/Conta.txt", 400);

        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria(pessoas);

        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < cpfs.length; i++) {
            sbf.append(pesquisaBinaria.removeChave(cpfs[i])+ "\n\n\n");
        }

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("src/generated/testesaida.txt")));

        // write contents of StringBuffer to a file
        bwr.write(sbf.toString());

        // flush the stream
        bwr.flush();

        // close the stream
        bwr.close();

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Demorou " + estimatedTime);
    }

    public void heapSort(int nElem) {
        int dir = nElem - 1;
        int esq = (dir - 1) / 2;
        Pessoa temp;

        while (esq >= 0) {
            refazHeap(esq, nElem - 1);
            esq--;
        }
        while (dir > 0) {
            temp = pessoas[0];
            pessoas[0] = pessoas[dir];
            pessoas[dir] = temp;
            dir--;
            refazHeap(0, dir);
        }
    }

    private void refazHeap(int esq, int dir) {
        int i = esq;
        int mF = 2 * i + 1; // maior filho
        Pessoa raiz = pessoas[i];
        boolean heap = false;

        while ((mF <= dir) && (!heap)) {
            if (mF < dir)
                if (isFirst(pessoas[mF], pessoas[mF + 1]))
                    mF++;
            if (isFirst(raiz, pessoas[mF])) {
                pessoas[i] = pessoas[mF];
                i = mF;
                mF = 2 * i + 1;
            } else
                heap = true;
        }
        pessoas[i] = raiz;
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
