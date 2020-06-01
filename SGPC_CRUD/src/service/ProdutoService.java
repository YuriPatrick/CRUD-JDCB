package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.EmptyFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.ProdutoDao;
import model.Produto;

/**
 * Servlet implementation class ProdutoService
 */
@WebServlet("/ProdutoService")
public class ProdutoService extends HttpServlet {

	private static final String ID_PROD = "idProd";

	private static final String NOM_PROD = "nomProd";

	private static final String DESC_PROD = "descProd";

	private static final String QNT_PROD = "qntProd";

	private static final String OBS_PROD = "obsProd";

	private static final String SAVE_DIR = "uploadFiles";

	private static final long serialVersionUID = 1L;

	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProdutoDao dao = new ProdutoDao();
			Produto produto = new Produto();

			String nome = request.getParameter(NOM_PROD);
			String descricao = request.getParameter(DESC_PROD);
			int qnt = Integer.parseInt(request.getParameter(QNT_PROD));
			String obs = request.getParameter(OBS_PROD);

			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setQnt(qnt);
			produto.setObs(obs);

			dao.adiciona(produto);

		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Produto produto = new Produto();
			String id = request.getParameter(ID_PROD);
			String nome = request.getParameter(NOM_PROD);
			String descricao = request.getParameter(DESC_PROD);
			int qnt = Integer.parseInt(request.getParameter(QNT_PROD));
			String obs = request.getParameter(OBS_PROD);

			produto.setId(Integer.parseInt(id));
			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setQnt(qnt);
			produto.setObs(obs);

			new ProdutoDao().update(produto);

		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Produto produto = new Produto();
			produto.setId(Integer.parseInt(id));
			new ProdutoDao().remove(produto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> produtos = new ProdutoDao().getAll();
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String descricao = request.getParameter("descricao");
			List<Produto> produtos = new ProdutoDao().getProduto(descricao);
			request.setAttribute("produtos", produtos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getProdutoById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Produto produto = new ProdutoDao().getId(Integer.parseInt(id));
			request.setAttribute("produto", produto);
			request.setAttribute("produtoId", Integer.parseInt(id));
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

		Cell cell = row.createCell(cellnum);

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
			//cell = row.createCell(cellnum++);
			//cell.setCellValue(p.getId());

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

	public void importeExcel(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// String appPath = request.getServletContext().getRealPath("");
		String appPath = "C:\\Users\\f0fp631\\Documents";
		String savePath = appPath + File.separator + SAVE_DIR;

		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		Part p = request.getPart("file");

		InputStream is = p.getInputStream();

		byte[] b = IOUtils.toByteArray(is);

		FileOutputStream fos = null;

		String caminho = savePath + File.separator + "teste.xls";

		try {
			// create new file output stream
			fos = new FileOutputStream(caminho);

			// writes bytes to the output stream
			fos.write(b);

			// flushes the content to the underlying stream
			fos.flush();

		} catch (Exception ex) {

			// if an error occurs
			ex.printStackTrace();

		}

		uploadExcel(caminho, response);

	}

	public void uploadExcel(String upload, HttpServletResponse response) throws IOException, ServletException {

		ProdutoDao dao = new ProdutoDao();

		List<Produto> produtos = new ArrayList<>();

		// Recuparando o arquivo
		FileInputStream excelFile = new FileInputStream(new File(upload));
		try {
		Workbook workbook = new XSSFWorkbook(excelFile);

		// Setando a aba
		Sheet sheet = workbook.getSheetAt(0);

		// Setando as linhas
		List<Row> rows = (List<Row>) toList(sheet.iterator());

		// Remover o cabeçalho
		rows.remove(0);

		rows.forEach(row -> {

			// Setando as celulas
			List<Cell> cells = (List<Cell>) toList(row.cellIterator());

			Produto p = new Produto();

			p.setNome(cells.get(0).getStringCellValue());
			p.setDescricao(cells.get(1).getStringCellValue());
			p.setQnt((int) cells.get(2).getNumericCellValue());
			p.setObs(cells.get(3).getStringCellValue());

			produtos.add(p);

			try {
				dao.adiciona(p);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		
		}catch (EmptyFileException e) {
			System.out.print("Nenhum arquivo escolhido para upload");
		}
	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}

}
