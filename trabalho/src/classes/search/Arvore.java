package classes.search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import classes.models.NoArvore;
import classes.models.Pessoa;
import utils.DataFetcher;

public class Arvore {
    public NoArvore raiz;
    private DataFetcher dataFetcher = new DataFetcher();

    public Arvore() {
        this.raiz = null;
    }

    public long rotinaArvoreAvlArquivo(String inputFileName, int inputRegisterSize, String outPutFileFindName)
            throws Exception {
        long startTime = System.currentTimeMillis();
        Pessoa[] pessoas = dataFetcher.getPessoasFromFile(inputFileName, inputRegisterSize);
        for (int i = 0; i < pessoas.length; i++) {
            insere(pessoas[i]);
        }
        Arvore arvoreBalanceada = arvoreBalanceada(camCentral(new TabelaOrd(inputRegisterSize)));
        arvoreBalanceada.fazRotinaPesquisaCpf(outPutFileFindName);

        long estimatedTime = System.currentTimeMillis() - startTime;

        return estimatedTime;
    }

    public void fazRotinaPesquisaCpf(String outPutFileFindName) throws Exception {
        String[] cpfs = dataFetcher.getCpfsFromFile("src/basedados/Conta.txt", 400);
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < cpfs.length; i++) {
            ArrayList<Pessoa> pessoasEncontradas = new ArrayList<Pessoa>();
            NoArvore nodoEncontrado;
            while (pesquisar(cpfs[i])) {
                nodoEncontrado = this.remove(cpfs[i]);
                pessoasEncontradas.add(nodoEncontrado.getPessoa());
            }

            String texto;
            if (pessoasEncontradas.size() <= 0) {
                texto = "CPF " + cpfs[i] + ":\nNÃO HÁ NENHUM REGISTRO COM O CPF 12345612344\n";
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

    }

    private void insere(Pessoa elem) {
        this.raiz = this.insere(elem, this.raiz);
    }

    public NoArvore insere(Pessoa elem, NoArvore no) {
        NoArvore novo;
        if (no == null) {
            novo = new NoArvore(elem);
            return novo;
        } else {
            if (isFirst(elem, no.getPessoa())) {
                no.setEsq(this.insere(elem, no.getEsq()));
                return no;
            } else {
                no.setDir(this.insere(elem, no.getDir()));
                return no;
            }
        }
    }

    public TabelaOrd camCentral(TabelaOrd vetOrdenado) {
        return (this.fazCamCentral(this.raiz, vetOrdenado));
    }

    private TabelaOrd fazCamCentral(NoArvore arv, TabelaOrd vetOrdenado) {
        if (arv != null) {
            vetOrdenado = this.fazCamCentral(arv.getEsq(), vetOrdenado);
            vetOrdenado.insere(arv.getPessoa());
            vetOrdenado = this.fazCamCentral(arv.getDir(), vetOrdenado);
        }
        return vetOrdenado;
    }

    public Arvore arvoreBalanceada(TabelaOrd vetOrdenado) {
        Arvore temp = new Arvore();
        this.balancear(vetOrdenado, temp, 0, vetOrdenado.getNumeroElementos() - 1);
        return temp;
    }

    private void balancear(TabelaOrd vet, Arvore temp, int inic, int fim) {
        int meio;
        if (fim >= inic) {
            meio = (inic + fim) / 2;
            temp.insere(vet.getPessoa(meio));
            this.balancear(vet, temp, inic, meio - 1);
            this.balancear(vet, temp, meio + 1, fim);
        }
    }

    public NoArvore remove(String chave) {
        return remove(chave, raiz);
    }

    private NoArvore remove(String chave, NoArvore arv) {
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

    private NoArvore arruma(NoArvore Q, NoArvore R) {
        if (R.getDir() != null)
            R.setDir(this.arruma(Q, R.getDir()));
        else {
            Q.setPessoa(R.getPessoa());
            R = R.getEsq();
        }
        return R;
    }

    // comparacao de pessoa
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

    public boolean pesquisar(String chave) {
        return (pesquisar(chave, this.raiz) != null);
    }

    private NoArvore pesquisar(String chave, NoArvore no) {
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
