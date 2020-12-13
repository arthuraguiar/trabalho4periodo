package finalrotines;

import classes.search.Arvore;
import interfaces.Rotina;

public class ArvoreBRotine implements Rotina {
    @Override
    public void executeRotine() {

        System.out.println("\n\n----- Rotina Arvore Binaria -----\n\n");

        // -------- ABB 500 Aleatório -------------//
        long tempoABB500Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB500Ale += rotinaABB500Aleatorio();
        }
        System.out.println("Média de Tempo ABB 500 Aleatorio: " + (tempoABB500Ale / 5));

        // -------- ABB 500 Invertido -------------//
        long tempoABB500Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB500Inv += rotinaABB500Inv();
        }
        System.out.println("Média de Tempo ABB 500 Invertido: " + (tempoABB500Inv / 5));

        // -------- ABB 500 Ordenado -------------//
        long tempoABB500Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB500Ord += rotinaABB500Ord();
        }
        System.out.println("Média de Tempo ABB 500 Ordenado: " + (tempoABB500Ord / 5));

        // -------- ABB 1000 Aleatório -------------//
        long tempoABB1000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB1000Ale += rotinaABB1000Aleatorio();
        }
        System.out.println("Média de Tempo ABB 1000 Aleatorio: " + (tempoABB1000Ale / 5));

        // -------- ABB 1000 Invertido -------------//
        long tempoABB1000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB1000Inv += rotinaArvore1000Inv();
        }
        System.out.println("Média de Tempo ABB 1000 Invertido: " + (tempoABB1000Inv / 5));

        // -------- ABB 1000 Ordenado -------------//
        long tempoABB1000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB1000Ord += rotinaArvore1000Ord();
        }
        System.out.println("Média de Tempo ABB 1000 Ordenado: " + (tempoABB1000Ord / 5));

        // -------- ABB 5000 Aleatório -------------//
        long tempoABB5000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB5000Ale += rotinaArvore5000Aleatorio();
        }
        System.out.println("Média de Tempo ABB 5000 Aleatorio: " + (tempoABB5000Ale / 5));

        // -------- ABB 5000 Invertido -------------//
        long tempoABB5000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB5000Inv += rotinaArvore5000Inv();
        }
        System.out.println("Média de Tempo ABB 5000 Invertido: " + (tempoABB5000Inv / 5));

        // -------- ABB 5000 Ordenado -------------//
        long tempoABB5000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB5000Ord += rotinaArvore5000Ord();
        }
        System.out.println("Média de Tempo ABB 5000 Ordenado: " + (tempoABB5000Ord / 5));

        // -------- ABB 10.000 Aleatório -------------//
        long tempoABB10000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB10000Ale += rotinaArvore10000Aleatorio();
        }
        System.out.println("Média de Tempo ABB 10.000 Aleatorio: " + (tempoABB10000Ale / 5));

        // -------- ABB 10.000 Invertido -------------//
        long tempoABB10000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB10000Inv += rotinaArvore10000Inv();
        }
        System.out.println("Média de Tempo ABB 10.000 Invertido: " + (tempoABB10000Inv / 5));

        // -------- ABB 10.000 Ordenado -------------//
        long tempoABB10000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB10000Ord += rotinaArvore10000Ord();
        }
        System.out.println("Média de Tempo ABB 10.000 Ordenado: " + (tempoABB10000Ord / 5));

        // -------- ABB 50.000 Aleatório -------------//
        long tempoABB50000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB50000Ale += rotinaArvore50000Ale();
        }
        System.out.println("Média de Tempo ABB 50.000 Aleatorio: " + (tempoABB50000Ale / 5));

        // -------- ABB 50.000 Invertido -------------//
        long tempoABB50000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB50000Inv += rotinaArvore50000Inv();
        }
        System.out.println("Média de Tempo ABB 50.000 Invertido: " + (tempoABB50000Inv / 5));

        // -------- ABB 50.000 Ordenado -------------//
        long tempoABB50000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoABB50000Ord += rotinaArvore50000Ord();
        }
        System.out.println("Média de Tempo ABB 50.000 Ordenado: " + (tempoABB50000Ord / 5));

    }

    private long rotinaABB500Aleatorio() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta500alea.txt", 500, "ABBAlea500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 500 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaABB500Inv() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta500inv.txt", 500, "ABBInv500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 500 iverso erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaABB500Ord() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta500ord.txt", 500, "ABBOrd500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 500 ordernado erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaABB1000Aleatorio() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta1000alea.txt", 1000, "ABBAlea1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 1000 aleatorios erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaArvore1000Inv() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta1000inv.txt", 1000, "ABBInv1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 1000 invertido erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaArvore1000Ord() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta1000ord.txt", 1000, "ABBOrd1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 1000 ordernado erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaArvore5000Aleatorio() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta5000alea.txt", 5000, "ABBAlea5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 5000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore5000Ord() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta5000ord.txt", 5000, "ABBOrd5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 5000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore5000Inv() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta5000inv.txt", 5000, "ABBInv5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 5000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore10000Aleatorio() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta10000alea.txt", 10000, "ABBAlea10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 10.000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore10000Inv() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta10000inv.txt", 10000, "ABBInv10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 10.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore10000Ord() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta10000ord.txt", 10000, "ABBOrd10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 10.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore50000Ale() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta50000alea.txt", 50000, "HeaAle50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 50.000 aleatorio erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore50000Inv() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta50000inv.txt", 50000, "ABBInv50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 50.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvore50000Ord() {
        Arvore ABB = new Arvore();
        try {
            return ABB.rotinaArvoreAvlArquivo("src/basedados/conta50000ord.txt", 50000, "ABBOrd50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante ABB de 50.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

}
