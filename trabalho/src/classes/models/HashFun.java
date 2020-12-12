package classes.models;

import java.util.ArrayList;

public class HashFun {

    private int tamanho;
    private NoHash[] vetor;

    public HashFun(int tamanhoInicial) {
        this.tamanho = getSizeofVector(tamanhoInicial);
        this.vetor = new NoHash[tamanho];
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
        if (index > 499) {
            System.out.println("sdfsdf");
        }

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

    public void pesquisa(String[] cpfs) {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (int i = 0; i < cpfs.length; i++) {
            int hashValue = hashing(cpfs[i]);
            int posicao = hashValue % tamanho;
            int index = posicao % tamanho;

            NoHash noAtual = vetor[index];
            NoHash noAnterior = null;
           
            while(noAtual != null){
                if(noAtual !=null && noAtual.getPessoa().getCpf().equals(cpfs[i])){
                    pessoas.add(noAtual.getPessoa());

                    // quando é a raiz
                    if(noAtual == vetor[index]){
                        if(noAtual.getProxNo() == null){
                            vetor[index] = null;
                        }else{
                            vetor[index] = noAtual.getProxNo();
                        }
                    } else {
                        noAnterior.setProxNo(noAtual.getProxNo());
                    }
                }else{
                    noAnterior = noAtual;
                }

                noAtual = noAtual.getProxNo();
            }
        }

        System.out.println("sdfgsdfsad");

    }

}
