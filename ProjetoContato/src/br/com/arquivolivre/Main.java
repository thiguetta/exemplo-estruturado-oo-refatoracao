package br.com.arquivolivre;

import br.com.arquivolivre.modelo.Pessoa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        File arq = new File("arquivo.txt");
        Pessoa[] contatos = new Pessoa[0];
        try (Scanner sc = new Scanner(arq)) {
            sc.useDelimiter(",|\n");
            int tamanho = Integer.parseInt(sc.next());
            contatos = new Pessoa[tamanho];
            for (int i = 0; sc.hasNext(); i++) {
                Pessoa p = new Pessoa();
                p.setNome(sc.next());
                p.setTelefone(sc.next());
                contatos[i] = p;
            }
            System.out.println(Arrays.toString(contatos));
        } catch (FileNotFoundException ex) {
        }

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        Pessoa[] novosContatos = new Pessoa[0];
        while (opcao != 3) {
            System.out.println("1-Cadastrar novo contato");
            System.out.println("2-Visualizar contato");
            System.out.println("3-Sair");
            System.out.print("Digite sua opção: ");
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1:
                    novosContatos = Arrays.copyOf(novosContatos, novosContatos.length + 1);
                    Pessoa novaPessoa = new Pessoa();
                    System.out.print("Nome: ");
                    novaPessoa.setNome(sc.nextLine());
                    System.out.print("Telefone: ");
                    novaPessoa.setTelefone(sc.nextLine());
                    novosContatos[novosContatos.length - 1] = novaPessoa;
                    break;
                case 2:
                    System.out.print("Digite o nome da pessoa: ");
                    String busca = sc.nextLine();
                    for (Pessoa contato : contatos) {
                        if (contato.getNome().equals(busca)) {
                            System.out.printf("Nome: %s\n", contato.getNome());
                            System.out.printf("Telefone: %s \n", contato.getTelefone());
                        }
                    }
                    for (Pessoa contato : novosContatos) {
                        if (contato.getNome().equals(busca)) {
                            System.out.printf("Nome: %s\n", contato.getNome());
                            System.out.printf("Telefone: %s \n", contato.getTelefone());
                        }
                    }
                    break;
                case 3:
                    break;
            }
        }

        try (PrintWriter writer = new PrintWriter(arq)) {
            int total = contatos.length + novosContatos.length;
            writer.println(total);
            for (Pessoa pessoa : contatos) {
                writer.println(pessoa.toString());
            }
            for (Pessoa pessoa : novosContatos) {
                writer.println(pessoa.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
