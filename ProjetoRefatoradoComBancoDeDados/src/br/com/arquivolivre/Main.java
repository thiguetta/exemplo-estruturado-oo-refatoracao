package br.com.arquivolivre;

import br.com.arquivolivre.db.ConectorBanco;
import br.com.arquivolivre.db.ConectorMysql;
import br.com.arquivolivre.modelo.Contato;
import br.com.arquivolivre.dao.ContatoDAO;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //ler arquivo
//        ArquivoContato arquivo = new ArquivoContato("arquivo.txt");
//        Contatos contatos = new Contatos(arquivo.lerContatosDoArquivo());
        //conexao com o banco;
        ConectorBanco conector = new ConectorMysql("contatos", "root", "klapa22");
        ContatoDAO contatoDAO = new ContatoDAO(conector);
        LeitorContato leitor = new LeitorContato();
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        while (opcao != 3) {
            imprimirOpcoes();
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    contatoDAO.save(leitor.lerContatoDoTeclado());
                    break;
                case 2:
                    System.out.print("Digite o nome da pessoa: ");
                    List<Contato> contatoPorNome = contatoDAO.findByName(scanner.nextLine());
                    for (Contato contato : contatoPorNome) {
                        System.out.println(contato);
                    }
                    break;
                case 3:
                    break;
            }
        }
        // salvar arquivo
        //arquivo.salvarContatosNoArquivo(contatos);

        //fechar a conexao com o banco
        conector.fecharConexao();

    }

    private static void imprimirOpcoes() {
        System.out.println("1-Cadastrar novo contato");
        System.out.println("2-Visualizar contato");
        System.out.println("3-Sair");
        System.out.print("Digite sua opção: ");
    }
}
