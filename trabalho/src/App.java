import java.util.ArrayList;

import classes.models.HashFun;
import classes.models.Pessoa;
import classes.ord.HeapSort;
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
            ArrayList<Pessoa> listaCpfsAchados2 = new ArrayList<Pessoa>();
            hash.pesquisa(cpfs1);
            System.out.println("sdfgsdf");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Fim");

    }

    private static void rotinaHeapSort500Aleatorio() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta500alea.txt", 500, "HeapAlea500.txt",
                    "HeapAlea500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }

    private static void rotinaHeapSort500Inv() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta500inv.txt", 500, "HeapInv500.txt",
                    "HeapInv500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }

    private static void rotinaHeapSort500Ord() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta500ord.txt", 500, "HeapOrd500.txt",
                    "HeapOrd500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }

    private static void rotinaHeapSort1000Aleatorio() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta1000alea.txt", 500, "HeapAlea1000.txt",
                    "HeapAlea1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }

    private static void rotinaHeapSort1000Inv() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta1000inv.txt", 500, "HeapInv1000.txt",
                    "HeapInv1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 1000 aleatorios erro:" + e.getMessage());
        }

    }

    private static void rotinaHeapSort1000Ord() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta1000ord.txt", 500, "HeapOrd1000.txt",
                    "HeapOrd1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }


    private static void rotinaHeapSort5000Aleatorio() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta5000alea.txt", 500, "HeapAlea5000.txt",
                    "HeapAlea5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }


    private static void rotinaHeapSort5000Inv() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta5000inv.txt", 500, "HeapInv5000.txt",
                    "HeapInv5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }

    private static void rotinaHeapSort5000Ord() {
        HeapSort heap500ale = new HeapSort();
        try {
            heap500ale.rotinaHeapArquivo("src/basedados/conta5000ord.txt", 500, "HeapOrd5000.txt",
                    "HeapOrd5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
        }

    }




}