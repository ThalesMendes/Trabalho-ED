import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Thales Castro on 12/06/2017.
 */
public class Main {
    static public void main(String [] args) throws IOException, InterruptedException {

        ArvoreTRIE arvoreTRIE = new ArvoreTRIE();
        Scanner scanner = new Scanner(System.in);
        //FileReader in = new FileReader("C://Users//Thales Castro//Desktop//teste.txt");
        //BufferedReader br = new BufferedReader(in);


        arvoreTRIE.inserir("casa", 55);
        arvoreTRIE.inserir("casamento", 78);
        arvoreTRIE.inserir("cabana", 21);
        arvoreTRIE.inserir("caixa", 2);
        arvoreTRIE.inserir("banana", 14);

        String produto;
       // produto = scanner.nextLine();
       // arvoreTRIE.getSugestoes(produto);

        arvoreTRIE.imprimeRelatorio();

        /*
        No p = null;
        p = arvoreTRIE.getNoChave("casamento");
        if(p != null)
            System.out.println(p.getPreco());
        else
            System.out.println("Nao esta na arvore");
        */


        /*
        essa é a leitura de um txt simples, sem virgulas. Provavelmente nao vamos usar isso
        String linha;
        while (( linha = br.readLine()) != null) {
            arvoreTRIE.inserir(linha, 5);
        }
        in.close();
        */

    }


    public static void limparTela() {
        for(int i = 0; i<100; i++)
            System.out.println("\n");
    }
}

