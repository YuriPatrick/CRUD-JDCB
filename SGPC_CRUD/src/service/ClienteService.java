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
import dao.ProdutoDao;
import model.Cliente;
import model.Produto;

/**
 * Servlet implementation class ClienteService
 */
@WebServlet("/ClienteService")
public class ClienteService extends HttpServlet {
	
	private static final String ID_CLIE = "idClie";

	private static final String NOM_CLIE = "nomeClie";

	private static final String SOBRE_CLIE = "sobreClie";

	private static final String CPF_CLIE = "cpfClie";

	private static final String DATANASC_CLIE = "dataNascClie";

	private static final String LOCAL_CLIE = "localClie";
	
	private static final long serialVersionUID = 1L;
       
	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ClienteDao dao = new ClienteDao();
			Cliente cliente = new Cliente();

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

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Cliente cliente = new Cliente();
			
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

	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(id));
			new ClienteDao().remove(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Cliente> clientes = new ClienteDao().getAll();
			request.setAttribute("clientes", clientes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void getClienteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Cliente cliente = new ClienteDao().getId(Integer.parseInt(id));
			request.setAttribute("cliente", cliente);
			//srequest.setAttribute("produtoId", Integer.parseInt(id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=produtoList.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("list");
		List<Produto> produtos = new ProdutoDao().getAll();

		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeight((short) 400);
		sheet.setHorizontallyCenter(true);

		int rowNo = 0;
		Row row = sheet.createRow(rowNo++);
		int cellnum = 0;

		Cell cell = row.createCell(cellnum++);
		cell.setCellValue("ID Produto");

		cell = row.createCell(cellnum++);
		cell.setCellValue("Nome Produto");

		cell = row.createCell(cellnum++);
		cell.setCellValue("Descrição Produto");

		cell = row.createCell(cellnum++);
		cell.setCellValue("Quantidade Produto");

		cell = row.createCell(cellnum++);
		cell.setCellValue("Observação Produto");

		for (Produto p : produtos) {
			cellnum = 0;
			row = sheet.createRow(rowNo++);
			cell = row.createCell(cellnum++);
			cell.setCellValue(p.getId());

			cell = row.createCell(cellnum++);
			cell.setCellValue(p.getNome());

			cell = row.createCell(cellnum++);
			cell.setCellValue(p.getDescricao());

			cell = row.createCell(cellnum++);
			cell.setCellValue(p.getQnt());

			cell = row.createCell(cellnum++);
			cell.setCellValue(p.getObs());
		}

		wb.write(response.getOutputStream());
		wb.close();

	}

}
