package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.ClienteDao;
import model.Cliente;

/**
 * Servlet implementado o cliente com requisições e respostas, com as operações de
 * cadastrar,consultar,alterar,exportar excel e deletar.. {@link HttpServlet}
 */
@WebServlet("/ClienteService")
public class ClienteService extends HttpServlet {

	private static final String ID_CLIE = "idClie";

	private static final String NOM_CLIE = "nomeClie";

	private static final String SOBRE_CLIE = "sobreClie";

	private static final String CPF_CLIE = "cpfClie";

	private static final String DATANASC_CLIE = "dataNascClie";

	private static final String LOCAL_CLIE = "localClie";

	ClienteDao dao = new ClienteDao();
	Cliente cliente = new Cliente();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#adiciona(HttpServletRequest request, HttpServletResponse response) 
	 * Método adiciona com a requisição para salvar os dados no SGBD.
	 * @param HttpServletRequest request
	 */
	public void adiciona(HttpServletRequest request)
			throws ServletException, IOException {
		try {

			String nome = request.getParameter(NOM_CLIE);
			String sobrenome = request.getParameter(SOBRE_CLIE);
			String cpf = request.getParameter(CPF_CLIE);
			String data = request.getParameter(DATANASC_CLIE);
			String localidade = request.getParameter(LOCAL_CLIE);

			cliente.setNome(nome);
			cliente.setSobrenome(sobrenome);
			cliente.setCpf(cpf);
			cliente.setDataNascimento(data);
			cliente.setLocalidade(localidade);
			dao.adiciona(cliente);

		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#adiciona(HttpServletRequest request, HttpServletResponse response) 
	 * Método atualiza os dados no SGBD com a requisição do servlet.
	 * @param HttpServletRequest request
	 */
	public void update(HttpServletRequest request) throws ServletException, IOException {
		try {

			String idClie = request.getParameter(ID_CLIE);
			String nome = request.getParameter(NOM_CLIE);
			String sobrenome = request.getParameter(SOBRE_CLIE);
			String cpf = request.getParameter(CPF_CLIE);
			String data = request.getParameter(DATANASC_CLIE);
			String localidade = request.getParameter(LOCAL_CLIE);

			cliente.setId(Integer.parseInt(idClie));
			cliente.setNome(nome);
			cliente.setSobrenome(sobrenome);
			cliente.setCpf(cpf);
			cliente.setDataNascimento(data);
			cliente.setLocalidade(localidade);

			new ClienteDao().update(cliente);

		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#remove(HttpServletRequest request, HttpServletResponse response) 
	 * Método remove os dados no SGBD com a requisição do servlet.
	 * @param HttpServletRequest request
	 */
	public void remove(HttpServletRequest request) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(id));
			new ClienteDao().remove(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#getAll(HttpServletRequest request, HttpServletResponse response) 
	 * Método lista os dados cadastrado no SGBD com a requisição do servlet.
	 * @param HttpServletRequest request
	 */
	public void getAll(HttpServletRequest request) throws ServletException, IOException {
		try {
			List<Cliente> clientes = new ClienteDao().getAll();
			request.setAttribute("clientes", clientes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#getClienteById(HttpServletRequest request, HttpServletResponse response) 
	 * Método busca os dados por ID cadastrado no SGBD com a requisição do servlet.
	 * @param HttpServletRequest request
	 */
	public void getClienteById(HttpServletRequest request)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			cliente = new ClienteDao().getId(Integer.parseInt(id));
			request.setAttribute("cliente", cliente);
			// srequest.setAttribute("produtoId", Integer.parseInt(id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#exportExcel(HttpServletResponse response) 
	 * Método exporte Excel com a resposta para exporta os dados salvo do SGBD.
	 * @param HttpServletResponse response
	 */
	public void exportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=clienteList.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("list");
		List<Cliente> clientes = new ClienteDao().getAll();

		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeight((short) 400);
		sheet.setHorizontallyCenter(true);

		int rowNo = 0;
		Row row = sheet.createRow(rowNo++);
		int cellnum = 0;

		Cell cell = row.createCell(cellnum++);
		cell.setCellValue("Nome Cliente");

		cell = row.createCell(cellnum++);
		cell.setCellValue("SobreNome Cliente");

		cell = row.createCell(cellnum++);
		cell.setCellValue("CPF Cliente");

		cell = row.createCell(cellnum++);
		cell.setCellValue("Data de Nascimento Cliente");

		cell = row.createCell(cellnum++);
		cell.setCellValue("Localidade Cliente");

		for (Cliente c : clientes) {
			cellnum = 0;
			row = sheet.createRow(rowNo++);
			// cell = row.createCell(cellnum++);
			// cell.setCellValue(p.getId());

			cell = row.createCell(cellnum++);
			cell.setCellValue(c.getNome());

			cell = row.createCell(cellnum++);
			cell.setCellValue(c.getSobrenome());

			cell = row.createCell(cellnum++);
			cell.setCellValue(c.getCpf());

			cell = row.createCell(cellnum++);
			cell.setCellValue(c.getDataNascimento());

			cell = row.createCell(cellnum++);
			cell.setCellValue(c.getLocalidade());
		}

		wb.write(response.getOutputStream());
		wb.close();

	}

}
