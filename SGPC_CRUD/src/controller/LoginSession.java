package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/*", "/salva-usuario" })
public class LoginSession implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();

		if (!usuarioLogado(session) && !usuarioAutenticado(request) && !usuarioCadastra(request)) {
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			chain.doFilter(req, resp);
		}
	}

	public boolean usuarioLogado(HttpSession session) {
		return session != null && session.getAttribute("usuario_logado") != null;
	}

	public boolean usuarioAutenticado(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.equals(request.getContextPath() + "/login") || uri.equals(request.getContextPath() + "/autentica");
	}

	public boolean usuarioCadastra(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.equals(request.getContextPath() + "/login")
				|| uri.equals(request.getContextPath() + "/salva-usuario");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
