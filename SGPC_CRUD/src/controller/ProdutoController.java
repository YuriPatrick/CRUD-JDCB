package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProdutoService;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet({ "/novo-produto", "/salva-produto", "/update-produto", "/remove-produto", "/lista-produtos",
		"/getId-produto", "/alteracao-produtos", "/exporte-produtos", "/importe-produtos" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProdutoService produtoService = new ProdutoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = request.getContextPath();
		String uri = request.getRequestURI();

		// Novo Produto
		if (uri.equalsIgnoreCase(path + "/novo-produto")) {
			request.getRequestDispatcher("/novo-produto.jsp").forward(request, response);
		}

		// Salva o produto
		if (uri.equalsIgnoreCase(path + "/salva-produto")) {
			produtoService.adiciona(request, response);
			response.sendRedirect(path + "/novo-produto");
		}

		// Lista todos os produtos
		if (uri.equalsIgnoreCase(path + "/lista-produtos")) {
			produtoService.getAll(request, response);
			request.getRequestDispatcher("/lista-produtos.jsp").forward(request, response);
		}

		// Exporta Excel
		if (uri.equalsIgnoreCase(path + "/exporte-produtos")) {
			produtoService.exportExcel(request, response);
		}

		// Importe Excel
		if (uri.equalsIgnoreCase(path + "/importe-produtos")) {
			produtoService.importeExcel(request, response);
			response.sendRedirect(path + "/lista-produtos");
		}

		// Lista produto na jsp alteração produto
		if (uri.equalsIgnoreCase(path + "/alteracao-produtos")) {
			produtoService.getAll(request, response);
			request.getRequestDispatcher("/alteracao-produtos.jsp").forward(request, response);
		}

		// Busca o produto pelo ID
		if (uri.equalsIgnoreCase(path + "/getId-produto")) {
			produtoService.getProdutoById(request, response);
			request.getRequestDispatcher("/update-produto.jsp").forward(request, response);
		}

		// Atualiza o produto
		if (uri.equalsIgnoreCase(path + "/update-produto")) {
			produtoService.update(request, response);
			response.sendRedirect(path + "/alteracao-produtos");
		}

		// Remove os produtos
		if (uri.equalsIgnoreCase(path + "/remove-produto")) {
			produtoService.remove(request, response);
			response.sendRedirect(path + "/alteracao-produtos");
		}

	}

}
