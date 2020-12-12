package classes.models;

public class NoHash {
    private NoHash proxNo;
    private int hashValue;
    private Pessoa pessoa;

    public NoHash getProxNo() {
        return proxNo;
    }

    public void setProxNo(NoHash proxNo) {
        this.proxNo = proxNo;
    }

    public int getHashValue() {
        return hashValue;
    }

    public void setHashValue(int hashValue) {
        this.hashValue = hashValue;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
