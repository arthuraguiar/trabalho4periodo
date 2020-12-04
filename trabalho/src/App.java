import classes.models.Pessoa;
import classes.ord.HeapSort;
import classes.ord.QuickSort;
import utils.DataFetcher;

public class App {

    public static void main(String[] args) {
        try {
           Pessoa[] pessoas = new DataFetcher().getPessoasFromFile("src/basedados/conta500alea.txt", 500);
           QuickSort quick = new QuickSort(pessoas, 500);
           quick.quicksort();

        //     HeapSort heapSort = new HeapSort();
        //     heapSort.rotinaHeapArquivo("src/basedados/conta500alea.txt", 500, "src/generated/HeapAlea500.txt",
        //             "src/generated/HeapAleaEncontrados500.txt");
        //     heapSort.rotinaHeapArquivo("src/basedados/conta500inv.txt", 500, "src/generated/HeapIve500.txt",
        //             "src/generated/HeapInvEncontrados500.txt");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Fim");

    }

}