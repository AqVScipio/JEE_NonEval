package fr.epsi.controller;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Role;
import fr.epsi.entite.Utilisateur;
import fr.epsi.service.IdeeService;
import fr.epsi.service.UtilisateurService;

@WebServlet("/users")
public class UtilisateurServlet extends HttpServlet {

	@EJB
	private UtilisateurService service;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		if(!username.isBlank()) {
			Utilisateur p = service.getUtilisateur(username);
			if(p == null) {
				p = new Utilisateur();
				p.setUsername(username);
				service.createUtilisateur(p);
			}		
					
			HttpSession sess = req.getSession();
			sess.setAttribute("userID", p.getId());
			
			// this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/ideeList.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/idees?action=list");
		}
	}
}
