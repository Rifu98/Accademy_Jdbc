package com.federicorifugiato;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Converti
 */
public class Converti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Converti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String euro = request.getParameter("euro");
			if(euro.equals("")) {
				request.getServletContext().getRequestDispatcher("/jsp/Pagina1.jsp").include(request, response);
			} else {
				double dollaro = Double.parseDouble(euro) * 1.07;
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html!>");
				out.println("<html>");
				out.println("<head><title>Cifra Convertita</title></head>");
				out.println("<body><h1>" + dollaro + "</h1></body>");
				out.println("</html>");
			}
		} catch (NullPointerException e) {
			request.getServletContext().getRequestDispatcher("/jsp/Pagina1.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
