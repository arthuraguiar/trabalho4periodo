package finalrotines;

import classes.ord.HeapSort;
import interfaces.Rotina;

public class HeapRotine implements Rotina {

    @Override
    public void executeRotine() {

        // -------- Heap 500 Aleatório -------------//
        long tempoHeap500Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap500Ale += rotinaHeapSort500Aleatorio();
        }
        System.out.println("Média de Tempo HeapSort 500 Aleatorio: " + (tempoHeap500Ale / 5));

        // -------- Heap 500 Invertido -------------//
        long tempoHeap500Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap500Inv += rotinaHeapSort500Inv();
        }
        System.out.println("Média de Tempo HeapSort 500 ivertido: " + (tempoHeap500Inv / 5));

        // -------- Heap 500 Ordenado -------------//
        long tempoHeap500Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap500Ord += rotinaHeapSort500Ord();
        }
        System.out.println("Média de Tempo HeapSort 500 ordenado: " + (tempoHeap500Ord / 5));

        // -------- Heap 1000 Aleatório -------------//
        long tempoHeap1000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap1000Ale += rotinaHeapSort1000Aleatorio();
        }
        System.out.println("Média de Tempo HeapSort 1000 aleatorio: " + (tempoHeap1000Ale / 5));

        // -------- Heap 1000 Invertido -------------//
        long tempoHeap1000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap1000Inv += rotinaHeapSort1000Inv();
        }
        System.out.println("Média de Tempo HeapSort 1000 invertido: " + (tempoHeap1000Inv / 5));

        // -------- Heap 1000 Ordenado -------------//
        long tempoHeap1000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap1000Ord += rotinaHeapSort1000Ord();
        }
        System.out.println("Média de Tempo HeapSort 1000 ordenado: " + (tempoHeap1000Ord / 5));

        // -------- Heap 5000 Aleatório -------------//
        long tempoHeap5000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap5000Ale += rotinaHeapSort5000Aleatorio();
        }
        System.out.println("Média de Tempo HeapSort 5000 aleatório: " + (tempoHeap5000Ale / 5));

        // -------- Heap 5000 Invertido -------------//
        long tempoHeap5000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap5000Inv += rotinaHeapSort5000Inv();
        }
        System.out.println("Média de Tempo HeapSort 5000 invertido: " + (tempoHeap5000Inv / 5));

        // -------- Heap 5000 Ordenado -------------//
        long tempoHeap5000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap5000Ord += rotinaHeapSort5000Ord();
        }
        System.out.println("Média de Tempo HeapSort 5000 ordenado: " + (tempoHeap5000Ord / 5));

        // -------- Heap 10.000 Aleatório -------------//
        long tempoHeap10000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap10000Ale += rotinaHeapSort10000Aleatorio();
        }
        System.out.println("Média de Tempo HeapSort 10.000 aleatório: " + (tempoHeap10000Ale / 5));

        // -------- Heap 10.000 Invertido -------------//
        long tempoHeap10000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap10000Inv += rotinaHeapSort10000Inv();
        }
        System.out.println("Média de Tempo HeapSort 10.000 invertido: " + (tempoHeap10000Inv / 5));

        // -------- Heap 10.000 Invertido -------------//
        long tempoHeap10000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap10000Ord += rotinaHeapSort10000Ord();
        }
        System.out.println("Média de Tempo HeapSort 10.000 ordenado: " + (tempoHeap10000Ord / 5));

        // -------- Heap 50.000 Aleatório -------------//
        long tempoHeap50000Ale = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap50000Ale += rotinaHeapSort50000Ale();
        }
        System.out.println("Média de Tempo HeapSort 50.000 aleatório: " + (tempoHeap50000Ale / 5));

        // -------- Heap 50.000 Invertido -------------//
        long tempoHeap50000Inv = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap50000Inv += rotinaHeapSort50000Inv();
        }
        System.out.println("Média de Tempo HeapSort 50.000 invertido: " + (tempoHeap50000Inv / 5));

        // -------- Heap 50.000 Ordenado -------------//
        long tempoHeap50000Ord = 0;
        for (int i = 0; i < 5; i++) {
            tempoHeap50000Ord += rotinaHeapSort50000Ord();
        }
        System.out.println("Média de Tempo HeapSort 50.000 ordenado: " + (tempoHeap50000Ord / 5));

    }

    private long rotinaHeapSort500Aleatorio() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta500alea.txt", 500, "HeapAlea500.txt",
                    "HeapAlea500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort500Inv() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta500inv.txt", 500, "HeapInv500.txt",
                    "HeapInv500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 iverso erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort500Ord() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta500ord.txt", 500, "HeapOrd500.txt",
                    "HeapOrd500Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 500 ordernado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort1000Aleatorio() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta1000alea.txt", 1000, "HeapAlea1000.txt",
                    "HeapAlea1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 1000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort1000Inv() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta1000inv.txt", 1000, "HeapInv1000.txt",
                    "HeapInv1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 1000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort1000Ord() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta1000ord.txt", 1000, "HeapOrd1000.txt",
                    "HeapOrd1000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 1000 ordernado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort5000Aleatorio() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta5000alea.txt", 5000, "HeapAlea5000.txt",
                    "HeapAlea5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 5000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort5000Inv() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta5000inv.txt", 5000, "HeapInv5000.txt",
                    "HeapInv5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 5000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort5000Ord() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta5000ord.txt", 5000, "HeapOrd5000.txt",
                    "HeapOrd5000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 5000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort10000Aleatorio() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta10000alea.txt", 10000, "HeapAlea10000.txt",
                    "HeapAlea10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 10.000 aleatorios erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort10000Inv() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta10000inv.txt", 10000, "HeapInv10000.txt",
                    "HeapInv10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 10.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort10000Ord() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta10000ord.txt", 10000, "HeapOrd10000.txt",
                    "HeapOrd10000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 10.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort50000Ale() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta50000alea.txt", 50000, "HeapAle50000.txt",
                    "HeaAle50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 50.000 aleatorio erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort50000Inv() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta50000inv.txt", 50000, "HeapInv50000.txt",
                    "HeapInv50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 50.000 invertido erro:" + e.getMessage());
            return 0;
        }

    }

    private long rotinaHeapSort50000Ord() {
        HeapSort heap = new HeapSort();
        try {
            return heap.rotinaHeapArquivo("src/basedados/conta50000ord.txt", 50000, "HeapOrd50000.txt",
                    "HeapOrd50000Encontrado.txt");
        } catch (Exception e) {
            System.out.println("Erro durante heap de 50.000 ordenado erro:" + e.getMessage());
            return 0;
        }

    }

}
