package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ClienteService;

/**
 * SERVLET IMPLEMENTADO AS REQUISIÇÕES E RESPOSTAS DO REDIRECIONAMENTO DAS
 * PÁGINAS JSP E AS OPERAÇÕES DE CADASTRAR,CONSULTAR,ALTERAR,EXPORTAR EXCEL E
 * DELETAR.
 */
@WebServlet({ "/novo-cliente", "/salva-cliente", "/update-cliente", "/remove-cliente", "/lista-clientes", "/id-cliente",
		"/id-update-cliente", "/exportar-clientes" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteService cliente = new ClienteService();

	/**
	 * @SEE HTTPSERVLET#DOGET(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HTTPSERVLET#DOPOST(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HTTPSERVLET#EXECUTA(HttpServletRequest request, HttpServletResponse
	 *      response) MÉTODO EXECUTA COM A REQUISIÇÃO E RESPOSTA PARA
	 *      CADASTRAR,ALTERAR,CONSULTAR,DELETAR E EXPORTAR EXCEL.
	 *      
	 *      
	 * @param request
	 * @param response
	 */
	private void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		// NOVO CLIENTE
		if (uri.equalsIgnoreCase(path + "/novo-cliente")) {
			request.getRequestDispatcher("/novo-cliente.jsp").forward(request, response);
		}

		// SALVA CLIENTE
		if (uri.equalsIgnoreCase(path + "/salva-cliente")) {
			cliente.adiciona(request);
			response.sendRedirect(path + "/novo-cliente");
		}

		// LISTA CLIENTES
		if (uri.equalsIgnoreCase(path + "/lista-clientes")) {
			cliente.getAll(request);
			request.getRequestDispatcher("/lista-clientes.jsp").forward(request, response);
		}

		// BUSCA O CLIENTE POR ID
		if (uri.equalsIgnoreCase(path + "/id-update-cliente")) {
			cliente.getClienteById(request);
			request.getRequestDispatcher("/cliente-update.jsp").forward(request, response);
		}

		// ATUALIZA O CLIENTE DA LISTA
		if (uri.equalsIgnoreCase(path + "/update-cliente")) {
			cliente.update(request);
			response.sendRedirect(path + "/lista-clientes");
		}

		// EXOIRTAR EXCEL
		if (uri.equalsIgnoreCase(path + "/exportar-clientes")) {
			cliente.exportExcel(response);
		}

		// REMOVE CLIENTE
		if (uri.equalsIgnoreCase(path + "/remove-cliente")) {
			cliente.remove(request);
			response.sendRedirect(path + "/lista-clientes");
		}
	}

}
