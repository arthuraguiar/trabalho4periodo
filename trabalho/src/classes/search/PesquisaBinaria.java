package classes.search;

import java.util.ArrayList;
import classes.models.Pessoa;

public class PesquisaBinaria {
    private Pessoa[] pessoas;
    private int numeroElementos = 0;
    private ArrayList<Pessoa> pessoasDoCpf;
    int encontrados = 0;

    public PesquisaBinaria(Pessoa[] pessoas) {
        this.pessoas = pessoas;
        this.numeroElementos = pessoas.length;
    }

    public String removeChave(String chave){
        pessoasDoCpf = new ArrayList<Pessoa>();
        boolean removeu = false;
        do{
            removeu = remove(chave);
        }while(removeu);


        String texto;
        if(pessoasDoCpf.size() <= 0){
            texto ="CPF "+chave+ ":\nNÃO HÁ NENHUM REGISTRO COM O CPF 12345612344\n";
        }else{
            double saldo = 0;
            texto = "CPF"+ chave + "     " +pessoasDoCpf.get(0).getNome() + "\n";
            for (Pessoa pessoa : pessoasDoCpf) {
               encontrados++;
               texto += pessoa.getInfo() + "\n";
               saldo += Double.parseDouble(pessoa.getSaldo());
            }
            texto += "Saldo Total: " + saldo + "\n";
        }

        return texto;
    }

    public int pesqBinaria(String chave) {
        int meio, esq, dir;
        esq = 0;
        dir = numeroElementos - 1;
        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (chave.compareTo(this.pessoas[meio].getCpf()) == 0)
                return meio;
            else {
                if (chave.compareTo(this.pessoas[meio].getCpf()) < 0)
                    dir = meio - 1;
                else
                    esq = meio + 1;
            }
        }
        return -1;
    }

    public boolean remove(String chave) {
        int i, pos;
        if (this.numeroElementos == 0)
            return false;
        else {
            pos = pesqBinaria(chave);
            if (pos >= 0) {
                pessoasDoCpf.add(pessoas[pos]);
                for (i = pos + 1; i < this.numeroElementos; i++)
                    this.pessoas[i - 1] = this.pessoas[i];
                this.numeroElementos--;
                return true;
            } else
                return false;
        }
    }


}
