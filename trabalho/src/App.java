import classes.models.Pessoa;
import utils.DataFetcher;

public class App {

    public static Pessoa[] vetor;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        DataFetcher dataFetcher = new DataFetcher();

        vetor = dataFetcher
                .getPessoasFromFile("C:/faesa/4periodo/LPOO/trabalho/trabalho/src/basedados/conta500alea.txt", 500);

        HeapSort(500);
        System.out.println("pessoas.length");
    }

    public static void HeapSort(int nElem) {
        int dir = nElem - 1;
        int esq = (dir - 1) / 2;
        Pessoa temp;

        while (esq >= 0) {
            refazHeap(esq, nElem - 1);
            esq--;
        }
        while (dir > 0) {
            temp = vetor[0];
            vetor[0] = vetor[dir];
            vetor[dir] = temp;
            dir--;
            refazHeap(0, dir);
        }
    }

    private static void refazHeap(int esq, int dir) {
        int i = esq;
        int mF = 2 * i + 1; // maior filho
        Pessoa raiz = vetor[i];
        boolean heap = false;

        while ((mF <= dir) && (!heap)) {
            if (mF < dir)
                if (vetor[mF].getCpf().compareTo(vetor[mF + 1].getCpf()) < 0  )
                    mF++;
            if (isFirst(raiz,vetor[mF])) {
                vetor[i] = vetor[mF];
                i = mF;
                mF = 2 * i + 1;
            } else
                heap = true;
        }
        vetor[i] = raiz;
    }

    private static boolean isFirst(Pessoa pessoa1, Pessoa pessoa2){
        int compareResult = pessoa1.getCpf().compareTo(pessoa2.getCpf());
        if(compareResult < 0){
            return true;
        } else if (compareResult == 0){
            if(pessoa1.getAgencia().compareTo(pessoa2.getAgencia()) < 0){
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }
}