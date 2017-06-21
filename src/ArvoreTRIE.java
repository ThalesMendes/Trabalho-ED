import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thales Castro on 12/06/2017.
 */
public class ArvoreTRIE {
    private static final int ALFABETO = 26;
    private No raiz;
    private boolean prefixoExiste;

    public ArvoreTRIE() {
        this.raiz = new No();
        this.prefixoExiste = false;
    }

    // Insere a palavra na arvore
    public void inserir(String nome, double preco) {
        No p = raiz;

        for(int i = 0; i < nome.length(); i++){
            char c = nome.charAt(i);

            int indice = c - 'a';

            if(p.getChaves()[indice] == null){
                No aux = new No();
                p.getChaves()[indice] = aux;
                p = aux;
            }

            else{
                p = p.getChaves()[indice];
            }
        }
        p.setEhChave(true);
        p.setPreco(preco);
        p.setNome(nome);
    }

    //Procuro pelo nome do produto. Se for chave, eu retorno ele. Se nao encontrei ou se ele nao é chave, retorno NULL
    public No getNoChave(String nome) {
        No p = procuraNoPrefixo(nome);
        if(p != null)
            if(p.isEhChave())
                return p;

        return null;
    }

    public void getSugestoes(String prefixo){
        auxGetSugestoes(prefixo);
        if(! this.prefixoExiste){
            System.out.print("Nao achamos o que voce digitou. Talvez voce quis dizer: ");
            for(int i = prefixo.length(); i > 0; i--){

                StringBuilder stringBuilder = new StringBuilder(prefixo);
                stringBuilder.deleteCharAt(i - 1);
                prefixo = stringBuilder.toString();
                auxGetSugestoesNaoEncontrei(prefixo);
                if(this.prefixoExiste)
                    return;
            }
        }
        prefixoExiste = false;
    }

    //Imprimo todas palavras que começam com o prefixo digitado
    public void auxGetSugestoes(String prefixo){

        No p = procuraNoPrefixo(prefixo);

        if(p == null)
            return;

        for(int i = 0; i < ALFABETO; i++){
            No aux = p.getChaves()[i];

            if (aux != null && aux.isEhChave()){
                System.out.println(aux.getNome());
                this.prefixoExiste = true;
            }

            auxGetSugestoes(prefixo + (char) ('a' + i));
        }
    }

    //essa é pra imprirmir as sugestoes quando nao encontrei a palavra que a pessoa digitou
    //fiz diferente porque ela so imprime uma vez e tem uma interrogacao no final
    public void auxGetSugestoesNaoEncontrei(String prefixo){
        No p = procuraNoPrefixo(prefixo);

        if(p == null)
            return;

        for(int i = 0; i < ALFABETO; i++) {
            No aux = p.getChaves()[i];

            if (aux != null && !prefixoExiste) {

                if( aux.isEhChave()) {
                    System.out.println(aux.getNome() + "?");
                    prefixoExiste = true;
                    return;
                }

                auxGetSugestoesNaoEncontrei(prefixo + (char) ('a' + i));
            }
        }
    }

    //Retorna o No que começa com o prefixo digitado
    public No procuraNoPrefixo(String string){
        No p = raiz;

        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            int indice = c - 'a';

            if(p.getChaves()[indice] != null){
                p = p.getChaves()[indice];
            }
            else{
                return null;
            }
        }

        if(p==raiz)
            return null;

        return p;
    }

    public void imprimeRelatorio(){

        ArrayList<No> todosProdutos = new ArrayList<>();

        //essa funcao acha todos os nos que começam com a letra ('a' + i). Como o 'for' percorre todas as letras,
        //eu pego todos os nós
        for(int i = 0; i < ALFABETO; i++) {

            char adicionaNaStringParaIrProProximo = (char) ('a' + i);

            String nomeParaProcurar = "";
            nomeParaProcurar += adicionaNaStringParaIrProProximo;

            criaListaComTodosNos(todosProdutos, nomeParaProcurar);

        }

        System.out.println("testando a lista com todos produtos");

        for(No no : todosProdutos){
            System.out.println(no.getNome());
        }


    }

    private void criaListaComTodosNos(ArrayList<No> todosProdutos, String prefixo){

        No p = procuraNoPrefixo(prefixo);

        if(p == null)
            return;

        for(int i = 0; i < ALFABETO; i++){

            No aux = p.getChaves()[i];

            if(aux != null && aux.isEhChave()){
                todosProdutos.add(aux);
            }

            criaListaComTodosNos(todosProdutos, prefixo + (char) ('a' + i));
        }


    }



    //acho que nao precisa de voce. Na real ja esqueci porque te fiz
    public boolean busca(String nome) {
        No p = procuraNoPrefixo(nome);
        if(p == null){
            return false;
        }else{
            if(p.isEhChave())
                return true;
        }

        return false;
    }

}

