import classes.models.Pessoa;
import utils.DataFetcher;

public class App {

    public static Pessoa[] pessoas;
    public static DataFetcher dataFetcher = new DataFetcher();

    public static void main(String[] args) {
        try {
            rotinaHeapArquivo("src/basedados/conta500alea.txt", 500 , "src/generated/HeapAlea500.txt");
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }

        System.out.println("Fim");
        
    }

    private static void rotinaHeapArquivo(String inputFileName, int inputRegisterSize, String outputFileName) throws Exception{
        long startTime = System.currentTimeMillis();
        
        pessoas = dataFetcher.getPessoasFromFile(inputFileName, inputRegisterSize);
        HeapSort(inputRegisterSize);
        dataFetcher.writeFile(outputFileName, pessoas);
    
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Demorou " + estimatedTime);
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
            temp = pessoas[0];
            pessoas[0] = pessoas[dir];
            pessoas[dir] = temp;
            dir--;
            refazHeap(0, dir);
        }
    }

    private static void refazHeap(int esq, int dir) {
        int i = esq;
        int mF = 2 * i + 1; // maior filho
        Pessoa raiz = pessoas[i];
        boolean heap = false;

        while ((mF <= dir) && (!heap)) {
            if (mF < dir)
                if (isFirst(pessoas[mF],pessoas[mF + 1]))
                    mF++;
            if (isFirst(raiz,pessoas[mF])) {
                pessoas[i] = pessoas[mF];
                i = mF;
                mF = 2 * i + 1;
            } else
                heap = true;
        }
        pessoas[i] = raiz;
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