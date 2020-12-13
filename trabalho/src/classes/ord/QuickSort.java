package classes.ord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import classes.models.Pessoa;
import classes.search.PesquisaBinaria;
import utils.DataFetcher;

public class QuickSort {
    private Pessoa[] vetor;
    private DataFetcher dataFetcher = new DataFetcher();

    public long rotinaQuickArquivo(String inputFileName, int inputRegisterSize, String outputFileName,
            String outPutFileFindName) throws Exception {

        long startTime = System.currentTimeMillis();

        vetor = dataFetcher.getPessoasFromFile(inputFileName, inputRegisterSize);
        quicksort();
        dataFetcher.writeFile(outputFileName, vetor);

        String[] cpfs = dataFetcher.getCpfsFromFile("src/basedados/Conta.txt", 400);

        PesquisaBinaria pesquisaBinaria = new PesquisaBinaria(vetor);

        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < cpfs.length; i++) {
            sbf.append(pesquisaBinaria.removeChave(cpfs[i]) + "\n\n\n");
        }

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(outPutFileFindName)));

        bwr.write(sbf.toString());

        bwr.flush();

        bwr.close();

        long estimatedTime = System.currentTimeMillis() - startTime;

        return estimatedTime;
    }

    public void quicksort() {
        ordena(0, vetor.length - 1);
    }

    private void ordena(int esq, int dir) {
        int i = esq, j = dir;
        Pessoa pivo;
        Pessoa temp;

        pivo = this.vetor[(i + j) / 2];
        do {
            while (isFirst(this.vetor[i], pivo))
                i++;
            while (isFirst(pivo, this.vetor[j]))
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
