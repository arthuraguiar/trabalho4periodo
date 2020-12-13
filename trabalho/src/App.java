import finalrotines.HeapRotine;
import finalrotines.QuickSortRotine;

public class App {

    public static void main(String[] args) {
        try {

            // HeapRotine heapRotine = new HeapRotine();
            // heapRotine.executeRotine();

            QuickSortRotine quickSortRotine = new QuickSortRotine();
            quickSortRotine.executeRotine();

            // Pessoa[] pessoas = new
            // DataFetcher().getPessoasFromFile("src/basedados/conta500alea.txt", 500);
            // HashFun hash = new HashFun(500);
            // for (int i = 0; i < pessoas.length; i++) {
            // hash.insere(pessoas[i]);
            // }

            // String[] cpfs1 = new DataFetcher().getCpfsFromFile("src/basedados/Conta.txt",
            // 400);
            // ArrayList<Pessoa> listaCpfsAchados2 = new ArrayList<Pessoa>();
            // hash.pesquisa(cpfs1);
            // System.out.println("sdfgsdf");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

}