package com.sistemaAeropuerto.Controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sistemaAeropuerto.DAO.ClsConsulta;
import com.sistemaAeropuerto.Entidades.Consulta;


/**
 * Servlet implementation class ControllerConsulta
 */
public class ControllerConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sesion = (HttpSession) request.getSession();
		String id = String.valueOf(sesion.getAttribute("usuario"));
		Consulta usu = new Consulta();
		ClsConsulta cls = new ClsConsulta();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		usu.setId(Integer.parseInt(request.getParameter("usu")));
		
		if(id==null|| id.isEmpty() || id=="null") {
			
			response.sendRedirect("menu.jsp");	

		}else {
		
		cls.Eliminar(usu);
		response.sendRedirect("menu.jsp");
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Gson json = new Gson();

		ClsConsulta cls = new ClsConsulta();

		response.getWriter().append(json.toJson(cls.MostrarConsulta()));
	}

}
