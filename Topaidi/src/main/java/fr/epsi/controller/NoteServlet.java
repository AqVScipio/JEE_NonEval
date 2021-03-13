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
import fr.epsi.entite.Note;
import fr.epsi.entite.NoteId;
import fr.epsi.entite.Role;
import fr.epsi.entite.Utilisateur;
import fr.epsi.service.IdeeService;
import fr.epsi.service.NoteService;
import fr.epsi.service.UtilisateurService;

@WebServlet("/notes")
public class NoteServlet extends HttpServlet {

	@EJB
	private NoteService service;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Note p = new Note();
		Utilisateur u = new Utilisateur();
		Idee i = new Idee();
		HttpSession sess = req.getSession();
		if(sess.getAttribute("userID") != null) {
			if (req.getParameter("action").equals("top"))
				p.setNote((byte) 1);
			else if (req.getParameter("action").equals("flop"))
				p.setNote((byte) 0);

			u.setId((Long) sess.getAttribute("userID"));
			i.setId(Long.parseLong(req.getParameter("idee")));

			p.setUtilisateur(u);
			p.setIdee(i);
			
			service.createNote(p);
		}

		resp.sendRedirect(req.getContextPath() + "/idees?action=list");
	}
}
