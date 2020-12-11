package classes.models;

public class NoArvore {
    private Pessoa pessoa;
    private NoArvore dir, esq;

    public NoArvore(Pessoa _info) {
        this.pessoa = _info;
    }

    public NoArvore getDir() {
        return dir;
    }

    public void setDir(NoArvore dir) {
        this.dir = dir;
    }

    public NoArvore getEsq() {
        return esq;
    }

    public void setEsq(NoArvore esq) {
        this.esq = esq;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa novo) {
        this.pessoa = novo;
    }
}