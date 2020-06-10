package testJUnit;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.ClienteDao;
import dao.Conexao;
import model.Cliente;

public class ClienteServiceTest {

	ClienteDao cd = new ClienteDao();

	Logger logger = Logger.getLogger("testJUnit.ClienteServiceTest");

	@Before
	public void setUp() throws Exception {

		Connection con = Conexao.getConnection();
		assertNotNull("Não foi possível conectar no banco de dados", con);
	}

	@Test
	public void testSalvar() throws Exception {
		Cliente c1 = new Cliente();
		c1.setNome("jose");
		c1.setSobrenome("joao");
		c1.setCpf("523532");
		c1.setDataNascimento("18-06-1991");
		c1.setLocalidade("SC");

		Assert.assertEquals("jose", c1.getNome());
		Assert.assertEquals("joao", c1.getSobrenome());
		Assert.assertEquals("523532", c1.getCpf());
		Assert.assertEquals("18-06-1991", c1.getDataNascimento());
		Assert.assertEquals("SC", c1.getLocalidade());

		cd.adiciona(c1);

		logger.info("cliente salvo");

	}

	@Test
	public void testExcluir() throws Exception {
		String id = "1";
		Cliente cliente = new Cliente();
		cliente.setId(Integer.parseInt(id));
		new ClienteDao().remove(cliente);
	}

	@Test
	public void testConsulta() throws Exception {
		logger.info("Consulta: " + cd.getAll());

	}

	@Test
	public void testBuscaPorID() throws Exception {
		String id = "31";
		logger.info("Busca por ID: " + cd.getId(Integer.parseInt(id)));
	}

}
