package classes.models;

public class Pessoa {
    private String cpf;
    private String Nome;
    private String agencia;
    private String conta;
    private String saldo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {

        return this.cpf + ";" + this.Nome + ";" + this.agencia + ";" + this.conta + ";" + this.saldo;
    }

    public String getInfo(){
        return "Ag: "+ this.agencia + "   Conta: "+ this.getNomeTipoConta() + "Saldo: R$" + this.saldo;
    }

    private String getNomeTipoConta() {
        String primeirosDigitosConta = this.conta.substring(0, 3);
        switch (primeirosDigitosConta) {
            case "001":
                return "Conta Comum";
            case "002":
                return "Conta Especial";
            case "010":
                return "Poupança";
            default:
                return "Não especificado";
        }
    }
}