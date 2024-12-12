package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoCoche;
import dao.DaoMarca;
import entidad.Coche;
import entidad.Marca;

/** Servlet implementation class Controller*/
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** @see HttpServlet#HttpServlet()*/
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Coche> coches = null;
		ArrayList<Marca> marcas = null;
		String idmarca="0";
		String orden="null";

		HttpSession session = request.getSession();
		String operacion = request.getParameter("operacion");
		
		switch (operacion) {
		case "iniciar": 
			// actuar en consecuencia
			try {
				coches = new DaoCoche().getCoches(0,"null");
				marcas = new DaoMarca().getMarcas();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("coches", coches);
			session.setAttribute("marcas", marcas);
			session.setAttribute("idmarca", idmarca);
			session.setAttribute("orden", orden);
			request.getRequestDispatcher("coche.jsp").forward(request, response);
			break;
		case "cambiomarca": {
			idmarca = request.getParameter("idmarca"); //recogemos la marca seleccionada
			session.setAttribute("idmarca", idmarca); //la guardo en la session
			orden = (String) session.getAttribute("orden");
			// actuar en consecuencia
			try {
				coches = new DaoCoche().getCoches(Integer.parseInt(idmarca), orden);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("coches", coches);
			request.getRequestDispatcher("coche.jsp").forward(request, response);
			break;
		}
		case "cambioorden": {
			orden = request.getParameter("orden");
			session.setAttribute("orden", orden);
			idmarca = (String) session.getAttribute("idmarca");
			// actuar en consecuencia
			try {
				coches = new DaoCoche().getCoches(Integer.parseInt(idmarca), orden);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("coches", coches);
			request.getRequestDispatcher("coche.jsp").forward(request, response);
			break;
		}
		case "like": {
			String idcoche = request.getParameter("idcoche");
			idmarca = String.valueOf(session.getAttribute("idmarca"));
			orden = (String) session.getAttribute("orden");
			try {
				new DaoCoche().addLike(Integer.valueOf(idcoche));
				coches = new DaoCoche().getCoches(Integer.parseInt(idmarca),orden);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("coches", coches);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
			default:
				break;
		}
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
