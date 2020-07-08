package com.testJUnit;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dao.Conexao;
import com.dao.ProdutoDao;
import com.model.Produto;

class ProdutoServiceTest {

	ProdutoDao produtoDao = new ProdutoDao();
	
	Logger logger = Logger.getLogger("testJUnit.ClienteServiceTest");


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

		produtoDao.adiciona(p);
		
		logger.info("Salva Produto");

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
		logger.info("Consulta: " + produtoDao.getAll());

	}

	@Test
	public void testBuscaPorID() throws Exception {
		String id = "55";
		logger.info("Busca por ID: " + produtoDao.getId(Integer.parseInt(id)));
		

	}

}
