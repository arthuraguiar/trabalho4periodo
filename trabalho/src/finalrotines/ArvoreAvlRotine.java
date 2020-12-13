package finalrotines;

import classes.search.ArvoreAvl;
import interfaces.Rotina;

public class ArvoreAvlRotine implements Rotina {

    @Override
    public void executeRotine() {

        System.out.println("\n\n----- Rotina Arvore Avl -----\n\n");

        // -------- AVL 500 Aleatório -------------//
        long tempoAvl500Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl500Ale += rotinaAvl500Aleatorio();
        }
        System.out.println("Média de Tempo AVL 500 Aleatorio: " + (tempoAvl500Ale / 5));

        // -------- AVL 500 Invertido -------------//
        long tempoAvl500Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl500Inv += rotinaAvl500Inv();
        }
        System.out.println("Média de Tempo AVL 500 Invertido: " + (tempoAvl500Inv / 5));

        // -------- AVL 500 Ordenado -------------//
        long tempoAvl500Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl500Ord += rotinaAvl500Ord();
        }
        System.out.println("Média de Tempo AVL 500 Ordenado: " + (tempoAvl500Ord / 5));

        // -------- AVL 1000 Aleatório -------------//
        long tempoAvl1000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl1000Ale += rotinaAvl1000Aleatorio();
        }
        System.out.println("Média de Tempo AVL 1000 Aleatorio: " + (tempoAvl1000Ale / 5));

        // -------- AVL 1000 Invertido -------------//
        long tempoAvl1000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl1000Inv += rotinaArvoreAvl1000Inv();
        }
        System.out.println("Média de Tempo AVL 1000 Invertido: " + (tempoAvl1000Inv / 5));

        // -------- AVL 1000 Ordenado -------------//
        long tempoAvl1000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl1000Ord += rotinaArvoreAvl1000Ord();
        }
        System.out.println("Média de Tempo AVL 1000 Ordenado: " + (tempoAvl1000Ord / 5));

        // -------- AVL 5000 Aleatório -------------//
        long tempoAvl5000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl5000Ale += rotinaArvoreAvl5000Aleatorio();
        }
        System.out.println("Média de Tempo AVL 5000 Aleatorio: " + (tempoAvl5000Ale / 5));

        // -------- AVL 5000 Invertido -------------//
        long tempoAvl5000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl5000Inv += rotinaArvoreAvl5000Inv();
        }
        System.out.println("Média de Tempo AVL 5000 Invertido: " + (tempoAvl5000Inv / 5));

        // -------- AVL 5000 Ordenado -------------//
        long tempoAvl5000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl5000Ord += rotinaArvoreAvl5000Ord();
        }
        System.out.println("Média de Tempo AVL 5000 Ordenado: " + (tempoAvl5000Ord / 5));

        // -------- AVL 10.000 Aleatório -------------//
        long tempoAvl10000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl10000Ale += rotinaArvoreAvl10000Aleatorio();
        }
        System.out.println("Média de Tempo AVL 10.000 Aleatorio: " + (tempoAvl10000Ale / 5));

        // -------- AVL 10.000 Invertido -------------//
        long tempoAvl10000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl10000Inv += rotinaArvoreAvl10000Inv();
        }
        System.out.println("Média de Tempo AVL 10.000 Invertido: " + (tempoAvl10000Inv / 5));

        // -------- AVL 10.000 Ordenado -------------//
        long tempoAvl10000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl10000Ord += rotinaArvoreAvl10000Ord();
        }
        System.out.println("Média de Tempo AVL 10.000 Ordenado: " + (tempoAvl10000Ord / 5));

        // -------- AVL 50.000 Aleatório -------------//
        long tempoAvl50000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl50000Ale += rotinaArvoreAvl50000Ale();
        }
        System.out.println("Média de Tempo AVL 50.000 Aleatorio: " + (tempoAvl50000Ale / 5));

        // -------- AVL 50.000 Invertido -------------//
        long tempoAvl50000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl50000Inv += rotinaArvoreAvl50000Inv();
        }
        System.out.println("Média de Tempo AVL 50.000 Invertido: " + (tempoAvl50000Inv / 5));

        // -------- AVL 50.000 Ordenado -------------//
        long tempoAvl50000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoAvl50000Ord += rotinaArvoreAvl50000Ord();
        }
        System.out.println("Média de Tempo AVL 50.000 Ordenado: " + (tempoAvl50000Ord / 5));

    }

    private long rotinaAvl500Aleatorio() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta500alea.txt", 500, "src/generated/avl/AvlAlea500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante AVL de 500 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaAvl500Inv() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta500inv.txt", 500, "src/generated/avl/AvlInv500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante AVL de 500 iverso erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaAvl500Ord() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta500ord.txt", 500, "src/generated/avl/AvlOrd500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante AVL de 500 ordernado erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaAvl1000Aleatorio() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta1000alea.txt", 1000, "src/generated/avl/avlAlea1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 1000 aleatorios erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaArvoreAvl1000Inv() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta1000inv.txt", 1000, "src/generated/avl/avlInv1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 1000 invertido erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaArvoreAvl1000Ord() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta1000ord.txt", 1000, "src/generated/avl/avlOrd1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 1000 ordernado erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaArvoreAvl5000Aleatorio() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta5000alea.txt", 5000, "src/generated/avl/avlAlea5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 5000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl5000Ord() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta5000ord.txt", 5000, "src/generated/avl/avlOrd5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 5000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl5000Inv() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta5000inv.txt", 5000, "src/generated/avl/avlInv5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 5000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl10000Aleatorio() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta10000alea.txt", 10000, "src/generated/avl/avlAlea10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 10.000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl10000Inv() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta10000inv.txt", 10000, "src/generated/avl/avlInv10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 10.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl10000Ord() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta10000ord.txt", 10000, "src/generated/avl/avlOrd10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 10.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl50000Ale() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta50000alea.txt", 50000, "src/generated/avl/avlAle50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 50.000 aleatorio erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl50000Inv() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta50000inv.txt", 50000, "src/generated/avl/avlInv50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 50.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaArvoreAvl50000Ord() {
        ArvoreAvl avl = new ArvoreAvl();
        try {
            return avl.rotinaArvoreAvlArquivo("src/basedados/conta50000ord.txt", 50000, "src/generated/avl/avlOrd50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante avl de 50.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

}
