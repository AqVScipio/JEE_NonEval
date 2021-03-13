package fr.epsi.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Utilisateur;
import fr.epsi.service.IdeeService;

@WebServlet("/idees")
public class IdeeServlet extends HttpServlet {

	@EJB
	private IdeeService service;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Alerte !");
		HttpSession sess = req.getSession();
		if (sess.getAttribute("userID") != null) {
			if (req.getParameter("action").equals("create"))
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/ideeCreate.jsp").forward(req, resp);
			else {
				List<Idee> idees = service.getIdees();
				req.setAttribute("idees", idees);
				this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/ideeList.jsp").forward(req, resp);
			}
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/home.jsp").forward(req, resp);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		Idee p = new Idee();
		Utilisateur u = new Utilisateur();

		u.setId((Long)sess.getAttribute("userID"));
		p.setTitre(req.getParameter("titre"));
		p.setPitch(req.getParameter("pitch"));
		p.setDatePublication(new Date());
		p.setInitiateur(u);
		service.createIdee(p);
		// this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/ideeList.jsp").forward(req,
		// resp);
		resp.sendRedirect(req.getContextPath() + "/idees?action=list");
	}
}
