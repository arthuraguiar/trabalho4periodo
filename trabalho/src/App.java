import classes.models.Pessoa;
import utils.DataFetcher;

public class App {

    public static Pessoa[] vetor;

    public static void main(String[] args) throws Exception {
        DataFetcher dataFetcher = new DataFetcher();

        vetor = dataFetcher
                .getPessoasFromFile("src/basedados/conta500alea.txt", 500);

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
                if (isFirst(vetor[mF],vetor[mF + 1]))
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
        int compareCpfResult = pessoa1.getCpf().compareTo(pessoa2.getCpf());
        if(compareCpfResult < 0){
            return true;
        } else if (compareCpfResult == 0){
            int compareAgenciaResult = pessoa1.getAgencia().compareTo(pessoa2.getAgencia());
            if(compareAgenciaResult< 0){
                return true;
            } else if (compareAgenciaResult == 0){
                int compareContaResult = pessoa1.getConta().compareTo(pessoa2.getConta());          
                return (compareContaResult < 0);            
            } else{
                return false;
            }
        } else{
            return false;
        }
    }
}