import classes.ord.HeapSort;

public class App {

    public static void main(String[] args) {
        try {
            HeapSort heapSort = new HeapSort();
            heapSort.rotinaHeapArquivo("src/basedados/conta500alea.txt", 500 , "src/generated/HeapAlea500.txt");
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }

        System.out.println("Fim");
        
    }

    
}