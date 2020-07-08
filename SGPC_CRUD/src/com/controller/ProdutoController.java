package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ProdutoService;

/**
 * SERVLET IMPLEMENTADO AS REQUISI��ES E RESPOSTAS DO REDIRECIONAMENTO DAS
 * PAGINAS JSP E AS OPERA��ES DE CADASTRAR, CONSULTAR, ALTERAR, EXPORTAR EXCEL,
 * IMPORTAR EXCEL E DELETAR.
 */
@WebServlet({ "/novo-produto", "/salva-produto", "/update-produto", "/remove-produto", "/lista-produtos",
		"/getId-produto", "/alteracao-produtos", "/exporte-produtos", "/importe-produtos" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProdutoService produtoService = new ProdutoService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HTTPSERVLET#executa(HttpServletRequest request, HttpServletResponse
	 *      response) M�TODO EXECUTA COM A REQUISI��O E RESPOSTA PARA OS
	 *      REDIRECIONAMENTO E AS OPERA��ES
	 *      CADASTRAR,ALTERAR,CONSULTAR,DELETAR,EXPORTAR EXCEL E IMPORTAR EXCEL.
	 *      
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 */
	private void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = request.getContextPath();
		String uri = request.getRequestURI();

		// NOVO PRODUTO
		if (uri.equalsIgnoreCase(path + "/novo-produto")) {
			request.getRequestDispatcher("/novo-produto.jsp").forward(request, response);
		}

		// SALVAR PRODUTO
		if (uri.equalsIgnoreCase(path + "/salva-produto")) {
			produtoService.adiciona(request);
			response.sendRedirect(path + "/novo-produto");
		}

		// LISTAR TODOS OS PRODUTOS
		if (uri.equalsIgnoreCase(path + "/lista-produtos")) {
			produtoService.getAll(request);
			request.getRequestDispatcher("/lista-produtos.jsp").forward(request, response);
		}

		// EXPORTAR EXCEL
		if (uri.equalsIgnoreCase(path + "/exporte-produtos")) {
			produtoService.exportExcel(response);
		}

		// IMPORTAR EXCEL
		if (uri.equalsIgnoreCase(path + "/importe-produtos")) {
			produtoService.importeExcel(request, response);
			response.sendRedirect(path + "/lista-produtos");
		}

		// LISTAR PRODUTOS NA jsp ALTERA��O PRODUTO
		if (uri.equalsIgnoreCase(path + "/alteracao-produtos")) {
			produtoService.getAll(request);
			request.getRequestDispatcher("/alteracao-produtos.jsp").forward(request, response);
		}

		// BUSCA PRODUTO PELO ID
		if (uri.equalsIgnoreCase(path + "/getId-produto")) {
			produtoService.getProdutoById(request);
			request.getRequestDispatcher("/update-produto.jsp").forward(request, response);
		}

		// ATUALIZA O PRODUTO
		if (uri.equalsIgnoreCase(path + "/update-produto")) {
			produtoService.update(request);
			response.sendRedirect(path + "/alteracao-produtos");
		}

		// REMOVE OS PRODUTOS
		if (uri.equalsIgnoreCase(path + "/remove-produto")) {
			produtoService.remove(request);
			response.sendRedirect(path + "/alteracao-produtos");
		}

	}

}
