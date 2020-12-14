import finalrotines.ArvoreAvlRotine;
import finalrotines.ArvoreBRotine;
import finalrotines.HashRotine;
import finalrotines.HeapRotine;
import finalrotines.QuickSortRotine;

public class App {

    public static void main(String[] args) {
        System.out.println("------------Trabalho Pesquisa Ordenação e LPOO------------\n");
        System.out.println("Alunos: Arthur Barcellos de Aguiar \nIgor Teixeira \nArthur Sanglard \nJuliana Silva Costa \n Fagner Pelicioni\n");
        System.out.println("Professora: Cinthia C L Caliari");

        // new HeapRotine().executeRotine();
        // new QuickSortRotine().executeRotine();
        // new ArvoreBRotine().executeRotine();
        new ArvoreAvlRotine().executeRotine();
        // new HashRotine().executeRotine();
    }

}