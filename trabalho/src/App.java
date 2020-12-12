import java.util.ArrayList;

import classes.models.HashFun;
import classes.models.NoHash;
import classes.models.Nodo;
import classes.models.Pessoa;
import classes.ord.HeapSort;
import classes.ord.QuickSort;
import classes.search.ArvoreAvl;
import utils.DataFetcher;

public class App {

    public static void main(String[] args) {
        try {
            Pessoa[] pessoas = new DataFetcher().getPessoasFromFile("src/basedados/conta500alea.txt", 500);
            HashFun hash = new HashFun(500);
            for (int i = 0; i < pessoas.length; i++) {
                hash.insere(pessoas[i]);
            }

            String[] cpfs1 = new DataFetcher().getCpfsFromFile("src/basedados/Conta.txt", 400);
            ArrayList<Pessoa> listaCpfsAchados2= new ArrayList<Pessoa>();
            hash.pesquisa(cpfs1);
            System.out.println("sdfgsdf");
            // Arvore arvore = new Arvore();
            // for (int i = 0; i < pessoas.length; i++) {
            // arvore.insere(pessoas[i]);
            // }

            // Arvore arvoreBalanceada = arvore.arvoreBalanceada(arvore.camCentral(new
            // TabelaOrd(500)));
            // ArrayList<Pessoa> listaCpfsAchados= new ArrayList<Pessoa>();
            // String[] cpfs = new DataFetcher().getCpfsFromFile("src/basedados/Conta.txt",
            // 400);

            // for (int i = 0; i < cpfs.length; i++) {

            // NoArvore noarv = null;
            // do{
            // noarv = arvoreBalanceada.pesquisar(cpfs[i], arvoreBalanceada.raiz);
            // if(noarv != null){
            // listaCpfsAchados.add(noarv.getPessoa());
            // arvoreBalanceada.raiz = arvoreBalanceada.remove(cpfs[i]);
            // }
            // }while(noarv != null);

            // }

            ArvoreAvl avl = new ArvoreAvl();
            for (int i = 0; i < pessoas.length; i++) {
                avl.insereRaiz(pessoas[i]);
            }

            ArrayList<Pessoa> listaCpfsAchados = new ArrayList<Pessoa>();
            String[] cpfs = new DataFetcher().getCpfsFromFile("src/basedados/Conta.txt", 400);

            for (int i = 0; i < cpfs.length; i++) {

                Nodo noarv = null;
                do {
                    noarv = avl.pesquisar(cpfs[i], avl.raiz);
                    if (noarv != null) {
                        listaCpfsAchados.add(noarv.getPessoa());
                        avl.raiz = avl.remove(cpfs[i]);
                    }
                } while (noarv != null);

            }

            System.out.println("teste");

            QuickSort quick = new QuickSort(pessoas, 500);
            quick.quicksort();

            HeapSort heapSort = new HeapSort();
            heapSort.rotinaHeapArquivo("src/basedados/conta500alea.txt", 500, "src/generated/HeapAlea500.txt",
                    "src/generated/HeapAleaEncontrados500.txt");
            heapSort.rotinaHeapArquivo("src/basedados/conta500inv.txt", 500, "src/generated/HeapIve500.txt",
                    "src/generated/HeapInvEncontrados500.txt");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Fim");

    }

}