/**
 * Created by Thales Castro on 12/06/2017.
 */



public class No {
    private static final int ALFABETO = 26;

    private No[] chaves ;
    private boolean ehChave;
    private String nome;
    private double preco;

    public No(String nome, double preco){
        this.chaves = new No[ALFABETO];
        this.nome = nome;
        this.preco = preco;
    }

    public No() {
        this.chaves = new No[ALFABETO];
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public No[] getChaves() {
        return chaves;
    }

    public void setChaves(No[] chaves) {
        this.chaves = chaves;
    }

    public boolean isEhChave() {
        return ehChave;
    }

    public void setEhChave(boolean ehChave) {
        this.ehChave = ehChave;
    }
}
