package classes.models;

public class Nodo {
    private Pessoa pessoa;
    private Nodo esq, dir;
    private byte fatorBalanceamento;

    public Nodo(Pessoa i) {
        this.pessoa = i;
        this.fatorBalanceamento = 0;
    }

    public Nodo getDir() {
        return this.dir;
    }

    public void setDir(Nodo dir) {
        this.dir = dir;
    }

    public Nodo getEsq() {
        return this.esq;
    }

    public void setEsq(Nodo esq) {
        this.esq = esq;
    }

    public byte getFatorBalanceamento() {
        return this.fatorBalanceamento;
    }

    public void setFatorBalanceamento(byte fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
      this.pessoa = pessoa;
    }
}
