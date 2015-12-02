package br.com.zup.contatos.db;

import br.com.arquivolivre.contatos.db.ConectorMysql;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
public class ConectorMysqlTest {

    private ConectorMysql conector;

    @Before
    public void setUp() {
        conector = new ConectorMysql("contatos", "root", "klapa22");
    }

    @Test
    public void testarNovoStatement() {
        assertNotNull(conector.novoStatement());
    }

    @Test
    public void testarPreparartatement() {
        String sql = "select * from agenda where id=?";
        assertNotNull(conector.prepararStatement(sql));
    }
    
    @Test
    public void testarConexaoAberta(){
        assertTrue(conector.estaAberta());
    }
    
    @Test
    public void testarFecharConexao(){
        assertTrue(conector.fecharConexao());
    }
    
    @Test
    public void testarConexaoFechada(){
        conector.fecharConexao();
        assertFalse(conector.estaAberta());
    }

}
