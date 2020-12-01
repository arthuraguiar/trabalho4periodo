package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import classes.models.*;

public class DataFetcher {

    public Pessoa[] getPessoasFromFile(String filePath, int tamanho) {
        Pessoa[] pessoas = new Pessoa[tamanho];
        int numeroAdicionado = 0;
        try {
            File file = new File(filePath); // creates a new file instance
            FileReader fr = new FileReader(file); // reads the file
            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
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
                if(numeroAdicionado >= tamanho)
                    break;
            }
            fr.close(); // closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString()); // returns a string that textually represents the object
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }




  

}
