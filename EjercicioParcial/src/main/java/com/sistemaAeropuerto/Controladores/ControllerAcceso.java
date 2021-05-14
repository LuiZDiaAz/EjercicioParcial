package com.sistemaAeropuerto.Controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistemaAeropuerto.DAO.ClsUsuario;
import com.sistemaAeropuerto.Entidades.Usuario;

/**
 * Servlet implementation class ControllerAcceso
 */
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAcceso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession(true);
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		Usuario log = new Usuario();

		log.setNombre(user);
		log.setContrasena(pass);

		ClsUsuario cls = new ClsUsuario();

		boolean resultado = cls.Login(log);

		if (resultado == true) {
			int id = cls.id;
			session.setAttribute("usuario", id);

			response.sendRedirect("menu.jsp");

		} else {
			response.sendRedirect("Index.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
