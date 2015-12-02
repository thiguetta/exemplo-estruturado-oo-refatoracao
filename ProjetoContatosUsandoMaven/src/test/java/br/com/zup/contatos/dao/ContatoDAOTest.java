package br.com.zup.contatos.dao;

import br.com.arquivolivre.contatos.dao.ContatoDAO;
import br.com.arquivolivre.contatos.db.ConectorMysql;
import br.com.arquivolivre.contatos.modelo.Contato;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatoDAOTest {

    static final Contato CONTATO_MOCK = new Contato();
    ConectorMysql conector;
    ContatoDAO dao;
    private static final Logger LOGGER = Logger.getLogger(ContatoDAOTest.class.getName());

    public ContatoDAOTest() {
        CONTATO_MOCK.setNome("teste");
        CONTATO_MOCK.setTelefone("teste");
        CONTATO_MOCK.setEmail("teste");
        conector = new ConectorMysql("contatos", "root", "klapa22");
        dao = new ContatoDAO(conector);
    }

    @Test
    public void a_testarInserir() {
        LOGGER.info("Testando método inserir.");
        assertTrue(dao.inserir(CONTATO_MOCK));
        LOGGER.info("Inserir testado com sucesso.");
    }

    @Test
    public void b_testarBuscaPorNome() {
        LOGGER.info("Testando método Busca por nome.");
        List<Contato> resultadoBusca = dao.buscarPorNome(CONTATO_MOCK.getNome());
        assertNotEquals(0, resultadoBusca.size());
        Contato retorno = resultadoBusca.get(0);
        assertEquals(CONTATO_MOCK.getNome(), retorno.getNome());
        assertEquals(CONTATO_MOCK.getTelefone(), retorno.getTelefone());
        assertEquals(CONTATO_MOCK.getEmail(), retorno.getEmail());
        CONTATO_MOCK.setId(retorno.getId());
        LOGGER.info("Buscar por nome testado com sucesso.");

    }

    @Test
    public void c_testarBuscaPorId() {
        LOGGER.info("Testando buscar por Id");
        Contato retorno = dao.buscarPorId(CONTATO_MOCK.getId());
        assertNotNull(retorno);
        assertEquals(CONTATO_MOCK.getNome(), retorno.getNome());
        assertEquals(CONTATO_MOCK.getTelefone(), retorno.getTelefone());
        assertEquals(CONTATO_MOCK.getEmail(), retorno.getEmail());
        LOGGER.info("Buscar por Id testado com sucesso.");

    }

    @Test
    public void d_testarAtualizar() {
        LOGGER.info("Testando atualizar.");
        CONTATO_MOCK.setEmail("teste_novo");
        assertTrue(dao.atualizar(CONTATO_MOCK));
        c_testarBuscaPorId();
        LOGGER.info("Atualizar testado com sucesso.");

    }

    @Test
    public void e_testarRemover() {
        LOGGER.info("Testando remover.");
        assertTrue(dao.remover(CONTATO_MOCK));
        Contato retorno = dao.buscarPorId(CONTATO_MOCK.getId());
        assertNull(retorno);
        LOGGER.info("Remover testado com sucesso.");

    }

}
