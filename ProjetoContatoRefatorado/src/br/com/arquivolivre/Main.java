package br.com.arquivolivre;

import br.com.arquivolivre.modelo.Contato;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //ler arquivo
        ArquivoContato arquivo = new ArquivoContato("arquivo.txt");
        Contatos contatos = new Contatos(arquivo.lerContatosDoArquivo());
        LeitorContato leitor = new LeitorContato();
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        while (opcao != 3) {
            imprimirOpcoes();
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    contatos.adicionarContato(leitor.lerContatoDoTeclado());
                    break;
                case 2:
                    System.out.print("Digite o nome da pessoa: ");
                    Contato contato = contatos.buscaContato(scanner.nextLine());
                    if (contato == null) {
                        System.out.println("Contato inexistente");
                    } else {
                        contato.imprime();
                    }
                    break;
                case 3:
                    break;
            }
        }
        // salvar arquivo
        arquivo.salvarContatosNoArquivo(contatos);

    }

    private static void imprimirOpcoes() {
        System.out.println("1-Cadastrar novo contato");
        System.out.println("2-Visualizar contato");
        System.out.println("3-Sair");
        System.out.print("Digite sua opção: ");
    }
}
