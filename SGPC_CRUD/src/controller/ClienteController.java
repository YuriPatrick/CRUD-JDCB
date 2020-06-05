package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClienteService;

@WebServlet({ "/novo-cliente", "/salva-cliente", "/update-cliente", "/remove-cliente", "/all-clientes", "/id-cliente",
		"/id-update-cliente" })

public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteService cliente = new ClienteService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	private void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		if (uri.equalsIgnoreCase(path + "/novo-cliente")) {
			request.getRequestDispatcher("/novo-cliente.jsp").forward(request, response);
		}
		if (uri.equalsIgnoreCase(path + "/salva-cliente")) {
			cliente.adiciona(request, response);
			response.sendRedirect(path + "/novo-cliente");
		}
		if (uri.equalsIgnoreCase(path + "/id-update-cliente")) {
			cliente.getClienteById(request, response);
			request.getRequestDispatcher("/cliente-update.jsp").forward(request, response);
		}
		if (uri.equalsIgnoreCase(path + "/remove-cliente")) {
			cliente.remove(request, response);
			response.sendRedirect(path + "/all-clientes");
		}
		if (uri.equalsIgnoreCase(path + "/update-cliente")) {
			cliente.update(request, response);
			response.sendRedirect(path + "/all-clientes");
		}
		if (uri.equalsIgnoreCase(path + "/all-clientes")) {
			cliente.getAll(request, response);
			request.getRequestDispatcher("/alteracao-clientes.jsp").forward(request, response);
		}

	}

}
