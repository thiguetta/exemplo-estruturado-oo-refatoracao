package br.com.zup.contatos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorMysql implements ConectorBanco {

    private Connection conexao;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
        }
    }

    public ConectorMysql(String nomeDaBase, String usuario, String senha) {
        try {
            String urlDoBanco = String.format("jdbc:mysql://localhost:3306/%s", nomeDaBase);
            conexao = DriverManager.getConnection(urlDoBanco, usuario, senha);
        } catch (SQLException ex) {
            System.out.println("Não foi possivel conectar ao banco de dados.");
        }
    }

    @Override
    public boolean fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Não foi possivel finalizar a conexao do banco");
            return false;
        }
        return true;
    }

    @Override
    public boolean estaAberta() {
        try {
            return !conexao.isClosed();
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public Statement novoStatement() {
        try {
            return conexao.createStatement();
        } catch (SQLException ex) {
            System.out.println("Não foi possivel criar o Statement");
        }
        return null;
    }

    @Override
    public PreparedStatement prepararStatement(String sql) {
        try {
            return conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Não foi possivel preparar um Statement");
        }
        return null;
    }

}
