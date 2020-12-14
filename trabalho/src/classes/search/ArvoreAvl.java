package classes.search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import classes.models.Nodo;
import classes.models.Pessoa;
import utils.DataFetcher;

public class ArvoreAvl {
    public Nodo raiz;
    private boolean h;
    private DataFetcher dataFetcher = new DataFetcher();

    public ArvoreAvl() {
        this.raiz = null;
        this.h = true;
    }

    public long rotinaArvoreAvlArquivo(String inputFileName, int inputRegisterSize, String outPutFileFindName)
            throws Exception {
        long startTime = System.currentTimeMillis();
        Pessoa[] pessoas = dataFetcher.getPessoasFromFile(inputFileName, inputRegisterSize);
        for (int i = 0; i < pessoas.length; i++) {
            insereRaiz(pessoas[i]);
        }
        String[] cpfs = dataFetcher.getCpfsFromFile("src/basedados/Conta.txt", 400);
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < cpfs.length; i++) {
            ArrayList<Pessoa> pessoasEncontradas = new ArrayList<Pessoa>();
            Nodo nodoEncontrado;
            do{
                nodoEncontrado = pesquisar(cpfs[i], this.raiz);
                if(nodoEncontrado != null){
                    pessoasEncontradas.add(nodoEncontrado.getPessoa());
                    this.raiz = remove(cpfs[i]);
                }
            }while(nodoEncontrado != null); 

            String texto;
            if (pessoasEncontradas.size() <= 0) {
                texto = "CPF " + cpfs[i] + ": NÃO HÁ NENHUM REGISTRO COM O CPF \n";
            } else {
                double saldo = 0;
                texto = "CPF" + cpfs[i] + "     " + pessoasEncontradas.get(0).getNome() + "\n";
                for (Pessoa pessoa : pessoasEncontradas) {
                    texto += pessoa.getInfo() + "\n";
                    saldo += Double.parseDouble(pessoa.getSaldo());
                }
                texto += "Saldo Total: " + saldo + "\n";
            }
            sbf.append(texto + "\n\n\n");
        }

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(outPutFileFindName)));

        bwr.write(sbf.toString());

        bwr.flush();

        bwr.close();

        long estimatedTime = System.currentTimeMillis() - startTime;

        return estimatedTime;
    }

    private void insereRaiz(Pessoa elem) {
        this.raiz = this.insere(elem, this.raiz);
    }

    private Nodo insere(Pessoa elem, Nodo no) {
        if (no == null) {
            Nodo novo = new Nodo(elem);
            this.h = true;
            return novo;

        } else {
            if (isFirst(elem, no.getPessoa())) {
                no.setEsq(this.insere(elem, no.getEsq()));
                no = this.balancearDir(no);
                return no;
            } else {
                no.setDir(this.insere(elem, no.getDir()));
                no = this.balancearEsq(no);
                return no;
            }
        }
    }

    private Nodo balancearDir(Nodo no) {
        if (this.h)
            switch (no.getFatorBalanceamento()) {
                case 1:
                    no.setFatorBalanceamento((byte) 0);
                    this.h = false;
                    break;
                case 0:
                    no.setFatorBalanceamento((byte) -1);
                    break;
                case -1:
                    no = this.rotaçãoDireita(no);
            }
        return no;
    }

    private Nodo balancearEsq(Nodo no) {
        if (this.h)
            switch (no.getFatorBalanceamento()) {
                case -1:
                    no.setFatorBalanceamento((byte) 0);
                    this.h = false;
                    break;
                case 0:
                    no.setFatorBalanceamento((byte) 1);
                    break;
                case 1:
                    no = this.rotaçãoEsquerda(no);
            }
        return no;
    }

    private Nodo rotaçãoDireita(Nodo no) {
        Nodo temp1, temp2;
        temp1 = no.getEsq();
        if (temp1.getFatorBalanceamento() == -1) {
            no.setEsq(temp1.getDir());
            temp1.setDir(no);
            no.setFatorBalanceamento((byte) 0);
            no = temp1;
        } else {
            temp2 = temp1.getDir();
            temp1.setDir(temp2.getEsq());
            temp2.setEsq(temp1);
            no.setEsq(temp2.getDir());
            temp2.setDir(no);
            if (temp2.getFatorBalanceamento() == -1)
                no.setFatorBalanceamento((byte) 1);
            else
                no.setFatorBalanceamento((byte) 0);
            if (temp2.getFatorBalanceamento() == 1)
                temp1.setFatorBalanceamento((byte) -1);
            else
                temp1.setFatorBalanceamento((byte) 0);
            no = temp2;
        }
        no.setFatorBalanceamento((byte) 0);
        this.h = false;
        return no;
    }

    private Nodo rotaçãoEsquerda(Nodo no) {
        Nodo temp1, temp2;
        temp1 = no.getDir();
        if (temp1.getFatorBalanceamento() == 1) {
            no.setDir(temp1.getEsq());
            temp1.setEsq(no);
            no.setFatorBalanceamento((byte) 0);
            no = temp1;
        } else {
            temp2 = temp1.getEsq();
            temp1.setEsq(temp2.getDir());
            temp2.setDir(temp1);
            no.setDir(temp2.getEsq());
            temp2.setEsq(no);
            if (temp2.getFatorBalanceamento() == 1)
                no.setFatorBalanceamento((byte) -1);
            else
                no.setFatorBalanceamento((byte) 0);
            if (temp2.getFatorBalanceamento() == -1)
                temp1.setFatorBalanceamento((byte) 1);
            else
                temp1.setFatorBalanceamento((byte) 0);
            no = temp2;
        }
        no.setFatorBalanceamento((byte) 0);
        this.h = false;
        return no;
    }

    private boolean isFirst(Pessoa pessoa1, Pessoa pessoa2) {
        int compareCpfResult = pessoa1.getCpf().compareTo(pessoa2.getCpf());
        if (compareCpfResult < 0) {
            return true;
        } else if (compareCpfResult == 0) {
            int compareAgenciaResult = pessoa1.getAgencia().compareTo(pessoa2.getAgencia());
            if (compareAgenciaResult < 0) {
                return true;
            } else if (compareAgenciaResult == 0) {
                int compareContaResult = pessoa1.getConta().compareTo(pessoa2.getConta());
                return (compareContaResult < 0);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean pesquisa(String chave) {
        Nodo temp;

        temp = this.pesquisa(chave, this.raiz);
        if (temp != null)
            return true;
        else
            return false;
    }

    private Nodo pesquisa(String chave, Nodo no) {
        Nodo temp;
        temp = no;

        if (temp != null) {
            if (chave.compareTo(temp.getPessoa().getCpf()) < 0)
                temp = this.pesquisa(chave, temp.getEsq());
            else {
                if (chave.compareTo(temp.getPessoa().getCpf()) > 0)
                    temp = this.pesquisa(chave, temp.getDir());
            }
        }
        return temp;
    }

    public Nodo remove(String chave) {
        return remove(chave, raiz);
    }

    private Nodo remove(String chave, Nodo arv) {
        if (arv == null)
            return arv;
        else {
            if (chave.compareTo(arv.getPessoa().getCpf()) < 0)
                arv.setEsq(this.remove(chave, arv.getEsq()));
            else if (chave.compareTo(arv.getPessoa().getCpf()) > 0)
                arv.setDir(this.remove(chave, arv.getDir()));
            else if (arv.getDir() == null)
                return arv.getEsq();
            else if (arv.getEsq() == null)
                return arv.getDir();
            else
                arv.setEsq(this.arruma(arv, arv.getEsq()));
        }
        return arv;
    }

    private Nodo arruma(Nodo Q, Nodo R) {
        if (R.getDir() != null)
            R.setDir(this.arruma(Q, R.getDir()));
        else {
            Q.setPessoa(R.getPessoa());
            R = R.getEsq();
        }
        return R;
    }

    public Nodo pesquisar(String chave, Nodo no) {
        if (no != null) {
            if (chave.compareTo(no.getPessoa().getCpf()) < 0) {
                no = pesquisar(chave, no.getEsq());
            } else {
                if (chave.compareTo(no.getPessoa().getCpf()) > 0) {
                    no = pesquisar(chave, no.getDir());
                }
            }
        }
        return no;
    }

}
