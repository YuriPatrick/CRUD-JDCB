package testJUnit;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.Conexao;
import dao.ProdutoDao;
import model.Produto;

class ProdutoServiceTest {

	ProdutoDao pd = new ProdutoDao();

	Logger logger = Logger.getLogger("testJUnit.ProdutoServiceTest");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		Connection con = Conexao.getConnection();
		assertNotNull("Não foi possível conectar no banco de dados", con);

	}

	@Test
	void testSalvar() throws Exception {
		Produto p = new Produto();

		p.setNome("motor");
		p.setDescricao("motorVW");
		p.setQnt(10);
		p.setObs("motorVW");

		Assert.assertEquals("motor", p.getNome());
		Assert.assertEquals("motorVW", p.getDescricao());
		Assert.assertEquals(10, p.getQnt());
		Assert.assertEquals("motorVW", p.getObs());

		pd.adiciona(p);

		logger.info("Produto salvo");

	}

	@Test
	public void testExcluir() throws Exception {
		String id = "54";
		Produto produto = new Produto();
		produto.setId(Integer.parseInt(id));
		new ProdutoDao().remove(produto);
	}

	@Test
	public void testConsulta() throws Exception {
		logger.info("Consulta: " + pd.getAll());

	}

	@Test
	public void testBuscaPorID() throws Exception {
		String id = "55";
		logger.info("Busca por ID: " + pd.getId(Integer.parseInt(id)));
		

	}

}
