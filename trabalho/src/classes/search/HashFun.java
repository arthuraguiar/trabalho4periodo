package classes.search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import classes.models.NoHash;
import classes.models.Pessoa;
import utils.DataFetcher;

public class HashFun {

    private int tamanho;
    private NoHash[] vetor;
    private DataFetcher dataFetcher = new DataFetcher();

    public HashFun(int tamanhoInicial) {
        this.tamanho = getSizeofVector(tamanhoInicial);
        this.vetor = new NoHash[tamanho];
    }

    public long rotinaHashArquivo(String inputFileName, int inputRegisterSize, String outPutFileFindName)
            throws Exception {
        long startTime = System.currentTimeMillis();
        Pessoa[] pessoas = dataFetcher.getPessoasFromFile(inputFileName, inputRegisterSize);
        for (int i = 0; i < pessoas.length; i++) {
            insere(pessoas[i]);
        }

        String[] cpfs = dataFetcher.getCpfsFromFile("src/basedados/Conta.txt", 400);
        pesquisa(outPutFileFindName, cpfs);

        long estimatedTime = System.currentTimeMillis() - startTime;

        return estimatedTime;
    }

    public int hashing(String chave) {
        char carac;
        int i, soma = 0;
        for (i = 0; i < chave.length(); i++) {
            carac = chave.charAt(i);
            soma += Character.getNumericValue(carac);
        }
        return soma;
    }

    public void insere(Pessoa pessoa) {
        int hashValue = hashing(pessoa.getCpf());
        NoHash no = new NoHash();
        no.setPessoa(pessoa);
        no.setHashValue(hashValue);
        int posicao = hashValue % tamanho;
        inserePosicao(no, posicao % tamanho);
    }

    private void inserePosicao(NoHash no, int index) {
        try {
            NoHash noVetor = vetor[index];
            if (noVetor == null) {
                vetor[index] = no;
            } else {
                NoHash atual = noVetor;

                if (atual.getProxNo() != null) {
                    do {
                        atual = atual.getProxNo();
                    } while (atual.getProxNo() != null);
                }

                atual.setProxNo(no);
            }
        } catch (Exception e) {
            System.out.println("sdfsdf");
        }

    }

    public int isPrime(int num) {
        int prime = 1;
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
                prime = 0;
            }
        }
        return prime;
    }

    public int nextPrime(int num) {
        num++;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                num++;
                i = 2;
            } else {
                continue;
            }
        }
        return num;
    }

    public int getSizeofVector(int tamanho) {
        int num = (int) (tamanho * 1.1);
        int prime = isPrime(num);
        if (prime == 1) {
            return num;
        } else {
            return nextPrime(num);
        }

    }

    public int nextPrimeB(int num) {

        int prime = 0; // next prime will be assigned to this var

        for (int j = num; j < 15; j++) { // outer loop

            int count = 0;
            for (int i = 2; i <= j / 2; i++) { // inner loop

                if (j % i == 0) {
                    count++;
                }
            }

            if (count == 0) {

                prime = j; // assign next prime
                break;

            }

        }

        return prime;
    }

    public void pesquisa(String outPutFileFindName, String[] cpfs) throws IOException {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < cpfs.length; i++) {
            ArrayList<Pessoa> pessoasEncontradas = new ArrayList<Pessoa>();
            int hashValue = hashing(cpfs[i]);
            int posicao = hashValue % tamanho;
            int index = posicao % tamanho;

            NoHash noAtual = vetor[index];
            NoHash noAnterior = null;

            while (noAtual != null) {
                if (noAtual != null && noAtual.getPessoa().getCpf().equals(cpfs[i])) {
                    pessoasEncontradas.add(noAtual.getPessoa());

                    // quando é a raiz
                    if (noAtual == vetor[index]) {
                        if (noAtual.getProxNo() == null) {
                            vetor[index] = null;
                        } else {
                            vetor[index] = noAtual.getProxNo();
                        }
                    } else {
                        noAnterior.setProxNo(noAtual.getProxNo());
                    }
                } else {
                    noAnterior = noAtual;
                }

                noAtual = noAtual.getProxNo();
            }

            String texto;
            if (pessoasEncontradas.size() <= 0) {
                texto = "CPF " + cpfs[i] + ":\nNÃO HÁ NENHUM REGISTRO COM O CPF 12345612344\n";
            } else {
                double saldo = 0;
                texto = "CPF" + cpfs[i] + "     " + pessoasEncontradas.get(0).getNome() + "\n";
                for (Pessoa pessoa : pessoasEncontradas) {
                    texto += pessoa.getInfo() + "\n";
                    saldo += Double.parseDouble(pessoa.getSaldo());
                }
                texto += "Saldo Total: " + saldo + "\n";
            }
            sbf.append(texto + "\n\n\n");
        }
        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(outPutFileFindName)));

        bwr.write(sbf.toString());

        bwr.flush();

        bwr.close();
    }

}
