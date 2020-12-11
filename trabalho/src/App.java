import java.util.ArrayList;

import classes.models.NoArvore;
import classes.models.Pessoa;
import classes.ord.HeapSort;
import classes.ord.QuickSort;
import classes.search.Arvore;
import classes.search.TabelaOrd;
import utils.DataFetcher;

public class App {

    public static void main(String[] args) {
        try {
           Pessoa[] pessoas = new DataFetcher().getPessoasFromFile("src/basedados/conta500alea.txt", 500);
           Arvore arvore = new Arvore(); 
           for (int i = 0; i < pessoas.length; i++) {
                arvore.insere(pessoas[i]);
            }

            Arvore arvoreBalanceada = arvore.arvoreBalanceada(arvore.camCentral(new TabelaOrd(500)));
            ArrayList<Pessoa> listaCpfsAchados= new ArrayList<Pessoa>();
            String[] cpfs = new DataFetcher().getCpfsFromFile("src/basedados/Conta.txt", 400);

            for (int i = 0; i < cpfs.length; i++) {

                NoArvore noarv = null;
                do{
                    noarv = arvoreBalanceada.pesquisar(cpfs[i], arvoreBalanceada.raiz);
                    if(noarv != null){
                        listaCpfsAchados.add(noarv.getPessoa());
                        arvoreBalanceada.raiz = arvoreBalanceada.remove(cpfs[i]);
                    }
                }while(noarv != null);

            //    while(arvoreBalanceada.pesquisa(cpfs[i])){
            //     NoArvore no = arvoreBalanceada.remove(cpfs[i]);
            //     if(no != null){
            //         listaCpfsAchados.add(no.getPessoa());
            //     }       
            //     no = null;
            //    }
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