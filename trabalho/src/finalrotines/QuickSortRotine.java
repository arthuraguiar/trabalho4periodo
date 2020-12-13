package finalrotines;

import classes.ord.QuickSort;
import interfaces.Rotina;

public class QuickSortRotine implements Rotina {

    @Override
    public void executeRotine() {
        
        System.out.println("\n\n----- Rotina QuickSort -----\n\n");


        // -------- Quick 500 Aleatório -------------//
        long tempoQuick500Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick500Ale += rotinaQuickSort500Aleatorio();
        }
        System.out.println("Média de Tempo QuickSort 500 Aleatorio: " + (tempoQuick500Ale / 5));

        // -------- Quick 500 Invertido -------------//
        long tempoQuick500Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick500Inv += rotinaQuickSort500Inv();
        }
        System.out.println("Média de Tempo QuickSort 500 Invertido: " + (tempoQuick500Inv / 5));

        // -------- Quick 500 Ordenado -------------//
        long tempoQuick500Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick500Ord += rotinaQuickSort500Ord();
        }
        System.out.println("Média de Tempo QuickSort 500 Ordenado: " + (tempoQuick500Ord / 5));

        // -------- Quick 1000 Aleatório -------------//
        long tempoQuick1000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick1000Ale += rotinaQuickSort1000Aleatorio();
        }
        System.out.println("Média de Tempo QuickSort 1000 Aleatorio: " + (tempoQuick1000Ale / 5));

        // -------- Quick 1000 Invertido -------------//
        long tempoQuick1000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick1000Inv += rotinaQuickSort1000Inv();
        }
        System.out.println("Média de Tempo QuickSort 1000 Invertido: " + (tempoQuick1000Inv / 5));

        // -------- Quick 1000 Ordenado -------------//
        long tempoQuick1000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick1000Ord += rotinaQuickSort1000Ord();
        }
        System.out.println("Média de Tempo QuickSort 1000 Ordenado: " + (tempoQuick1000Ord / 5));

        // -------- Quick 5000 Aleatório -------------//
        long tempoQuick5000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick5000Ale += rotinaQuickSort5000Aleatorio();
        }
        System.out.println("Média de Tempo QuickSort 5000 Aleatorio: " + (tempoQuick5000Ale / 5));

        // -------- Quick 5000 Invertido -------------//
        long tempoQuick5000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick5000Inv += rotinaQuickSort5000Inv();
        }
        System.out.println("Média de Tempo QuickSort 5000 Invertido: " + (tempoQuick5000Inv / 5));

        // -------- Quick 5000 Ordenado -------------//
        long tempoQuick5000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick5000Ord += rotinaQuickSort5000Ord();
        }
        System.out.println("Média de Tempo QuickSort 5000 Ordenado: " + (tempoQuick5000Ord / 5));

        // -------- Quick 10.000 Aleatório -------------//
        long tempoQuick10000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick10000Ale += rotinaQuickSort10000Aleatorio();
        }
        System.out.println("Média de Tempo QuickSort 10.000 Aleatorio: " + (tempoQuick10000Ale / 5));

        // -------- Quick 10.000 Invertido -------------//
        long tempoQuick10000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick10000Inv += rotinaQuickSort10000Inv();
        }
        System.out.println("Média de Tempo QuickSort 10.000 Invertido: " + (tempoQuick10000Inv / 5));

        // -------- Quick 10.000 Ordenado -------------//
        long tempoQuick10000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick10000Ord += rotinaQuickSort10000Ord();
        }
        System.out.println("Média de Tempo QuickSort 10.000 Ordenado: " + (tempoQuick10000Ord / 5));

        // -------- Quick 50.000 Aleatório -------------//
        long tempoQuick50000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick50000Ale += rotinaQuickSort50000Ale();
        }
        System.out.println("Média de Tempo QuickSort 50.000 Aleatorio: " + (tempoQuick50000Ale / 5));

        // -------- Quick 50.000 Invertido -------------//
        long tempoQuick50000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick50000Inv += rotinaQuickSort50000Inv();
        }
        System.out.println("Média de Tempo QuickSort 50.000 Invertido: " + (tempoQuick50000Inv / 5));

        // -------- Quick 50.000 Ordenado -------------//
        long tempoQuick50000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoQuick50000Ord += rotinaQuickSort50000Ord();
        }
        System.out.println("Média de Tempo QuickSort 50.000 Ordenado: " + (tempoQuick50000Ord / 5));


    }


    private long rotinaQuickSort500Aleatorio() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta500alea.txt", 500, "src/generated/quick/QuickAlea500.txt",
                    "src/generated/quick/QuickAlea500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 500 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort500Inv() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta500inv.txt", 500, "src/generated/quick/QuickInv500.txt",
                    "src/generated/quick/QuickInv500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 500 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort500Ord() {
        QuickSort heap = new QuickSort();
        try {
            return heap.rotinaQuickArquivo("src/basedados/conta500ord.txt", 500, "src/generated/quick/QuickOrd500.txt",
                    "src/generated/quick/QuickOrd500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante quick de 500 ordernado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort1000Aleatorio() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta1000alea.txt", 1000, "src/generated/quick/QuickAlea1000.txt",
                    "src/generated/quick/QuickAlea1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante quick de 1000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort1000Inv() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta1000inv.txt", 1000, "src/generated/quick/QuickInv1000.txt",
                    "src/generated/quick/QuickInv1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 1000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort1000Ord() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta1000ord.txt", 1000, "src/generated/quick/QuickOrd1000.txt",
                    "src/generated/quick/QuickOrd1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 1000 ordernado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort5000Aleatorio() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta5000alea.txt", 5000, "src/generated/quick/QuickAlea5000.txt",
                    "src/generated/quick/QuickAlea5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 5000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort5000Inv() {
        QuickSort heap = new QuickSort();
        try {
            return heap.rotinaQuickArquivo("src/basedados/conta5000inv.txt", 5000, "src/generated/quick/QuickInv5000.txt",
                    "src/generated/quick/QuickInv5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 5000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort5000Ord() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta5000ord.txt", 5000, "src/generated/quick/QuickOrd5000.txt",
                    "src/generated/quick/QuickOrd5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 5000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort10000Aleatorio() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta10000alea.txt", 10000, "src/generated/quick/QuickAlea10000.txt",
                    "src/generated/quick/QuickAlea10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 10.000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort10000Inv() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta10000inv.txt", 10000, "src/generated/quick/QuickInv10000.txt",
                    "src/generated/quick/QuickInv10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 10.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort10000Ord() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta10000ord.txt", 10000, "src/generated/quick/QuickOrd10000.txt",
                    "src/generated/quick/QuickOrd10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 10.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort50000Ale() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta50000alea.txt", 50000, "src/generated/quick/QuickAle50000.txt",
                    "src/generated/quick/QuickAle50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 50.000 aleatorio erro:" + e.getMessage());
            return 0;
        }

    }

    
    private long rotinaQuickSort50000Inv() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta50000inv.txt", 50000, "src/generated/quick/QuickInv50000.txt",
                    "src/generated/quick/QuickInv50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 50.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaQuickSort50000Ord() {
        QuickSort quick = new QuickSort();
        try {
            return quick.rotinaQuickArquivo("src/basedados/conta50000ord.txt", 50000, "src/generated/quick/QuickOrd50000.txt",
                    "src/generated/quick/QuickOrd50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Quick de 50.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

}
