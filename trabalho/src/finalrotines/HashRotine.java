package finalrotines;

import classes.models.HashFun;
import interfaces.Rotina;

public class HashRotine implements Rotina {

    @Override
    public void executeRotine() {

        System.out.println("\n\n----- Rotina Hash -----\n\n");


        // -------- Hash 500 Aleatório -------------//
        long tempoHash500Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash500Ale += rotinaHash500Aleatorio();
        }
        System.out.println("Média de Tempo HASH 500 Aleatorio: " + (tempoHash500Ale / 5));

        // -------- Hash 500 Invertido -------------//
        long tempoHash500Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash500Inv += rotinaHash500Inv();
        }
        System.out.println("Média de Tempo HASH 500 Invertido: " + (tempoHash500Inv / 5));

        // -------- Hash 500 -------------//
        long tempoHash500Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash500Ord += rotinaHash500Ord();
        }
        System.out.println("Média de Tempo HASH 500 Ordenado: " + (tempoHash500Ord / 5));

        // -------- Hash 1000 Aleatório -------------//
        long tempoHash1000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash1000Ale += rotinaHash1000Aleatorio();
        }
        System.out.println("Média de Tempo HASH 1000 Aleatorio: " + (tempoHash1000Ale / 5));

        // -------- Hash 1000 Invertido -------------//
        long tempoHash1000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash1000Inv += rotinaHash1000Inv();
        }
        System.out.println("Média de Tempo HASH 1000 Invertido: " + (tempoHash1000Inv / 5));

        // -------- Hash 1000 Ordenado -------------//
        long tempoHash1000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash1000Ord += rotinaHash1000Ord();
        }
        System.out.println("Média de Tempo HASH 1000 Ordenado: " + (tempoHash1000Ord / 5));

        // -------- Hash 5000 Aleatorio -------------//
        long tempoHash5000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash5000Ale += rotinaHash5000Aleatorio();
        }
        System.out.println("Média de Tempo HASH 5000 Aleatorio: " + (tempoHash5000Ale / 5));

        // -------- Hash 5000 Invertido -------------//
        long tempoHash5000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash5000Inv += rotinaHashe5000Inv();
        }
        System.out.println("Média de Tempo HASH 5000 Invertido: " + (tempoHash5000Inv / 5));

        // -------- Hash 5000 Ordenado -------------//
        long tempoHash5000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash5000Ord += rotinaHash5000Ord();
        }
        System.out.println("Média de Tempo HASH 5000 Ordenado: " + (tempoHash5000Ord / 5));

        // -------- Hash 10.000 Aleatorio -------------//
        long tempoHash10000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash10000Ale += rotinaHash10000Aleatorio();
        }
        System.out.println("Média de Tempo HASH 10.000 Aleatorio: " + (tempoHash10000Ale / 5));

        // -------- Hash 10.000 Invertido -------------//
        long tempoHash10000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash10000Inv += rotinaHash10000Inv();
        }
        System.out.println("Média de Tempo HASH 10.000 Invertido: " + (tempoHash10000Inv / 5));

        // -------- Hash 10.000 Ordenado -------------//
        long tempoHash10000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash10000Ord += rotinaHash10000Ord();
        }
        System.out.println("Média de Tempo HASH 10.000 Ordenado: " + (tempoHash10000Ord / 5));

        // -------- Hash 50.000 Aleatorio -------------//
        long tempoHash50000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash50000Ale += rotinaHash50000Ale();
        }
        System.out.println("Média de Tempo HASH 50.000 Aleatorio: " + (tempoHash50000Ale / 5));

        // -------- Hash 50.000 Invertido -------------//
        long tempoHash50000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash50000Inv += rotinaHash50000Inv();
        }
        System.out.println("Média de Tempo HASH 50.000 Invertido: " + (tempoHash50000Inv / 5));

        // -------- Hash 50.000 Ordenado -------------//
        long tempoHash50000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHash50000Ord += rotinaHash50000Ord();
        }
        System.out.println("Média de Tempo HASH 50.000 Ordenado: " + (tempoHash50000Ord / 5));

    }

    private long rotinaHash500Aleatorio() {
        HashFun hashFun = new HashFun(500);
        try {
            return hashFun.rotinaHashArquivo("src/basedados/conta500alea.txt", 500, "src/generated/hash/HashAlea500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 500 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHash500Inv() {
        HashFun hash = new HashFun(500);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta500inv.txt", 500, "src/generated/hash/HashInv500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 500 iverso erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaHash500Ord() {
        HashFun hash = new HashFun(500);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta500ord.txt", 500, "src/generated/hash/HashOrd500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 500 ordernado erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaHash1000Aleatorio() {
        HashFun Hash = new HashFun(1000);
        try {
            return Hash.rotinaHashArquivo("src/basedados/conta1000alea.txt", 1000, "src/generated/hash/HashAlea1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 1000 aleatorios erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaHash1000Inv() {
        HashFun hash = new HashFun(1000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta1000inv.txt", 1000, "src/generated/hash/HashInv1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 1000 invertido erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaHash1000Ord() {
        HashFun hash = new HashFun(1000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta1000ord.txt", 1000, "src/generated/hash/HashOrd1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 1000 ordernado erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaHash5000Aleatorio() {
        HashFun hash = new HashFun(5000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta5000alea.txt", 5000, "src/generated/hash/HashAlea5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 5000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHashe5000Inv() {
        HashFun hash = new HashFun(5000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta5000inv.txt", 5000, "src/generated/hash/HashInv5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 5000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHash5000Ord() {
        HashFun hash = new HashFun(5000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta5000ord.txt", 5000, "src/generated/hash/HashOrd5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 5000 ordenado erro:" + e.getMessage());
            return 0;
        }
    }

    private long rotinaHash10000Aleatorio() {
        HashFun hash = new HashFun(10000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta10000alea.txt", 10000, "src/generated/hash/HashAlea10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 10.000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHash10000Inv() {
        HashFun hash = new HashFun(10000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta10000inv.txt", 10000, "src/generated/hash/HashInv10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 10.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHash10000Ord() {
        HashFun hash = new HashFun(10000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta10000ord.txt", 10000, "src/generated/hash/HashOrd10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 10.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHash50000Ale() {
        HashFun hash = new HashFun(50000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta50000alea.txt", 50000, "src/generated/hash/HashAle50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 50.000 aleatorio erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHash50000Inv() {
        HashFun hash = new HashFun(50000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta50000inv.txt", 50000, "src/generated/hash/HashInv50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 50.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHash50000Ord() {
        HashFun hash = new HashFun(50000);
        try {
            return hash.rotinaHashArquivo("src/basedados/conta50000ord.txt", 50000, "src/generated/hash/HashOrd50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante Hash de 50.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

}
