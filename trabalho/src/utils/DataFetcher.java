package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import classes.models.*;

public class DataFetcher {

    public Pessoa[] getPessoasFromFile(String filePath, int tamanho) {
        Pessoa[] pessoas = new Pessoa[tamanho];
        int numeroAdicionado = 0;
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(";");
                Pessoa pessoa = new Pessoa();
                pessoa.setCpf(lineContent[0].trim());
                pessoa.setNome(lineContent[1].trim());
                pessoa.setAgencia(lineContent[2].trim());
                pessoa.setConta(lineContent[3].trim());
                pessoa.setSaldo(lineContent[4].trim());
                pessoas[numeroAdicionado] = pessoa;
                numeroAdicionado++;
                if (numeroAdicionado >= tamanho)
                    break;
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public String[] getCpfsFromFile(String filePath, int tamanho) {
        String[] cpfs = new String[tamanho];
        int numeroAdicionado = 0;
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                cpfs[numeroAdicionado] = line.trim();
                numeroAdicionado++;
                if (numeroAdicionado >= tamanho)
                    break;
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cpfs;
    }

    public void writeFile(String filePath, Pessoa[] pessoas) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < pessoas.length; i++) {
            fw.write(pessoas[i].toString() + (i == pessoas.length - 1 ? "" : "\n"));
        }
        fw.close();
    }

}
