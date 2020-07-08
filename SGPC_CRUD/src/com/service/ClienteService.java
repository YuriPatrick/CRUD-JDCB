package com.service;

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

import com.dao.ClienteDao;
import com.model.Cliente;

/**
 * SERVLET IMPLEMENTADO O CLIENTE COM REQUISIÇÕES E RESPOSTAS, COM AS OPERAÇÕES
 * DE CADASTRAR,CONSULTAR,ALTERAR,EXPORTAR EXCEL E DELETAR..
 * 
 * {@link HttpServlet}
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
	 * @see HTTPSERVLET#ADICIONA(HttpServletRequest request, ) MÉTODO ADICIONA COM A
	 *      REQUISIÇÃO PARA SALVAR OS DADOS NO SGBD.
	 * 
	 * 
	 * @param HttpServletRequest request
	 */
	public void adiciona(HttpServletRequest request) throws ServletException, IOException {
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
			
			request.setAttribute("msg_resultado", "Cliente cadastrado com sucesso!!");
			
			String msg_resultado = "Dados gravados com sucesso!";
			request.setAttribute("mensagem", msg_resultado);

			
			
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	/**
	 * @see HTTPSERVLET#UPDATE(HttpServletRequest request, ) MÉTODO ATUALIZA OS
	 *      DADOS NO SGBD COM A REQUISIÇÃO DO SERVLET.
	 * 
	 * 
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
	 * @see HTTPSERVLET#REMOVE(HttpServletRequest request) MÉTODO REMOVE OS DADOS NO
	 *      SGBD COM A REQUISIÇÃO DO SERVLET.
	 * 
	 * 
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
	 * @see HTTPSERVLET#GETALL(HttpServletRequest request) MÉTODO LISTA OS DADOS
	 *      CADASTRADO NO SGBD COM A REQUISIÇÃO DO SERVLET.
	 * 
	 * 
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
	 * @see HTTPSERVLET#GETCLIENTEBYID(HttpServletRequest request) MÉTODO BUSCA OS
	 *      DADOS POR ID CADASTRADO NO SGBD COM A REQUISIÇÃO DO SERVLET.
	 * 
	 * 
	 * @param HttpServletRequest request
	 */
	public void getClienteById(HttpServletRequest request) throws ServletException, IOException {
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
	 * @see HTTPSERVLET#EXPORTEXCEL(HttpServletResponse response) MÉTODO EXPORTE
	 *      EXCEL COM A RESPOSTA PARA EXPORTA OS DADOS SALVO DO SGBD.
	 * 
	 * 
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
