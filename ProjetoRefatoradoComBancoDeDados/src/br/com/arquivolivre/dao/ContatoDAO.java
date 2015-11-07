package br.com.arquivolivre.dao;

import br.com.arquivolivre.db.ConectorBanco;
import br.com.arquivolivre.modelo.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements DAO<Contato> {

    ConectorBanco conector;

    public ContatoDAO(ConectorBanco conector) {
        this.conector = conector;
    }

    @Override
    public List<Contato> listarTodos() {
        List<Contato> contatos = new ArrayList<>();
        try {
            Statement consulta = conector.novoStatement();
            ResultSet resultado = consulta.executeQuery("select * from agenda");
            contatos = popularListaContatos(resultado);
        } catch (SQLException ex) {
            System.out.println("Não foi possivel executar a requisicao.");
        }
        return contatos;
    }

    @Override
    public List<Contato> buscarPorNome(String nome) {
        List<Contato> contatos = new ArrayList<>();
        try {
            PreparedStatement consulta = conector.prepararStatement("select * from agenda where nome like ?");
            consulta.setString(1, String.format("%%%s%%", nome));
            ResultSet resultado = consulta.executeQuery();
            contatos = popularListaContatos(resultado);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return contatos;
    }

    private List<Contato> popularListaContatos(ResultSet resultado) throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        while (resultado.next()) {
            Contato contato = popularContato(resultado);
            contatos.add(contato);
        }
        return contatos;
    }

    private Contato popularContato(ResultSet resultado) throws SQLException {
        Contato contato = new Contato();
        contato.setId(resultado.getInt("id"));
        contato.setNome(resultado.getString("nome"));
        contato.setTelefone(resultado.getString("telefone"));
        contato.setEmail(resultado.getString("email"));
        return contato;
    }

    @Override
    public Contato buscarPorId(int id) {
        Contato contato = null;
        try {
            PreparedStatement consulta = conector.prepararStatement("select * from agenda where id=?");
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.first()) {
                contato = popularContato(resultado);
            }

        } catch (SQLException ex) {
            System.out.println("Não foi possivel executar a requisicao");
        }
        return contato;
    }

    @Override
    public boolean inserir(Contato obj) {
        try {
            PreparedStatement insersao = conector.prepararStatement("insert into agenda(nome, telefone, email) values(?, ?, ?)");
            insersao.setString(1, obj.getNome());
            insersao.setString(2, obj.getTelefone());
            insersao.setString(3, obj.getEmail());
            return insersao.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Não foi possivel inserir no banco.");
        }
        return false;
    }

    @Override
    public boolean atualizar(Contato obj) {
        try {
            PreparedStatement atualizacao = conector.prepararStatement("update agenda set nome=?, telefone=?, email=? where id=?");
            atualizacao.setString(1, obj.getNome());
            atualizacao.setString(2, obj.getTelefone());
            atualizacao.setString(3, obj.getEmail());
            atualizacao.setInt(4, obj.getId());
            return atualizacao.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Não foi possivel alterar registro do banco.");
        }
        return false;
    }

    @Override
    public boolean remover(Contato obj) {
        try {
            PreparedStatement remocao = conector.prepararStatement("delete from agenda where id=?");
            remocao.setInt(1, obj.getId());
            return remocao.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Não foi possivel apagar o registro do banco.");
        }
        return false;
    }

}
