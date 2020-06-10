package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClienteService;

@WebServlet({ "/novo-cliente", "/salva-cliente", "/update-cliente", "/remove-cliente", "/lista-clientes", "/id-cliente",
		"/id-update-cliente", "/exportar-clientes" })

public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteService cliente = new ClienteService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		// Novo Cliente
		if (uri.equalsIgnoreCase(path + "/novo-cliente")) {
			request.getRequestDispatcher("/novo-cliente.jsp").forward(request, response);
		}

		// Salva Cliente
		if (uri.equalsIgnoreCase(path + "/salva-cliente")) {
			cliente.adiciona(request, response);
			response.sendRedirect(path + "/novo-cliente");
		}

		// Lista Clientes
		if (uri.equalsIgnoreCase(path + "/lista-clientes")) {
			cliente.getAll(request, response);
			request.getRequestDispatcher("/lista-clientes.jsp").forward(request, response);
		}

		// Busca o cliente por ID
		if (uri.equalsIgnoreCase(path + "/id-update-cliente")) {
			cliente.getClienteById(request, response);
			request.getRequestDispatcher("/cliente-update.jsp").forward(request, response);
		}

		// Atualiza o cliente da lista
		if (uri.equalsIgnoreCase(path + "/update-cliente")) {
			cliente.update(request, response);
			response.sendRedirect(path + "/lista-clientes");
		}

		// Exporta excel
		if (uri.equalsIgnoreCase(path + "/exportar-clientes")) {
			cliente.exportExcel(request, response);
		}

		// Remove cliente
		if (uri.equalsIgnoreCase(path + "/remove-cliente")) {
			cliente.remove(request);
			response.sendRedirect(path + "/lista-clientes");
		}
	}

}
