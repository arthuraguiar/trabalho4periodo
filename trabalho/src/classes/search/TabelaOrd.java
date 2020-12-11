package classes.search;

import classes.models.Pessoa;

public class TabelaOrd {
    private int tamanho;
    private Pessoa[] pessoas;
    private int posicaoAinserir;


    public TabelaOrd(int tamanho){
        this.tamanho = tamanho;
        pessoas = new Pessoa[this.tamanho];
    }

    public void insere(Pessoa pessoa){
        this.pessoas[posicaoAinserir] = pessoa;
        this.posicaoAinserir++;
    }

    public Pessoa getPessoa(int index){
        return pessoas[index];
    }

    public int getNumeroElementos(){
        return tamanho;
    }
}
