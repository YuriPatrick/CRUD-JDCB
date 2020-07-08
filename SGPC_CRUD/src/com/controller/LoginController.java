package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.model.Login;

/**
 * Servlet implementado as requisições e respostas do redirecionamento das
 * paginas jsp e as operações de autenticar,logar,cadastrar usuario e logoff.
 */
@WebServlet(urlPatterns = { "/login", "/autentica", "/logof", "/salva-usuario", "/novo-usuario" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USUARIO = "user";

	private static final String SENHA = "password";

	private static final String EMAIL = "email";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	/**
	 * @see HttpServlet#executa(HttpServletRequest request, HttpServletResponse
	 *      response) Método executa com a requisição e resposta para
	 *      autenticar,logar,cadastrar usuario e logoff.
	 * @param HttpServletRequest  request
	 * @param HttpServletResponse response
	 */
	private void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		if (uri.equalsIgnoreCase(path + "/login")) {
			login(request, response);

		}

		if (uri.equalsIgnoreCase(path + "/salva-usuario")) {
			cadastrar(request, response);
		}

		if (uri.equalsIgnoreCase(path + "/autentica")) {
			logar(request, response);
		}
		if (uri.equalsIgnoreCase(path + "/logof")) {
			logof(request, response);
		}

	}

	/**
	 * @see HttpServlet#login(HttpServletRequest request, HttpServletResponse response) 
	 * Método login com a requisição e resposta para o redirecionamento para a pagina login
	 * @param HttpServletRequest  request
	 * @param HttpServletResponse response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#logar(HttpServletRequest request, HttpServletResponse response) 
	 * Método logar com a requisição e resposta para o redirecionamento de paginas home e login
	 * @param HttpServletRequest  request
	 * @param HttpServletResponse response
	 */
	public void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			Login login1 = new Login();
			login1.setUsuario(usuario);
			login1.setSenha(senha);

			Login login = new LoginDao().logar(login1);

			if (login != null) {
				HttpSession session = request.getSession();
				session.setAttribute("usuario_logado", login);
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("login_erro", "Usuario ou Senha invalido");
				response.sendRedirect(request.getContextPath() + "/login");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#logof(HttpServletRequest request, HttpServletResponse response) 
	 * Método logof com a requisição e resposta para o redirecionamento para a pagina login.
	 * @param HttpServletRequest  request
	 * @param HttpServletResponse response
	 */
	public void logof(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/login");
	}

	/**
	 * @see HttpServlet#cadastrar(HttpServletRequest request, HttpServletResponse response) 
	 * Método cadastrar com a requisição e resposta para o cadastro de novo usuario
	 * @param HttpServletRequest  request
	 * @param HttpServletResponse response
	 */
	public void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoginDao dao = new LoginDao();
			Login login = new Login();

			String user = request.getParameter(USUARIO);
			String password = request.getParameter(SENHA);
			String email = request.getParameter(EMAIL);

			login.setUsuario(user);
			login.setSenha(password);
			login.setEmail(email);

			dao.adiciona(login);

			response.sendRedirect(request.getContextPath() + "/login");

		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
	}

}